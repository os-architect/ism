package api.implementation.controllers;

import api.implementation.repository.AuthenticationRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/auth")
    public String authenticate() {
        return "authenticated";
    }

    @GetMapping("/auth")
    public String checkAuthentication() {
        return "";
    }

    @DeleteMapping("/auth")
    public String logOut() {
        return "";
    }
    
}
