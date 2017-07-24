package com.herro.service;

import com.herro.entity.User;
import com.herro.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by andrewdmo on 7/7/17.
 */
@Service("userService")
public class UserService {

    private UserRepo userRepo;

    // AW breaks so turned off:
    @Autowired
    public UserService(@Qualifier("userRepo") UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User findByUsername(String email) {
        return userRepo.findByUsername(email);
    }

    public User findByConfirmationToken(String confirmationToken) {
        return userRepo.findByConfirmationToken(confirmationToken);
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

}