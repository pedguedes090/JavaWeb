package org.example.hnk24cntt2nguyendangduong001.repository;

import org.example.hnk24cntt2nguyendangduong001.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private List<Book> books = new ArrayList<>();

    public BookRepository(){
        books.add(new Book(1L, "Java 8 in Action", "hoang", 100, "anh.png" ));
        books.add(new Book(2L, "Spring Boot 2 in Action", "van", 100, "anh.png"));
        books.add(new Book(3L, "Spring MVC 5 in Action", "nguyen", 100, "anh.png"));
        books.add(new Book(4L, "Hibernate 5 in Action", "duc", 100, "anh.png"));
    }


    public List<Book> getAllBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void updateBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(book.getId())) {
                books.set(i, book);
                return;
            }
        }
    }
    public void removeBook(Book book) {
        books.remove(book);
    }
    public Book getBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }
    public void removeBookById(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
    public List<Book> getBooksByAuthorortitle(String str) {
        String keyword = str == null ? "" : str.trim().toLowerCase();
        if (keyword.isEmpty()) {
            return getAllBooks();
        }
        return books.stream()
                .filter(book -> (book.getAuthor() != null && book.getAuthor().toLowerCase().contains(keyword))
                        || (book.getTitle() != null && book.getTitle().toLowerCase().contains(keyword)))
                .toList();
    }

}

