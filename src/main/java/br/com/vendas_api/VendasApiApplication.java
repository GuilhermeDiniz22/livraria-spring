package br.com.vendas_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Livraria API", version = "2.1", description = "Uma api para ser usada em uma livraria"))
public class VendasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasApiApplication.class, args);
	}

}
