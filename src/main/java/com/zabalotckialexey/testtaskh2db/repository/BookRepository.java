package com.zabalotckialexey.testtaskh2db.repository;

import com.zabalotckialexey.testtaskh2db.model.Book;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitleContains(String title);

    List<Book> findAllByAuthorContains(String author);

    List<Book> findByPublisherContains(String publisher);

    @Query("Select * From BOOKS Where PUBLICATION_DATE = :publicationDate ")
    List<Book> findAllByPublicationDateContaining(String publicationDate);

    List<Book> findAll();

}
