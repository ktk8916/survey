package com.survey.api.presentation;

import com.survey.api.domain.survey.submit.SurveyAnswerItemCommand;
import com.survey.api.domain.survey.submit.SurveySubmitCommand;

import java.util.List;

public record SurveyAnswerSubmitRequest(
        long surveyItemId,
        List<SurveyItemAnswerRequest> itemAnswers
) {
    public SurveySubmitCommand toCommand() {
        return new SurveySubmitCommand(
                surveyItemId,
                itemAnswers.stream()
                        .map(SurveyItemAnswerRequest::toCommand)
                        .toList()
        );
    }

    public record SurveyItemAnswerRequest(
        String shortQuestionAnswer,
        String longQuestionAnswer,
        Integer singleChoiceItemAnswer,
        Integer multipleChoiceItemAnswer
    ) {
        public SurveyAnswerItemCommand toCommand() {
            return new SurveyAnswerItemCommand(
                    shortQuestionAnswer,
                    longQuestionAnswer,
                    singleChoiceItemAnswer,
                    multipleChoiceItemAnswer
            );
        }

    }
}
