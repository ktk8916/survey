package com.survey.api.domain.survey.form;

import com.survey.api.global.ExceptionCode;
import com.survey.api.global.SurveyAppException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SurveyVersionReader {

    private final SurveyVersionRepository surveyVersionRepository;

    public SurveyVersion readLatest(String surveyVersionKey) {
        return surveyVersionRepository.findLatestBySurveyVersionKey(surveyVersionKey)
                .orElseThrow(() -> new SurveyAppException(
                        ExceptionCode.NOT_FOUND,
                        String.format("not found survey version %s", surveyVersionKey))
                );
    }
}
