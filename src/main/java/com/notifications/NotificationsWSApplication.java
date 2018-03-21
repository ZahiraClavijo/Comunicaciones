package com.notifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.notifications.api", "com.notifications.service",
        "com.notifications.dao", "com.notifications.mapper", "com.notifications.exception",
        "com.notifications.provider"})
public class NotificationsWSApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationsWSApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        return restTemplate;
    }
}
