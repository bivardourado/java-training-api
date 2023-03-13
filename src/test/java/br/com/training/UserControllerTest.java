package br.com.training;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import br.com.training.model.User;
import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSaveUser() throws Exception {
        User user = new User();
        user.setName("Bivar Dourado");
        user.setEmail("bivardourado@gmailcom");
        user.setCpf("12345678900");
        user.setBirthDate(LocalDate.of(1990, 1, 1));

        mockMvc.perform(MockMvcRequestBuilders
            .post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Bivar Dourado"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("bivardourado@gmailcom"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value("12345678900"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.birthDate").value("1990-01-01"));
    }

    @Test
    public void testFindUserByCpf() throws Exception {
        User user = new User();
        user.setName("Bivar Dourado");
        user.setEmail("bivardourado@gmailcom");
        user.setCpf("12345678900");
        user.setBirthDate(LocalDate.of(1990, 1, 1));

        mockMvc.perform(MockMvcRequestBuilders
            .post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)));

        mockMvc.perform(MockMvcRequestBuilders
            .get("/users/12345678900"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Bivar Dourado"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("bivardourado@gmailcom"))
            		 .andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value("12345678900"))
            		 .andExpect(MockMvcResultMatchers.jsonPath("$.birthDate").value("1990-01-01"));
            		 }
    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setName("Bivar Dourado");
        user.setEmail("bivardourado@gmailcom");
        user.setCpf("12345678900");
        user.setBirthDate(LocalDate.of(1990, 1, 1));

        mockMvc.perform(MockMvcRequestBuilders
            .post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)));

        user.setName("Bivar Dourado Silva");

        mockMvc.perform(MockMvcRequestBuilders
            .put("/users/12345678900")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Bivar Dourado Silva"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("bivardourado@gmailcom"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value("12345678900"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.birthDate").value("1990-01-01"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        User user = new User();
        user.setName("Bivar Dourado");
        user.setEmail("bivardourado@gmailcom");
        user.setCpf("12345678900");
        user.setBirthDate(LocalDate.of(1990, 1, 1));

        mockMvc.perform(MockMvcRequestBuilders
            .post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)));

        mockMvc.perform(MockMvcRequestBuilders
            .delete("/users/12345678900"))
            .andExpect(MockMvcResultMatchers.status().isNoContent());

        //mockMvc.perform(MockMvcRequestBuilders
         //   .get("/users/12345678900"))
         //   .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

};