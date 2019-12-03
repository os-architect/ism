package api.implementation.controllers;

import api.implementation.model.Authentication;
import api.implementation.util.Util;
import api.meta.model.controller.BaseController;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@RestController
public class AuthenticationController extends BaseController<Authentication> {

    public AuthenticationController() {
        super(Authentication.class);
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/auth/{id}")
    public String authenticate(@PathVariable("id") UUID id) {

        Authentication auth;

        try {

            auth = this.getRepository().get(id);
            return Util.toJson(auth);

        } catch (NullPointerException e) {
            try {

                auth = new Authentication(id, System.currentTimeMillis(), new ArrayList<>());
                auth.setSessionStart(System.currentTimeMillis());
                this.getRepository().update(auth);

                return Util.toJson(this.getRepository().get(auth.getId()));

            } catch (Exception e2) {

                e.printStackTrace();
                return e.getMessage();

            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    @GetMapping("/auth/{id}")
    public String checkAuthentication(@PathVariable("id") UUID id) {
        try {

            Authentication auth = this.getRepository().get(id);
            return Util.toJson(auth);

        } catch (JsonProcessingException | NullPointerException e) {
            return "404";
        } catch (IOException e) {
            return "500";
        }
    }

    @DeleteMapping("/auth")
    public String logOut() {
        return "";
    }
    
}
