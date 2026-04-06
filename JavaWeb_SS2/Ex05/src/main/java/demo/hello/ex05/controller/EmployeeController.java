package demo.hello.ex05.controller;

import demo.hello.ex05.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired private EmployeeService service;

    private boolean notLogged(HttpSession s) {
        return s.getAttribute("loggedUser") == null;
    }

    @GetMapping("/employees")
    public String list(HttpSession session, Model model) {
        if (notLogged(session)) return "redirect:/login";

        model.addAttribute("employees", service.findAll());
        model.addAttribute("techTotal", service.totalSalaryByDept("Kỹ thuật"));
        return "employees";
    }

    @GetMapping("/employees/{code}")
    public String detail(@PathVariable String code, HttpSession session, Model model) {
        if (notLogged(session)) return "redirect:/login";

        model.addAttribute("emp", service.findByCode(code));
        return "employee-detail";
    }
}