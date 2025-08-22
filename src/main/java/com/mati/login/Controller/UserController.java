package com.mati.login.Controller;

import com.mati.login.Model.User;
import com.mati.login.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PrivilegedAction;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ResponseBody
    private List<User> listUsers(){
        return userService.listUsers();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    private User findUser(@RequestBody Long id){
        return userService.findUserById(id);
    }

    @PostMapping("/user")
    @ResponseBody
    private User createUser (@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/user/{id}")
    @ResponseBody
    private User updateUser (@RequestBody User user, Long id){
        return userService.updateUser(user,id);
    }

    @DeleteMapping("/user")
    @ResponseBody
    private void deleteUserById (@RequestBody Long id){
        userService.deleteUserById(id);
    }

}
