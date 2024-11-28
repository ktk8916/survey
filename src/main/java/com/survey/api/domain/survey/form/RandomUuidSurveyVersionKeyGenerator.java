package com.survey.api.domain.survey.form;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RandomUuidSurveyVersionKeyGenerator implements SurveyVersionKeyGenerator {
    @Override
    public SurveyVersionKey generate() {
        return SurveyVersionKey.of(UUID.randomUUID());
    }
}
