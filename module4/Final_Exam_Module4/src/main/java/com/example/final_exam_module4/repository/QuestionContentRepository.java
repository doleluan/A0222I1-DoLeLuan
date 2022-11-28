package com.example.final_exam_module4.repository;

import com.example.final_exam_module4.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface QuestionContentRepository extends JpaRepository<QuestionContent,Integer> {
    Page<QuestionContent> findQuestionContentByTitleContaining(String title, Pageable pageable);
}
