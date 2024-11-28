package com.survey.api.domain.survey.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SurveyItemAppender {

    private final SurveyItemRepository surveyItemRepository;

    public long append(long surveyFormId, String name, String description, boolean isRequired, SurveyItemType itemType) {
        SurveyItem surveyItem = SurveyItem.create(surveyFormId, name, description, isRequired, itemType);
        SurveyItem savedSurveyItem = surveyItemRepository.save(surveyItem);
        return savedSurveyItem.getId();
    }
}
