package com.datasite.test.controller;

import com.datasite.test.service.UsersService;
import com.datasite.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public ResponseEntity<List<User> >getUser() {
        List<User> users= usersService.getUsers();
        if(users.size()==0){
            return ResponseEntity.notFound().build();
        }
     return ResponseEntity.ok().body(users);
    }
}
