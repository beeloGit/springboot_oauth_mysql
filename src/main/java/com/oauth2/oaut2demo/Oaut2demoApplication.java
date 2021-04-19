package com.oauth2.oaut2demo;

import com.oauth2.oaut2demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;



@SpringBootApplication
public class Oaut2demoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oaut2demoApplication.class, args);
    }

    @Autowired
    public void AuthenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception {
        //builder.userDetailsService((UserDetailsService) (u) -> new CustomUserDetails(repo.findByUserName(u)));
    }
}
