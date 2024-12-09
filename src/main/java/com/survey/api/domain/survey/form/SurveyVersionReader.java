package com.survey.api.domain.survey.form;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class SurveyVersionReader {

    private final SurveyVersionRepository surveyVersionRepository;

    public SurveyVersionEntity readLatest(SurveyVersionKey surveyVersionKey) {
        return surveyVersionRepository.findLatestBySurveyVersionKey(surveyVersionKey)
                .orElseThrow(() -> new NoSuchElementException(String.format("survey version %s", surveyVersionKey.value())));
    }
}
