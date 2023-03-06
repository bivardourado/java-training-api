package br.com.training.service;

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

    public UserResponse createUser(UserForm userForm) {
        User user = toUser(userForm);
        User savedUser = userRepository.save(user);
        UserResponse userResponse = toUserResponse(savedUser);
        return userResponse;
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        return toUserResponse(user);
    }

    public UserResponse updateUser(Long id, UserForm userForm) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        updateUserFromDTO(user, userForm);
        User updatedUser = userRepository.save(user);
        UserResponse userResponse = toUserResponse(updatedUser);
        return userResponse;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private User toUser(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setCpf(userForm.getCpf());
        user.setBirthDate(userForm.getBirthDate());
        return user;
    }

    private void updateUserFromDTO(User user, UserForm userForm) {
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
    }

    private UserResponse toUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setCpf(user.getCpf());
        userResponse.setBirthDate(user.getBirthDate());
        return userResponse;
    }
}

