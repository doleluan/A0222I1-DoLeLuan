package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
//    @GetMapping(value = "/aa")
//    public  String getPageHello(){
//        return "hello";
//    }
    @GetMapping(value = "")
    public  String getPageHello1(){
        return "hello";
    }
}
