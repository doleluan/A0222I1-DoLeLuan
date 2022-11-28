package codegym.product_management.controller;

import codegym.product_management.model.Category;
import codegym.product_management.model.Product;
import codegym.product_management.services.ICategoryServices;
import codegym.product_management.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("rest")
@CrossOrigin("http://localhost:63343/")
public class ProductRestController {
    @Autowired
    private IProductServices iProductServices;
    @Autowired
    private ICategoryServices iCategoryServices;
    @PostMapping(value = "save")
    private ResponseEntity<?> saveProduct(@Valid @RequestBody Product product) {
        iProductServices.save(product);
         return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "xxx")
    private Page getPage( @RequestParam(value = "page", defaultValue = "0")int page, @RequestParam (name = "inputSearch",defaultValue = "") String inputSearch) {
        return iProductServices.getAll(PageRequest.of(page,3));
    }
    @GetMapping(value = "getProducts")
    private Page getList(@RequestParam(value = "page", defaultValue = "0")int page,@RequestParam (name = "inputSearch",defaultValue = "") String inputSearch) {
        if (inputSearch.equals("")){
            return iProductServices.getAll(PageRequest.of(page,10));
        }
        else {
            return iProductServices.findByName(inputSearch,PageRequest.of(page,10));
        }
    }
    @DeleteMapping(value = "/delete")
    private void deleteProduct(@RequestParam(name = "idProduct") Integer idProduct){
        iProductServices.delete(iProductServices.getProductById(idProduct));
    }
    @GetMapping(value = "/list")
    private List<Category> getCategory(){
        return iCategoryServices.getAll();
    }
}
