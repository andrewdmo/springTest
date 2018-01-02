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


    //FOR MULTPLOGINS:
//    @Configuration
//    @Order(1)
//    public static class App1ConfigurationAdapter extends WebSecurityConfigurerAdapter {
//        public App1ConfigurationAdapter() {
//            super();
//        }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
            .antMatchers("/usersecurespace", "/user/**").hasRole("USER") //orig
            .antMatchers("/odd**").hasRole("MAID")
            .antMatchers("/", "/index", "/public_**", "/css/**", "/img/**", "/scripts/**", "/**.html", "/restgreeting", "/mvc**", "/register").permitAll()
            .anyRequest().authenticated()

            .and()
            .formLogin() // orig
            .loginPage("/login") // orig
            .failureUrl("/login?error") // orig
//            .successForwardUrl("/usersecurespace") // orig
//            .failureForwardUrl("/login?error")

            .permitAll() // orig

            .and()
            .logout()
            .logoutSuccessUrl("/login?logout")
            .deleteCookies("JSESSIONID")

            .and()
            .exceptionHandling()
            .accessDeniedPage("/403");

//                //good:?
//                .and()
//                .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("test@test").password("test").roles("USER")
            .and()
            .withUser("eve").password("melon").roles("MAID", "USER")
        ;

    }


//    @Configuration
//    @Order(1)
//    public static class configureLuv extends WebSecurityConfigurerAdapter {
//
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                .antMatcher("/odd**")
//
//                .authorizeRequests()
//                .antMatchers("/oddrod", "/oddrod/**").hasRole("MAID") //<3
//                .anyRequest().authenticated()
//
//                .and()
//                .formLogin()  // <3
//                .loginPage("/lovin") // <3
//                .failureUrl("/lovin?error") // <3
//                .successForwardUrl("/oddrod") // <3
//                .permitAll() // <3
//
//                .and()
//                .logout()
////                .logoutUrl("/user_logout")
//                .logoutSuccessUrl("/lovin?logout")
//                .deleteCookies("JSESSIONID")
//
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/403");
//
//            //good:?
////                .and()
////                .csrf().disable();
//
//
////        @Autowired
////        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////            auth
////                .inMemoryAuthentication()
////                //<3
////                .withUser("eve").password("melon").roles("MAID");
////
////
////        }
////    }
//    }
}