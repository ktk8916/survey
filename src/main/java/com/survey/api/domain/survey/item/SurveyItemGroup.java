package com.survey.api.domain.survey.item;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public enum SurveyItemGroup {

    QUESTION("주관식", List.of(SurveyItemType.SHORT_ANSWER, SurveyItemType.LONG_ANSWER)),
    MULTIPLE_CHOICE("객관식", List.of(SurveyItemType.SINGLE_SELECT, SurveyItemType.MULTIPLE_SELECT));

    private final String description;
    private final List<SurveyItemType> itemTypes;

    public static SurveyItemGroup findByItemType(SurveyItemType type) {
        return Arrays.stream(SurveyItemGroup.values())
                .filter(surveyItemGroup -> surveyItemGroup.hasSurveyItemType(type))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("every item type must belong to a group"));
    }

    public boolean hasSurveyItemType(SurveyItemType type) {
        return itemTypes.contains(type);
    }
}
