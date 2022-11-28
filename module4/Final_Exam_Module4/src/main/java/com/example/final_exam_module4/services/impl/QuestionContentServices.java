package com.example.final_exam_module4.services.impl;

import com.example.final_exam_module4.model.QuestionContent;
import com.example.final_exam_module4.repository.QuestionContentRepository;
import com.example.final_exam_module4.services.IQuestionContentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionContentServices implements IQuestionContentServices {
    @Autowired
    private QuestionContentRepository questionContentRepository;


    @Override
    public Page findByTitle(String name, Pageable pageable) {
        return questionContentRepository.findQuestionContentByTitleContaining(name,pageable);
    }

    @Override
    public List<QuestionContent> findAll() {
        return questionContentRepository.findAll();
    }

    @Override
    public void save(QuestionContent questionContent) {
        questionContentRepository.save(questionContent);
    }

    @Override
    public void delete(QuestionContent questionContent) {
        questionContentRepository.delete(questionContent);
    }

    @Override
    public QuestionContent getQuestionContentById(int id) {
        return questionContentRepository.findById(id).orElse(null);
    }

    @Override
    public Page<QuestionContent> getAll(Pageable pageable) {
        return questionContentRepository.findAll(pageable);
    }
}
