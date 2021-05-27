package by.epam.springbootmvc.controllers;

import by.epam.springbootmvc.beans.Login;
import by.epam.springbootmvc.beans.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class DefaultModelAttributeController {
    @ModelAttribute("newuser")
    public User getDefaultUser() {
        return new User();
    }

    @ModelAttribute("genderitems")
    public List<String> getGender() {
        return Arrays.asList("Male", "Female", "Other");
    }

    @ModelAttribute("login")
    public Login getDefaultLogin() {
        return new Login();
    }
}
