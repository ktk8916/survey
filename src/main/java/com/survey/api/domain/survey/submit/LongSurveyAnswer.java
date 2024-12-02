package com.survey.api.domain.survey.submit;

public record LongSurveyAnswer(
        String value
) {

    public LongSurveyAnswer {
        int longSurveyAnswerMaxLength = 1000;
        if (value.isBlank() || value.length() > longSurveyAnswerMaxLength) {
            throw new IllegalArgumentException();
        }
    }
    public static LongSurveyAnswer of(String value) {
        return new LongSurveyAnswer(value);
    }
}
