# 🕹️ DSList - Catálogo de Games

Este projeto foi desenvolvido durante o **Intensivão Java Spring**, ministrado pelo Professor [Nélio Alves](https://www.instagram.com/devsuperior.ig/) da [DevSuperior](https://devsuperior.com.br/).

A aplicação consiste em uma **API REST** de games, onde é possível:
- Listar todos os jogos cadastrados;
- Listar jogos com base em uma lista;
- Pesquisar por ID e posição na lista.

---

## 📘 Modelo Conceitual

![IMG MODEL ](dslist-model.png)

Entidades principais:
- **Game**: título, gênero, plataforma, score, descrições, imagem, etc.
- **GameList**: nome da lista.
- **Belonging**: entidade de associação com campo `position` (posição do jogo na lista).

---

## ✅ Funcionalidades

- 📜 Listar todos os Games
- 🔍 Pesquisar um Game pelo seu ID
- 🗂️ Listar todas as listas de Games cadastradas
- 🔎 Pesquisar Games por lista
- 🔀 Mudar a posição de um Game em uma lista

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- JPA / Hibernate
- PostgreSQL
- H2 Database (testes)

---

## 📚 Aprendizados

Durante o projeto, foi possível aprender sobre:
- Criação e estruturação de projetos com **Spring Boot**
- Uso do [Spring Initializr](https://start.spring.io/)
- Perfis de projeto: teste, homologação e produção
- Utilização de verbos HTTP para criação de uma API RESTful
- Integração com banco de dados utilizando JPA e Hibernate

---

## 🔗 Link do Projeto

Repositório backend: [dslist-backend](https://github.com/devsuperior/dslist-backend)

---