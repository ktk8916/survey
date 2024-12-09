package com.survey.api.application;

import com.survey.api.domain.survey.answer.query.SurveyQueryRepository;
import com.survey.api.domain.survey.answer.query.data.SurveyAnswerData;
import com.survey.api.presentation.response.SurveyQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyAnswerQueryService {

    private final SurveyQueryRepository surveyQueryRepository;

    public List<SurveyQueryResponse> findById(long surveyFormId) {
        List<SurveyAnswerData> answers = surveyQueryRepository.findAnswers(surveyFormId);
        return null;
    }
}
