package com.survey.api.domain.survey.item;

import com.survey.api.global.ExceptionCode;
import com.survey.api.global.SurveyAppException;
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
            throw new SurveyAppException(ExceptionCode.INVALID_VALUE);
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
