package com.gl.tdms.labwk17d02dem1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.gl.tdms.labwk17d02dem1.controller","com.gl.tdms.labwk17d02dem1.entity","com.gl.tdms.labwk17d02dem1.repository","com.gl.tdms.labwk17d02dem1.security","com.gl.tdms.labwk17d02dem1.service"})
public class Labwk17d02dem1Application {

	public static void main(String[] args) {
		SpringApplication.run(Labwk17d02dem1Application.class, args);
		System.out.println("Welcome to SpringBoot - Spring Security Project");
	}

}
