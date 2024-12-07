package com.survey.api.domain.survey.submit;

import com.survey.api.domain.survey.item.SurveyItemType;
import org.springframework.stereotype.Component;

@Component
public class SurveyAnswerItemFactory {

    public SurveyAnswerItem create(SurveyItemType itemType, long surveyFormId, SurveySubmitCommand command) {
        return switch (itemType) {
            case SHORT_ANSWER -> ShortSurveyAnswerItem.of(surveyFormId, command);
            case LONG_ANSWER -> LongSurveyAnswerItem.of(surveyFormId, command);
            case SINGLE_SELECT -> SingleChoiceSurveyAnswerItem.of(surveyFormId, command);
            case MULTIPLE_SELECT -> MultipleChoiceSurveyAnswerItem.of(surveyFormId, command);
        };
    }
}
