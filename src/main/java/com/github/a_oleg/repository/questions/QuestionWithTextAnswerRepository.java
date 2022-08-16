package com.github.a_oleg.repository.questions;

import com.github.a_oleg.entity.Survey;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionWithTextAnswerRepository {
    Set<Survey> findById(int id);
}
