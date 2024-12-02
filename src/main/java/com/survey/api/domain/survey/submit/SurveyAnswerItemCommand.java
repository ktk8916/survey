package com.survey.api.domain.survey.submit;

public record SurveyAnswerItemCommand(
        String shortQuestionAnswer,
        String longQuestionAnswer,
        Integer singleChoiceItemAnswer,
        Integer multipleChoiceItemAnswer
) {
}
