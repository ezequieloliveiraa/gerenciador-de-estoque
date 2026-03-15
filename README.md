# gerenciador-de-estoque
Aplicação backend para gerenciamento de estoque desenvolvida com Spring Boot, oferecendo funcionalidades para controle de produtos e organização de dados. O projeto tem como objetivo praticar arquitetura de APIs REST, persistência de dados e boas práticas no desenvolvimento de aplicações Java.


# Objetivo

Este projeto tem como objetivo aplicar conceitos de desenvolvimento backend utilizando Java e Spring Boot, incluindo:

criação de endpoints REST

manipulação de dados em banco relacional

uso de DTOs para transferência de dados

controle de entidades e relacionamentos

implementação de Soft Delete para preservação de registros

Tecnologias Utilizadas

Java

Spring Boot

Spring Web

Spring Data JPA

Hibernate

MySQL

Maven

Lombok

JSON

Estrutura do Projeto

O projeto foi organizado nas seguintes pastas:

src/main/java/localhost/StockManager

config
controller
dto
entity
repository

config

Contém configurações do projeto e da aplicação.

controller

Responsável por expor os endpoints da API e lidar com as requisições HTTP.

Controllers presentes no projeto:

ClientController

SalesController

dto

Contém os DTOs (Data Transfer Objects) utilizados para transferência de dados entre a API e o cliente.

DTOs utilizados:

ClientDto

ProductDto

SalesDTO

SalesItemsDTO

entity

Representa as entidades do sistema mapeadas para o banco de dados utilizando JPA/Hibernate.

Entidades presentes:

Client

Product

Sales

Sales_items

repository

Responsável pela comunicação com o banco de dados utilizando Spring Data JPA.

Repositórios presentes:

ClientRepository

ProductRepository

SalesRepository

Sales_ItemsRepository

Funcionalidades Implementadas

Cadastro de clientes

Cadastro de produtos

Registro de vendas

Registro de itens da venda

Atualização de dados

Listagem de registros

Integração entre entidades

Uso de DTOs para entrada de dados

API REST seguindo padrões HTTP

Implementação de Soft Delete

Soft Delete

O sistema utiliza Soft Delete, ou seja, os registros não são removidos fisicamente do banco de dados.

Em vez disso, um campo de controle é utilizado para marcar o registro como inativo.

Isso permite:

preservar histórico de dados

evitar perda permanente de registros

permitir recuperação futura dos dados

Configuração do Banco de Dados

Para executar o projeto, é necessário configurar um banco de dados MySQL.

1 Criar o banco de dados
CREATE DATABASE stockmanager;

2 Configurar o arquivo

Localize o arquivo:

src/main/resources/application.properties


Configure com as credenciais do seu banco:

spring.datasource.url=jdbc:mysql://localhost:3306/stockmanager
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


O Hibernate irá criar automaticamente as tabelas ao iniciar a aplicação.

Como Executar o Projeto
1 Clonar o repositório
git clone https://github.com/seu-usuario/StockManager.git

2 Acessar o projeto
cd StockManager

3 Executar a aplicação

Caso utilize Maven:

mvn spring-boot:run


Ou execute diretamente a classe:

StockManagerApplication


pela sua IDE.

Endpoints da API

A API segue o padrão REST utilizando métodos HTTP.

Exemplos:

Método	Endpoint	Descrição
GET	/clients	Listar clientes
POST	/clients	Criar cliente
PUT	/clients/{id}	Atualizar cliente
DELETE	/clients/{id}	Remoção lógica
Método	Endpoint	Descrição
GET	/sales	Listar vendas
POST	/sales	Registrar venda
Autor

Projeto desenvolvido para prática de desenvolvimento backend utilizando Java e Spring Boot, focado na construção de APIs REST e manipulação de dados com JPA/Hibernate.
