package com.survey.api.application;

import com.survey.api.domain.survey.form.SurveyFormAppender;
import com.survey.api.domain.survey.form.SurveyModifyCommand;
import com.survey.api.domain.survey.form.SurveyVersion;
import com.survey.api.domain.survey.form.SurveyVersionReader;
import com.survey.api.domain.survey.item.SurveyItemManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyModifyUseCase {

    private final SurveyVersionReader surveyVersionReader;
    private final SurveyFormAppender surveyFormAppender;
    private final SurveyItemManager surveyItemManager;

    public long modify(String surveyVersionKey, SurveyModifyCommand command) {
        SurveyVersion latestVersion = surveyVersionReader.readLatest(surveyVersionKey);
        long surveyFormId = surveyFormAppender.appendLater(
                latestVersion,
                command.name(),
                command.description()
        );
        surveyItemManager.registerAll(surveyFormId, command.itemCommands());
        return surveyFormId;
    }
}
