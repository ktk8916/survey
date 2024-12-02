package com.survey.api.application;

import com.survey.api.domain.survey.item.SurveyItemEntity;
import com.survey.api.domain.survey.item.SurveyItemReader;
import com.survey.api.domain.survey.submit.SurveyAnswerSubmitCommand;
import com.survey.api.domain.survey.submit.SurveySubmitManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveySubmitUseCase {

    private final SurveyItemReader surveyItemReader;
    private final SurveySubmitManager surveySubmitManager;

    public void submit(long surveyFormId, List<SurveyAnswerSubmitCommand> surveyAnswerCommands) {
        List<SurveyItemEntity> surveyItems = surveyItemReader.read(surveyFormId);
        surveySubmitManager.submit(surveyItems, surveyAnswerCommands);
    }
}
