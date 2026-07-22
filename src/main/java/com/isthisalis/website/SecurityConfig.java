package com.isthisalis.website;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig
 */
  @Configuration @EnableWebSecurity
public class SecurityConfig {

  public SecurityFilterChain configure(HttpSecurity httpsec) {
    httpsec.cors(Customizer.withDefaults());
    httpsec.csrf(csrf -> csrf.disable());
    httpsec.authorizeHttpRequests(auth -> { auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
      .requestMatchers(HttpMethod.GET).permitAll()
      .anyRequest().authenticated(); 
    } );
    httpsec.httpBasic(Customizer.withDefaults());
    return httpsec.build();
  }
}
