package com.example.Karaikadeeshwarar.service;

import com.example.Karaikadeeshwarar.model.Admin;
import com.example.Karaikadeeshwarar.repo.AdminRepo;
import com.example.Karaikadeeshwarar.security.JwtUtil;
import com.example.Karaikadeeshwarar.security.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AdminRepo repo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LoginAttemptService loginAttemptService;


    public String login(Admin admin){

        String status =
                loginAttemptService.checkBlockStatus(
                        admin.getUsername()
                );

        if(status.equals("BLOCKED")){
            return "Too many attempts. Wait 10 seconds";
        }

        if(status.equals("BLOCK_EXPIRED")){
            return "Block expired. Now you can try again";
        }

        Admin dbAdmin = repo.findByUsername(
                admin.getUsername()
        ).orElse(null);

        if(dbAdmin != null &&
                passwordEncoder.matches(
                        admin.getPassword(),
                        dbAdmin.getPassword()
                )) {

            loginAttemptService.loginSuccess(
                    admin.getUsername()
            );

            return jwtUtil.generateToken(
                    admin.getUsername()
            );
        }

        loginAttemptService.loginFailed(
                admin.getUsername()
        );

        return "Invalid Credentials";
    }
}