package com.survey.api.domain.survey.item;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long surveyFormId;
    private String name;
    private String description;
    private boolean isRequired;
    @Enumerated(EnumType.STRING)
    private SurveyItemType itemType;

    public long getId() {
        return id;
    }

    public static SurveyItem create(long surveyFormId, String name, String description, boolean isRequired, SurveyItemType itemType) {
        return SurveyItem.builder()
                .surveyFormId(surveyFormId)
                .name(name)
                .description(description)
                .isRequired(isRequired)
                .itemType(itemType)
                .build();
    }

    @Builder(access = AccessLevel.PRIVATE)
    private SurveyItem(Long id, Long surveyFormId, String name, String description, boolean isRequired, SurveyItemType itemType) {
        this.id = id;
        this.surveyFormId = surveyFormId;
        this.name = name;
        this.description = description;
        this.isRequired = isRequired;
        this.itemType = itemType;
    }
}
