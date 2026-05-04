# Desafio Duxus - API REST com Spring Boot

Este projeto foi desenvolvido como solução para o desafio técnico proposto pela Duxus, com foco na organização do código, boas práticas e implementação das funcionalidades solicitadas.

---

## Sobre o desafio

O desafio consiste em complementar uma base de código existente para gerenciar times e integrantes, permitindo consultas e análises com base nos dados cadastrados.

---

## Tecnologias utilizadas

- Java 8+
- Spring Boot
- Spring Data JPA
- H2 Database (em memória)
- Maven

---

## Como executar o projeto

### Clonar o repositório

git clone https://github.com/CleittonQueiroz/desafio-duxus.git

### Acessar a pasta do projeto

cd desafio-duxus

### Executar a aplicação

Via IDE (Spring Tool Suite, IntelliJ ou Eclipse)

Ou via terminal:

./mvnw spring-boot:run

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

- Uso de Java Streams para processamento de dados
- Utilização de Collectors.groupingBy para cálculos de frequência
- Separação em camadas (Controller, Service, Repository)
- Banco de dados em memória (H2)

---

## Melhorias possíveis

- Implementação de testes automatizados
- Tratamento global de exceções
- Validações mais robustas
- Documentação com Swagger
- Uso de banco persistente

---

## Autor

Cleiton Marques Queiroz  
GitHub: https://github.com/CleittonQueiroz  
LinkedIn: https://www.linkedin.com/in/cleitonqueiroz/

---

## Observação

O projeto foi desenvolvido priorizando a entrega funcional dentro do prazo proposto, mantendo organização e clareza no código.
