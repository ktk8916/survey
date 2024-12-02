package com.survey.api.domain.survey.submit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SurveyAnswersAppender {

    private final SurveyAnswerRepository surveyAnswerRepository;

    public void append(List<SurveyAnswerItem> surveyAnswerItems) {
        surveyAnswerItems.forEach(
                surveyAnswerItem -> surveyAnswerRepository.saveAll(surveyAnswerItem.toEntities())
        );
    }
}
