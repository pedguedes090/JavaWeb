package demo.hello.ex05.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public String handle(NoSuchElementException ex, Model model) {
        model.addAttribute("errorMessage",
                "Nhân viên " + ex.getMessage() + " không tồn tại trong hệ thống");
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleAll(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Có lỗi xảy ra");
        return "error";
    }
}