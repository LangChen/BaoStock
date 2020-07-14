package com.chlang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.chlang.mapper")
@SpringBootApplication
public class SpringBootProApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProApplication.class, args);
	}

}
