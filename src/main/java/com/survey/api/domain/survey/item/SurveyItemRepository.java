package com.survey.api.domain.survey.item;

import java.util.List;
import java.util.Optional;

public interface SurveyItemRepository {

    List<SurveyItemEntity> findBySurveyFormId(long surveyFormId);
    SurveyItemEntity save(SurveyItemEntity surveyItem);
}
