package com.project.webservice.crs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${spring.security.user.name}")
    String userName;

    @Value("${spring.security.user.password}")
    String password;
@Override
    protected void configure(HttpSecurity http) throws Exception{
    http.authorizeHttpRequests().antMatchers("*/customer/*").authenticated().and().httpBasic().and().csrf().disable();

}
@Bean
    public UserDetailsService userDetailsService(){
    InMemoryUserDetailsManager inMemoryUserDetailsManager=new InMemoryUserDetailsManager();
    inMemoryUserDetailsManager.createUser(User.withUsername(userName).password("{noop}"+password).roles("USER").build());
    return inMemoryUserDetailsManager;
}
}
