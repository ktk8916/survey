package com.survey.api.domain.survey.submit;

import java.util.List;

public interface SurveyAnswerRepository {
    SurveyAnswerEntity save(SurveyAnswerEntity surveySubmit);
    <S extends SurveyAnswerEntity> List<S> saveAll(Iterable<S> surveySubmits);
}
