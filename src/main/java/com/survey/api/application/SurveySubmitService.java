package com.survey.api.application;

import com.survey.api.domain.survey.item.SurveyItemEntity;
import com.survey.api.domain.survey.item.SurveyItemReader;
import com.survey.api.domain.survey.submit.SurveySubmitCommand;
import com.survey.api.domain.survey.submit.SurveySubmitManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveySubmitService {

    private final SurveyItemReader surveyItemReader;
    private final SurveySubmitManager surveySubmitManager;

    public void submit(long surveyFormId, List<SurveySubmitCommand> surveyAnswerCommands) {
        List<SurveyItemEntity> surveyItems = surveyItemReader.read(surveyFormId);
        surveySubmitManager.submit(surveyItems, surveyAnswerCommands);
    }
}
