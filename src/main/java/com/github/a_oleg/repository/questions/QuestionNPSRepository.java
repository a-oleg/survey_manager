package com.github.a_oleg.repository.questions;

import com.github.a_oleg.entity.questions.QuestionNPS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionNPSRepository extends JpaRepository<QuestionNPS, Integer> {
    Set<QuestionNPS> findById(int id);
}
