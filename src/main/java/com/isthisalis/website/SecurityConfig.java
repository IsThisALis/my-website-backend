package com.isthisalis.website;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig
 */
  @Configuration @EnableWebSecurity
public class SecurityConfig {

    @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpsec) {
    String api = "/api";
    httpsec.cors(Customizer.withDefaults())
      .csrf(csrf -> csrf.disable())
      .sessionManagement(session -> { session.sessionCreationPolicy(SessionCreationPolicy.STATELESS); } );
    httpsec.authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, api + "/comments").permitAll()
                .requestMatchers(HttpMethod.GET, api + "/posts", api + "/abouts", api + "/projects", api + "/comments").permitAll()
                .requestMatchers(HttpMethod.GET, api + "/posts/**", api + "/abouts/**", api + "/projects/**", api + "/comments/**").permitAll()
                .requestMatchers("/**").authenticated()
                .anyRequest().authenticated());
                httpsec.httpBasic(Customizer.withDefaults());
    return httpsec.build();
  }
}
