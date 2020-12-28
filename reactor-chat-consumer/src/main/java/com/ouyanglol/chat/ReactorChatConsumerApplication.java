package com.ouyanglol.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ouyangduning
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ReactorChatConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactorChatConsumerApplication.class, args);
	}

}
