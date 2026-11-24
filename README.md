# 🚀 DevOps AWS API

**Java 21 | Spring Boot | Docker | CI/CD | AWS | SRE**

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.2.0-6DB33F?logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?logo=apachemaven)
![Docker](https://img.shields.io/badge/Docker-Container-2496ED?logo=docker&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-5-25A162?logo=junit5)
![GitHub](https://img.shields.io/badge/GitHub-Version_Control-181717?logo=github)
![Status](https://img.shields.io/badge/Status-Em_Desenvolvimento-yellow)

## 📌 Sobre o projeto

O **DevOps AWS API** é um projeto prático voltado ao desenvolvimento backend, automação de infraestrutura, integração contínua, entrega contínua, computação em nuvem e confiabilidade de sistemas (SRE).

A aplicação foi desenvolvida utilizando Java 21 e Spring Boot, com testes automatizados, versionamento Git e containerização Docker utilizando a estratégia Multi-stage Build.

O projeto evoluirá para uma arquitetura em nuvem AWS, com pipelines automatizados e monitoramento de aplicações.

## 🎯 Objetivos

- Desenvolver uma API REST utilizando Java e Spring Boot.
- Implementar testes automatizados com JUnit e MockMvc.
- Aplicar boas práticas de versionamento com Git e GitHub.
- Containerizar a aplicação utilizando Docker.
- Automatizar processos de build, testes e deploy.
- Implantar a aplicação na AWS.
- Implementar práticas de observabilidade e SRE.

## 🏗️ Arquitetura do projeto

```mermaid
flowchart LR
    A[Desenvolvedor] --> B[GitHub]
    B --> C[GitHub Actions]
    C --> D[Maven Build]
    D --> E[JUnit Tests]
    E --> F[Docker Image]
    F --> G[Amazon ECR]
    G --> H[Amazon ECS Fargate]
    H --> I[Spring Boot API]
    H --> J[Amazon CloudWatch]
```

A arquitetura representa o fluxo completo planejado para o projeto, desde o desenvolvimento local até a implantação e o monitoramento na AWS.

Atualmente, a aplicação possui testes automatizados e containerização Docker local.

## 🛠️ Stack tecnológica

| Categoria | Tecnologia | Status |
|---|---|---|
| Linguagem | Java 21 | Implementado |
| Framework | Spring Boot 4.2.0 | Implementado |
| API REST | Spring Web MVC | Implementado |
| Build | Apache Maven | Implementado |
| Testes | JUnit 5 e MockMvc | Implementado |
| Versionamento | Git e GitHub | Implementado |
| Containers | Docker | Implementado |
| Build de containers | Multi-stage Build | Implementado |
| IDE | IntelliJ IDEA | Utilizado |
| CI/CD | GitHub Actions | Planejado |
| Container Registry | Amazon ECR | Planejado |
| Orquestração | Amazon ECS Fargate | Planejado |
| Observabilidade | Amazon CloudWatch | Planejado |

## 📂 Estrutura do projeto

```text
devpos-aws-api/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/devops/devpos_aws_api/
│   │   │       ├── DevposAwsApiApplication.java
│   │   │       └── controller/
│   │   │           └── HelloController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/devops/devpos_aws_api/
│               ├── DevposAwsApiApplicationTests.java
│               └── controller/
│                   └── HelloControllerTest.java
├── .dockerignore
├── .gitattributes
├── .gitignore
├── Dockerfile
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## ⚙️ Executando localmente

### Pré-requisitos

- Java JDK 21
- Git
- Docker Desktop
- IntelliJ IDEA (opcional)
- Maven Wrapper

### Configuração da aplicação

Arquivo `src/main/resources/application.properties`:

```properties
server.port=8081
```

### Executar com Maven no Windows

```powershell
.\mvnw.cmd spring-boot:run
```

### Executar com Maven no Linux

```bash
./mvnw spring-boot:run
```

### Acessar a aplicação

```text
http://localhost:8081/hello
```

## 🌐 Documentação da API

| Método | Endpoint | Descrição | Status |
|---|---|---|---|
| GET | `/hello` | Verifica a resposta da aplicação | 200 OK |

### Exemplo de requisição

```bash
curl http://localhost:8081/hello
```

### Resposta esperada

```text
Olá! Minha API DevOps AWS está funcionando!
```

## 🧪 Testes automatizados

A aplicação possui testes automatizados utilizando JUnit 5 e MockMvc, permitindo validar o comportamento do endpoint REST sem iniciar um servidor HTTP real.

### Validações implementadas

- Disponibilidade da rota `/hello` no ambiente de testes.
- Validação do status HTTP 200.
- Validação do conteúdo retornado pela API.

### Executar todos os testes no Windows

```powershell
.\mvnw.cmd test
```

### Executar todos os testes no Linux

```bash
./mvnw test
```

### Resultado do teste do controller

| Indicador | Resultado |
|---|---|
| Testes executados | 1 |
| Testes aprovados | 1 |
| Falhas | 0 |
| Status | PASSED |

## 🐳 Containerização com Docker

A aplicação utiliza Docker com a estratégia Multi-stage Build, separando o ambiente de compilação do ambiente de execução.

### Arquitetura do container

```mermaid
flowchart TD
    A[Código-fonte Java] --> B[Maven + JDK 21]
    B --> C[Compilação e testes]
    C --> D[Arquivo JAR]
    D --> E[Java 21 JRE]
    E --> F[Imagem Docker]
    F --> G[Container Spring Boot]
    G --> H[Porta 8081]
```

### Dockerfile

```dockerfile
# Stage 1 - Build
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

# Stage 2 - Runtime
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Benefícios do Multi-stage Build

- Separação entre compilação e execução.
- Redução do tamanho da imagem final.
- Execução dos testes durante o build.
- Ausência do Maven na imagem de execução.
- Portabilidade entre ambientes.
- Preparação para implantação na AWS.

### Construir a imagem Docker

Execute na pasta que contém o Dockerfile e o pom.xml:

```bash
docker build -t devops-aws-api:1.0 .
```

### Listar imagens disponíveis

```bash
docker images
```

### Executar o container

```bash
docker run -d --name devops-api -p 8081:8081 devops-aws-api:1.0
```

### Verificar containers em execução

```bash
docker ps
```

### Consultar logs da aplicação

```bash
docker logs devops-api
```

### Acompanhar logs em tempo real

```bash
docker logs -f devops-api
```

### Parar o container

```bash
docker stop devops-api
```

### Reiniciar o container

```bash
docker start devops-api
```

### Remover o container

```bash
docker rm devops-api
```

O container deverá estar parado antes da remoção.

### Acessar a API containerizada

```text
http://localhost:8081/hello
```

Certifique-se de que nenhuma outra aplicação esteja utilizando a porta 8081.

## 🔄 CI/CD — GitHub Actions

**Status: próxima etapa de implementação.**

O pipeline será responsável por automatizar o ciclo de integração e entrega da aplicação.

```mermaid
flowchart LR
    A[Git Push] --> B[GitHub Actions]
    B --> C[Build Maven]
    C --> D[Testes JUnit]
    D --> E[Docker Build]
    E --> F[Amazon ECR]
    F --> G[Deploy ECS]
```

### Etapas planejadas

- Checkout do código-fonte.
- Configuração do Java 21.
- Compilação da aplicação.
- Execução dos testes automatizados.
- Construção da imagem Docker.
- Autenticação segura na AWS.
- Publicação da imagem no Amazon ECR.
- Deploy automatizado no Amazon ECS Fargate.

## ☁️ Infraestrutura AWS

**Status: planejado.**

| Serviço | Responsabilidade |
|---|---|
| Amazon ECR | Armazenamento de imagens Docker |
| Amazon ECS | Gerenciamento dos containers |
| AWS Fargate | Execução de containers sem gerenciamento de servidores |
| Amazon CloudWatch | Logs, métricas e alertas |
| AWS IAM | Gerenciamento de identidades e permissões |
| Amazon VPC | Isolamento e configuração de rede |
| Application Load Balancer | Distribuição de tráfego HTTP |

## 📡 Observabilidade e SRE

**Status: planejado.**

A evolução do projeto incluirá práticas de Site Reliability Engineering para garantir maior confiabilidade e visibilidade operacional.

- Monitoramento de disponibilidade.
- Health checks com Spring Boot Actuator.
- Monitoramento de latência.
- Monitoramento de erros HTTP.
- Métricas de CPU e memória.
- Centralização de logs.
- Alarmes com Amazon CloudWatch.
- Definição de SLI, SLO e SLA.
- Estratégias de recuperação e rollback.
- Documentação de incidentes.

## 📊 Roadmap

### Fase 1 — Desenvolvimento

- [x] Criação do projeto Spring Boot
- [x] Configuração do Java 21
- [x] Desenvolvimento da API REST
- [x] Configuração da porta 8081
- [x] Validação do endpoint local

### Fase 2 — Versionamento

- [x] Configuração do Git
- [x] Criação do repositório GitHub
- [x] Publicação inicial do código-fonte
- [x] Configuração do .gitignore
- [x] Documentação do projeto

### Fase 3 — Qualidade de software

- [x] Configuração do JUnit
- [x] Implementação do MockMvc
- [x] Teste automatizado do controller
- [x] Validação do status HTTP
- [x] Validação do conteúdo da resposta

### Fase 4 — Docker

- [x] Configuração do Dockerfile
- [x] Configuração do .dockerignore
- [x] Implementação do Multi-stage Build
- [x] Construção da imagem Docker
- [x] Configuração do mapeamento de portas
- [x] Inicialização do container
- [ ] Confirmação final do endpoint containerizado
- [ ] Publicação das alterações no GitHub

### Fase 5 — CI/CD

- [ ] Configuração do GitHub Actions
- [ ] Automação de build
- [ ] Automação de testes
- [ ] Automação da construção da imagem Docker
- [ ] Configuração do pipeline de deploy

### Fase 6 — AWS Cloud

- [ ] Configuração do Amazon ECR
- [ ] Publicação da imagem Docker
- [ ] Configuração do Amazon ECS
- [ ] Configuração do AWS Fargate
- [ ] Configuração de rede e segurança
- [ ] Deploy da aplicação

### Fase 7 — SRE e Observabilidade

- [ ] Configuração do Spring Boot Actuator
- [ ] Configuração do Amazon CloudWatch
- [ ] Monitoramento de métricas
- [ ] Centralização de logs
- [ ] Configuração de alarmes
- [ ] Definição de SLI e SLO
- [ ] Simulação e análise de incidentes

## 🔐 Segurança e boas práticas

### Implementadas

- Exclusão de arquivos desnecessários do versionamento.
- Configuração do .gitignore.
- Configuração do .dockerignore.
- Separação dos ambientes de build e runtime.
- Testes automatizados.
- Versionamento da imagem Docker.

### Planejadas

- Execução do container com usuário não privilegiado.
- Gerenciamento seguro de credenciais.
- Autenticação AWS com GitHub Actions via OIDC.
- Princípio do menor privilégio com IAM.
- Análise de vulnerabilidades em imagens Docker.
- Gerenciamento de variáveis de ambiente.
- Monitoramento e alertas operacionais.

## 📚 Conhecimentos aplicados

- Desenvolvimento backend com Java.
- APIs REST com Spring Boot.
- Testes automatizados.
- Versionamento de código.
- Containerização de aplicações.
- Multi-stage Build.
- Gerenciamento de imagens e containers.
- Análise de logs e troubleshooting.
- Fundamentos de DevOps e SRE.

## 👨‍💻 Autor

**Ailton Ferreira da Cruz Junior**

Projeto desenvolvido para aprimoramento profissional nas áreas de Software Engineering, DevOps, Cloud Computing e Site Reliability Engineering.

GitHub: [Ailton-Tech](https://github.com/Ailton-Tech)

## 📄 Licença

Licença a definir.

---

**Status:** Em desenvolvimento.

**Próxima etapa:** Implementação do pipeline CI/CD com GitHub Actions.
