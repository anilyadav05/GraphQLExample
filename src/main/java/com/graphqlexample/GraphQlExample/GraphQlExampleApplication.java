package com.graphqlexample.GraphQlExample;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class GraphQlExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlExampleApplication.class, args);
	}
	

}
