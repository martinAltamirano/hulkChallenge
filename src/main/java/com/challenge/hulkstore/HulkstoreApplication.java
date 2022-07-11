package com.challenge.hulkstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class HulkstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(HulkstoreApplication.class, args);
	}

}
