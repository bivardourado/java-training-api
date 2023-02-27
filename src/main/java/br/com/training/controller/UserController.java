package br.com.training.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;
import br.com.training.service.UserService;

@RestController
@RestControllerAdvice
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }

    @GetMapping (value = "/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser (@PathVariable String cpf){
        return userService.findUserByCpf(cpf);
        
    }

    @PutMapping (value = "/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable String cpf, @RequestBody @Valid User user) {
        return userService.updateUserByCpf(cpf, user);
    }

    @DeleteMapping (value = "/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String cpf) {
        userService.deleteUserByCpf(cpf);
    }
}
