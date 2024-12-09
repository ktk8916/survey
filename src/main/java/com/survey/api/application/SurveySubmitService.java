package com.survey.api.application;

import com.survey.api.domain.survey.item.SurveyItemEntity;
import com.survey.api.domain.survey.item.SurveyItemReader;
import com.survey.api.domain.survey.answer.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveySubmitService {

    private final SurveyItemReader surveyItemReader;
    private final SubmittedSurveyItemAnswerConvertor submittedSurveyItemAnswerConvertor;
    private final SurveyAnswersAppender surveyAnswersAppender;

    public void submit(long surveyFormId, List<SubmittedSurveyItemAnswer> submittedSurveyItemAnswers) {
        List<SurveyItemEntity> surveyItems = surveyItemReader.read(surveyFormId);
        List<SurveyItemAnswer> itemAnswers = submittedSurveyItemAnswerConvertor.convert(surveyItems, submittedSurveyItemAnswers);
        surveyAnswersAppender.append(itemAnswers);
    }
}
