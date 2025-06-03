package com.company.ems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class EmsApplication {
    
    private static final Logger logger = LoggerFactory.getLogger(EmsApplication.class);
    
    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(EmsApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void verifyConfiguration() {
        logger.info("--------------------------------------------");
        logger.info("Application is ready!");
        logger.info("Running on port: {}", env.getProperty("server.port"));
        logger.info("Active profiles: {}", String.join(", ", env.getActiveProfiles()));
        logger.info("Database URL: {}", env.getProperty("spring.datasource.url"));
        logger.info("JPA DDL Auto: {}", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        logger.info("--------------------------------------------");
    }
}

