package my.standard.crud.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class SimpleCrudResource {

    private HelloService helloService;

    public SimpleCrudResource(HelloService helloService) {
        this.helloService = helloService;
    }

    @PostMapping("/hello/create")
    public ResponseEntity<HelloObject> createHelloObject(@RequestBody HelloObject helloObject) {
        HelloObject hObject = helloService.createHelloObject(helloObject);
        return ResponseEntity.ok(hObject);
    }

    @GetMapping("/hello/retrieve/{id}")
    public ResponseEntity<HelloObject> retrieveHelloObject(@PathVariable("id") int id) {
        HelloObject hObject = helloService.retrieveHelloObject(id);
        return ResponseEntity.ok(hObject);
    }
}
