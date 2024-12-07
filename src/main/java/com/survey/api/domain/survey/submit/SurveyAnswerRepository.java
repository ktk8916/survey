package com.survey.api.domain.survey.submit;

import java.util.List;
import java.util.Optional;

public interface SurveyAnswerRepository {
    SurveyAnswerEntity save(SurveyAnswerEntity surveySubmit);
    <S extends SurveyAnswerEntity> List<S> saveAll(Iterable<S> surveySubmits);
}
