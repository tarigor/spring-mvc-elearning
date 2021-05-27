package by.epam.springbootmvc.controllers;

import by.epam.springbootmvc.beans.Login;
import by.epam.springbootmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserProfileController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/userprofile")
    public String getUserProfile(@SessionAttribute("login") Login login, Model model) {
        model.addAttribute("user",userRepository.getUserByName(login.getUsername()));
        return "profile";
    }
}
