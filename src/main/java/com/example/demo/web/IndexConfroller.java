package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexConfroller {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
