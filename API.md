# API prática

  Exercício prático de API da **Etapa 2** dos estudos sobre a construção de uma API, a qual aborda relacionamentos de dados em Springboot/Banco de Dados. A dinâmica é criar uma API REST do zero
  sempre que concluir uma etapa, abordando todos os conteúdos estudados nas etapas anteriores.

  ## Conteúdos da Etapa 2:

* @OneToMany
* @ManyToOne
* @OneToOne
* foreign key
* entidades ligadas
* listas dentro de entities
* cascata (CascadeType)
* fetch
* relacionamento bidirecional
* problemas de serialização
* modelagem relacional aplicada

---

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

    DELETE /usuario/id
Deleta usuário por ID;

---

### Curso:

    POST /curso/idUsuario
Cria um curso (usuário deve ser Professor) utilizando o Id do usuário pra identificar o criador;

    GET /curso
Devolve todos os cursos existentes com o nome de seu criador;

    GET /curso/id
Devolve um curso pelo seu ID;

    PUT /curso/id
Atualiza dados do curso pelo seu ID;

    DELETE /curso/id
Deleta um curso e seus matriculados pelo ID do curso;

---

### Matricula:

    POST /matricula
Matricula um usuário aluno em um curso

    GET /matricula/usuario/id
Devolve os cursos em que um aluno está matriculado;

    GET /matricula/curso/id
Devolve os alunos de um curso;

    PUT /matricula/id
Atualiza progresso e status de uma matricula;

    DELETE /matricula/id
Deleta uma matrícula (aluno sai de um curso) por ID;

---
> [!IMPORTANT]
> **Este documento foi concluído, não haverão mais atualizações!**
---
