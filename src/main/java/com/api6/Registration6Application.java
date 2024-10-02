package com.api6;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Registration6Application {

	public static void main(String[] args) {
		SpringApplication.run(Registration6Application.class, args);
	}
@Bean
	public ModelMapper getMap(){
		return new ModelMapper();
}
}
