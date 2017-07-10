package com.herro.repo;

import com.herro.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by andrewdmo on 5/22/17.
 */
@Repository("userRepo")
public interface UserRepo extends CrudRepository<User, Long> {

    User findByUsername(String username);

    //not yet:
    User findByConfirmationToken(String confirmationToken);

}