package com.survey.api.domain.survey.answer.query.data;

import com.survey.api.domain.survey.item.SurveyItemType;

public record SurveyAnswerData(
        long surveyItemId,
        SurveyItemType itemType,
        String shortQuestionAnswer,
        String longQuestionAnswer,
        Integer selectedOption
) {
}
