# 📰 API de Notícias com Spring Boot + WebClient + Swagger + PostgreSQL + E-mail

Este projeto é uma API desenvolvida em **Spring Boot** que consome notícias da [API Mediastack](https://mediastack.com/) utilizando `WebClient`, salva no banco de dados **PostgreSQL** e envia uma das notícias por e-mail usando `JavaMailSender`. A API também está documentada com Swagger.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Web (WebClient)
- Spring Data JPA
- PostgreSQL
- JavaMailSender
- Springdoc OpenAPI (Swagger)
- Maven

---

## 📦 Funcionalidades

- 🔍 Buscar até 100 notícias da categoria **"general"** do Brasil
- 🎲 Escolher uma notícia aleatória
- 📨 Enviar a notícia aleatória por e-mail
- 💾 Salvar todas as notícias retornadas no banco PostgreSQL
- 🧪 Swagger para documentação e testes

