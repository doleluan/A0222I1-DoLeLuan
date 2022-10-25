package com.example.furama.repository;

import com.example.furama.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILevelRepository extends JpaRepository<Level,Integer> {
}
