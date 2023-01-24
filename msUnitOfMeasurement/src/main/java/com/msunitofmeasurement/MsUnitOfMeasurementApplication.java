package com.msunitofmeasurement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsUnitOfMeasurementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUnitOfMeasurementApplication.class, args);
	}

}
