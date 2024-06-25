# Book Social API

### Bem-vindo à documentação da API Book Social. Esta API permite gerenciar feedbacks, livros e autenticação de usuários. A documentação segue o padrão OpenAPI e está disponível no Swagger UI.

## Acesso à Documentação

### A documentação completa da API está disponível através do Swagger UI. Para acessá-la, utilize o seguinte endereço:

```bash
http://localhost:8088/api/v1/swagger-ui.html
```
## Estrutura da API

### Endpoints

#### A API está dividida nos seguintes grupos de endpoints:

1. `Feedback`
2. `Book`
3. `Authentication`

## Detalhes dos Endpoints

#### Feedback
* `POST` `/feedback:` Cria um novo feedback.
* `GET` `/feedback/book/{book-id}:` Obtém todos os feedbacks de um livro específico.

#### Book
* `POST` `/books:` Cria um novo livro.
* `GET` `/books:` Obtém todos os livros.
* `GET` `/books/owner:` Obtém todos os livros do proprietário.
* `GET` `/books/borrowed:` Obtém todos os livros emprestados.
* `GET` `/books/returned:` Obtém todos os livros devolvidos.
* `PATCH` `/books/shareable/{book-id}:` Atualiza o status de compartilhamento de um livro.
* `PATCH` `/books/archived/{book-id}:` Atualiza o status de arquivamento de um livro.
* `POST` `/books/borrow/{book-id}:` Solicita o empréstimo de um livro.
* `PATCH` `/books/borrow/return/{book-id}:` Solicita a devolução de um livro emprestado.
* `PATCH` `/books/borrow/return/approve/{book-id}:` Aprova a devolução de um livro emprestado.
* `POST` `/books/cover/{book-id}:` Faz upload da capa de um livro.

#### Authentication
* `POST` `/auth/register:` Registra um novo usuário.
* `POST` `/auth/authenticate:` Autentica um usuário.
* `GET` `/auth/activate-account:` Ativa uma conta de usuário.

## Configuração de Segurança

 A API utiliza JWT (JSON Web Tokens) para autenticação. A configuração de segurança é definida no OpenApiConfig da seguinte maneira:

```java
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
```

Ao realizar requisições para endpoints protegidos, inclua o token JWT no cabeçalho da seguinte maneira:

```bash
Authorization: Bearer <seu-token-jwt>
```

## Tecnologias Utilizadas

#### A API foi desenvolvida utilizando as seguintes tecnologias:

* `Java 17:` Linguagem java versão 17 LTS;
* `Spring Boot:` Framework principal para desenvolvimento da API;
* `Spring Security:` Utilizado para autenticação e autorização;
* `Spring Data JPA:` Utilizado para persistência de dados;
* `PostgreSQL:` Banco de dados utilizado para persistência de dados;
* `JWT (io.jsonwebtoken:jjwt-root:0.12.5):`  Utilizado para geração e validação de tokens JWT;
* `MailDev:` Utilizado para gerenciamento de emails de token;
* `Swagger:` Utilizado para documentação da API;
* `Docker:` Utilizando Docker para gerenciar o banco de dados PostgreSQL e o MailDev, a partir de um servidor dedicado Rocky Linux;
* `Insomnia:` Utilizado para testar as requisições da API;

## Licença

Este projeto está licenciado sob a [MIT LICENSE](LICENSE).