package com.pro.forum.service;

import com.pro.forum.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
