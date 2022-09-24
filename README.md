# Projeto E-diaristas
Projeto desenvolvido durante a imersão Multi Stack da TreinaWeb ultilizando Java e Spring Boot.

## Dependências do Projeto
- Spring Boot
- Spring Web MVC
- Thymeleaf
- Spring Data Jpa
- Bean Validation

## Dependências de Desenvolvimento
- Spring Boot Devtools
- Lombok

## Requisitos
- Java 17
- Maven 3.8

## Como testtar esse projeto na minha Máquina?

Clone este Repósitorio e entre na pasta do projeto.
 
```Sh
git clone git@github.com:francivaldo-alves/e-diaristas-.git
cd e-diaristas
```
Atualize as configurações de acesso ao banco de dados no arquivo [application.properties](src/main/resources/application.properties)

````properties
spring.datasource.url=jdbc:mariadb://host:porta/banco?useTimezone=true&serverTimezone=America/Sao_Paulo
spring.datasource.username=usuario
spring.datasource.password =senha
````

Execulte o projeto através do Maven.

````sh
mvn spring-boot:run
````
Acesse a aplicação em [http://localhost:8080/admin/servicos](http://localhost:8080/admin/servicos)