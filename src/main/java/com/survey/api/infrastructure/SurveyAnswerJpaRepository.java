package com.survey.api.infrastructure;

import com.survey.api.domain.survey.submit.SurveyAnswerEntity;
import com.survey.api.domain.survey.submit.SurveyAnswerRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyAnswerJpaRepository extends SurveyAnswerRepository, JpaRepository<SurveyAnswerEntity, Long> {
}
