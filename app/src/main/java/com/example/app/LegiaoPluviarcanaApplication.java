package com.example.app;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = {
            "com.example.app"
            })
@EnableJpaRepositories(basePackages = {
            "com.example.app.denuncia"
            })
public class LegiaoPluviarcanaApplication{

	public static void main(String[] args) {
		SpringApplication.run(LegiaoPluviarcanaApplication.class, args);
	}


}
