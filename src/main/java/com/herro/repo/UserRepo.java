package com.herro.repo;

import com.herro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by andrewdmo on 5/22/17.
 */
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

}