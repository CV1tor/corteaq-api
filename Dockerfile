# Usando a imagem do OpenJDK como base
FROM openjdk:21-jdk-slim

# Definindo o diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo JAR gerado para o container
COPY target/api-0.0.1-SNAPSHOT.jar meu-app.jar

# Expõe a porta da aplicação (geralmente 8080 para Spring Boot)
EXPOSE 8080

# Comando para rodar a aplicação Spring
ENTRYPOINT ["java", "-jar", "meu-app.jar"]