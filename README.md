# 🚀 DevOps AWS API

**API REST com Java 21 e Spring Boot | Projeto prático de DevOps e Cloud Computing**

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-Framework-6DB33F?logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?logo=apachemaven)
![Status](https://img.shields.io/badge/Status-Em_Desenvolvimento-yellow)

## 📌 Sobre o projeto

O **DevOps AWS API** é um projeto de desenvolvimento e infraestrutura criado para demonstrar, na prática, conhecimentos em desenvolvimento backend, automação de processos, integração contínua, entrega contínua e computação em nuvem.

A aplicação utiliza Java 21 e Spring Boot, com evolução planejada para uma arquitetura baseada em containers Docker, pipelines GitHub Actions e infraestrutura AWS.

### Objetivos

- Desenvolver uma API REST com Spring Boot.
- Implementar testes automatizados.
- Containerizar a aplicação com Docker.
- Automatizar build e testes utilizando GitHub Actions.
- Publicar a aplicação na AWS.
- Implementar monitoramento e observabilidade.

## 🏗️ Arquitetura planejada

```text
Developer
    |
    v
GitHub Repository
    |
    v
GitHub Actions (CI/CD)
    |
    v
Maven Build + JUnit Tests
    |
    v
Docker Image
    |
    v
Amazon ECR
    |
    v
Amazon ECS / AWS Fargate
    |
    v
Spring Boot REST API
    |
    v
Amazon CloudWatch
```

> **Nota:** A arquitetura acima representa a evolução planejada. Atualmente, a API está funcionando localmente.

## 🛠️ Stack tecnológica

| Categoria | Tecnologia |
|---|---|
| Linguagem | Java 21 |
| Framework | Spring Boot |
| Gerenciador de dependências | Maven |
| API | Spring Web |
| Desenvolvimento | IntelliJ IDEA |
| Testes planejados | JUnit 5 |
| Containers planejados | Docker |
| CI/CD planejado | GitHub Actions |
| Cloud planejada | Amazon Web Services |
| Monitoramento planejado | Amazon CloudWatch |

## 📂 Estrutura do projeto

```text
devops-aws-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/devops/
│   │   │       └── devops_aws_api/
│   │   │           ├── DevopsAwsApiApplication.java
│   │   │           └── controller/
│   │   │               └── HelloController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

*O caminho do pacote Java deve corresponder ao pacote gerado no seu projeto.*

## ⚙️ Executando localmente

### Pré-requisitos

- Java JDK 21
- IntelliJ IDEA ou terminal
- Maven Wrapper incluído no projeto

### 1. Abrir o projeto

Abra a pasta `devops-aws-api` no IntelliJ IDEA e aguarde o carregamento das dependências Maven.

### 2. Configurar a aplicação

No arquivo `src/main/resources/application.properties`, configure:

```properties
server.port=8081
```

### 3. Executar

Execute a classe `DevopsAwsApiApplication` pelo IntelliJ.

Alternativamente, no Windows, execute na raiz do projeto:

```powershell
.\mvnw.cmd spring-boot:run
```

### 4. Acessar a API

```http
GET http://localhost:8081/hello
```

**Resposta esperada:**

```text
Olá! Minha API DevOps AWS está funcionando!
```

## 🌐 Documentação da API

| Método | Endpoint | Descrição | Status esperado |
|---|---|---|---|
| GET | `/hello` | Retorna mensagem de confirmação | 200 OK |

Exemplo com cURL:

```bash
curl http://localhost:8081/hello
```

## 🧪 Testes automatizados

A implementação de testes unitários e de integração com JUnit 5 está prevista para as próximas etapas.

Os testes serão integrados ao pipeline de CI para validar o projeto antes da publicação.

## 🔄 CI/CD — Planejamento

O pipeline GitHub Actions será responsável por:

1. Fazer checkout do código-fonte.
2. Configurar o ambiente Java 21.
3. Compilar a aplicação com Maven.
4. Executar testes automatizados.
5. Construir a imagem Docker.
6. Publicar a imagem no Amazon ECR.
7. Implantar a aplicação no Amazon ECS.

A implantação dependerá da configuração das permissões e credenciais AWS necessárias.

## 📊 Roadmap do projeto

- [x] Inicialização do projeto Spring Boot
- [x] Configuração do Java 21
- [x] Implementação do primeiro endpoint REST
- [x] Execução e validação local da API
- [x] Documentação inicial
- [ ] Implementação de testes com JUnit
- [ ] Criação do Dockerfile
- [ ] Execução com Docker
- [ ] Versionamento e publicação no GitHub
- [ ] Pipeline CI/CD com GitHub Actions
- [ ] Publicação de imagens no Amazon ECR
- [ ] Deploy no Amazon ECS com Fargate
- [ ] Monitoramento com Amazon CloudWatch
- [ ] Configuração de métricas, logs e alertas

## 🔐 Boas práticas previstas

- Gerenciamento seguro de credenciais e permissões IAM.
- Utilização de variáveis de ambiente.
- Aplicação do princípio do menor privilégio.
- Automação de testes e validações.
- Monitoramento de disponibilidade e erros.
- Documentação e versionamento de alterações.

## 📈 Aprendizados

O projeto tem como propósito consolidar conhecimentos em desenvolvimento Java, APIs REST, Git, Docker, CI/CD, serviços AWS e práticas de confiabilidade de sistemas.

## 📄 Licença

A licença do projeto será definida antes de sua distribuição pública.

---

**Status do projeto:** Em desenvolvimento.

**Próxima entrega:** Testes automatizados com JUnit 5 e containerização com Docker.
