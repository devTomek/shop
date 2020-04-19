package com.tomek.shop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Macintosh {
    @Id
    @GeneratedValue
    @NotNull
    Long id;

    @NotNull
    String name;

    @NotNull
    String processor;

    @NotNull
    Integer ram;

    @NotNull
    Integer storage;

    @NotNull
    Float price;

    public Macintosh() {
    }

    public Macintosh(String name, String processor, Integer ram, Integer storage, Float price) {
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProcessor() {
        return processor;
    }

    public Integer getRam() {
        return ram;
    }

    public Integer getStorage() {
        return storage;
    }

    public Float getPrice() {
        return price;
    }
}
