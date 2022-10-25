package codegym.product.controller;

import codegym.product.model.Product;
import codegym.product.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private IProductServices iProductServices;

    @GetMapping(value = "")
    private String getPage(Model model) {
        model.addAttribute("productList", iProductServices.getAll());
        return "list";
    }

    @GetMapping(value = "save")
    private String getSave(@RequestParam(name = "idProduct", defaultValue = "0") Integer idProduct, Model model) {
        if (idProduct == 0) {
            model.addAttribute("product", new Product());
        } else {
            model.addAttribute("product", iProductServices.getProductById(idProduct));
        }
        return "save";
    }

    @PostMapping(value = "save")
    private String saveProduct(@ModelAttribute("product") Product product) {
        iProductServices.save(product);
        return "redirect:/";
    }

    @GetMapping(value = "delete")
    private String deleteProduct(@RequestParam(name = "idProduct") Integer idProduct) {
        iProductServices.delete(iProductServices.getProductById(idProduct));
        return "redirect:/";
    }
}
