package com.survey.api.domain.survey.item;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "survey_item_select_option")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyItemSelectOptionEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long surveyItemId;
    private String content;

    public static SurveyItemSelectOptionEntity create(long surveyItemId, String content) {
        return SurveyItemSelectOptionEntity.builder()
                .surveyItemId(surveyItemId)
                .content(content)
                .build();
    }

    @Builder(access = AccessLevel.PRIVATE)
    private SurveyItemSelectOptionEntity(Long id, Long surveyItemId, String content) {
        this.id = id;
        this.surveyItemId = surveyItemId;
        this.content = content;
    }
}
