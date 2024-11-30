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
        SurveyVersionEntity firstVersion = SurveyVersionEntity.first(surveyVersionKeyGenerator);
        SurveyVersionEntity savedFirstVersion = surveyVersionRepository.save(firstVersion);

        SurveyFormEntity surveyForm = SurveyFormEntity.begin(savedFirstVersion, name, description);
        SurveyFormEntity savedSurveyForm = surveyFormRepository.save(surveyForm);
        return savedSurveyForm.getId();
    }

    @Transactional
    public long appendLater(SurveyVersionEntity previousVersion, String name, String description) {
        SurveyVersionEntity nextVersion = SurveyVersionEntity.next(previousVersion);
        SurveyVersionEntity savedNextVersion = surveyVersionRepository.save(nextVersion);

        SurveyFormEntity surveyForm = SurveyFormEntity.release(savedNextVersion, name, description);
        SurveyFormEntity savedSurveyForm = surveyFormRepository.save(surveyForm);
        return savedSurveyForm.getId();
    }
}
