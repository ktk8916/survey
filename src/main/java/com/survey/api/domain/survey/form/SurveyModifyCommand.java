package com.survey.api.domain.survey.form;

import com.survey.api.domain.survey.item.SurveyItemCreateCommand;

import java.util.List;

public record SurveyModifyCommand(
        String name,
        String description,
        List<SurveyItemCreateCommand> itemCommands
) {
}
