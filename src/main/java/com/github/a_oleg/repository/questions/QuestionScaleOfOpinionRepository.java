package com.github.a_oleg.repository.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionScaleOfOpinionRepository extends JpaRepository<QuestionScaleOfOpinionRepository, Integer> {
    Set<QuestionScaleOfOpinionRepository> findById(int id);
}
