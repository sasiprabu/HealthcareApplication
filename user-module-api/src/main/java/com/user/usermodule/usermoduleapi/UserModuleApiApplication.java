package com.user.usermodule.usermoduleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@SpringBootApplication
@EnableJpaAuditing
@EnableDiscoveryClient
@RefreshScope
@EnableCaching
public class UserModuleApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserModuleApiApplication.class, args);
	}

}
