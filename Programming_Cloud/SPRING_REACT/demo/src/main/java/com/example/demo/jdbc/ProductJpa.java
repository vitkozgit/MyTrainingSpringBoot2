package com.example.demo.jdbc;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MY_TEST_JPA")
public class ProductJpa implements Serializable {

    @Id
    @GeneratedValue
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    public ProductJpa() {
        super();
    }

    public ProductJpa(String id, String name, String type) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
