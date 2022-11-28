package com.example.final_exam_module4.services.impl;

import com.example.final_exam_module4.model.QuestionType;
import com.example.final_exam_module4.repository.QuestionTypeRepository;
import com.example.final_exam_module4.services.IQuestionTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeServices implements IQuestionTypeServices {
    @Autowired
    private QuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> getAll() {
        return questionTypeRepository.findAll();
    }
}
