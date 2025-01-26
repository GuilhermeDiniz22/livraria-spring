# Etapa 1: Construir a aplicação usando Maven
FROM maven:3.8.6-jdk-8-slim AS build

# Instalar OpenJDK 17
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get clean;

# Definir a variável de ambiente JAVA_HOME
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64

# Diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo pom.xml e baixar as dependências
COPY pom.xml .

# Baixar as dependências sem compilar
RUN mvn dependency:go-offline

# Copiar o código-fonte da aplicação
COPY src ./src

# Compilar a aplicação e gerar o arquivo .jar
RUN mvn clean package -DskipTests

# Etapa 2: Rodar a aplicação
FROM openjdk:17-slim

# Diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo .jar gerado para a imagem final
COPY --from=build /app/target/vendas-api-0.0.1-SNAPSHOT.jar /app/vendas-api-0.0.1-SNAPSHOT.jar

# Expor a porta 8080 (padrão do Spring Boot)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "vendas-api-0.0.1-SNAPSHOT.jar"]
