package com.survey.api.domain.survey.form;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record SurveyVersionKey(
        @Column(name = "survey_version_key", columnDefinition = "varchar (100)")
        UUID value
) {
        public static SurveyVersionKey from(String value) {
                return new SurveyVersionKey(UUID.fromString(value));
        }

        public static SurveyVersionKey of(UUID uuid) {
                return new SurveyVersionKey(uuid);
        }
}
