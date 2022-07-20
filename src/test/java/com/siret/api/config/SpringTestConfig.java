package com.siret.api.config;

import org.springframework.context.annotation.*;
import org.springframework.test.context.TestPropertySources;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.siret")
@PropertySources({@PropertySource("classpath:test.properties")})
public class SpringTestConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}