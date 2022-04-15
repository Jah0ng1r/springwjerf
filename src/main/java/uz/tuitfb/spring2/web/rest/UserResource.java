package uz.tuitfb.spring2.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.tuitfb.spring2.service.UserService;

@RestController
@RequestMapping("api")
public class UserResource {
     private final UserService userService;


    public UserResource(UserService userService) {
        this.userService = userService;
    }
}
