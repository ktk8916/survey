package com.survey.api.domain.survey.form;

import java.util.Optional;

public interface SurveyVersionRepository {

    Optional<SurveyVersion> findLatestBySurveyVersionKey(String surveyVersionKey);
    SurveyVersion save(SurveyVersion surveyVersion);
}
