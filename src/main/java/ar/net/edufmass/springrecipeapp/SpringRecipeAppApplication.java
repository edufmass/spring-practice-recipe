package ar.net.edufmass.springrecipeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class SpringRecipeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRecipeAppApplication.class, args);
		//System.out.println("version: " + SpringVersion.getVersion());
		//System.out.println("spring boot version: " + SpringBootVersion.getVersion());
	}

}
