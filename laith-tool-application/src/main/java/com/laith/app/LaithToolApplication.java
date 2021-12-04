package com.laith.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan("com.laith.app")
@EnableJpaRepositories("com.laith.app.dao")
@SpringBootApplication
@EntityScan("com.laith.app.model")
public class LaithToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaithToolApplication.class, args);
	}

}
