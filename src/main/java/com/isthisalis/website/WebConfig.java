package com.isthisalis.website;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 */
  @Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
      .allowedOrigins("isthisalis.github.io")
      .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD")
      .allowedHeaders("*")
      .allowCredentials(true);
  }
}
