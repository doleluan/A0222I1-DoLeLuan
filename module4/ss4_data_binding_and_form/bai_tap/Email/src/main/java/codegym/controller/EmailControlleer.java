package codegym.controller;

import codegym.model.Email;
import codegym.services.IEmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailControlleer {
    @Autowired
    private IEmailServices iEmailServices;
    @GetMapping(value = "/save")
    private String getPage(Model model, @RequestParam(name = "id",defaultValue = "0") Integer id){
        if (id==0){
            model.addAttribute("email",new Email());
        }else {
            Email email = iEmailServices.find(id);
            model.addAttribute("email",email);
        }
        model.addAttribute("listLanguages",new String []{"English","Vietnamese","Japanese","Chinese"});
        return "update";
    }
    @GetMapping(value = "")
    private ModelAndView getList(){
        return  new ModelAndView("list","list",iEmailServices.findALL());
    }
    @PostMapping(value = "/save")
    private String update(@ModelAttribute ("email") Email email ,RedirectAttributes redirectAttributes){
        iEmailServices.update(email);
        return "redirect:/";
    }
}
