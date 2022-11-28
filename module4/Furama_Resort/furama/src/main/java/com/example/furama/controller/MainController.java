package com.example.furama.controller;

import com.example.furama.model.user.AppUser;
import com.example.furama.services.user.impl.AppUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AppUserServices appUserServices;
    @GetMapping("/login")
    private String getLogin(){
        return "login/login";
    }
    @GetMapping("/home")
    private String getHome(){
        return "home";
    }
    @GetMapping("/registor")
    public String getRegistor(Model model){
        model.addAttribute("user",new AppUser());
        return  "login/registor";
    }
    @PostMapping("/registor")
    public String doRegistor(@ModelAttribute("user") AppUser appUser){
        AppUser appUser1 = appUser;
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUser.setEnabled(true);
        appUserServices.save(appUser);
        return "redirect:/login/login";
    }
    @GetMapping("/403")
    public  String toError(){
        return "error/failLogin";
    }
}
