package com.example.final_exam_module4.services;

import com.example.final_exam_module4.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuestionContentServices {
    Page findByTitle(String name, Pageable pageable);
    List<QuestionContent> findAll();
    void save (QuestionContent questionContent);
    void delete(QuestionContent questionContent);
    QuestionContent getQuestionContentById(int id);
    Page<QuestionContent> getAll(Pageable pageable);
}
