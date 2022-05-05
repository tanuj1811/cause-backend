package com.cause.Controllers;

import com.cause.Entities.Question;
import com.cause.Entities.User;
import com.cause.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> fetchAllUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping("/{userId}")
    public User fetchUser(@PathVariable String userId) {
        return userService.fetchUserById(userId);
    }

    @GetMapping("/{userId}/queries")
    public List<Question> getAllUserQueries(@PathVariable String userId) {
        return userService.fetchAllQueries(userId);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        System.out.println(user.toString());
        return userService.addUser(user);
    }

    @PostMapping("/{userId}/updateUser")
    public void updateUser(@RequestBody User user,@PathVariable String userId) {
        user.set_id(userId);
        userService.updateUser(user);
    }

}
