package com.zabalotckialexey.testtaskh2db.repository;

import com.zabalotckialexey.testtaskh2db.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b from Book b where " +
            "(:title is null or :title='' or lower(b.title) like lower(concat('%',:title, '%'))) " +
            "order by b.title asc")
    List<Book> findByTitle(@Param("title") String title);

    @Query("SELECT b from Book b where " +
            "(:author is null or :author='' or lower(b.author) like lower(concat('%',:author, '%'))) " +
            "order by b.author asc")
    List<Book> findByAuthor(@Param("author") String author);

    @Query("SELECT b from Book b where " +
            "(:publisher is null or :publisher='' or lower(b.publisher) like lower(concat('%',:publisher, '%'))) " +
            "order by b.publisher asc")
    List<Book> findByPublisher(@Param("publisher") String publisher);

    @Query("select b from Book b where b.publicationDate = (concat('',:publication_date,''))")
    List<Book> findByPublicationDate(@Param("publication_date") String publicationDate);

}
