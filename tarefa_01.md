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

*Usar uma camada de `Service` é uma boa prática para separar as responsabilidades no projeto, pois as regras de negocio serão implementada nesta camada no lugar de ficar na camada de Controller (que tem como responsabilidade de ser a camada de entrada e saida de dados).*

[Referência a respeito de separação de conceitos](https://www.profissionaisti.com.br/entendendo-a-separacao-de-conceitos-separation-of-concerns-soc/#:~:text=Na%20Programa%C3%A7%C3%A3o%20Orientada%20a%20Objetos,subclasses)

.


### CRUD completo

#### Tarefa 🚀

- Complete o CRUD com os endpoints de `UPDATE` e `DELETE` usando o CPF como *PathVariable*.
  - Atual: *POST + GET*
  - Esperado: *POST + GET + PUT + DELETE*



* * *
