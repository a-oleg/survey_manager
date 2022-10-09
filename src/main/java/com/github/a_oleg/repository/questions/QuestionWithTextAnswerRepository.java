package com.github.a_oleg.repository.questions;

import com.github.a_oleg.entity.question.QuestionWithTextAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionWithTextAnswerRepository extends JpaRepository<QuestionWithTextAnswer, Integer> {
    Set<QuestionWithTextAnswer> findById(int id);
}
