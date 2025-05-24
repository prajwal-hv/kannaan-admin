
package com.kannaan.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class KannaanAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(KannaanAdminApplication.class, args);
	}

}
