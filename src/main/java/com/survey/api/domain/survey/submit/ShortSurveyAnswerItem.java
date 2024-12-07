package com.survey.api.domain.survey.submit;

import java.util.List;

public class ShortSurveyAnswerItem implements SurveyAnswerItem {

    private static final int SHORT_SURVEY_ANSWER_MAX_LENGTH = 200;
    private final long surveyFormId;
    private final long surveyItemId;
    private final String value;

    public static ShortSurveyAnswerItem of(long surveyFormId, SurveySubmitCommand command) {
        return new ShortSurveyAnswerItem(
                surveyFormId,
                command.surveyItemId(),
                command.getShortQuestionAnswer());
    }

    private ShortSurveyAnswerItem(long surveyFormId, long surveyItemId, String value) {
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
