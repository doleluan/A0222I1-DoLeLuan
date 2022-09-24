package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculaterController {
    @PostMapping(value = "/add")
    private Object getAdd(@RequestParam char operatorName, @RequestParam Integer a, @RequestParam Integer b){
        if (a==null || b==null){
            return new ModelAndView("index","mess","Không được để trống");
        }else {
            switch (operatorName){
                case '+':return new ModelAndView("index","result",a+b);
                case '-':return new ModelAndView("index","result",a-b);
                case '*':return new ModelAndView("index","result",a*b);
                case '/':
                    if (b==0){
                        return new ModelAndView("index","erro","Không thể chia cho 0");
                    }
                    return new ModelAndView("index","result",a*b);
                default: return new ModelAndView("index","result","Not Found");
            }
        }
    }
    @GetMapping(value = "")
    private  String getPage(){
        return "index";
    }
}
