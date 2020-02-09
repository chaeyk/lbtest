package net.chaeyk.lbtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.endsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LbtestApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void pingTest() throws Exception {
        mockMvc.perform(get("/ping"))
                .andExpect(status().isOk());
    }

    @Test
    public void setCodeTest() throws Exception {
        mockMvc.perform(post("/ping/code/500"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/ping"))
                .andExpect(status().is(500));
    }

    @Test
    public void echoTest() throws Exception {
        mockMvc.perform(get("/echo/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(endsWith("hello")));
    }
}
