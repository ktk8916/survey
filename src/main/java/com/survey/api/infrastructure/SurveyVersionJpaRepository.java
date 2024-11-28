package com.survey.api.infrastructure;

import com.survey.api.domain.survey.form.SurveyVersion;
import com.survey.api.domain.survey.form.SurveyVersionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SurveyVersionJpaRepository extends SurveyVersionRepository, JpaRepository<SurveyVersion, Long> {
    @Query("select s " +
            "from SurveyVersion s " +
            "where s.surveyVersionKey = :surveyVersionKey " +
            "order by s.surveyVersionNumber desc " +
            "limit 1")
    Optional<SurveyVersion> findLatestBySurveyVersionKey(@Param("surveyVersionKey") String surveyVersionKey);
}
