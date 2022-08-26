package com.github.a_oleg.repository.questions;

import com.github.a_oleg.entity.questions.QuestionRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionRatingRepository extends JpaRepository<QuestionRating, Integer> {
    Set<QuestionRating> findById(int id);
}
