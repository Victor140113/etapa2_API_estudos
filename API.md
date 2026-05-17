# API prática

  Exercício prático de API da **Etapa 2** dos estudos sobre a construção de uma API, a qual aborda relacionamentos de dados em Springboot/Banco de Dados.

> [!NOTE]
> O repositório do exercício da Etapa 1 corresponde ao [**PraticaSpringbootWebSQL**](https://github.com/Victor140113/PraticaSpringbootWebSQL).

---
## Rotas:
### Usuário:

    POST /usuario
Cria um novo usuário caso o Email não exista no banco de dados;

    POST /usuario/login
Envia uma mensagem de sucesso caso o Email e Senha existam e estejam corretos;

    GET /usuario
Devolve todos os nomes e emails de usuários existentes no banco;

    GET /usuario/id
Devolve um usuário pelo ID;

    PUT /usuario/id
Atualiza nome, email e senha do usuário por ID;

> [!IMPORTANT]
> **Este documento está sendo atualizado de acordo com as rotas adicionadas.**
