package codegym.furama.controller;

import codegym.furama.model.Employee;
import codegym.furama.services.impl.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;
    @GetMapping("")
    private String getList(Model model){
        List<Employee> list = employeeServices.findAll();
        System.out.println(list.size());
        model.addAttribute("employeeList",employeeServices.findAll());
        return "employee/list";
    }
}
