package com.proyecto.spring.event.controller.error;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages="com.proyecto.spring.user.repository")
public class MongoClientConfig{
	
}