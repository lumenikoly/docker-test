package com.example.springapp;

import com.example.applib.QuoteGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    QuoteGenerator quoteGenerator;

    @GetMapping()
    public String getQuote() {
        return quoteGenerator.getQuote();
    }
}
