# To Do List (Backend)

Repositório responsável pela API do sistema **Priority**, desenvolvido com **Spring Boot** e **MySQL** como parte do desafio de estágio *NextAge | IFPR*.

> Este repositório contém **apenas o backend** da aplicação.  
> O repositório separado com o frontend será vinculado aqui posteriormente.

---

## 🚀 Tecnologias utilizadas

- Java 21  
- Spring Boot (Maven)  
- MySQL  
- JPA / Hibernate  

---

## ⚙️ Requisitos

| Ferramenta | Versão sugerida |
|-----------|----------------|
| Java      | 21             |
| Maven     | 3.8+           |
| MySQL     | 8+             |

---

## 📁 Como rodar o projeto localmente

```bash
# 1. Clone o repositório
git clone https://github.com/ClaudirFantuci/CodeChallenge-IFPR-NextAge.git
cd CodeChallenge-IFPR-NextAge

# 2. Certifique-se de ter o MySQL rodando com o banco já criado:
#    database: To_do
#    porta: 3304
#    usuário: root

# 3. Build e rode o projeto
./mvnw spring-boot:run
# ou
mvn spring-boot:run
