package com.survey.api.infrastructure;

import com.survey.api.domain.survey.answer.SurveyAnswerEntity;
import com.survey.api.domain.survey.answer.SurveyAnswerRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SurveyAnswerJpaRepository extends SurveyAnswerRepository, JpaRepository<SurveyAnswerEntity, Long> {
}
