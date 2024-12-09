package com.survey.api.application;

import com.survey.api.domain.survey.form.SurveyCreateCommand;
import com.survey.api.domain.survey.form.SurveyFormAppender;
import com.survey.api.domain.survey.form.SurveyVersionEntity;
import com.survey.api.domain.survey.form.SurveyVersionManager;
import com.survey.api.domain.survey.item.SurveyItemManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyCreateService {

    private final SurveyVersionManager surveyVersionManager;
    private final SurveyFormAppender surveyFormAppender;
    private final SurveyItemManager surveyItemManager;

    @Transactional
    public long create(SurveyCreateCommand command) {
        SurveyVersionEntity initialVersion = surveyVersionManager.initial();
        long surveyFormId = surveyFormAppender.append(initialVersion, command.name(), command.description());
        surveyItemManager.registerAll(surveyFormId, command.itemCommands());
        return surveyFormId;
    }
}
