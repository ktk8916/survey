package com.survey.api.domain.survey.answer;

import java.util.List;

public class LongSurveyItemAnswer implements SurveyItemAnswer {

    private static final int LONG_SURVEY_ITEM_ANSWER_MAX_LENGTH = 1000;
    private final long surveyFormId;
    private final long surveyItemId;
    private final String value;

    public static LongSurveyItemAnswer of(long surveyFormId, SubmittedSurveyItemAnswer submittedAnswer) {
        return new LongSurveyItemAnswer(
                surveyFormId,
                submittedAnswer.surveyItemId(),
                submittedAnswer.getLongQuestionAnswer());
    }

    private LongSurveyItemAnswer(long surveyFormId, long surveyItemId, String value) {
        if (value.isBlank() || value.length() > LONG_SURVEY_ITEM_ANSWER_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("long answer's length must be smaller than %d and larger than 0", LONG_SURVEY_ITEM_ANSWER_MAX_LENGTH));
        }
        this.surveyFormId = surveyFormId;
        this.surveyItemId = surveyItemId;
        this.value = value;
    }

    @Override
    public List<SurveyAnswerEntity> toEntities() {
        SurveyAnswerEntity longQuestionAnswer = SurveyAnswerEntity.ofLongQuestion(
                surveyFormId,
                surveyItemId,
                value
        );
        return List.of(longQuestionAnswer);
    }
}
