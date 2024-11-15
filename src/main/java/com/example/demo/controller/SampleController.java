package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/sample/test")
    public String test(){
        String msg = "OK";
        return msg;
    }

    @PostMapping("/sample/welcome/{name}")
    public String welcome(@PathVariable String name){
        String msg = "Welcome Mr. " + name;
        return msg;
    }
}
