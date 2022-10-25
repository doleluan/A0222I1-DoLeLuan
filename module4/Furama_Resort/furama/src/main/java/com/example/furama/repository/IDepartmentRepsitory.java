package com.example.furama.repository;

import com.example.furama.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepsitory extends JpaRepository<Department,Integer> {
}
