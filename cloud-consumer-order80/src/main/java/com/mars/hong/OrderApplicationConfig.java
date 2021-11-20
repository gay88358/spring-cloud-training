package com.mars.hong;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Configuration
public class OrderApplicationConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
