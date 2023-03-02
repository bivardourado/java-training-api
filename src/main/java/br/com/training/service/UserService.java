package br.com.training.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    public User updateUserByCpf(String cpf, @Valid User user) {
        User existingUser = userRepository.findByCpf(cpf);
        if (existingUser == null) {
        
            return null;
        }
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setBirthDate(user.getBirthDate());
       
        return userRepository.save(existingUser);
    }

    public void deleteUserByCpf(String cpf) {
        User existingUser = userRepository.findByCpf(cpf);
        if (existingUser == null) {
      
            return;
        }
        userRepository.delete(existingUser);
    }
}
