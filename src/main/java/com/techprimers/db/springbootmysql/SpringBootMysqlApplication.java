package com.techprimers.db.springbootmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.techprimers.db.repository")
@SpringBootApplication
@EntityScan("com.techprimers.db.model")
@ComponentScan(basePackages = {"com.techprimers.db.repository","com.techprimers.db.controller"})
public class SpringBootMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMysqlApplication.class, args);
	}

}
