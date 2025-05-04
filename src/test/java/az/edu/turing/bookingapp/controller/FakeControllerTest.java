package az.edu.turing.bookingapp.controller;

import az.edu.turing.bookingapp.service.ExampleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FakeController.class)
public class FakeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ExampleService exampleService;

    @Test
    void testLogTestEndpoint() throws Exception {
        when(exampleService.sayHello()).thenReturn("Salam, test!");

        mockMvc.perform(get("/log-test"))
                .andExpect(status().isOk())
                .andExpect(content().string("Log yazıldı!"));
    }
}
