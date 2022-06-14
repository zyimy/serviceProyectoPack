package com.restaurante;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class RestauranteApplication  {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
	}
	
//https://www.youtube.com/watch?v=PAQvxqocb6A

}
