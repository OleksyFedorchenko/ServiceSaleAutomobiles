package com.pkrok.servicesaleautomobiles.Controller;

import com.pkrok.servicesaleautomobiles.Domain.UserDTO;
import com.pkrok.servicesaleautomobiles.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDTO user) {
        userService.saveUser(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> users = userService.findAllUsers();
        return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
    }
@GetMapping("{userID}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("userID") Long id) {
        UserDTO user = userService.findUserById(id);
        return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    }
    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
