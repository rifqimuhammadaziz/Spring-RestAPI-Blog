package rifqimuhammadaziz.springrestapiblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rifqimuhammadaziz.springrestapiblog.payload.User.UserResponse;
import rifqimuhammadaziz.springrestapiblog.service.contract.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponse> findAllUsers() {
        return userService.findAllUsers();
    }
}
