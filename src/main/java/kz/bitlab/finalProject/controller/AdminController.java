package kz.bitlab.finalProject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @PreAuthorize("hasAnyRole('ROLE_ADMIN') and isAuthenticated()")
    @GetMapping(value = "/admin-panel")
    public String indexPage(){
        return "admin-products";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN') and isAuthenticated()")
    @GetMapping(value = "/admin-panel/profile")
    public String profilePage(){
        return "admin-profile";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN') and isAuthenticated()")
    @GetMapping(value = "/admin-panel/add-product")
    public String addProductPage(){
        return "admin-add-product";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN') and isAuthenticated()")
    @GetMapping(value = "/admin-panel/categories")
    public String categoriesPage(){
        return "admin-categories";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN') and isAuthenticated()")
    @GetMapping(value = "/admin-panel/users")
    public String usersPage(){
        return "admin-users";
    }

}
