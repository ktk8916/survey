package com.survey.api.domain.survey.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class SurveyItemReader {

    private final SurveyItemRepository surveyItemRepository;

    public List<SurveyItemEntity> read(long surveyFormId) {
        List<SurveyItemEntity> surveyItems = surveyItemRepository.findBySurveyFormId(surveyFormId);
        if (surveyItems.isEmpty()) {
            throw new NoSuchElementException();
        }
        return surveyItems;
    }
}
