# 🚀 API de Gerenciamento de Encomendas - Spring Boot & PostgreSQL

Este projeto é uma API desenvolvida com **Spring Boot** e **PostgreSQL** para gerenciamento de encomendas. A API permite operações de CRUD (Criar, Ler, Atualizar e Deletar) de encomendas, além de integração com um banco de dados relacional, aplicando boas práticas de arquitetura como DTOs, Mappers, e separação de camadas de serviço e controle.

## 📋 Features

- Cadastro de encomendas com validação de dados.
- Atualização, exclusão e listagem de encomendas.
- Integração com PostgreSQL para persistência de dados.
- Uso de DTOs (Data Transfer Objects) para transporte seguro e otimizado de dados.
- Arquitetura limpa, modular e escalável.
  
## 🛠️ Tecnologias Utilizadas

- **Java 21.0.1**
- **Spring Boot** (v3+)
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok** - para reduzir o boilerplate de código.
- **MapStruct** - para facilitar o mapeamento entre entidades e DTOs.
- **Maven** - gerenciamento de dependências e build.
  
## 🚀 Setup Inicial

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:

- **Java JDK** (versão 17 ou superior)
- **Maven**
- **PostgreSQL** (ou Docker para rodar o banco em um container)
- **IDE de sua preferência** (ex: IntelliJ IDEA, Eclipse)

### Passos para configuração

1. **Clone o repositório**

   ```bash
   git clone https://github.com/seu-usuario/seu-projeto.git
   cd seu-projeto

![condominio_tabela](https://github.com/user-attachments/assets/de9dfce9-3f68-4d8a-a391-0e7355be83ac)

![encomendas_db](https://github.com/user-attachments/assets/724d1d6f-28cb-4623-9faa-69f3e2b516bb)
![endpoints](https://github.com/user-attachments/assets/d63c41ee-7b9a-4eb2-9891-c107ad3ff4a8)


![moradores_tabela](https://github.com/user-attachments/assets/6603fff3-ec3e-4bdb-b170-44b0d3edd154)

![porteiro](https://github.com/user-attachments/assets/93c6cbc5-7fc4-4250-a79f-65b4ae1098ff)

![register](https://github.com/user-attachments/assets/6bd4dffa-8292-488c-90c4-f95b6761ec73)


## 🔧 Estrutura do Projeto

![estrtura](https://github.com/user-attachments/assets/39e8b1b1-3eba-4a08-afbe-63c9d8cfa4d2)


## Descrição das Camadas:
- Controller: Controladores REST que recebem as requisições e enviam as respostas HTTP.
- DTOs: Objetos de transferência de dados para troca de informações entre o frontend e backend.
- Entity: Mapeamento das entidades do banco de dados.
- Repository: Interface responsável pela comunicação com o banco de dados via JPA.
- Service: Camada que contém a lógica de negócios.
- Mapper: Utilizado para mapear entidades para DTOs e vice-versa.
