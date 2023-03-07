package br.com.training.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import br.com.training.controller.dto.UserForm;
import br.com.training.controller.dto.UserResponse;
import br.com.training.service.UserService;

@RestController
@RestControllerAdvice
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody @Valid UserForm userForm) {
        return userService.createUser(userForm);
    }

    @GetMapping(value = "/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUser(@PathVariable Long cpf) {
        return userService.getUserById(cpf);
    }

    @PutMapping(value = "/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse updateUser(@PathVariable Long cpf, @RequestBody @Valid UserForm userForm) {
        return userService.updateUser(cpf, userForm);
    }

    @DeleteMapping(value = "/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long cpf) {
        userService.deleteUser(cpf);
    }
}
