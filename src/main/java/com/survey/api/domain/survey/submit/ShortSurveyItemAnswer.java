package com.survey.api.domain.survey.submit;

import java.util.List;

public class ShortSurveyItemAnswer implements SurveyItemAnswer {

    private static final int SHORT_SURVEY_ANSWER_MAX_LENGTH = 200;
    private final long surveyFormId;
    private final long surveyItemId;
    private final String value;

    public static ShortSurveyItemAnswer of(long surveyFormId, SubmittedSurveyItemAnswer submittedAnswer) {
        return new ShortSurveyItemAnswer(
                surveyFormId,
                submittedAnswer.surveyItemId(),
                submittedAnswer.getShortQuestionAnswer());
    }

    private ShortSurveyItemAnswer(long surveyFormId, long surveyItemId, String value) {
        if (value.isBlank() || value.length() > SHORT_SURVEY_ANSWER_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.surveyFormId = surveyFormId;
        this.surveyItemId = surveyItemId;
        this.value = value;
    }

    @Override
    public List<SurveyAnswerEntity> toEntities() {
        SurveyAnswerEntity answerEntity = SurveyAnswerEntity.ofShortQuestion(
                surveyFormId,
                surveyItemId,
                value
        );
        return List.of(answerEntity);
    }
}
