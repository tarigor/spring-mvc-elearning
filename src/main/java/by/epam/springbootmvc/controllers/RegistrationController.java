package by.epam.springbootmvc.controllers;

import by.epam.springbootmvc.beans.User;
import by.epam.springbootmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @InitBinder
    public void initBuilder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,"dateOfBirth",new CustomDateEditor(new SimpleDateFormat("yyy-MM-dd"),true));
    }

    @PostMapping("/registeruser")
    public String registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, Model model) {
        System.out.println("inside registration controller");
        if(result.hasErrors()){
            return "register";
        }
        userRepository.save(user);
        model.addAttribute("dataSaved","The User has been successfully registered");
        return "login";
    }
}
