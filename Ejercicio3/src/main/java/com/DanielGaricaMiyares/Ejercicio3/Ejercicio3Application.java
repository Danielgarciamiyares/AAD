package com.DanielGaricaMiyares.Ejercicio3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejercicio3Application 
{
	
	@Bean
	public Principal applicationStartupRunner()
	{
		return new Principal();
	}
	
	
	public static void main(String[] args) 
	{
		SpringApplication.run(Ejercicio3Application.class, args);

		
	}

}
