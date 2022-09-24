//server.port = 8086

package com.cts.moviecruiser.favorite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication // (scanBasePackages= {"com.cts.moviecruiser.favorite"})
public class FavoriteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavoriteServiceApplication.class, args);

	}

}
