package com.scaleup.notesharing.config;

import com.scaleup.notesharing.auth.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService customeUserDetailsService;

    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .antMatchers("/dev_test/*").permitAll()
//                .antMatchers("/dev_test/getAllStudents").authenticated()
//                .antMatchers("/dev_test/getAllNotes").permitAll()
//                .antMatchers("/dev_test/populateDB").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().logout().permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(5);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth
                .parentAuthenticationManager(authenticationManagerBean())
                .userDetailsService(customeUserDetailsService);
    }
}