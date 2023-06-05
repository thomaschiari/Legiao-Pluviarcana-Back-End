package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.app.denuncia.DenunciaRepository;

@SpringBootApplication
@EntityScan(basePackages = {
            "com.example.app"
            })
@EnableJpaRepositories(basePackages = {
            "com.example.app.denuncia"
            })
public class LegiaoPluviarcanaApplication{

	@Autowired
	DenunciaRepository denunciaRepository;

	public static void main(String[] args) {
		SpringApplication.run(LegiaoPluviarcanaApplication.class, args);
	}


}
