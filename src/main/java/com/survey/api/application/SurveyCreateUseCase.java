package com.survey.api.application;

import com.survey.api.domain.survey.form.SurveyCreateCommand;
import com.survey.api.domain.survey.form.SurveyFormAppender;
import com.survey.api.domain.survey.item.SurveyItemManager;
import com.survey.api.domain.survey.item.SurveyItemType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyCreateUseCase {

    private final SurveyFormAppender surveyFormAppender;
    private final SurveyItemManager surveyItemManager;

    @Transactional
    public long create(SurveyCreateCommand command) {
        long surveyFormId = surveyFormAppender.append(command.name(), command.description());
        surveyItemManager.registerAll(surveyFormId, command.itemCommands());
        return surveyFormId;
    }
}
