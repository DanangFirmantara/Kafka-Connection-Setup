package com.danangcode.hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Test Print kedua");
        return "Hello world Test";
    }
}
