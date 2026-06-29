package com.example.Karaikadeeshwarar.security;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginAttemptService {

    private final int MAX_ATTEMPT = 5;

    // stores failed attempts
    private Map<String,Integer> attempts = new HashMap<>();

    // stores blocked time
    private Map<String, LocalDateTime> blockedUsers =
            new HashMap<>();


    public void loginFailed(String username){

        int count = attempts.getOrDefault(username, 0) + 1;

        attempts.put(username, count);

        System.out.println("Attempts = " + count);

        if(count >= MAX_ATTEMPT){

            blockedUsers.put(
                    username,
                    LocalDateTime.now()
            );

            System.out.println("BLOCKED USER");
        }
    }


    public void loginSuccess(String username){

        attempts.remove(username);

        blockedUsers.remove(username);
    }


    public boolean isBlocked(String username){

        // if not blocked
        if(!blockedUsers.containsKey(username)){
            return false;
        }

        LocalDateTime blockedTime =
                blockedUsers.get(username);

        // check if 10 sec passed
        if(blockedTime.plusSeconds(10)
                .isBefore(LocalDateTime.now())){

            // unblock user
            blockedUsers.remove(username);

            attempts.remove(username);

            System.out.println(
                    "10 seconds over. Now user can try again"
            );

            return false;
        }

        return true;
    }
    public String checkBlockStatus(String username){

        if(!blockedUsers.containsKey(username)){
            return "NOT_BLOCKED";
        }

        LocalDateTime blockedTime = blockedUsers.get(username);

        // if 10 sec over
        if(blockedTime.plusSeconds(10).isBefore(LocalDateTime.now())){

            blockedUsers.remove(username);
            attempts.remove(username);

            return "BLOCK_EXPIRED";
        }

        return "BLOCKED";
    }
}