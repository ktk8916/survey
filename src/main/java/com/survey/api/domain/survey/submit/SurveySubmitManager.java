package com.survey.api.domain.survey.submit;

import com.survey.api.domain.survey.item.SurveyItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class SurveySubmitManager {

    private final SurveyAnswerItemFactory surveyAnswerItemFactory;
    private final SurveyAnswersAppender surveyAnswersAppender;

    public void submit(List<SurveyItemEntity> surveyItems, List<SurveySubmitCommand> surveyAnswerCommands) {
        if (surveyItems.size() != surveyAnswerCommands.size()) {
            throw new IllegalArgumentException();
        }

        List<SurveyAnswerItem> surveyAnswerItems = IntStream.range(0, surveyItems.size())
                .mapToObj(index -> {
                    SurveyItemEntity surveyItem = surveyItems.get(index);
                    SurveySubmitCommand command = surveyAnswerCommands.get(index);
                    if (surveyItem.getId() != command.surveyItemId()) {
                        throw new IllegalArgumentException();
                    }
                    return surveyAnswerItemFactory.create(surveyItem.getSurveyFormId(), surveyItem.getItemType(), command);
                })
                .toList();

        surveyAnswersAppender.append(surveyAnswerItems);
    }
}
