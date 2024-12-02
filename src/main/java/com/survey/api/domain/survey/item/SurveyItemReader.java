package com.survey.api.domain.survey.item;

import com.survey.api.global.ExceptionCode;
import com.survey.api.global.SurveyAppException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SurveyItemReader {

    private final SurveyItemRepository surveyItemRepository;

    public List<SurveyItemEntity> read(long surveyFormId) {
        List<SurveyItemEntity> surveyItems = surveyItemRepository.findBySurveyFormId(surveyFormId);
        if (surveyItems.isEmpty()) {
            throw new SurveyAppException(ExceptionCode.NOT_FOUND);
        }
        return surveyItems;
    }
}
