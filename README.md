# livraria-api
projeto feito com spring boot 3 com segurança e autenticação, docker e documentação swagger.

é necessário criar um usuário e gerar um token para acessar as requisições via Postman ou Insomnia

para gerar o banco de dados com a tabela é necessário criar um schema no MYSQL com o nome de vendas de acordo com o application.properties,
com o user root e senha também root

spring.datasource.url=jdbc:mysql://localhost:3306/vendas?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

spring.datasource.username=root

spring.datasource.password=root
