package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private ServerProperties serverProperties;

    @GetMapping
    public String logs() {
        int serverPort = serverProperties.getPort();
        return "I'm working! Port: " + serverPort;
    }
}
