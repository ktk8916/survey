package com.survey.api.domain.survey.submit;

import com.survey.api.domain.survey.item.SurveyItemType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyAnswer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long surveyFormId;
    private Long surveyItemId;
    private SurveyItemType itemType;

}
