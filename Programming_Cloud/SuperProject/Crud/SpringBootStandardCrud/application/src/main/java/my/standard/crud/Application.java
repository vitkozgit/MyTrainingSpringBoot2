package my.standard.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "my.standard.crud")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}