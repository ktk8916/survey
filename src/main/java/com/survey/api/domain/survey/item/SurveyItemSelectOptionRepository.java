package com.survey.api.domain.survey.item;

import java.util.List;

public interface SurveyItemSelectOptionRepository {

    <S extends SurveyItemSelectOption> List<S> saveAll(Iterable<S> SurveyItemSelectOptions);
}
