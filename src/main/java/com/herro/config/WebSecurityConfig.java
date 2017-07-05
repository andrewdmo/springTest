package com.herro.config;

/**
 * Created by andrewdmo on 4/9/17.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
//          .antMatcher("/")
            .authorizeRequests()
            .antMatchers("/usersecurespace", "/user/**").hasRole("USER")
            .antMatchers("/", "/index", "/public_**", "/css/**", "/img/**", "/**.html", "/restgreeting").permitAll()
//.requestMatchers("/**.api")
            // unsecure!:
//            .anyRequest().permitAll()
            // re-activate:
            .anyRequest().authenticated()
            .and()

            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .successForwardUrl("/usersecurespace")
            .permitAll()
            .and()

            .exceptionHandling().accessDeniedPage("/403")
//            .loginProcessingUrl();
            .and()

            .logout()
            .logoutSuccessUrl("/login?logout")
            .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("test@test").password("test").roles("USER");
    }

}