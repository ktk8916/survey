package com.survey.api.domain.survey.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SurveyItemSelectOptionAppender {

    private final SurveyItemSelectOptionRepository surveyItemSelectOptionRepository;

    public void appendAll(long surveyItemId, SurveyItemSelectOptions itemSelectOptions) {
        if (itemSelectOptions.isQuestionType()) {
            return;
        }

        List<String> contents = itemSelectOptions.getOptions();
        List<SurveyItemSelectOption> selectOptions = contents.stream()
                .map(content -> SurveyItemSelectOption.create(surveyItemId, content))
                .toList();
        surveyItemSelectOptionRepository.saveAll(selectOptions);
    }
}
