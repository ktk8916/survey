package com.survey.api.domain.survey.submit;

import java.util.List;

public record SurveySubmitCommand(
        long surveyItemId,
        List<SurveyAnswerItemCommand> answerItems
) {
    public String getShortQuestionAnswer() {
        return answerItems.get(0).shortQuestionAnswer();
    }
    public String getLongQuestionAnswer() {
        return answerItems.get(0).longQuestionAnswer();
    }
    public int getSingleChoiceItemAnswer() {
        return answerItems.get(0).singleChoiceItemAnswer();
    }
    public List<Integer> getMultipleChoiceItemAnswer() {
        return answerItems.stream()
                .mapToInt(SurveyAnswerItemCommand::multipleChoiceItemAnswer)
                .boxed()
                .toList();
    }
}
