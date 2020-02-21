package com.example.demo.crudrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public ResponseEntity<MyTestCrudProduct> getProductById(@RequestParam("id") Long id) {
        MyTestCrudProduct value = iMyCrudRepository.myCustomById(id);
        return ResponseEntity.ok(value);
    }

    @PutMapping("/crud/product")
    public ResponseEntity<MyTestCrudProduct> saveProduct(@RequestBody MyTestCrudProduct myTestCrudProduct) {
        MyTestCrudProduct myTestCrudProduct1 = iMyCrudRepository.save(myTestCrudProduct);
        return ResponseEntity.ok(myTestCrudProduct1);
    }

    @GetMapping("/crud/product/type")
    public ResponseEntity<List<MyTestCrudProduct>> getProductByType(@RequestParam("type") String type) {
        List<MyTestCrudProduct> value = iMyCrudRepository.myCustom(type);
        return ResponseEntity.ok(value);
    }

    @GetMapping("/crud/products")
    public CollectionModel<EntityModel<MyTestCrudProduct>> getProductById() {
        System.out.println("PRODUCTS");
        Iterable<MyTestCrudProduct> value = iMyCrudRepository.findAll();
        CollectionModel<EntityModel<MyTestCrudProduct>> resources = CollectionModel.wrap(value);
        resources.add(WebMvcLinkBuilder.linkTo(MyCrudProductController.class).slash("/crud/products").withRel("products"));
        return resources;
    }
}
