package com.example.Karaikadeeshwarar.controller;

import com.example.Karaikadeeshwarar.model.Admin;
import com.example.Karaikadeeshwarar.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody Admin admin){

        String result = service.login(admin);

        if(result.equals("Invalid Credentials") ||
                result.equals("Too many attempts. Try later")){

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(result);
        }

        return ResponseEntity.ok(result);
    }
}