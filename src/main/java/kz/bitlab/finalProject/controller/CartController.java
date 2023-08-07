package kz.bitlab.finalProject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/cart")
    public String cartPage(){
        return "cart-page";
    }

}
