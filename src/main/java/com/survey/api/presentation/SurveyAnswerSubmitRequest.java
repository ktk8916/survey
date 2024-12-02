package com.survey.api.presentation;

import java.util.List;

public record SurveyAnswerSubmitRequest(
        long surveyItemId,
        List<SurveyItemAnswerRequest> itemAnswers
) {
    public record SurveyItemAnswerRequest(
        String shortQuestionAnswer,
        String longQuestionAnswer,
        Long singleChoiceItemAnswer,
        List<Long> multipleChoiceItemAnswer
    ) {

    }
}
