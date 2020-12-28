package com.ouyanglol.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ouyangduning
 */
@SpringBootApplication
@EnableEurekaServer
public class ReactorEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactorEurekaApplication.class, args);
	}

}
