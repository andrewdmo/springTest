package com.herro.config;

/**
 * Created by andrewdmo on 4/9/17.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
            .antMatchers("/**", "/static/**", "/css/**", "/img/**", "/script/**", "/public/**").permitAll()
            .antMatchers("/user/**").hasRole("USER")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .permitAll();
//            .successForwardUrl("/usersecurespace")
//        .and()
//            .exceptionHandling();


//            .loginProcessingUrl();
//            .and()
//            .logout()
//            .logoutSuccessUrl("/login?logout")
//            .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("test@test").password("test").roles("USER");
    }

}