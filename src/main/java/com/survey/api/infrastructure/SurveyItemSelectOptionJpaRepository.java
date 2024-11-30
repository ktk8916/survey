package com.survey.api.infrastructure;

import com.survey.api.domain.survey.item.SurveyItemSelectOptionEntity;
import com.survey.api.domain.survey.item.SurveyItemSelectOptionRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyItemSelectOptionJpaRepository extends SurveyItemSelectOptionRepository, JpaRepository<SurveyItemSelectOptionEntity, Long> {

}
