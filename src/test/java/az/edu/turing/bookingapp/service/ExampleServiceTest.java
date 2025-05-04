package az.edu.turing.bookingapp.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExampleServiceTest {


    private final ExampleService exampleService = new ExampleService();

    @Test
    public void testSayHello() {
        String message = exampleService.sayHello();
        assertNotNull(message);
        assertTrue(message.contains("Fener"));
    }
}