package com.survey.api.domain.survey.answer.query;

import com.survey.api.domain.survey.answer.query.data.SurveyAnswerData;

import java.util.List;

public interface SurveyQueryRepository {

    List<SurveyAnswerData> findAnswers(long surveyFormId);
}
