### Projeto de Biblioteca com Clean Architecture
Este repositório contém um projeto de gerenciamento de livros, desenvolvido com foco em práticas de arquitetura limpa (Clean Architecture) no backend. O backend foi implementado em Java com Spring Boot, enquanto o frontend, criado para treinamento do backend, foi feito em Node.js e Express.

O frontend está hospedado no Amazon S3, e o backend está em uma instância EC2 da AWS. Essa estrutura facilita a escalabilidade e permite a separação clara das camadas de aplicação.

## Estrutura do Backend
O backend foi construído seguindo o padrão de Clean Architecture, que utiliza portas e adaptadores para promover uma arquitetura modular, escalável e de fácil manutenção. A aplicação está organizada em camadas, permitindo uma separação clara entre lógica de negócios e interfaces externas.

## Componentes Principais
Domain: Contém as entidades e objetos de domínio, como a classe Livro.
Application Layer (Use Cases): Implementa os casos de uso da aplicação, como criação, leitura, atualização e remoção de livros, representados pelas interfaces CreateLivroUseCase, GetLivroUseCase, UpdateLivroUseCase e DeleteLivroUseCase.
Adapters: Incluem os adaptadores que expõem a API REST por meio de um controller (LivroController). Este controller atua como porta de entrada para o backend, facilitando a interação entre o frontend e os casos de uso.

## Endpoints da API
A API possui endpoints REST para operações CRUD (Create, Read, Update, Delete) na base de dados de livros:

POST /livros: Cria um novo livro.
GET /livros: Retorna uma lista de todos os livros.
GET /livros/{id}: Retorna um livro específico pelo seu ID.
PUT /livros/{id}: Atualiza as informações de um livro pelo seu ID.
DELETE /livros/{id}: Remove um livro pelo seu ID.
Esses endpoints possibilitam a gestão completa do ciclo de vida dos livros e foram projetados para facilitar a integração e o teste, especialmente no contexto de uma arquitetura orientada a portas e adaptadores.

## Estrutura do Frontend
O frontend simples, desenvolvido com Node.js e Express, serve para consumir os endpoints do backend, validando o funcionamento das operações CRUD. Ele foi projetado apenas para treinamento e testes e está hospedado na Amazon S3 para fácil acesso e distribuição.

