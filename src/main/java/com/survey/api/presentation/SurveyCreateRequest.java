package com.survey.api.presentation;

import com.survey.api.domain.survey.form.SurveyCreateCommand;
import com.survey.api.domain.survey.item.SurveyItemCreateCommand;

import java.util.List;

public record SurveyCreateRequest(
    String name,
    String description,
    List<SurveyItemRequest> surveyItems
) {

    public SurveyCreateCommand toCommand() {
        return new SurveyCreateCommand(
                name,
                description,
                surveyItems.stream()
                        .map(SurveyItemRequest::toCommand)
                        .toList()
        );
    }

    public record SurveyItemRequest(
            String name,
            String description,
            boolean isRequired,
            String surveyItemType,
            List<String> selectOptions
    ) {
        public SurveyItemCreateCommand toCommand() {
            return new SurveyItemCreateCommand(
                    name,
                    description,
                    isRequired,
                    surveyItemType,
                    selectOptions
            );
        }

    }
}
