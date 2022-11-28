package com.example.furama.controller;

import com.example.furama.model.customer.Customer;
import com.example.furama.services.customer.impl.CustomerServices;
import com.example.furama.services.customer.impl.CustomerTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/restCustomer")
@CrossOrigin
public class CustomerRestController {
    @Autowired
    private CustomerTypeServices customerTypeServices;
    @Autowired
    private CustomerServices customerServices;
    @PostMapping(value = "/save")
    private String saveCustomer(@RequestBody Customer customer){
        System.out.println(customer);
        customerServices.save(customer);
        return "redirect:/customer";
    }
}
