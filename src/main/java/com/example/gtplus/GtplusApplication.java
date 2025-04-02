package com.example.gtplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class GtplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtplusApplication.class, args);
	}

}
