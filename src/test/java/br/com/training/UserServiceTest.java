package br.com.training;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.training.model.User;
import br.com.training.service.UserService;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("Bivar Dourado");
        user.setEmail("bivardourado@gmail.com");
        user.setCpf("12345678900");
        user.setBirthDate(LocalDate.of(1990, 1, 1));

        User savedUser = userService.saveUser(user);

        assertEquals("Bivar Dourado", savedUser.getName());
        assertEquals("bivardourado@gmail.com", savedUser.getEmail());
        assertEquals("12345678900", savedUser.getCpf());
        assertEquals(LocalDate.of(1990, 1, 1), savedUser.getBirthDate());
    }

   
    @Test
    public void testFindUserByCpf() {
        User user = new User();
        user.setName("Bivar Dourado");
        user.setEmail("bivardourado@gmail.com");
        user.setCpf("12345678900");
        user.setBirthDate(LocalDate.of(1990, 1, 1));

        userService.saveUser(user);

        User foundUser = userService.findUserByCpf("12345678900");

        assertEquals("Bivar Dourado", foundUser.getName());
        assertEquals("bivardourado@gmail.com", foundUser.getEmail());
        assertEquals("12345678900", foundUser.getCpf());
        assertEquals(LocalDate.of(1990, 1, 1), foundUser.getBirthDate());
    }

    @Test
    public void testUpdateUserByCpf() {
        User user = new User();
        user.setName("Bivar Dourado");
        user.setEmail("bivardourado@gmailcom");
        user.setCpf("12345678900");
        user.setBirthDate(LocalDate.of(1990, 1, 1));

        userService.saveUser(user);

        User updatedUser = new User();
        updatedUser.setName("Bivar Dourado");
        updatedUser.setEmail("bivardourado@gmail.com");
        updatedUser.setCpf("12345678900");
        updatedUser.setBirthDate(LocalDate.of(1990, 1, 1));

        User savedUser = userService.updateUserByCpf("12345678900", updatedUser);

        assertEquals("Bivar Dourado", savedUser.getName());
        assertEquals("bivardourado@gmail.com", savedUser.getEmail());
        assertEquals("12345678900", savedUser.getCpf());
        assertEquals(LocalDate.of(1990, 1, 1), savedUser.getBirthDate());
    }

    @Test
    public void testDeleteUserByCpf() {
        User user = new User();
        user.setName("Bivar Dourado");
        user.setEmail("bivardourado@gmailcom");
        user.setCpf("12345678900 ");
        user.setBirthDate(LocalDate.of(1990, 1, 1));

        userService.saveUser(user);

        userService.deleteUserByCpf("12345678900 ");

        User deletedUser = userService.findUserByCpf("12345678900 ");
        assertNull(deletedUser);
        
        
    }

}

