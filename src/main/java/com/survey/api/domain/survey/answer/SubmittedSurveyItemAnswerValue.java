package com.survey.api.domain.survey.answer;

public record SubmittedSurveyItemAnswerValue(
        String shortQuestionAnswer,
        String longQuestionAnswer,
        Integer singleChoiceItemAnswer,
        Integer multipleChoiceItemAnswer
) {
}
