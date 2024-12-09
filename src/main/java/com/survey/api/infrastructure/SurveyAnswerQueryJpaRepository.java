package com.survey.api.infrastructure;

import com.survey.api.domain.survey.answer.query.SurveyQueryRepository;
import com.survey.api.domain.survey.answer.query.data.SurveyAnswerData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SurveyAnswerQueryJpaRepository implements SurveyQueryRepository {
    // TODO : query dsl..
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<SurveyAnswerData> findAnswers(long surveyFormId) {
        return em.createQuery("select new com.survey.api.domain.survey.answer.query.data.SurveyAnswerData(item.id, item.itemType, answer.shortQuestionAnswer, answer.longQuestionAnswer, answer.selectedOption) " +
                        "from SurveyAnswerEntity as answer " +
                        "inner join SurveyItemEntity as item " +
                        "on answer.surveyItemId = item.id " +
                        "where answer.surveyFormId = :surveyFormId", SurveyAnswerData.class)
                .setParameter("surveyFormId", surveyFormId)
                .getResultList();
    }
}
