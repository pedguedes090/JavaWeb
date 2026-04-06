package bai5.example.it210_ss02_btth.controller;

import bai5.example.it210_ss02_btth.model.Student;
import bai5.example.it210_ss02_btth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student-card")
    public String getStudent(@RequestParam(required = false) String msv,
                             Model model) {

        if (msv == null || msv.isEmpty()) {
            return "student-card";
        }

        Student student = studentService.findByMsv(msv);

        if (student == null) {
            model.addAttribute("errorMessage",
                    "Không tìm thấy sinh viên với mã " + msv);
        } else {
            model.addAttribute("student", student);
        }

        return "student-card";
    }
}