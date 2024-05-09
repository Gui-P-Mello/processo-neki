package br.com.neki.skills;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Sistema de Skills Neki", version = "2.1.0"))
@SpringBootApplication
public class NekiSkillsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NekiSkillsApplication.class, args);
	}

}