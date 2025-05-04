package az.edu.turing.bookingapp.controller;

import az.edu.turing.bookingapp.service.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FakeController {
    private final ExampleService exampleService;

    public FakeController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/log-test")
    public String logTest() {
        exampleService.sayHello();
        return "Log yazıldı!";
    }
}
