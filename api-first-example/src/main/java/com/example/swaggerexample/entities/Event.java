package com.example.swaggerexample.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull
    private Integer price;

    @NotNull
    @ManyToOne(targetEntity = Category.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull
    private LocalDate date;

    @NotBlank(message = "Description is required")
    private String description;

    public Event(String title, Integer price,
                 Category category, LocalDate date, String description) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    public Event() {

    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
