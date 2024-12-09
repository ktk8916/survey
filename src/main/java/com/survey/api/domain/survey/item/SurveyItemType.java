package com.survey.api.domain.survey.item;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum SurveyItemType {

    SHORT_ANSWER("단답형"),
    LONG_ANSWER("장문형"),
    SINGLE_SELECT("단일 선택"),
    MULTIPLE_SELECT("다중 선택");

    private final String description;

    public boolean isMultipleChoiceType() {
        SurveyItemGroup surveyItemGroup = SurveyItemGroup.findByItemType(this);
        return SurveyItemGroup.MULTIPLE_CHOICE == surveyItemGroup;
    }

    public boolean isQuestionType() {
        SurveyItemGroup surveyItemGroup = SurveyItemGroup.findByItemType(this);
        return SurveyItemGroup.QUESTION == surveyItemGroup;
    }

    public static SurveyItemType findByTypeName(String name) {
        return Arrays.stream(SurveyItemType.values())
                .filter(itemType -> itemType.name().equalsIgnoreCase(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("type name %s does not exist", name)));
    }
}
