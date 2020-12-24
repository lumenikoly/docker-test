package com.example.swaggerexample;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SwaggerExampleApplication {

	private static final Logger logger = LoggerFactory.getLogger(SwaggerExampleApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SwaggerExampleApplication.class, args);
		logger.info("Application successfully started info");
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
		return new OpenAPI()
				.info(new Info().title("Event API").version(appVersion).description(
						"This is a sample Event server."));
	}

}
