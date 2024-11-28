package com.survey.api.domain.survey.form;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyForm {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private SurveyVersion surveyVersion;
    private String name;
    private String description;

    public static SurveyForm begin(SurveyVersion initialVersion, String name, String description) {
        if (initialVersion.isNotFirstVersion()) {
            throw new IllegalArgumentException("");
        }

        return SurveyForm.builder()
                .surveyVersion(initialVersion)
                .name(name)
                .description(description)
                .build();
    }

    public static SurveyForm release(SurveyVersion releaseVersion, String name, String description) {
        if (releaseVersion.isFirstVersion()) {
            throw new IllegalArgumentException();
        }

        return SurveyForm.builder()
                .surveyVersion(releaseVersion)
                .name(name)
                .description(description)
                .build();
    }

    public Long getId() {
        return id;
    }

    @Builder(access = AccessLevel.PRIVATE)
    private SurveyForm(Long id, SurveyVersion surveyVersion, String name, String description) {
        this.id = id;
        this.surveyVersion = surveyVersion;
        this.name = name;
        this.description = description;
    }
}
