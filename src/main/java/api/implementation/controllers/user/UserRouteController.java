package api.implementation.controllers.user;

import api.implementation.model.User;
import api.implementation.repository.RedisRepository;
import api.meta.model.controller.ModelRouteController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRouteController extends ModelRouteController<User, RedisRepository<User>> {

    public UserRouteController() {
        super(new UserModelController());
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {

        try {
            UserModelController.addUser(user.getName());
            return "Works";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed";
        }

    }

}
