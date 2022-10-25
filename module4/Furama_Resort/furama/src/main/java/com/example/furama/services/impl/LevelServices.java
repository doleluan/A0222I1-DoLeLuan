package com.example.furama.services.impl;

import com.example.furama.model.Level;
import com.example.furama.repository.ILevelRepository;
import com.example.furama.services.ILevelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServices  implements ILevelServices {
    @Autowired
    private ILevelRepository iLevelRepository;
    @Override
    public List<Level> findAll() {
        return iLevelRepository.findAll();
    }
}
