package com.survey.api.domain.survey.form;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyVersion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surveyVersionKey;
    private Long surveyVersionNumber;

    public static SurveyVersion first(String surveyVersionKey) {
        return SurveyVersion.builder()
                .surveyVersionKey(surveyVersionKey)
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
    private SurveyVersion(Long id, String surveyVersionKey, Long surveyVersionNumber) {
        this.id = id;
        this.surveyVersionKey = surveyVersionKey;
        this.surveyVersionNumber = surveyVersionNumber;
    }
}
