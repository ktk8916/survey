package com.survey.api.presentation.response;

import com.survey.api.domain.survey.item.SurveyItemType;

import java.util.List;

public record SurveyQueryResponse(
        long surveyItemId,
        SurveyItemType itemType,
        List<String> shortAnswers,
        List<String> longAnswers,
        List<Integer> selectedOptionNumbers
) {
}
