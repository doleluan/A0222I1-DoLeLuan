package com.example.final_exam_module4.controller;

import com.example.final_exam_module4.model.QuestionContent;
import com.example.final_exam_module4.services.impl.QuestionContentServices;
import com.example.final_exam_module4.services.impl.QuestionTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    private QuestionContentServices questionContentServices;
    @Autowired
    QuestionTypeServices questionTypeServices;
    @GetMapping("")
    public String getList(Model model,@RequestParam(value = "page", defaultValue = "0")int page,@RequestParam (name = "nameSearch",defaultValue = "")String nameSearch){
//        Sort sort = Sort.by("status").ascending().and(Sort.by("date_create")).descending();
        model.addAttribute("questionContentList",questionContentServices.findByTitle(nameSearch,PageRequest.of(page,4)));
        model.addAttribute("questionTypeList",questionTypeServices.getAll());
        return "list";
    }
    @GetMapping("/search")
    private String getPage(Model model,@RequestParam(value = "page", defaultValue = "0")int page,@RequestParam (name = "nameSearch",defaultValue = "") String nameSearch)
    {
        model.addAttribute("questionContentList",questionContentServices.findByTitle(nameSearch,PageRequest.of(page,4)));
        model.addAttribute("nameSearch",nameSearch);
        return "list";
    }
    @GetMapping("/save")
    public String toSave(@RequestParam(name = "id",defaultValue = "0") Integer id, Model model){
        if (id==0){
            model.addAttribute("questionContent",new QuestionContent());
        }else {
            model.addAttribute("questionContent",questionContentServices.getQuestionContentById(id));
        }
        model.addAttribute("questionTypeList",questionTypeServices.getAll());
        model.addAttribute("id",id);
        return "save";
    }
    @PostMapping("/save")
    public  String doSave(@Valid @ModelAttribute("questionContent") QuestionContent questionContent, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("questionTypeList",questionTypeServices.getAll());
            return "save";
        }
        questionContent.setStatus(false);
        questionContentServices.save(questionContent);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String doDelete(@RequestParam(name = "id") Integer id){
        questionContentServices.delete(questionContentServices.getQuestionContentById(id));
        return "redirect:/";
    }
//    public String getList(Model model, @RequestParam(value = "page", defaultValue = "0")int page, @RequestParam (name = "nameSearch",defaultValue = "") String nameSearch){
//       model.addAttribute("questionContentList",questionContentServices.findAll());
//       model.addAttribute("questionTypeList",questionTypeServices.getAll());
//        return "list";
//    }
}
