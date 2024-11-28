package com.survey.api.domain.survey.item;

import java.util.List;

public record SurveyItemCreateCommand(
        String name,
        String description,
        boolean isRequired,
        String itemType,
        List<String> itemSelectOptions
) {
}
