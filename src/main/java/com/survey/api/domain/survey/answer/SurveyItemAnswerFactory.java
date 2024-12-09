package com.survey.api.domain.survey.answer;

import com.survey.api.domain.survey.item.SurveyItemType;
import org.springframework.stereotype.Component;

@Component
public class SurveyItemAnswerFactory {

    public SurveyItemAnswer create(SurveyItemType itemType, long surveyFormId, SubmittedSurveyItemAnswer itemAnswer) {
        return switch (itemType) {
            case SHORT_ANSWER -> ShortSurveyItemAnswer.of(surveyFormId, itemAnswer);
            case LONG_ANSWER -> LongSurveyItemAnswer.of(surveyFormId, itemAnswer);
            case SINGLE_SELECT -> SingleChoiceSurveyItemAnswer.of(surveyFormId, itemAnswer);
            case MULTIPLE_SELECT -> MultipleChoiceSurveyItemAnswer.of(surveyFormId, itemAnswer);
        };
    }
}
