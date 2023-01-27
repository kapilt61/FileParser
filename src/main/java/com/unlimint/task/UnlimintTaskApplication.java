package com.unlimint.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class UnlimintTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnlimintTaskApplication.class, args);
	}

}
