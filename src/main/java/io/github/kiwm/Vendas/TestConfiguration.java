package io.github.kiwm.Vendas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Profile("development")
public class TestConfiguration {

    @Bean(name = "testConfig")
    public String testConfig() {
        return "Config OK!";
    }
}
