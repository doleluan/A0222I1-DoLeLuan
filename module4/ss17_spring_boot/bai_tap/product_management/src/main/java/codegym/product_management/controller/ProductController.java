package codegym.product_management.controller;

import codegym.product_management.model.Product;
import codegym.product_management.services.ICategoryServices;
import codegym.product_management.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller

public class ProductController {
    @Autowired
    private IProductServices iProductServices;
    @Autowired
    private ICategoryServices iCategoryServices;
//    @GetMapping(value = "")
//    private String getPage(Model model) {
//        model.addAttribute("productList", iProductServices.getAll());
//        return "list";
//    }

    @GetMapping(value = "")
    private String getPage(Model model,@RequestParam(value = "page", defaultValue = "0")int page,@RequestParam (name = "inputSearch",defaultValue = "") String inputSearch) {
        model.addAttribute("productList",iProductServices.findByName(inputSearch,PageRequest.of(page,3)));
        model.addAttribute("inputSearch",inputSearch);
        return "list";
    }
    @GetMapping(value = "save")
    private String getSave(@RequestParam(name = "idProduct", defaultValue = "0") Integer idProduct, Model model) {
        if (idProduct == 0) {
            model.addAttribute("product", new Product());
        } else {
            model.addAttribute("product", iProductServices.getProductById(idProduct));
        }
        model.addAttribute("category",iCategoryServices.getAll());
        return "save";
    }

    @PostMapping(value = "save")
    private String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("category",iCategoryServices.getAll());
            return "save";
        }
        iProductServices.save(product);
        return "redirect:/";
    }
    @GetMapping(value = "delete")
    private String deleteProduct(@RequestParam(name = "idProduct") Integer idProduct) {
        iProductServices.delete(iProductServices.getProductById(idProduct));
        return "redirect:/";
    }

}
