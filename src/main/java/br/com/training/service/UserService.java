package br.com.training.service;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.training.controller.dto.UserForm;
import br.com.training.controller.dto.UserResponse;
import br.com.training.model.User;
import br.com.training.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserResponse saveUser(UserForm userForm) {
        User user = convertToEntity(userForm);
        User savedUser = userRepository.save(user);
        return convertToDto(savedUser);
    }

    private User convertToEntity(UserForm userForm) {
        return modelMapper.map(userForm, User.class);
    }

    private UserResponse convertToDto(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

    public UserResponse findUserByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        return convertToDto(user);
    }

    public UserResponse updateUserByCpf(String cpf, UserForm userForm) {
        User existingUser = userRepository.findByCpf(cpf);
        if (existingUser == null) {
            return null;
        }
        User user = convertToEntity(userForm);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setBirthDate(user.getBirthDate());
        User updatedUser = userRepository.save(existingUser);
        return convertToDto(updatedUser);
    }

    public void deleteUserByCpf(String cpf) {
        User existingUser = userRepository.findByCpf(cpf);
        if (existingUser == null) {
            userRepository.delete(existingUser);
        }
    
    }
}
