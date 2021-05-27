package by.epam.springbootmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/redirectToLinkedIn")
    public String redirectToLinkedIn(){
        return "redirect:http://www.linkedin.com";
    }
}
