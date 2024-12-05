package com.survey.api.domain.survey.submit;

import com.survey.api.domain.survey.item.SurveyItemEntity;
import com.survey.api.global.ExceptionCode;
import com.survey.api.global.SurveyAppException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SurveySubmitManager {

    private final SurveyAnswerItemFactory surveyAnswerItemFactory;
    private final SurveyAnswersAppender surveyAnswersAppender;

    public void submit(List<SurveyItemEntity> surveyItems, List<SurveySubmitCommand> surveyAnswerCommands) {
        if (surveyItems.size() < surveyAnswerCommands.size()) {
            throw new SurveyAppException(ExceptionCode.INVALID_VALUE);
        }

        // FIXME
        surveyItems.stream()
                .filter(
                        surveyItem -> surveyAnswerCommands.stream().noneMatch(command -> surveyItem.isRequired() && surveyItem.getId().equals(command.surveyItemId()))
                ).findAny()
                .ifPresent(surveyItem -> {throw new SurveyAppException(ExceptionCode.INVALID_VALUE, surveyItem.getId()+"");});

        List<SurveyAnswerItem> surveyAnswerItems = surveyAnswerCommands.stream()
                .map(command -> {
                    SurveyItemEntity surveyItem = matchingSurveyItem(command, surveyItems);
                    return surveyAnswerItemFactory.create(surveyItem.getItemType(), surveyItem.getSurveyFormId(), command);
                })
                .toList();

        surveyAnswersAppender.append(surveyAnswerItems);
    }

    private SurveyItemEntity matchingSurveyItem(SurveySubmitCommand surveySubmitCommand, List<SurveyItemEntity> surveyItems) {
        return surveyItems.stream()
                .filter(surveyItem -> surveyItem.getId() == surveySubmitCommand.surveyItemId())
                .findAny()
                .orElseThrow(() -> new SurveyAppException(ExceptionCode.INVALID_VALUE));
    }
}
