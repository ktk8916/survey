package com.survey.api.domain.survey.submit;

public record SubmittedSurveyItemAnswerValue(
        String shortQuestionAnswer,
        String longQuestionAnswer,
        Integer singleChoiceItemAnswer,
        Integer multipleChoiceItemAnswer
) {
}
