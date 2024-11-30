package com.survey.api.domain.survey.form;

import java.util.Optional;

public interface SurveyVersionRepository {

    Optional<SurveyVersionEntity> findLatestBySurveyVersionKey(SurveyVersionKey surveyVersionKey);
    SurveyVersionEntity save(SurveyVersionEntity surveyVersion);
}
