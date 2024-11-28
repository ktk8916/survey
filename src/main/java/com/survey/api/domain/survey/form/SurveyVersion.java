package com.survey.api.domain.survey.form;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyVersion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private SurveyVersionKey surveyVersionKey;
    private Long surveyVersionNumber;

    // TODO : 수정..
    public static SurveyVersion first(SurveyVersionKeyGenerator generator) {
        return SurveyVersion.builder()
                .surveyVersionKey(generator.generate())
                .surveyVersionNumber(1L)
                .build();
    }

    public static SurveyVersion next(SurveyVersion previousVersion) {
        return SurveyVersion.builder()
                .surveyVersionKey(previousVersion.surveyVersionKey)
                .surveyVersionNumber(previousVersion.surveyVersionNumber + 1)
                .build();
    }

    public boolean isFirstVersion() {
        return surveyVersionNumber == 1;
    }

    public boolean isNotFirstVersion() {
        return !isFirstVersion();
    }

    @Builder(access = AccessLevel.PRIVATE)
    private SurveyVersion(Long id, SurveyVersionKey surveyVersionKey, Long surveyVersionNumber) {
        this.id = id;
        this.surveyVersionKey = surveyVersionKey;
        this.surveyVersionNumber = surveyVersionNumber;
    }
}
