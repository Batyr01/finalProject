package kz.bitlab.finalProject.controller;

import kz.bitlab.finalProject.model.User;
import kz.bitlab.finalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/sign-in-page")
    public String signInPage() {
        return "sign-in-page";
    }

    @GetMapping(value = "/sign-up-page")
    public String signUpPage() {
        return "sign-up-page";
    }

    @PostMapping(value = "/to-sign-up")
    public String toSignUp(@RequestParam(name = "user_full_name") String fullName,
                           @RequestParam(name = "user_email") String email,
                           @RequestParam(name = "user_password") String password,
                           @RequestParam(name = "user_re_password") String rePassword) {

        if (password.equals(rePassword)) {
            User user = new User();
            user.setFullName(fullName);
            user.setEmail(email);
            user.setPassword(password);
            User newUser = userService.addUser(user);
            if (newUser != null) {
                return "redirect:/sign-up-page?success";
            } else {
                return "redirect:/sign-up-page?emailerror";
            }
        } else {
            return "redirect:/sign-up-page?passworderror";
        }

    }

    @PostMapping(value = "/update-profile")
    public String toUpdate(@RequestParam(name = "fullName") String fullName,
                           @RequestParam(name = "email") String email) {
        userService.updateUser(fullName, email);
        return "redirect:/profile";

    }

    @GetMapping(value = "/update-password-page")
    public String updatePasswordPage() {
        return "update-password";
    }

    @PostMapping(value = "/to-update-password")
    public String updatePassword(@RequestParam(name = "password") String oldPassword,
                                 @RequestParam(name = "new_password") String newPassword,
                                 @RequestParam(name = "re_new_password") String rePassword) {

        if (newPassword.equals(rePassword)){
            User user = userService.updatePassword(oldPassword, newPassword);
            if (user != null){
                return "redirect:/update-password-page?success";
            }else {
                return "redirect:/update-password-page?oldpassworderror";
            }
        }else {
            return "redirect:/update-password-page?passwordmissmatch";
        }

    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profilePage() {
        return "profile";
    }



}
