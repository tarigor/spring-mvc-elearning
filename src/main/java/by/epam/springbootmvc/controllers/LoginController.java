package by.epam.springbootmvc.controllers;

import by.epam.springbootmvc.beans.Login;
import by.epam.springbootmvc.beans.User;
import by.epam.springbootmvc.exceptions.ApplicationExceptions;
import by.epam.springbootmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("login")Login login) {
        User user = userRepository.getUserByName(login.getUsername());
        if(user==null){
            throw new ApplicationExceptions("there is no such user");
        }
        return "forward:/userprofile";
    }

//    @ExceptionHandler(ApplicationExceptions.class)
//    public String loginExceptionHandle(){
//        return "error";
//    }
}
