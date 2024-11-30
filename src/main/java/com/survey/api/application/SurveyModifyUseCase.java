package com.survey.api.application;

import com.survey.api.domain.survey.form.*;
import com.survey.api.domain.survey.item.SurveyItemManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyModifyUseCase {

    private final SurveyVersionReader surveyVersionReader;
    private final SurveyFormAppender surveyFormAppender;
    private final SurveyItemManager surveyItemManager;

    public long modify(SurveyVersionKey surveyVersionKey, SurveyModifyCommand command) {
        SurveyVersionEntity latestVersion = surveyVersionReader.readLatest(surveyVersionKey);
        long surveyFormId = surveyFormAppender.appendLater(
                latestVersion,
                command.name(),
                command.description()
        );
        surveyItemManager.registerAll(surveyFormId, command.itemCommands());
        return surveyFormId;
    }
}
