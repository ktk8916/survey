package com.survey.api.domain.survey.submit;

import com.survey.api.global.ExceptionCode;
import com.survey.api.global.SurveyAppException;

import java.util.List;

public class SingleChoiceSurveyAnswer implements SurveyAnswerItem {

    private final long surveyFormId;
    private final long surveyItemId;
    private final int selectedNumber;

    public static SingleChoiceSurveyAnswer of(long surveyFormId, SurveySubmitCommand command) {
        return new SingleChoiceSurveyAnswer(
                surveyFormId,
                command.surveyItemId(),
                command.getSingleChoiceItemAnswer()
        );
    }

    private SingleChoiceSurveyAnswer(long surveyFormId, long surveyItemId, int selectedNumber) {
        // TODO : selectedNumber vo로
        if (selectedNumber < 1) {
            throw new SurveyAppException(ExceptionCode.INVALID_VALUE);
        }
        this.surveyFormId = surveyFormId;
        this.surveyItemId = surveyItemId;
        this.selectedNumber = selectedNumber;
    }

    @Override
    public List<SurveyAnswerEntity> toEntities() {
        SurveyAnswerEntity singleChoiceAnswer = SurveyAnswerEntity.ofMultipleChoice(
                surveyFormId,
                surveyItemId,
                selectedNumber
        );
        return List.of(singleChoiceAnswer);
    }
}
