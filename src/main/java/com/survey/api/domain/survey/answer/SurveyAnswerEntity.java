package com.survey.api.domain.survey.answer;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "survey_answer")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyAnswerEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long surveyFormId;
    private Long surveyItemId;
    private String shortQuestionAnswer;
    private String longQuestionAnswer;
    private Integer selectedOption;

    public static SurveyAnswerEntity ofShortQuestion(long surveyFormId, long surveyItemId, String shortQuestionAnswer) {
        return SurveyAnswerEntity.builder()
                .surveyFormId(surveyFormId)
                .surveyItemId(surveyItemId)
                .shortQuestionAnswer(shortQuestionAnswer)
                .build();
    }

    public static SurveyAnswerEntity ofLongQuestion(long surveyFormId, long surveyItemId, String longQuestionAnswer) {
        return SurveyAnswerEntity.builder()
                .surveyFormId(surveyFormId)
                .surveyItemId(surveyItemId)
                .longQuestionAnswer(longQuestionAnswer)
                .build();
    }

    public static SurveyAnswerEntity ofMultipleChoice(long surveyFormId, long surveyItemId, int selectedOption) {
        return SurveyAnswerEntity.builder()
                .surveyFormId(surveyFormId)
                .surveyItemId(surveyItemId)
                .selectedOption(selectedOption)
                .build();
    }

    @Builder(access = AccessLevel.PRIVATE)
    private SurveyAnswerEntity(Long id, Long surveyFormId, Long surveyItemId, String shortQuestionAnswer, String longQuestionAnswer, Integer selectedOption) {
        this.id = id;
        this.surveyFormId = surveyFormId;
        this.surveyItemId = surveyItemId;
        this.shortQuestionAnswer = shortQuestionAnswer;
        this.longQuestionAnswer = longQuestionAnswer;
        this.selectedOption = selectedOption;
    }
}
