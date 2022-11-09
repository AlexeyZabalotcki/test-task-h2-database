package com.zabalotckialexey.testtaskh2db.service;

import com.zabalotckialexey.testtaskh2db.model.Book;
import com.zabalotckialexey.testtaskh2db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
        return bookRepository.findByTitle(title);
    }

    public List<Book> findBookByDate(String date) {
        return bookRepository.findByPublicationDate(date);
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
