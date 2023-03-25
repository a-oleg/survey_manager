package com.github.a_oleg.repository;

import com.github.a_oleg.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {
    Set<Survey> findById(int id);
    Set<Survey> findByCreator(String creator);
    Set<Survey> findByFolderId(int folderId);
}
