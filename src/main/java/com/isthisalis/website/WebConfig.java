package com.isthisalis.website;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 */
  @Configuration @EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
      .allowedOrigins("https://isthisalis.github.io")
      .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD")
      .allowedHeaders("*")
      .allowCredentials(true);
  }
}
