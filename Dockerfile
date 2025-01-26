# Use uma imagem do OpenJDK 21 como base
FROM openjdk:17-jdk-alpine

# Crie o diretório /app
RUN mkdir /app

# Defina o diretório de trabalho
WORKDIR /app

# Copie o JAR da aplicação para o container
COPY target/vendas-api-0.0.1-SNAPSHOT.jar /app/vendas-api.jar

# Exponha a porta que o Spring Boot irá rodar
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "vendas-api.jar"]

