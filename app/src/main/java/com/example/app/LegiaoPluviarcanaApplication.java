package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.app.denuncia.DenunciaRepository;

@SpringBootApplication
@EnableMongoRepositories
public class LegiaoPluviarcanaApplication implements CommandLineRunner{

	@Autowired
	DenunciaRepository denunciaRepository;

	public static void main(String[] args) {
		SpringApplication.run(LegiaoPluviarcanaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'run'");
	}

}
