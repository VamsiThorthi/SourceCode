package com.stg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@SwaggerDefinition
public class TsrtcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TsrtcApplication.class, args);
	}

}
