package az.edu.turing.bookingapp.config;

import az.edu.turing.bookingapp.service.ExampleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakeConfig {
    @Bean
    public CommandLineRunner fakeData(ExampleService exampleService) {
        return args ->
                exampleService.sayHello();

    }
}
