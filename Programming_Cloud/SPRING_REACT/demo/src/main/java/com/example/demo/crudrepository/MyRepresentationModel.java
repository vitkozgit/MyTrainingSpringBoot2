package com.example.demo.crudrepository;

import org.springframework.hateoas.RepresentationModel;

public class MyRepresentationModel extends RepresentationModel {
    private Long id;
    private String name;
    private String type;

    public MyRepresentationModel(MyTestCrudProduct myTestCrudProduct) {
        this.id = myTestCrudProduct.getId();
        this.name = myTestCrudProduct.getName();
        this.type = myTestCrudProduct.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
