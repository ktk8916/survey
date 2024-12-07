package com.survey.api.presentation;

import com.survey.api.domain.survey.submit.SubmittedSurveyItemAnswerValue;
import com.survey.api.domain.survey.submit.SubmittedSurveyItemAnswer;

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
