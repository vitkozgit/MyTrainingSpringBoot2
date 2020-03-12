package my.standard.crud.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleCrudResource {

    public SimpleCrudResource() {
        System.out.println();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello!!!";
    }
}
