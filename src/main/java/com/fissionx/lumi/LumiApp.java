package com.fissionx.lumi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.fissionx.form.store.repository")
@EntityScan(basePackages = "com.fissionx.form.store.entity")

public class LumiApp {

	public static void main(String[] args) {

		SpringApplication.run(LumiApp.class, args);

	}

}
