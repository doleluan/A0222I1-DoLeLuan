package com.example.furama.services.impl;

import com.example.furama.model.Department;
import com.example.furama.repository.IDepartmentRepsitory;
import com.example.furama.services.IDepartMentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServices implements IDepartMentServices {
    @Autowired
    private IDepartmentRepsitory iDepartmentRepsitory;
    @Override
    public List<Department> findAll() {
        return iDepartmentRepsitory.findAll();
    }
}
