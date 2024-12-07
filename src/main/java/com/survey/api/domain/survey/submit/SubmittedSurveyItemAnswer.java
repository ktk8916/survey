package com.survey.api.domain.survey.submit;

import java.util.List;

public record SubmittedSurveyItemAnswer(
        long surveyItemId,
        List<SubmittedSurveyItemAnswerValue> answerValues
) {
    public String getShortQuestionAnswer() {
        return answerValues.get(0).shortQuestionAnswer();
    }
    public String getLongQuestionAnswer() {
        return answerValues.get(0).longQuestionAnswer();
    }
    public int getSingleChoiceItemAnswer() {
        return answerValues.get(0).singleChoiceItemAnswer();
    }
    public List<Integer> getMultipleChoiceItemAnswer() {
        return answerValues.stream()
                .mapToInt(SubmittedSurveyItemAnswerValue::multipleChoiceItemAnswer)
                .boxed()
                .toList();
    }
}
