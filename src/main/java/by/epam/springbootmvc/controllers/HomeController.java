package by.epam.springbootmvc.controllers;

import by.epam.springbootmvc.beans.Login;
import by.epam.springbootmvc.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String goHome() {
        System.out.println("in home controller");
        return "index";
    }

    @GetMapping("/goToSearch")
    public String goToSearch() {
        System.out.println("inside a goToSearch");
        return "search";
    }

    @GetMapping("/goToLogin")
    public String goToLogin() {
        System.out.println("inside a goToLogin");
        return "login";
    }

    @GetMapping("/goToRegistration")
    public String goToRegistration() {
        System.out.println("inside a goToRegistration");
        return "register";
    }

//    @ModelAttribute("newuser")
//    public User getDefaultUser() {
//        return new User();
//    }
//
//    @ModelAttribute("genderitems")
//    public List<String> getGender() {
//        return Arrays.asList("Male", "Female", "Other");
//    }
//
//    @ModelAttribute("login")
//    public Login getDefaultLogin() {
//        return new Login();
//    }
}
