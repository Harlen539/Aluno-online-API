# 🎓 Aluno Online API

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de alunos e professores.  
O projeto implementa **CRUD completo** das duas entidades, com persistência em **PostgreSQL** e documentação contendo evidências das requisições e do banco de dados.

---

## 🚀 Objetivo

Simular um sistema acadêmico simples, permitindo o gerenciamento completo de alunos e professores por meio das seguintes operações:

### 👨‍🎓 Alunos

- Cadastrar novos alunos  
- Listar todos os alunos cadastrados  
- Buscar um aluno pelo ID  
- Atualizar os dados de um aluno  
- Excluir um aluno do sistema  

### 👨‍🏫 Professores

- Cadastrar novos professores  
- Listar todos os professores cadastrados  
- Buscar um professor pelo ID  
- Atualizar os dados de um professor  
- Excluir um professor do sistema  

---

## 🛠️ Tecnologias

- Java 21  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- PostgreSQL  
- Maven  
- Lombok  
- Insomnia  
- DBeaver  

---

## 🏗️ Arquitetura

O projeto segue o padrão de **arquitetura em camadas**, garantindo melhor organização e manutenção do código:

- **Controllers** → Recebem as requisições HTTP e retornam as respostas  
- **Services** → Contêm a lógica de negócio da aplicação  
- **Repositories** → Responsáveis pelo acesso ao banco de dados  
- **Models** → Representam as entidades da aplicação  
- **Exceptions** → Tratam erros, como registros não encontrados  

---

## 🔄 Fluxo da Aplicação

1. O cliente envia uma requisição para a API  
2. O **Controller** recebe e encaminha para o **Service**  
3. O **Service** aplica as regras de negócio  
4. O **Repository** acessa o banco via JPA/Hibernate  
5. A resposta é retornada em formato **JSON**  

---

## 📁 Estrutura do Projeto

```text
src/
├── main/
│   ├── java/
│   │   └── br/com/alunoonline/api/
│   │       ├── controllers/      → Endpoints da API (entrada HTTP)
│   │       │   ├── AlunoController.java
│   │       │   └── ProfessorController.java
│   │       │
│   │       ├── services/         → Regras de negócio
│   │       │   ├── AlunoService.java
│   │       │   └── ProfessorService.java
│   │       │
│   │       ├── repositories/     → Acesso ao banco (JPA)
│   │       │   ├── AlunoRepository.java
│   │       │   └── ProfessorRepository.java
│   │       │
│   │       ├── models/           → Entidades do sistema
│   │       │   ├── Aluno.java
│   │       │   └── Professor.java
│   │       │
│   │       ├── exceptions/       → Tratamento de erros
│   │       │   ├── ApiExceptionHandler.java
│   │       │   └── ResourceNotFoundException.java
│   │       │
│   │       └── AlunoOnlineApplication.java → Classe principal
│   │
│   └── resources/
│       └── application.properties → Configurações do sistema
│
└── test/                         → Testes automatizados
````

---

## 🧠 Detalhamento do Código

### 📌 Models

As classes **Aluno** e **Professor** representam as entidades persistidas no banco.

**Campos:**

* id
* name
* email
* cpf

**Anotações utilizadas:**

* `@Entity`
* `@Table`
* `@Id`
* `@GeneratedValue`

---

### 📌 Repositories

`AlunoRepository` e `ProfessorRepository` estendem `CrudRepository`, permitindo:

* Salvar registros
* Listar todos
* Buscar por ID
* Excluir por ID

---

### 📌 Services

Responsáveis pela lógica da aplicação:

* Listagem de registros
* Busca por ID
* Criação de novos dados
* Atualização de informações
* Validação de existência antes de atualizar ou excluir

📍 Caso o registro não exista → retorna **404 Not Found**

---

### 📌 Controllers

Responsáveis por expor os endpoints da API.

---

## 🔗 Endpoints

### 👨‍🎓 Aluno

```text
GET    /aluno/
GET    /aluno/{id}
POST   /aluno/create
PUT    /aluno/update/{id}
DELETE /aluno/delete/{id}
```

### 👨‍🏫 Professor

```text
GET    /professor/
GET    /professor/{id}
POST   /professor/create
PUT    /professor/update/{id}
DELETE /professor/delete/{id}
```

---

## 📦 JSON de Exemplo

### Aluno

```json
{
  "name": "Ana Souza",
  "email": "ana@email.com",
  "cpf": "12345678900"
}
```

### Professor

```json
{
  "name": "Carlos Lima",
  "email": "carlos@email.com",
  "cpf": "98765432100"
}
```

---

## ⚙️ Como Rodar

### 1. Criar o banco

```sql
CREATE DATABASE "aluno-online";
```

---

### 2. Configurar o `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/aluno-online
spring.datasource.username=postgres
spring.datasource.password=${DB_PASSWORD:postgres}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3. Executar a aplicação

#### IntelliJ

* Abrir `AlunoOnlineApplication.java`
* Clicar em **Run**

#### Terminal

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
.\mvnw.cmd spring-boot:run
```

---

## 🌐 Base URL

```text
http://localhost:8080
```

---

## 📸 Evidências

### 🔎 Insomnia — CRUD de Aluno

* Criar aluno → `imagens/print-insomnia-aluno-criar.png`
* Listar alunos → `imagens/print-insomnia-aluno-listar.png`
* Buscar por ID → `imagens/print-insomnia-aluno-buscar.png`
* Atualizar aluno → `imagens/print-insomnia-aluno-atualizar.png`
* Excluir aluno → `imagens/print-insomnia-aluno-excluir.png`

---

### 🔎 Insomnia — CRUD de Professor

* Criar professor → `imagens/print-insomnia-professor-criar.png`
* Listar professores → `imagens/print-insomnia-professor-listar.png`
* Buscar por ID → `imagens/print-insomnia-professor-buscar.png`
* Atualizar professor → `imagens/print-insomnia-professor-atualizar.png`
* Excluir professor → `imagens/print-insomnia-professor-excluir.png`

---

### 🗄️ DBeaver

* Tabela de alunos → `imagens/print-dbeaver-1.png`
* Tabela de professores → `imagens/print-dbeaver-2.png`

---

## 🧪 Testes

```bash
mvn test
```

O projeto utiliza **H2 em memória** para testes, evitando dependência do PostgreSQL local.

---

## ✅ Conclusão

Este projeto demonstra a construção de uma API REST completa com **Spring Boot**, aplicando boas práticas como:

* Arquitetura em camadas
* Separação de responsabilidades
* Tratamento de exceções
* Persistência com JPA

```

