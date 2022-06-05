package com.peerlearn.peerlearn.config;

import com.peerlearn.peerlearn.security.filters.auth.TokenAuthFilter;
import com.peerlearn.peerlearn.security.filters.group.IsGroupAdminFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    final TokenAuthFilter tokenAuthFilter;

    public SecurityConfiguration(TokenAuthFilter tokenAuthFilter) {
        this.tokenAuthFilter = tokenAuthFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .addFilterAt(tokenAuthFilter, BasicAuthenticationFilter.class);
                //.addFilterAfter(isGroupAdminFilter,TokenAuthFilter.class)
        http.csrf().disable();
        http.httpBasic().disable();
        return http.build();
    }

    @Bean
    PasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
