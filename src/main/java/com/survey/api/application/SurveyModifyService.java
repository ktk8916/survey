package com.survey.api.application;

import com.survey.api.domain.survey.form.*;
import com.survey.api.domain.survey.item.SurveyItemManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SurveyModifyService {

    private final SurveyVersionReader surveyVersionReader;
    private final SurveyVersionManager surveyVersionManager;
    private final SurveyFormAppender surveyFormAppender;
    private final SurveyItemManager surveyItemManager;

    @Transactional
    public long modify(SurveyVersionKey surveyVersionKey, SurveyModifyCommand command) {
        SurveyVersionEntity latestVersion = surveyVersionReader.readLatest(surveyVersionKey);
        SurveyVersionEntity nextVersion = surveyVersionManager.increase(latestVersion);
        long surveyFormId = surveyFormAppender.appendNextVersion(
                nextVersion,
                command.name(),
                command.description()
        );
        surveyItemManager.registerAll(surveyFormId, command.itemCommands());
        return surveyFormId;
    }
}
