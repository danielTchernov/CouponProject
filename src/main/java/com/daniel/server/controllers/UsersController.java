package com.daniel.server.controllers;

import com.daniel.server.beans.Company;
import com.daniel.server.beans.User;
import com.daniel.server.entities.UserEntity;
import com.daniel.server.enums.UserType;
import com.daniel.server.exceptions.ServerException;
import com.daniel.server.logic.UserLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {

    private UserLogic userLogic;

    @Autowired
    public UsersController(UserLogic userLogic){
        this.userLogic = userLogic;
    }

    @PostMapping
    public void createUser (@RequestBody UserEntity user) throws Exception {
        userLogic.createUser(user);
    }

    @PutMapping
    public void updateUser (@RequestBody UserEntity user) throws Exception {
        userLogic.updateUser(user);
    }

    @DeleteMapping("{userId}")
    public void removeUser (@PathVariable ("userId") long id) throws Exception {
        userLogic.removeUser(id);
    }

    @GetMapping("{userId}")
    public UserEntity getUser(@PathVariable("userId") long id) throws Exception {
        UserEntity user = userLogic.getUser(id);
        return user;
    }

    @GetMapping
    public List<User> getAllUsers (@RequestParam("page") int page) throws ServerException {
        List<User> users = userLogic.getAllUsers(page);
        return users;
    }

    @GetMapping("/byTimeStampAsc")
    public List<User> getAllUsersByTimeStampAscending(@RequestParam("page") int page) throws ServerException {
        List<User> users = userLogic.getAllUsersByTimeStampAscending(page);
        return users;
    }

    @GetMapping("/byTimeStampDes")
    public List<User> getAllUsersByTimeStampDescending(@RequestParam("page") int page) throws ServerException{
        List<User> users = userLogic.getAllUsersByTimeStampDescending(page);
        return users;
    }

}
