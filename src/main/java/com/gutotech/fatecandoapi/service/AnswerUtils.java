package com.gutotech.fatecandoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.Alternative;
import com.gutotech.fatecandoapi.model.Answer;
import com.gutotech.fatecandoapi.model.AnswerId;
import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.Reward;
import com.gutotech.fatecandoapi.model.RewardType;
import com.gutotech.fatecandoapi.model.User;

@Component
public class AnswerUtils {

	@Autowired
	private AnswerService answerService;

	@Autowired
	private UserService userService;

	@Autowired
	private RewardService rewardService;

	public void saveQuestionAnswer(Question question, Alternative chosenAlternative, User user) {
		Answer lastAnswer = answerService.findById(new AnswerId(user, question));

		if (lastAnswer == null) {
			lastAnswer = new Answer(user, question, false);
		}

		if (!lastAnswer.isCorrect()) {
			Reward reward;

			if (chosenAlternative.isCorrect()) {
				reward = new Reward(RewardType.RIGHT_ANSWER, user);
				user.getUserActivity().incrementRightAnswers();
			} else {
				reward = new Reward(RewardType.WRONG_ANSWER, user);
				user.getUserActivity().incrementWrongAnswers();
			}

			rewardService.save(reward);
			userService.save(user);

			lastAnswer.setCorrect(chosenAlternative.isCorrect());
			answerService.save(lastAnswer);
		}
	}

}
