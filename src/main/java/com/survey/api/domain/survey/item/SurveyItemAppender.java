package com.survey.api.domain.survey.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SurveyItemAppender {

    private final SurveyItemRepository surveyItemRepository;

    public long append(long surveyFormId, String name, String description, boolean isRequired, SurveyItemType itemType) {
        SurveyItemEntity surveyItem = SurveyItemEntity.create(surveyFormId, name, description, isRequired, itemType);
        SurveyItemEntity savedSurveyItem = surveyItemRepository.save(surveyItem);
        return savedSurveyItem.getId();
    }
}
