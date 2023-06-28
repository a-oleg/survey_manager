package com.github.a_oleg.repository.questions;

import com.github.a_oleg.entity.Survey;
import com.github.a_oleg.entity.question.QuestionScaleOfOpinion;
import com.github.a_oleg.entity.question.QuestionSlider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionSliderRepository extends JpaRepository<QuestionSlider, Integer> {
    Set<QuestionSlider> findById(int id);
    Set<QuestionSlider> findBySurvey(Survey survey);
}
