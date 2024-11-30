package com.survey.api.infrastructure;

import com.survey.api.domain.survey.item.SurveyItemEntity;
import com.survey.api.domain.survey.item.SurveyItemRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyItemJpaRepository extends SurveyItemRepository, JpaRepository<SurveyItemEntity, Long> {
}
