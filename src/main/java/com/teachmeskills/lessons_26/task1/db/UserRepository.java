package com.teachmeskills.lessons_26.task1.db;

import com.teachmeskills.lessons_26.task1.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static final Map<String, User> users = new HashMap<>();

    static  {
        users.put("admin", new User("admin", "111111"));
        users.put("user", new User("user", "222222"));
    }

    public static boolean isValidUser(String username, String password){
        User user = users.get(username);
        if (username == null || password == null){
            return false;
        }
        if (users.containsKey(username)){
            return user.getPassword().equals(password) ;
        }
        return false;
    }

}
