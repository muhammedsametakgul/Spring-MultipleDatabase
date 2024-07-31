package com.sametakgul.multiple_db.controller;


import com.sametakgul.multiple_db.model.mysql.MySQLUser;
import com.sametakgul.multiple_db.model.postgresql.PostgreSQLUser;
import com.sametakgul.multiple_db.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping("/mysql/users")
    public List<MySQLUser> getAllMySQLUsers() {
        return userService.getAllMySQLUsers();
    }

    @PostMapping("/mysql/users")
    public MySQLUser saveMySQLUser(@RequestBody MySQLUser user) {
        return userService.saveMySQLUser(user);
    }

    @GetMapping("/postgresql/users")
    public List<PostgreSQLUser> getAllPostgresUsers() {
        return userService.getAllPostgresUsers();
    }

    @PostMapping("/postgresql/users")
    public PostgreSQLUser savePostgresUser(@RequestBody PostgreSQLUser user) {
        return userService.savePostgresUser(user);
    }
}