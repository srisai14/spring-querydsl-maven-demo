package com.srisai.springquerydslmavendemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.srisai"})
public class SpringQuerydslMavenDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringQuerydslMavenDemoApplication.class, args);
	}

}
