package br.com.vendas_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permite CORS para todas as rotas
        registry.addMapping("/**")
                .allowedOrigins("*")  // Permite todas as origens. Você pode restringir a URLs específicas, se necessário.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Permite os métodos HTTP que você deseja
                .allowedHeaders("*")  // Permite todos os cabeçalhos
                .allowCredentials(true);  // Se necessário, permite o envio de cookies
    }
}
