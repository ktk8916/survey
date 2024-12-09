package com.survey.api.domain.survey.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SurveyItemManager {

    private final SurveyItemAppender surveyItemAppender;
    private final SurveyItemSelectOptionAppender selectOptionAppender;

    public void registerAll(long surveyFormId, List<SurveyItemCreateCommand> surveyItems) {
        if (surveyItems.isEmpty()) {
            throw new IllegalArgumentException("survey items can't be empty");
        }

        surveyItems.forEach(
                surveyItem -> {
                    SurveyItemType itemType = SurveyItemType.findByTypeName(surveyItem.itemType());
                    long surveyItemId = surveyItemAppender.append(
                            surveyFormId,
                            surveyItem.name(),
                            surveyItem.description(),
                            surveyItem.isRequired(),
                            itemType
                    );
                    SurveyItemSelectOptions itemSelectOptions = SurveyItemSelectOptions.of(itemType, surveyItem.itemSelectOptions());
                    selectOptionAppender.appendAll(surveyItemId, itemSelectOptions);
                }
        );
    }
}
