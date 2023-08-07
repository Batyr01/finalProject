package kz.bitlab.finalProject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {

    @PreAuthorize("hasAnyRole('ROLE_MANAGER') and isAuthenticated()")
    @GetMapping(value = "/manager-panel")
    public String indexPage(){
        return "manager-products";
    }

}
