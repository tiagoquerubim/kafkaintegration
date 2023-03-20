package com.kafkaintegration.kafkaintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping(path = "/")
public class KafkaintegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaintegrationApplication.class, args);
	}

}
