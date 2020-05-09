package com.son.oauth2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    // In spring-security-core:5.0.0.RC1, the default PasswordEncoder is
    // built as a DelegatingPasswordEncoder. When you store the users in memory,
    // you are providing the passwords in plain text and when trying to retrieve
    // the encoder from the DelegatingPasswordEncoder to validate the password
    // it can't find one that matches the way in which these passwords were stored.

    // You can also simply prefix {noop} to your passwords in order for the DelegatingPasswordEncoder
    // use the NoOpPasswordEncoder to validate these passwords. Notice that NoOpPasswordEncoder
    // is deprecated though, as it is not a good practice to store passwords in plain text.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("son1")
                .password("{noop}password1")
                .roles("USER")
                .and()
                .withUser("son2")
                .password("{noop}password2")
                .roles("USER", "ADMIN");
    }
}
