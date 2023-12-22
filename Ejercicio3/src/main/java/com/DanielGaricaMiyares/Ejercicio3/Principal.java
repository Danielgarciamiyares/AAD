package com.DanielGaricaMiyares.Ejercicio3;

import org.springframework.boot.CommandLineRunner;

public class Principal implements CommandLineRunner
{

	@Override
	public void run(String... args) throws Exception 
	{
		try {
			System.out.println("INICIO");
		}
		catch(Exception ex) 
		{
			ex.getMessage();
		}
	}

	
}
