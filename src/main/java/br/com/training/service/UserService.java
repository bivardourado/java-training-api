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
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUserByCpf(String cpf) {
		// TODO Auto-generated method stub
		
	}
}
