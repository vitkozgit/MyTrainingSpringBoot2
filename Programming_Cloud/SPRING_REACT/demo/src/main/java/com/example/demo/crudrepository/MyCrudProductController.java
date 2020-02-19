package com.example.demo.crudrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyCrudProductController {

    private IMyCrudRepository iMyCrudRepository;

    @Autowired
    public MyCrudProductController(IMyCrudRepository iMyCrudRepository) {
        this.iMyCrudRepository = iMyCrudRepository;
    }

    @GetMapping("/crud/product")
    public ResponseEntity<MyTestCrudProduct> getProductById(@RequestParam("id") String id) {
        Optional<MyTestCrudProduct> value = iMyCrudRepository.findById(id);
        return ResponseEntity.ok(value.orElse(new MyTestCrudProduct()));
    }

    @PutMapping("/crud/product")
    public ResponseEntity<MyTestCrudProduct> saveProduct(@RequestBody MyTestCrudProduct myTestCrudProduct) {
        MyTestCrudProduct myTestCrudProduct1 = iMyCrudRepository.save(myTestCrudProduct);
        return ResponseEntity.ok(myTestCrudProduct1);
    }

    @GetMapping("/crud/product/type")
    public ResponseEntity<List<MyTestCrudProduct>> getProductByType(@RequestParam("type") String type) {
        //List<MyTestCrudProduct> value = iMyCrudRepository.findByType(type);
        List<MyTestCrudProduct> value = iMyCrudRepository.myCustom(type);
        return ResponseEntity.ok(value);
    }
}
