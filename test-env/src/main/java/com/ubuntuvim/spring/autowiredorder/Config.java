package com.ubuntuvim.spring.autowiredorder;

import com.ubuntuvim.spring.scop.AppConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ComponentScan
@Configuration
@ImportResource(locations = "classpath:autowried-override.xml")
public class Config {
	@Bean
	public Apple apple() {
		return new Apple();
	}

	@Bean
	public Banana banana() {
		return new Banana();
	}
}

