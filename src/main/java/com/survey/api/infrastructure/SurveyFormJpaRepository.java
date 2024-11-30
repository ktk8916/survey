package com.survey.api.infrastructure;

import com.survey.api.domain.survey.form.SurveyFormEntity;
import com.survey.api.domain.survey.form.SurveyFormRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyFormJpaRepository extends SurveyFormRepository, JpaRepository<SurveyFormEntity, Long> {
}
