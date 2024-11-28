package com.survey.api.presentation;

import com.survey.api.domain.survey.form.SurveyModifyCommand;
import com.survey.api.domain.survey.item.SurveyItemCreateCommand;

import java.util.List;

public record SurveyModifyRequest(
        String name,
        String description,
        List<SurveyItemRequest> surveyItems
) {

    public SurveyModifyCommand toCommand() {
        return new SurveyModifyCommand(
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
