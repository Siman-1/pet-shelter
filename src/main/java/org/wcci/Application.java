package org.wcci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class Application {
    public static void main(String[] args) {
        // First going to see if all requirements can be satisfied
        // Then it's going to create all components
        // Let them run
        SpringApplication.run(Application.class, args);
    } 
}
