package com.gutotech.fatecandoapi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.service.AnswerService;
import com.gutotech.fatecandoapi.service.RewardService;
import com.gutotech.fatecandoapi.service.UserService;

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
