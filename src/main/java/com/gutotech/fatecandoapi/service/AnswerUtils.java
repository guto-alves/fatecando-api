package com.gutotech.fatecandoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.Alternative;
import com.gutotech.fatecandoapi.model.Answer;
import com.gutotech.fatecandoapi.model.AnswerId;
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

	public void saveAnswer(Alternative chosenAlternative, User user) {
		AnswerId answerId = new AnswerId(user, chosenAlternative.getQuestion());
		
		Answer lastAnswer = answerService.findById(answerId);

		if (lastAnswer == null) {
			lastAnswer = new Answer(answerId, false);
		}

		if (!lastAnswer.isCorrect()) {
			if (chosenAlternative.getFeedback().isCorrect()) {
				rewardService.add(RewardType.RIGHT_ANSWER, user);
				user.getUserActivity().incrementRightAnswers();
			} else {
				rewardService.add(RewardType.WRONG_ANSWER, user);
				user.getUserActivity().incrementWrongAnswers();
			}
			
			userService.save(user);

			lastAnswer.setCorrect(chosenAlternative.getFeedback().isCorrect());
			answerService.save(lastAnswer);
		}
	}

}
