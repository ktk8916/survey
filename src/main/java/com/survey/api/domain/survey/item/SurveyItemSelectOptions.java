package com.survey.api.domain.survey.item;

import java.util.List;

public class SurveyItemSelectOptions {

    private static final int MAX_OPTION_SIZE = 10;

    private final SurveyItemType itemType;
    private final List<String> options;

    public static SurveyItemSelectOptions of(SurveyItemType itemType, List<String> options) {
        return new SurveyItemSelectOptions(itemType, options);
    }

    public boolean isQuestionType() {
        return itemType.isQuestionType();
    }

    public List<String> getOptions() {
        return options;
    }

    private SurveyItemSelectOptions(SurveyItemType itemType, List<String> options) {
        validate(itemType, options);
        this.itemType = itemType;
        this.options = options;
    }

    private void validate(SurveyItemType itemType, List<String> options) {
        if (itemType.isMultipleChoiceType() && options.isEmpty()) {
            throw new IllegalArgumentException(String.format("item type is %s, but options is empty", itemType));
        }

        if (itemType.isQuestionType() && !options.isEmpty()) {
            throw new IllegalArgumentException(String.format("item type is %s, but options is not empty", itemType));
        }

        if (options.size() > MAX_OPTION_SIZE) {
            throw new IllegalArgumentException(String.format("option size must be less than %d", MAX_OPTION_SIZE));
        }
    }
}
