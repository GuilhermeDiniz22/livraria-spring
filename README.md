# livraria-api
Projeto feito com spring boot 3 com segurança e autenticação, docker e documentação swagger.

É necessário criar um usuário e gerar um token para acessar as requisições via Postman, Insomnia ou na propria documentação swagger. 

A api está configurada para entrar na pagina do swagger logo de início.

Para gerar o banco de dados com a tabela é necessário criar um schema no MYSQL com o nome de: vendas. De acordo com o application.properties,
usando com o user root e senha também root.

spring.datasource.url=jdbc:mysql://localhost:3306/vendas?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

spring.datasource.username=root

spring.datasource.password=root
