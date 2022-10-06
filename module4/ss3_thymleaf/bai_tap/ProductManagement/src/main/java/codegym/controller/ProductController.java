package codegym.controller;

import codegym.model.Product;
import codegym.services.IProductServices.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    private IProductServices iProductServices;
    @GetMapping(value = "")
    private String getPage(Model model){
        model.addAttribute("productList",iProductServices.findAll());
        return "home";
    }
    @GetMapping(value = "save")
    private String showUpdate(@RequestParam(name ="idProduct", defaultValue = "0") Integer idProduct,Model model) {
        if (idProduct==0){
            model.addAttribute("product", new Product());
        }
        else {
            Product product = iProductServices.findById(idProduct);
            model.addAttribute("product", product);
        }
        return "update";
    }
    @GetMapping(value = "search")
    private String search(@RequestParam(value = "inputSeach") String inputSeach,Model model){
        model.addAttribute("productList",iProductServices.searchByName(inputSeach));
        return "home";
    }
    @PostMapping(value = "save")
    private String update(@ModelAttribute("product") Product product){
        iProductServices.update(product);
        return "redirect:/";
    }
    @GetMapping(value = "delete")
    private String delete(@RequestParam(value = "idProduct") Integer idProduct){
        Product product = iProductServices.findById(idProduct);
        iProductServices.delete(product);
        return "redirect:/";
    }
//    @GetMapping(value = "delete/{idProduct}")
//    private String delete(@PathVariable(value = "idProduct") Integer idProduct){
//    Product product = iProductServices.findById(idProduct);
//    iProductServices.delete(product);
//    return "redirect:/";
}

