package codegym.furama.services.impl;

import codegym.furama.model.Employee;
import codegym.furama.repository.IEmployeeRepository;
import codegym.furama.services.IEmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServices implements IEmployeeServices {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }
}
