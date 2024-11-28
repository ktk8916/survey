package com.survey.api.domain.survey.form;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SurveyFormAppender {

    private final SurveyFormRepository surveyFormRepository;
    private final SurveyVersionRepository surveyVersionRepository;
    private final SurveyVersionKeyGenerator surveyVersionKeyGenerator;

    @Transactional
    public long append(String name, String description) {
        SurveyVersion firstVersion = SurveyVersion.first(surveyVersionKeyGenerator);
        SurveyVersion savedFirstVersion = surveyVersionRepository.save(firstVersion);

        SurveyForm surveyForm = SurveyForm.begin(savedFirstVersion, name, description);
        SurveyForm savedSurveyForm = surveyFormRepository.save(surveyForm);
        return savedSurveyForm.getId();
    }

    @Transactional
    public long appendLater(SurveyVersion previousVersion, String name, String description) {
        SurveyVersion nextVersion = SurveyVersion.next(previousVersion);
        SurveyVersion savedNextVersion = surveyVersionRepository.save(nextVersion);

        SurveyForm surveyForm = SurveyForm.release(savedNextVersion, name, description);
        SurveyForm savedSurveyForm = surveyFormRepository.save(surveyForm);
        return savedSurveyForm.getId();
    }
}
