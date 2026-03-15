# gerenciador-de-estoque
Aplicação backend para gerenciamento de estoque desenvolvida com Spring Boot, oferecendo funcionalidades para controle de produtos e organização de dados. O projeto tem como objetivo praticar arquitetura de APIs REST, persistência de dados e boas práticas no desenvolvimento de aplicações Java.


# StockManager

API RESTful desenvolvida com Spring Boot para gerenciamento de estoque, permitindo o controle de produtos, clientes e vendas.  
O projeto foi criado com foco no aprendizado de desenvolvimento backend, construção de APIs REST e manipulação de dados utilizando JPA/Hibernate.

---

# Objetivo

Este projeto foi desenvolvido para praticar conceitos de desenvolvimento backend utilizando Java e Spring Boot, incluindo:

- criação de APIs REST
- manipulação de dados em banco relacional
- uso de DTOs para transferência de dados
- controle de entidades e relacionamentos
- implementação de Soft Delete
- organização de código em camadas

---

# Tecnologias Utilizadas

- Java  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Hibernate  
- MySQL  
- Maven  
- Lombok  
- JSON  

---

# Estrutura do Projeto

src/main/java/localhost/StockManager

├── config
├── controller
├── dto
├── entity
└── repository


## config

Contém configurações gerais do projeto e da aplicação.

## controller

Responsável por expor os endpoints da API e lidar com as requisições HTTP.

Controllers presentes:

- ClientController  
- SalesController  

## dto

Contém os DTOs (Data Transfer Objects) utilizados para transferência de dados entre cliente e servidor.

DTOs utilizados:

- ClientDto  
- ProductDto  
- SalesDTO  
- SalesItemsDTO  

## entity

Representa as entidades do sistema mapeadas para o banco de dados utilizando JPA/Hibernate.

Entidades presentes:

- Client  
- Product  
- Sales  
- Sales_items  

## repository

Responsável pela comunicação com o banco de dados utilizando Spring Data JPA.

Repositórios presentes:

- ClientRepository  
- ProductRepository  
- SalesRepository  
- Sales_ItemsRepository  

---

# Funcionalidades Implementadas

- Cadastro de clientes  
- Cadastro de produtos  
- Registro de vendas  
- Registro de itens da venda  
- Atualização de dados  
- Listagem de registros  
- Integração entre entidades  
- Uso de DTOs para entrada de dados  
- API REST seguindo padrões HTTP  
- Implementação de Soft Delete  

---

# Soft Delete

O sistema utiliza Soft Delete, ou seja, os registros não são removidos fisicamente do banco de dados.

Em vez disso, um campo de controle é utilizado para marcar o registro como inativo.

Vantagens dessa abordagem:

- preservação do histórico de dados  
- maior segurança na exclusão de registros  
- possibilidade de recuperação de dados  

---

# Configuração do Banco de Dados

Para executar o projeto é necessário configurar um banco MySQL.

## 1. Criar o banco de dados

SQL
\`\`\`
CREATE DATABASE stock;
\`\`\`
## 2. Configurar o arquivo

Localize o arquivo:

src/main/resources/application.properties

Configure as credenciais do seu banco:
\`\`\`
spring.datasource.url=jdbc:mysql://localhost:3306/stock
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
\`\`\`

O Hibernate criará automaticamente as tabelas ao iniciar a aplicação.

---
# Como executar o projeto

## 1 Clonar o repositório

https://github.com/ezequieloliveiraa/gerenciador-de-estoque.git

## 2. Execute a classe principal pela IDE:
\`\`\`
StockManagerApplication
\`\`\`

# Endpoints da API
# Endpoints da API

## Clientes

| Método | Endpoint | Descrição |
|------|------|------|
| GET | /clients | Listar clientes |
| POST | /clients | Criar cliente |
| PUT | /clients/{id} | Atualizar cliente |
| DELETE | /clients/{id} | Remoção lógica |

---

## Produtos

| Método | Endpoint | Descrição |
|------|------|------|
| GET | /products | Listar produtos |
| POST | /products | Criar produto |
| PUT | /products/{id} | Atualizar produto |
| DELETE | /products/{id} | Remoção lógica |

---

## Vendas

| Método | Endpoint | Descrição |
|------|------|------|
| GET | /sales | Listar vendas |
| POST | /sales | Registrar venda |
