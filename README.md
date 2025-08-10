# To Do List - Backend

Este é o backend do projeto **To Do List**, desenvolvido como parte do desafio do processo seletivo de estágio.  
Ele é responsável por fornecer APIs RESTful para gerenciamento de tarefas, integrando-se com um banco de dados MySQL.

Projeto em desenvolvimento.

## ✅ Funcionalidades (em desenvolvimento)
- [ ] Criação de Tarefas
- [ ] Visualização de Tarefas
- [ ] Edição de Tarefas
- [ ] Marcação de Conclusão
- [ ] Exclusão de Tarefas
- [ ] Autenticação de Usuário (Opcional)
- [ ] Filtros e Ordenação (Opcional)
- [ ] Outras funcionalidades (descrever)

## 🛠 Tecnologias Utilizadas
- **Backend:** Spring Boot
- **Banco de Dados:** MySQL
- **Gerenciamento de Dependências:** Maven

## 🚀 Como Configurar e Executar
### Pré-requisitos
- Java 21+
- Maven
- MySQL configurado e em execução
- IDE compatível com projetos Maven

### Passos
```bash
# 1. Clone o repositório
git clone https://github.com/ClaudirFantuci/CodeChallenge-IFPR-NextAge-Backend.git
cd CodeChallenge-IFPR-NextAge-Backend

# 2. Configure o banco de dados
# Crie um banco de dados MySQL, por exemplo:
# CREATE DATABASE todolist;

# 3. Configure as credenciais no arquivo application.properties
# spring.datasource.url=jdbc:mysql://localhost:3306/todolist
# spring.datasource.username=seu_usuario
# spring.datasource.password=sua_senha

# 4. Compile e execute a aplicação
mvn spring-boot:run
