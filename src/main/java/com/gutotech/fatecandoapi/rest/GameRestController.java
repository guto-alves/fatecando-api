package com.gutotech.fatecandoapi.rest;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Alternative;
import com.gutotech.fatecandoapi.model.AnswerUtils;
import com.gutotech.fatecandoapi.model.Game;
import com.gutotech.fatecandoapi.model.GameStatus;
import com.gutotech.fatecandoapi.model.GameUserStatus;
import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.Round;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.service.GameService;
import com.gutotech.fatecandoapi.service.QuestionService;

@RestController
@RequestMapping("games")
public class GameRestController {

	@Autowired
	private GameService gameService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerUtils answerUtils;

	private static final SecureRandom random = new SecureRandom();

	// Creates a game
	@PostMapping
	public ResponseEntity<Game> create(@RequestBody @Valid Game game) {
		game.setCurrentRound(-1);
		game.setStatus(GameStatus.WAITING);
		gameService.save(game);

		return ResponseEntity.ok(game);
	}

	// Enters the game
	@PostMapping("{id}")
	public ResponseEntity<Game> joinGame(@RequestBody User user, @PathVariable Long id) {
		Game game = gameService.findById(id);

		if (game.getInGameUserStatus().size() >= game.getTotalUsers()) {
			throw new IllegalStateException("The game is already full");
		}

		game.getInGameUserStatus().add(new GameUserStatus(game, user, true));

		if (game.getInGameUserStatus().size() == game.getTotalUsers()) {
			game.setStatus(GameStatus.PLAYING);
			nextRound(game);
		}

		gameService.save(game);

		return ResponseEntity.ok(game);
	}

	// Submits answer for current round question
	@PostMapping("{id}/answer")
	public ResponseEntity<?> answerGameQuestion(@RequestBody Alternative chosenAlternative,
			@PathVariable("id") Long id) {
		Game game = gameService.findById(id);

		Round currentRound = game.getRounds().get(game.getCurrentRound());

		User user = null; // TODO fix this

		// Checks if the chosen alternative, time and game status are valid
		if (currentRound.getQuestion().getAlternatives().contains(chosenAlternative) && //
				game.getStatus() == GameStatus.PLAYING && //
				System.currentTimeMillis() - currentRound.getStartTime() <= game.getTimeToAnswer()) {
			answerUtils.saveQuestionAnswer(currentRound.getQuestion(), chosenAlternative, user);

			currentRound.getUsersWhoAnswered().add(user);

			if (chosenAlternative.isCorrect()) {
				GameUserStatus gameUserStatus = game.getInGameUserStatus().stream() //
						.filter(userStatus -> userStatus.getUser() == user) //
						.findFirst() //
						.orElse(null); //

				gameUserStatus.setHits(gameUserStatus.getHits() + 1);

				gameService.save(game);
			}
		} else {
			throw new IllegalStateException(
					"Error reason: time to answer or game is over or this is a invalid alternative");
		}

		Map<String, Object> feedback = new HashMap<>();
		feedback.put("feedback", chosenAlternative.getFeedback());
		feedback.put("isCorrect", chosenAlternative.isCorrect());

		return ResponseEntity.ok(feedback);
	}

	// Goes to the next round
	private void nextRound(Game game) {
		int topicIndex = random.nextInt(game.getTopics().size());
		Topic topic = game.getTopics().get(topicIndex);

		List<Question> questions = questionService.findAllByTopic(topic);

		int questionIndex = random.nextInt(questions.size());
		Question question = questions.get(questionIndex);

		Round round = new Round(question, game, System.currentTimeMillis());

		game.setCurrentRound(game.getCurrentRound() + 1);
		game.getRounds().add(round);
	}

}
