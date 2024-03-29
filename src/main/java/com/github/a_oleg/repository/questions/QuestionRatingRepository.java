package com.github.a_oleg.repository.questions;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.entity.question.QuestionNPS;
import com.github.a_oleg.entity.question.QuestionRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionRatingRepository extends JpaRepository<QuestionRating, Integer> {
    Set<QuestionRating> findById(int id);
    Set<QuestionRating> findBySurvey(Survey survey);
}
