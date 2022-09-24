package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {
    private  static Map<String,String> list = new HashMap<>();
    static {
        list.put("hello","Xin Chào");
        list.put("dog","Chó");
        list.put("cat","Mèo");
    }
    @PostMapping (value = "/translate")
    public  String getTranslate(@RequestParam ("englishText") String vnText, Model model){
        model.addAttribute("vnText",list.get(vnText));
        return "index";
    }
    @GetMapping(value = "")
    public  String getTranslate1(){
        return "index";
    }
}
