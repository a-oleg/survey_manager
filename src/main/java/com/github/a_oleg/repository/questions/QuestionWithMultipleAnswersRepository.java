package com.github.a_oleg.repository.questions;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.entity.question.QuestionWithMultipleAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionWithMultipleAnswersRepository extends JpaRepository<QuestionWithMultipleAnswers, Integer> {
    Set<QuestionWithMultipleAnswers> findById(int id);
    Set<QuestionWithMultipleAnswers> findBySurvey(Survey survey);
}
