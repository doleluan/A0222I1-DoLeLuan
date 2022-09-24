package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpiceController {

    @PostMapping(value = "/priceChoose")
    private ModelAndView getPrice(@RequestParam String[] choose){
        return new ModelAndView("price","result",choose);
    }
    @GetMapping(value = "")
    private String getIndex(){
        return  "index";
    }
}
