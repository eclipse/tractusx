package net.catenax.prs.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PrsControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(
                        "Hello World")));
    }
}