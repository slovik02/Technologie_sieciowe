package ib.ts_2.controller;
import ib.ts_2.entity.User;
import ib.ts_2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable long id){
        return userService.getOne(id);
    }

    @PostMapping("/add")
    // tego nie używać, user musi się zarejestrować
    public User addUser(@RequestBody User user){
        return userService.create(user);
    }

    @DeleteMapping("/delete/{id}")
    public User delete(@PathVariable long id){return userService.delete(id);}

    @PatchMapping("update/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User userUpdates) {
        return userService.update(userUpdates, id);
    }

}
