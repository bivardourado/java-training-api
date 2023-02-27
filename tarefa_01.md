* * *

## 1️⃣ Primeira parte

Na primeira parte desse desafio, o objetivo vai ser de atualizar a estrutura do projeto, e completar o CRUD (Create, Read, Update e Delete) do Controller.

### Versionando seu código

#### Tarefa 🔀

- O versionamento do nosso código é algo muito importante, para cada tarefa que está sendo solicitada for concluída, faça um commit para o seu repositório.

[Referência a respeito do GIT](https://rogerdudler.github.io/git-guide/index.pt_BR.html)

### Camada de Service

#### Tarefa 🔛

- Crie uma camada de `Service` para ser usada entre a camada de `Controller` e de `Repository`.
  - Atual: *Controller --> Repository*
  - Esperado: *Controller --> Service --> Repository*

### Crei um pacote Service.
### Crei uma classe Userservice.
### Criei uma instância da classe UserService no UserController, injetando-a com a anotação @Autowired.
### Alterei o método createUser() do UserController para chamar o método saveUser() da classe UserService.
### Alterei o método getUser() do UserController para chamar o método findUserByCpf() da classe UserService.

.


### CRUD completo

#### Tarefa 🚀

- Complete o CRUD com os endpoints de `UPDATE` e `DELETE` usando o CPF como *PathVariable*.
  - Atual: *POST + GET*
  - Esperado: *POST + GET + PUT + DELETE*

Criei dois novos endpoints:

@PutMapping (value = "/{cpf}") para realizar a operação de update.
@DeleteMapping (value = "/{cpf}") para realizar a operação de delete.
Ambos recebem o CPF como parâmetro na URL e utilizam o UserService para executar as operações necessárias.

* * *
