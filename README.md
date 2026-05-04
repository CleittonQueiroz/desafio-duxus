# Desafio Duxus - API REST com Spring Boot

Este projeto foi desenvolvido como solução para o desafio técnico proposto pela Élin Duxus, com foco na implementação das funcionalidades solicitadas a partir de uma base de código já existente. O principal objetivo foi trabalhar o processamento de dados e a lógica de negócio, buscando organização e clareza na implementação.

---

## Sobre o desafio

O desafio consiste em complementar uma base de código existente para gerenciar times e integrantes, permitindo consultas e análises com base nos dados cadastrados.

---

## Tecnologias utilizadas

- Java (uso de Streams)
- Spring Boot
- Spring Data JPA
- H2 Database (em memória)
- Maven
- Postman (testes e validação dos endpoints REST)

---

## Como executar o projeto

### Clonar o repositório

git clone https://github.com/CleittonQueiroz/desafio-duxus.git

### Acessar a pasta do projeto

cd desafio-duxus

### Executar a aplicação

Via IDE (Spring Tool Suite, IntelliJ ou Eclipse)

Ou via terminal: ./mvnw spring-boot:run

---

## Acesso à aplicação

Após iniciar, a aplicação estará disponível em:

http://localhost:8080

---

## Banco de dados (H2)

Console:  
http://localhost:8080/h2-console

Configurações:

JDBC URL: jdbc:h2:mem:duxusdb  
User: sa  
Password: (em branco)

---

## Funcionalidades implementadas

- Cadastro de integrantes
- Cadastro de times
- Associação de integrantes aos times
- Consulta por período
- Integrante mais utilizado
- Função mais recorrente
- Clube mais frequente
- Contagem de participações no período

---

## Decisões técnicas

- Implementação dos métodos propostos no ApiService
- Uso de Java Streams para processamento de dados
- Utilização de Collectors.groupingBy para cálculos de frequência
- Implementação de endpoints REST para cadastro e consulta
- Uso de banco de dados em memória (H2) para facilitar execução

---

## Melhorias possíveis

- Implementação de testes automatizados
- Tratamento de exceções
- Validações mais completas
- Uso de banco de dados persistente

---

## Observação

O projeto foi desenvolvido a partir de uma estrutura pré-existente, com foco na implementação das regras de negócio e no processamento dos dados conforme solicitado no desafio.
