package com.survey.api.domain.survey.item;

import java.util.List;

public class SurveyItems {
    private String name;
    private String description;
    private boolean isRequired;
    private SurveyItemType itemType;
    private List<String> selectOptions;
}
