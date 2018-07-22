package com.eletronics.elephantweb;

import lombok.NonNull;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(@NonNull HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                        "/**" // TODO
                ).permitAll()
                .anyRequest().authenticated();
    }
}