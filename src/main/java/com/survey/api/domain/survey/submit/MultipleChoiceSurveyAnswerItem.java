package com.survey.api.domain.survey.submit;

import com.survey.api.global.ExceptionCode;
import com.survey.api.global.SurveyAppException;

import java.util.List;

public class MultipleChoiceSurveyAnswerItem implements SurveyAnswerItem {

    private final long surveyFormId;
    private final long surveyItemId;
    private final List<Integer> selectedNumbers;

    public static MultipleChoiceSurveyAnswerItem of(long surveyFormId, SurveySubmitCommand command) {
        return new MultipleChoiceSurveyAnswerItem(
                surveyFormId,
                command.surveyItemId(),
                command.getMultipleChoiceItemAnswer()
        );
    }

    private MultipleChoiceSurveyAnswerItem(long surveyFormId, long surveyItemId, List<Integer> selectedNumbers) {
        // TODO : selectedNumbers 일급 컬렉션으로, 또는 SurveyItemSelectedOptions 활용
        if (selectedNumbers.isEmpty()) {
            throw new SurveyAppException(ExceptionCode.INVALID_VALUE);
        }
        this.surveyFormId = surveyFormId;
        this.surveyItemId = surveyItemId;
        this.selectedNumbers = selectedNumbers;
    }

    @Override
    public List<SurveyAnswerEntity> toEntities() {
        return selectedNumbers.stream()
                .map(selectedNumber -> SurveyAnswerEntity.ofMultipleChoice(
                        surveyFormId,
                        surveyItemId,
                        selectedNumber))
                .toList();
    }
}