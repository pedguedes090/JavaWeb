package demo.hello.ex05.controller;

import jakarta.servlet.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() { return "login"; }

    @PostMapping("/login")
    public String login(String username, String password,
                        HttpSession session, HttpServletRequest request) {

        if ("hr_manager".equals(username) && "hr123".equals(password)) {
            session.setAttribute("loggedUser", username);
            session.setAttribute("role", "hr_manager");
            return "redirect:/employees";
        }
        if ("hr_staff".equals(username) && "staff456".equals(password)) {
            session.setAttribute("loggedUser", username);
            session.setAttribute("role", "hr_staff");
            return "redirect:/employees";
        }

        request.setAttribute("errorMessage", "Sai tài khoản hoặc mật khẩu");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @ControllerAdvice
    public static class GlobalExceptionHandler {

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
}