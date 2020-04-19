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

    public Macintosh() {
    }

    public Macintosh(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
