package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);//ctrl+alt +v

	//Bean-object
	//@Controller,service,repositroy,compoent,restcontroller-we use at class level
	//@Bean- we use method level
	}

}
