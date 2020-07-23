package com.chlang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.chlang.mapper")
@SpringBootApplication
public class SpringBootProApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProApplication.class, args);
	}

}
