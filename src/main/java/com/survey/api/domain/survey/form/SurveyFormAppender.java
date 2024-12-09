package com.survey.api.domain.survey.form;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SurveyFormAppender {

    private final SurveyFormRepository surveyFormRepository;

    public long append(SurveyVersionEntity firstVersion, String name, String description) {
        SurveyFormEntity surveyForm = SurveyFormEntity.initial(firstVersion, name, description);
        SurveyFormEntity savedSurveyForm = surveyFormRepository.save(surveyForm);
        return savedSurveyForm.getId();
    }

    public long appendNextVersion(SurveyVersionEntity releaseVersion, String name, String description) {
        SurveyFormEntity surveyForm = SurveyFormEntity.release(releaseVersion, name, description);
        SurveyFormEntity savedSurveyForm = surveyFormRepository.save(surveyForm);
        return savedSurveyForm.getId();
    }
}
