# Desafio TDD Event City - Java Spring Expert

Projeto desenvolvido como parte do primeiro desafio da formação Java Spring Expert, da plataforma Devsuperior

## Tecnologias

- Java 21
- Spring Boot 4.0.6
- Spring Data JPA
- Banco de dados H2
- JUnit 5
- Maven

## Objetivo

O objetivo é realizar o desenvolvimento do projeto a partir dos testes (TDD). As especificações estão no próprio código fonte dos testes automatizados.

## Diagrama de classe

<img width="709" height="196" alt="Image" src="https://github.com/user-attachments/assets/46e34135-dd61-45b2-ac35-3b5e4144905e" />

## Critérios de correção

- DELETE /cities/{id} deve retornar 404 Not Found, quando id não existir
- DELETE /cities/{id} deve retornar 204 No Content, quando id for independente
- DELETE /cities/{id} deve retornar 400 Bad Request, quando id for dependente
- POST /cities deve inserir recurso
- GET /cities deve retornar recursos ordenados por nome
- PUT /events deve atualizar recurso, quando id existir
- PUT /events deve retornar 404 Not Found, quando id não existir

## Competências avaliadas

- Desenvolvimento TDD de API Rest com Java e Spring Boot
- Implementação de cenários de busca, inserção, deleção e atualização
- Tratamento de exceções em API com respostas HTTP customizadas