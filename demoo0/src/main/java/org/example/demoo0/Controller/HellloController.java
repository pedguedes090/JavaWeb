package org.example.demoo0.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/","/hello"})
public class HellloController {
    @GetMapping
    public String hello(Model model) {
        model.addAttribute("name", "Hello, Spring MVC!");
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        model.addAttribute("list", list);

        return "hello";
    }
}
