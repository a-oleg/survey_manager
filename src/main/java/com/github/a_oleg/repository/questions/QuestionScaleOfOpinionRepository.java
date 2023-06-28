package com.github.a_oleg.repository.questions;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.entity.question.QuestionRating;
import com.github.a_oleg.entity.question.QuestionScaleOfOpinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionScaleOfOpinionRepository extends JpaRepository<QuestionScaleOfOpinion, Integer> {
    Set<QuestionScaleOfOpinion> findById(int id);
    Set<QuestionScaleOfOpinion> findBySurvey(Survey survey);
}
