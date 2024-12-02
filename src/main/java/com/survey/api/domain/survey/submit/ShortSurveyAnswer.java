package com.survey.api.domain.survey.submit;

import java.util.List;

public class ShortSurveyAnswer implements SurveyAnswerItem {

    private static final int SHORT_SURVEY_ANSWER_MAX_LENGTH = 200;
    private final Long surveyFormId;
    private final Long surveyItemId;
    private final String value;

    public static ShortSurveyAnswer of(long surveyFormId, SurveySubmitCommand command) {
        return new ShortSurveyAnswer(
                surveyFormId,
                command.surveyItemId(),
                command.getShortQuestionAnswer());
    }

    private ShortSurveyAnswer(long surveyFormId, long surveyItemId, String value) {
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
