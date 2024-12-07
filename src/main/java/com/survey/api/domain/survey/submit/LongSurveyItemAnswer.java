package com.survey.api.domain.survey.submit;

import com.survey.api.global.ExceptionCode;
import com.survey.api.global.SurveyAppException;

import java.util.List;

public class LongSurveyItemAnswer implements SurveyItemAnswer {

    private static final int SHORT_SURVEY_ITEM_ANSWER_MAX_LENGTH = 1000;
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
        if (value.isBlank() || value.length() > SHORT_SURVEY_ITEM_ANSWER_MAX_LENGTH) {
            throw new SurveyAppException(ExceptionCode.INVALID_VALUE);
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
