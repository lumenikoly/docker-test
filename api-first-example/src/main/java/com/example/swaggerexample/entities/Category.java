package com.example.swaggerexample.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Collections;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category title is required")
    private String title;

    @OneToMany(mappedBy = "category")
    private Collection<Event> events;

    public Category(String title) {
        this.title = title;
    }

    public Category() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
