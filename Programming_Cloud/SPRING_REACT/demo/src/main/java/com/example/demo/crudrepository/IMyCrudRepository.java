package com.example.demo.crudrepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMyCrudRepository extends CrudRepository<MyTestCrudProduct, String> {
    List<MyTestCrudProduct> findByType(String type);

    @Query("select p from MyTestCrudProduct p where p.type = ?1")
    List<MyTestCrudProduct> myCustom(String type);
}
