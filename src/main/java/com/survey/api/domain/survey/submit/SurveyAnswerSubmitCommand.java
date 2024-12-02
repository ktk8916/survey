package com.survey.api.domain.survey.submit;

import java.util.List;

public record SurveyAnswerSubmitCommand(
        long surveyItemId,
        String questionAnswer,
        Integer singleChoiceAnswer,
        List<Integer> multipleChoiceAnswer
) {
}
