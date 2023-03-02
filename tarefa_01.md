* * *

## 1️⃣ Primeira parte

### Versionando seu código

### Feito



### Camada de Service

#### Tarefa 🔛

- Crie uma camada de `Service` para ser usada entre a camada de `Controller` e de `Repository`.
 

### Crei um pacote Service.
### Crei uma classe Userservice.
### Criei uma instância da classe UserService no UserController, injetando-a com a anotação @Autowired.
### Alterei o método createUser() do UserController para chamar o método saveUser() da classe UserService.
### Alterei o método getUser() do UserController para chamar o método findUserByCpf() da classe UserService.

.



### CRUD completo

Criei dois novos endpoints:

@PutMapping (value = "/{cpf}") para realizar a operação de update.
@DeleteMapping (value = "/{cpf}") para realizar a operação de delete.
Ambos recebem o CPF como parâmetro na URL e utilizam o UserService para executar as operações necessárias.




* * *
