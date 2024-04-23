package br.com.neki.skills.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Sistema de Skills Neki", version = "2.1.0"))
public class SwaggerConfig {

}
