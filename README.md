# Teste Tokio

### Requisitos

1. JDK 8
1. Maven 3

### Rodando o projeto 

1. Clone o projeto: `https://github.com/rubensjjr/testeMaster`
1. Entre na pasta `practical-test` e execute: `mvn spring-boot:run`
1. Acesse: `http://localhost:8080/customers`

# Sobre o projeto

Teste Devenvolvido para qualificações de conhecimento em Spring boot.

## GET - listando todos os Customers
![Mobile 1](https://raw.githubusercontent.com/rubensjjr/Assets/main/Get.PNG) 

http://localhost:8080/customers

## GET - Listando o recurso selecionado pelo id especifico
![Mobile 2](https://raw.githubusercontent.com/rubensjjr/Assets/main/GetId.PNG) 

-Exemplo de request:
http://localhost:8080/customers/4  - e passado o paremetro id para selecionar somente o usuario 4 no banco

## POST - incluindo um novo recurso 
![Web 1](https://raw.githubusercontent.com/rubensjjr/Assets/main/POST.PNG)

Exempo de requisição:

{
  "name": "Teste",
  "email": "Teste@email.com",
  "logradouro": "Rua Africa",
  "numero": "88",
  "complemento": "Casa 5",
  "bairro": "Vila aurora",
  "cep": "09280520",
  "cidadeId" : 2
}

## PUT - Alterando o nome e email de um recurso 
![Web 2](https://raw.githubusercontent.com/rubensjjr/Assets/main/PUT.PNG)

Exempo de requisição:
{
  "name": "joao atualizado",
  "email": "Teste@email.com"
}

## DELETE - Apagando um recurso do banco de dados por parametro passado na URL 
![Web 3](https://github.com/rubensjjr/Assets/blob/main/DELETE.PNG)
-Exemplo de request:
http://localhost:8080/customers/4  - e passado o paremetro id para selecionar somente o usuario 4 que devera ser deletado do banco

## Modelo conceitual Utilizado para criação das classes
![Modelo Conceitual](https://raw.githubusercontent.com/rubensjjr/Assets/main/0bef3781-f2d1-45b1-83f1-9942be4081ea.jpg)

# Tecnologias utilizadas

## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- H2 - Banco em memoria 

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/rubensjjr/testeMaster

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run
```


# Autor

Rubens Junior

https://www.linkedin.com/in/rubens-ferreira-soares-junior-/


