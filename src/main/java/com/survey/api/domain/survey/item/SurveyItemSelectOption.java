package com.survey.api.domain.survey.item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyItemSelectOption {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long surveyItemId;
    private String content;

    public static SurveyItemSelectOption create(long surveyItemId, String content) {
        return SurveyItemSelectOption.builder()
                .surveyItemId(surveyItemId)
                .content(content)
                .build();
    }

    @Builder(access = AccessLevel.PRIVATE)
    private SurveyItemSelectOption(Long id, Long surveyItemId, String content) {
        this.id = id;
        this.surveyItemId = surveyItemId;
        this.content = content;
    }
}
