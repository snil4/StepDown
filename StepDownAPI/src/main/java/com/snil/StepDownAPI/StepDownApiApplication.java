package com.snil.StepDownAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StepDownApiApplication {

	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(StepDownApiApplication.class, args);
	}

	public static void stop() {
		context.stop();
	}

}
