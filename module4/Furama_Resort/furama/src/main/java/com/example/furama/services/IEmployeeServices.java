package com.example.furama.services;

import com.example.furama.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeServices {
    List<Employee> findAll();
    Page findByName(String name, Pageable pageable);
    void save (Employee employee);
    void delete(Employee employee);
    Employee getEmployeeById(int id);
    Page<Employee> getAll(Pageable pageable);
}
