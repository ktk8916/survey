package com.survey.api.domain.survey.form;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "survey_form")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyFormEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private SurveyVersionEntity surveyVersion;
    private String name;
    private String description;

    public static SurveyFormEntity begin(SurveyVersionEntity initialVersion, String name, String description) {
        if (initialVersion.isNotFirstVersion()) {
            throw new IllegalArgumentException("");
        }

        return SurveyFormEntity.builder()
                .surveyVersion(initialVersion)
                .name(name)
                .description(description)
                .build();
    }

    public static SurveyFormEntity release(SurveyVersionEntity releaseVersion, String name, String description) {
        if (releaseVersion.isFirstVersion()) {
            throw new IllegalArgumentException();
        }

        return SurveyFormEntity.builder()
                .surveyVersion(releaseVersion)
                .name(name)
                .description(description)
                .build();
    }

    public Long getId() {
        return id;
    }

    @Builder(access = AccessLevel.PRIVATE)
    private SurveyFormEntity(Long id, SurveyVersionEntity surveyVersion, String name, String description) {
        this.id = id;
        this.surveyVersion = surveyVersion;
        this.name = name;
        this.description = description;
    }
}
