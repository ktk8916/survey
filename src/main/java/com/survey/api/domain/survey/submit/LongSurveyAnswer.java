package com.survey.api.domain.survey.submit;

import com.survey.api.global.ExceptionCode;
import com.survey.api.global.SurveyAppException;

import java.util.List;

public class LongSurveyAnswer implements SurveyAnswerItem {

    private static final int SHORT_SURVEY_ANSWER_MAX_LENGTH = 1000;
    private final long surveyFormId;
    private final long surveyItemId;
    private final String value;

    public static LongSurveyAnswer of(long surveyFormId, SurveySubmitCommand command) {
        return new LongSurveyAnswer(
                surveyFormId,
                command.surveyItemId(),
                command.getLongQuestionAnswer());
    }

    private LongSurveyAnswer(long surveyFormId, long surveyItemId, String value) {
        if (value.isBlank() || value.length() > SHORT_SURVEY_ANSWER_MAX_LENGTH) {
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
