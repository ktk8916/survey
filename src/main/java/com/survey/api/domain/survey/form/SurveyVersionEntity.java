package com.survey.api.domain.survey.form;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "survey_version")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyVersionEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private SurveyVersionKey surveyVersionKey;
    private Long surveyVersionNumber;

    public static SurveyVersionEntity first(SurveyVersionKeyGenerator generator) {
        return SurveyVersionEntity.builder()
                .surveyVersionKey(generator.generate())
                .surveyVersionNumber(1L)
                .build();
    }

    public static SurveyVersionEntity next(SurveyVersionEntity previousVersion) {
        return SurveyVersionEntity.builder()
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
    private SurveyVersionEntity(Long id, SurveyVersionKey surveyVersionKey, Long surveyVersionNumber) {
        this.id = id;
        this.surveyVersionKey = surveyVersionKey;
        this.surveyVersionNumber = surveyVersionNumber;
    }
}
