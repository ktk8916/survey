package com.survey.api.domain.survey.form;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SurveyVersionManager {

    private final SurveyVersionKeyGenerator surveyVersionKeyGenerator;
    private final SurveyVersionRepository surveyVersionRepository;

    public SurveyVersionEntity initial() {
        SurveyVersionEntity firstVersion = SurveyVersionEntity.first(surveyVersionKeyGenerator);
        return surveyVersionRepository.save(firstVersion);
    }

    public SurveyVersionEntity increase(SurveyVersionEntity previousVersion) {
        SurveyVersionEntity nextVersion = SurveyVersionEntity.next(previousVersion);
        return surveyVersionRepository.save(nextVersion);
    }
}
