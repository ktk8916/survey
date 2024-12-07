package com.survey.api.domain.survey.submit;

import com.survey.api.global.ExceptionCode;
import com.survey.api.global.SurveyAppException;

import java.util.List;

public class SingleChoiceSurveyItemAnswer implements SurveyItemAnswer {

    private final long surveyFormId;
    private final long surveyItemId;
    private final int selectedNumber;

    public static SingleChoiceSurveyItemAnswer of(long surveyFormId, SubmittedSurveyItemAnswer submittedAnswer) {
        return new SingleChoiceSurveyItemAnswer(
                surveyFormId,
                submittedAnswer.surveyItemId(),
                submittedAnswer.getSingleChoiceItemAnswer()
        );
    }

    private SingleChoiceSurveyItemAnswer(long surveyFormId, long surveyItemId, int selectedNumber) {
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
