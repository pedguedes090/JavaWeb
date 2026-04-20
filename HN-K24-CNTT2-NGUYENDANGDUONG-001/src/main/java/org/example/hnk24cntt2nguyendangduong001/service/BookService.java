package org.example.hnk24cntt2nguyendangduong001.service;

import org.example.hnk24cntt2nguyendangduong001.model.Book;
import org.example.hnk24cntt2nguyendangduong001.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }
    public Book getBookById(Long id){
        return bookRepository.getBookById(id);
    }
    public void addBook(Book book){
        bookRepository.addBook(book);
    }
    public void updateBook(Book book){
        bookRepository.updateBook(book);
    }
    public void removeBook(Book book){
        bookRepository.removeBook(book);
    }
    public void removeBookById(Long id){
        bookRepository.removeBookById(id);
    }
    public List<Book> getBooksByAuthorortitle(String str){
        return bookRepository.getBooksByAuthorortitle(str);
    }

}
