package org.example.javaweb_ss1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {
    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
