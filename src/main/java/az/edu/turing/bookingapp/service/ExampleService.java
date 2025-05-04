package az.edu.turing.bookingapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    private static final Logger logger = LoggerFactory.getLogger(ExampleService.class);

    public String sayHello(){
        logger.info("ExampleService is running...");
        return "Salam, Aynur. Fener gelen il cempion olacag!!!!!!!!!!";
    }
}
