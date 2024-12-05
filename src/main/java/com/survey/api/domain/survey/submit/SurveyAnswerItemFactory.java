package com.survey.api.domain.survey.submit;

import com.survey.api.domain.survey.item.SurveyItemType;
import org.springframework.stereotype.Component;

@Component
public class SurveyAnswerItemFactory {

    public SurveyAnswerItem create(SurveyItemType itemType, long surveyFormId, SurveySubmitCommand command) {
        return switch (itemType) {
            case SHORT_ANSWER -> ShortSurveyAnswer.of(surveyFormId, command);
            case LONG_ANSWER -> LongSurveyAnswer.of(surveyFormId, command);
            case SINGLE_SELECT -> SingleChoiceSurveyAnswer.of(surveyFormId, command);
            case MULTIPLE_SELECT -> MultipleChoiceSurveyAnswerItem.of(surveyFormId, command);
        };
    }
}
