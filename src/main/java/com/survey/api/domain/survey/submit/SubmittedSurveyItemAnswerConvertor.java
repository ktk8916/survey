package com.survey.api.domain.survey.submit;

import com.survey.api.domain.survey.item.SurveyItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SubmittedSurveyItemAnswerConvertor {

    private final SurveyItemAnswerFactory surveyItemAnswerFactory;

    public List<SurveyItemAnswer> convert(List<SurveyItemEntity> surveyItems, List<SubmittedSurveyItemAnswer> itemAnswers) {
        if (isValidSubmit(surveyItems, itemAnswers)) {
            throw new IllegalArgumentException("answers size can't be greater than items size");
        }

        Map<Long, SubmittedSurveyItemAnswer> itemAnswerMap = getItemAnswerMap(itemAnswers);

        return surveyItems.stream()
                .filter(surveyItem -> isSubmitted(surveyItem, itemAnswerMap))
                .map(surveyItem -> toSurveyItemAnswer(surveyItem, itemAnswerMap))
                .toList();
    }

    private boolean isValidSubmit(List<SurveyItemEntity> surveyItems, List<SubmittedSurveyItemAnswer> itemAnswers) {
        return surveyItems.size() < itemAnswers.size();
    }

    private Map<Long, SubmittedSurveyItemAnswer> getItemAnswerMap(List<SubmittedSurveyItemAnswer> itemAnswers) {
        return itemAnswers.stream()
                .collect(Collectors.toMap(
                        SubmittedSurveyItemAnswer::surveyItemId,
                        answer -> answer
                ));
    }

    private boolean isSubmitted(SurveyItemEntity surveyItem, Map<Long, SubmittedSurveyItemAnswer> itemAnswerMap) {
        boolean contains = itemAnswerMap.containsKey(surveyItem.getId());
        if (surveyItem.isRequired() && !contains) {
            throw new IllegalArgumentException(String.format("item %d is required submission", surveyItem.getId()));
        }
        return contains;
    }

    private SurveyItemAnswer toSurveyItemAnswer(SurveyItemEntity surveyItem, Map<Long, SubmittedSurveyItemAnswer> itemAnswerMap) {
        return surveyItemAnswerFactory.create(
                surveyItem.getItemType(),
                surveyItem.getSurveyFormId(),
                itemAnswerMap.get(surveyItem.getId()));
    }
}
