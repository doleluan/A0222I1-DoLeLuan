package codegym.controller;

import codegym.model.Login;
import codegym.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import codegym.services.IUserServices;
import codegym.services.impl.UserServices;

@Controller
public class LoginController {
    @Autowired
    private  IUserServices iUserServices = new UserServices();
    @GetMapping(value = "")
    private ModelAndView getPage(){
        return new ModelAndView("index","login",new Login());
    }
    @PostMapping(value = "/login")
    private  ModelAndView getLogin(@ModelAttribute ("login") Login login){
        User user = iUserServices.checkLogin(login);
        if (user==null){
            return  new ModelAndView("error");
        }else {
            return  new ModelAndView("user","user",user);
        }
    }
}
