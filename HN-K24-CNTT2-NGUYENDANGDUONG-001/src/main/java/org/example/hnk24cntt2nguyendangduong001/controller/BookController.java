package org.example.hnk24cntt2nguyendangduong001.controller;

import org.example.hnk24cntt2nguyendangduong001.model.Book;
import org.example.hnk24cntt2nguyendangduong001.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping({"/","/books"})
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String listBook(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("search", "");
        return "list-book";
    }

    @GetMapping("/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "add-book";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-book";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return "redirect:/books";
        }
        model.addAttribute("book", book);
        return "update-book";
    }

    @PostMapping("/edit")
    public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update-book";
        }
        bookService.updateBook(book);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String removeBook(@PathVariable("id") Long id) {
        bookService.removeBookById(id);
        return "redirect:/books";
    }
    @PostMapping("/search")
    public String searchBook(@RequestParam(name = "search", defaultValue = "") String search, Model model){
        model.addAttribute("books", bookService.getBooksByAuthorortitle(search));
        model.addAttribute("search", search);
        return "list-book";
    }
}
