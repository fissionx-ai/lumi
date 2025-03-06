package com.fissionx.lumi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration

public class LumiApp {

	public static void main(String[] args) {

		SpringApplication.run(LumiApp.class, args);

	}

}
