package com.example.swaggerexample.repository;

import com.example.swaggerexample.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Integer deleteById(Long id);
    Optional<Category> findById(Long id);
}
