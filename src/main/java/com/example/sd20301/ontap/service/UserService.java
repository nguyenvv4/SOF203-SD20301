package com.example.sd20301.ontap.service;

import com.example.sd20301.ontap.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserService {

    ArrayList<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(1, "Nguyen Van A", "a@example.com", "20", true));
        users.add(new User(2, "Tran Thi B", "b@example.com", "22", false));
        users.add(new User(3, "Le Van C", "c@example.com", "19", true));
        users.add(new User(4, "Pham Thi D", "d@example.com", "21", false));
        users.add(new User(5, "Hoang Van E", "e@example.com", "23", true));
    }

    public ArrayList<User> list() {
        return users;
    }

    public User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
