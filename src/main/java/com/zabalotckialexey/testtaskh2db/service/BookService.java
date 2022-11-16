package com.zabalotckialexey.testtaskh2db.service;

import com.zabalotckialexey.testtaskh2db.model.Book;
import com.zabalotckialexey.testtaskh2db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    public List<Book> findBookByTitle(String title) {
        return bookRepository.findByTitleContains(title);
    }

    public List<Book> findBookByAuthor(String author) {
        return bookRepository.findAllByAuthorContains(author);
    }

    public List<Book> findBookByPublisher(String publisher) {
        return bookRepository.findByPublisherContains(publisher);
    }

    public List<Book> findBookByDate(String date) {
        return bookRepository.findAllByPublicationDateContaining(date);
    }

    public Book add(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
