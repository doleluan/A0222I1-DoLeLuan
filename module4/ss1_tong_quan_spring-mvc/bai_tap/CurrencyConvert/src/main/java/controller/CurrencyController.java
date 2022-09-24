package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @PostMapping(value = "/caculater")
    public String getResult(@RequestParam(name = "usd") Integer usd,Model model){
        float result = usd*23000;
        model.addAttribute("result",result);
        return  "caculater";
    }
    @GetMapping(value = "")
    public String getCaculater(){
        return  "caculater";
    }
}
