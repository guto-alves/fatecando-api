package com.gutotech.fatecandoapi.rest;

import java.security.SecureRandom;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Alternative;
import com.gutotech.fatecandoapi.model.AnswerUtils;
import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.Game;
import com.gutotech.fatecandoapi.model.GameStatus;
import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.Round;
import com.gutotech.fatecandoapi.model.RoundAnswer;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.service.GameService;
import com.gutotech.fatecandoapi.service.QuestionService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/games")
public class GameRestController {
	private static final SecureRandom random = new SecureRandom();

	@Autowired
	private GameService gameService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserService userService;

	@Autowired
	private AnswerUtils answerUtils;

	@GetMapping("playing")
	public ResponseEntity<Game> getGame() {
		Game game = gameService.findByUser(userService.findCurrentUser());

		if (game != null && game.getStatus() == GameStatus.PLAYING) {
			Round currentRound = game.getRounds().get(game.getCurrentRound());

			boolean answered = currentRound.getAnswers().size() == game.getPlayers().size();
			boolean timeIsOver = System.currentTimeMillis() - currentRound.getStartTime() >= game.getAnswerTime() * 1000;

			boolean lastRound = game.getTotalRounds() == game.getCurrentRound() + 1;

			if (answered || timeIsOver) {
				if (lastRound) {
					game.setStatus(GameStatus.FINISHED);
				} else {
					generateNextRound(game);
				}

				gameService.save(game);
			} else {
				long secondsLeft = game.getAnswerTime()
						- (System.currentTimeMillis() - currentRound.getStartTime()) / 1000;
				currentRound.setSecondsLeft(secondsLeft);
			}
		}

		return ResponseEntity.ok(game);
	}

	@GetMapping
	public ResponseEntity<List<Game>> getGames() {
		return ResponseEntity.ok(gameService.findAll());
	}

	@PostMapping
	public ResponseEntity<Game> createGame(@RequestBody @Valid Game game) {
		Discipline discipline = game.getTopics().get(0).getDiscipline();

		if (game.getTopics().stream().anyMatch(topic -> topic.getDiscipline() != discipline)) {
			throw new IllegalArgumentException("All Topics must belong to the same Discipline");
		}

		game.setCurrentRound(-1);
		game.setStatus(GameStatus.WAITING);
		game.getPlayers().clear();

		User user = userService.findCurrentUser();
		game.setCreatedBy(user);
		game.getPlayers().add(user);

		gameService.save(game);

		return ResponseEntity.ok(game);
	}

	@PutMapping("{id}")
	public ResponseEntity<Void> joinGame(@PathVariable Long id) {
		Game game = gameService.findById(id);

		if (game.getStatus() != GameStatus.WAITING) {
			throw new IllegalStateException("This Game is already underway");
		}

		User user = userService.findCurrentUser();

		if (gameService.findByUser(user) != null) {
			throw new IllegalStateException("The player is already in a Game");
		}

		game.getPlayers().add(user);

		if (game.getPlayers().size() == game.getTotalPlayers()) {
			game.setStatus(GameStatus.PLAYING);
			generateNextRound(game);
		}

		gameService.save(game);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping
	public ResponseEntity<Void> leaveGame() {
		User user = userService.findCurrentUser();
		Game game = gameService.findByUser(user);

		game.getPlayers().remove(user);

		if (game.getPlayers().size() == 0) {
			gameService.deleteById(game.getId());
		} else {
			gameService.save(game);
		}

		return ResponseEntity.noContent().build();
	}

	@PostMapping("answer/{chosenAlternativeId}")
	public ResponseEntity<RoundAnswer> answerGameQuestion(@PathVariable Long chosenAlternativeId) {
		User user = userService.findCurrentUser();

		Game game = gameService.findByUser(user);

		if (game == null || game.getStatus() != GameStatus.PLAYING) {
			return ResponseEntity.badRequest().build();
		}

		Round currentRound = game.getRounds().get(game.getCurrentRound());

		Alternative chosenAlternative = currentRound.getQuestion().getAlternatives() //
				.stream() //
				.filter(a -> a.getId() == chosenAlternativeId) //
				.findFirst() //
				.orElseThrow(() -> new ResourceNotFoundException("Could not find alternative " + chosenAlternativeId
						+ " for the question " + currentRound.getQuestion()));

		if (currentRound.getAnswers().stream().noneMatch(answer -> answer.getUser() == user)
				|| System.currentTimeMillis() - currentRound.getStartTime() <= game.getAnswerTime()) {
			
			answerUtils.saveQuestionAnswer(currentRound.getQuestion(), chosenAlternative, user);

			RoundAnswer roundAnswer = new RoundAnswer(user, chosenAlternative);

			currentRound.getAnswers().add(roundAnswer);

			gameService.save(game);

			return ResponseEntity.ok(roundAnswer);
		}

		throw new IllegalStateException("Time to answer or game is over or this is a invalid alternative");
	}

	private void generateNextRound(Game game) {
		int topicIndex = random.nextInt(game.getTopics().size());
		Topic topic = game.getTopics().get(topicIndex);

		List<Question> questions = questionService.findAllByTopic(topic);

		int questionIndex = random.nextInt(questions.size());
		Question question = questions.get(questionIndex);

		Round round = new Round(question, System.currentTimeMillis());
		round.setSecondsLeft(game.getAnswerTime());

		game.setCurrentRound(game.getCurrentRound() + 1);
		game.getRounds().add(round);
	}

}
