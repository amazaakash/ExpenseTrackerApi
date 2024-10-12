package com.aakash.ExpenseTrackerApiNew.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests.requestMatchers("/expenses/{id}")
                        .permitAll().
                        anyRequest()
                        .authenticated())
                .formLogin(withDefaults());
		return httpSecurity.build();
		
	}
}
