package kz.bitlab.finalProject.controller;

import kz.bitlab.finalProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product/{id}")
    public String detailsProduct(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("product", productService.getProduct(id));
        return "product-details";
    }

}
