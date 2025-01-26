package br.com.vendas_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("livraria-spring")
                        .version("1.0")
                        .description("API de uma livraria online")
                        .contact(new Contact()
                                .name("Guilherme Diniz Java DEV")
                                .email("guilhermediniz303@gmail.com")));
    }

    @Bean
    public GroupedOpenApi customApi() {
        return GroupedOpenApi.builder()
                .group("all")
                .pathsToMatch("/**") // Incluir todas as rotas
                .pathsToExclude("/error", "/actuator/**")
                .build();
    }
}
