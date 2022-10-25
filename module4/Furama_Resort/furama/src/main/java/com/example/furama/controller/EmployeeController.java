package com.example.furama.controller;

import com.example.furama.model.Department;
import com.example.furama.model.Employee;
import com.example.furama.services.impl.DepartmentServices;
import com.example.furama.services.impl.EmployeeServices;
import com.example.furama.services.impl.LevelServices;
import com.example.furama.services.impl.PositionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;
    @Autowired
    private PositionServices positionServices;
    @Autowired
    private LevelServices levelServices;
    @Autowired
    private DepartmentServices departmentServices;
    @GetMapping("list")
    private String getList(Model model,@RequestParam(value = "page", defaultValue = "0")int page){
        model.addAttribute("employeeList",employeeServices.getAll(PageRequest.of(page,4)));
        return "employee/list";
    }
    @GetMapping("")
    private String getPage(Model model,@RequestParam(value = "page", defaultValue = "0")int page,@RequestParam (name = "nameSearch",defaultValue = "") String nameSearch)
    {
        model.addAttribute("employeeList",employeeServices.findByName(nameSearch, PageRequest.of(page,4)));
        model.addAttribute("nameSearch",nameSearch);
        return "employee/list";
    }
    @GetMapping(value = "save")
    private String getSave(@RequestParam(name = "id",defaultValue = "0") Integer id,Model model){
        if (id==0){
            model.addAttribute("employee",new Employee());
        }else {
            model.addAttribute("employee",employeeServices.getEmployeeById(id));
        }
        model.addAttribute("positionList",positionServices.findAll());
        model.addAttribute("levelList",levelServices.findAll());
        model.addAttribute("departmentList",departmentServices.findAll());
        model.addAttribute("id",id);
        return "employee/save";
    }
    @PostMapping(value = "/save")
    private String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeServices.save(employee);
        return "redirect:/";
    }
    @GetMapping(value = "delete")
    private String deleteProduct(@RequestParam(name = "id") Integer id) {
        employeeServices.delete(employeeServices.getEmployeeById(id));
        return "redirect:/";
    }
}
