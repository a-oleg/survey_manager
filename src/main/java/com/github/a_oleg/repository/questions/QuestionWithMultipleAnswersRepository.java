package com.github.a_oleg.repository.questions;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.entity.question.QuestionSlider;
import com.github.a_oleg.entity.question.QuestionWithMultipleAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionWithMultipleAnswersRepository extends JpaRepository<QuestionWithMultipleAnswer, Integer> {
    Set<QuestionWithMultipleAnswer> findById(int id);
    Set<QuestionWithMultipleAnswer> findBySurvey(Survey survey);
}
