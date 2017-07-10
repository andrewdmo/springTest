//package com.herro.service;
//
//import com.herro.entity.A_UserPrincipal;
//import com.herro.entity.User;
//import com.herro.repo.UserRepo;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class A_UserDetailsService implements UserDetailsService {
//
//    private UserRepo userRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        User user = userRepo.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new A_UserPrincipal(user);
//    }
//}