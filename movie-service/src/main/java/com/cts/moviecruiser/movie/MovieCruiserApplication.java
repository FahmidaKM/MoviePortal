//server.port = 8086

package com.cts.moviecruiser.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@EnableDiscoveryClient
@SpringBootApplication//(scanBasePackages= {"com.cts.moviecruiser.movie"})
public class MovieCruiserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCruiserApplication.class, args);
		

	}

}
