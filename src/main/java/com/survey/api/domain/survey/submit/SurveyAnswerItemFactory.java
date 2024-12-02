package com.survey.api.domain.survey.submit;

import com.survey.api.domain.survey.item.SurveyItemType;
import org.springframework.stereotype.Component;

@Component
public class SurveyAnswerItemFactory {

    public SurveyAnswerItem create(long surveyFormId, SurveyItemType itemType, SurveyAnswerSubmitCommand command) {
        return switch (itemType) {
            case SHORT_ANSWER -> ShortSurveyAnswer.of(surveyFormId, command);
            default -> throw new RuntimeException();
        };

    }
}
