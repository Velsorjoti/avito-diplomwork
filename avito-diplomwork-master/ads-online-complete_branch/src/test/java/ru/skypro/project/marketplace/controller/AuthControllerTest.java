package ru.skypro.project.marketplace.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import ru.skypro.project.marketplace.dto.LoginReq;
import ru.skypro.project.marketplace.dto.RegisterReq;
import ru.skypro.project.marketplace.enums.Role;
import ru.skypro.project.marketplace.exception.ObjectNotFoundExeption;
import ru.skypro.project.marketplace.model.User;
import ru.skypro.project.marketplace.repository.UserRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private ObjectMapper objectMapper;

    private final LoginReq loginReq = new LoginReq();
    private final User user = new User();
    private final RegisterReq registerReq = new RegisterReq();


    @BeforeEach
    void setUp() {
        user.setUsername("user@mail.ru");
        user.setFirstName("User");
        user.setLastName("Test");
        user.setPhone("+79279993456");
        user.setPassword(encoder.encode("password"));
        user.setRole(Role.USER);
        user.setEnabled(true);
        userRepository.save(user);

        loginReq.setUsername("user@mail.ru");
        loginReq.setPassword("password");

        registerReq.setUsername("user1@mail.ru");
        registerReq.setFirstName("User1");
        registerReq.setLastName("Test1");
        registerReq.setPhone("+79278885634");
        registerReq.setPassword("password1");
        registerReq.setRole(Role.ADMIN);
    }

    @AfterEach
    void clearAll() {
        userRepository.delete(user);
    }

    @Test
    public void testLoginReturnsValidCredentialsWhenLoginSuccess() throws Exception {
        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginReq)))
                .andExpect(status().isOk());
    }

    @Test
    public void testRegisterReturnsValidCredentialsWhenRegisterSuccess() throws Exception {
        mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registerReq)))
                .andExpect(status().isOk());

        User savedUser = userRepository.findByUsernameIgnoreCase(registerReq.getUsername())
                .orElseThrow(ObjectNotFoundExeption::new);

        userRepository.delete(savedUser);
    }

}
