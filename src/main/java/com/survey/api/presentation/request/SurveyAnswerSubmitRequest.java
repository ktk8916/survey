package com.survey.api.presentation.request;

import com.survey.api.domain.survey.answer.SubmittedSurveyItemAnswerValue;
import com.survey.api.domain.survey.answer.SubmittedSurveyItemAnswer;

import java.util.List;

public record SurveyAnswerSubmitRequest(
        long surveyItemId,
        List<SurveyItemAnswerRequest> itemAnswers
) {
    public SubmittedSurveyItemAnswer toDomain() {
        return new SubmittedSurveyItemAnswer(
                surveyItemId,
                itemAnswers.stream()
                        .map(SurveyItemAnswerRequest::toDomain)
                        .toList()
        );
    }

    public record SurveyItemAnswerRequest(
        String shortQuestionAnswer,
        String longQuestionAnswer,
        Integer singleChoiceItemAnswer,
        Integer multipleChoiceItemAnswer
    ) {
        public SubmittedSurveyItemAnswerValue toDomain() {
            return new SubmittedSurveyItemAnswerValue(
                    shortQuestionAnswer,
                    longQuestionAnswer,
                    singleChoiceItemAnswer,
                    multipleChoiceItemAnswer
            );
        }
    }
}
