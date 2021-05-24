package com.sb.ifmodemo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class MainEndpoint {

    @Autowired
    private IfmoUserRepository ifmoUserRepository;

    @GetMapping
    public String test() {
        StringBuilder sb = new StringBuilder();
        ifmoUserRepository.findAll().forEach(p -> sb.append(p.getName()+", "));
        return sb.toString();
    }

    @PostMapping
    public IfmoUser createUser(@RequestBody IfmoUser user){
        return ifmoUserRepository.save(user);
    }

}
