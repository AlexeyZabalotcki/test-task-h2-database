package com.zabalotckialexey.testtaskh2db.repository;

import com.zabalotckialexey.testtaskh2db.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b from Book b where " +
            "(:title is null or :title='' or lower(b.title) like lower(concat('%',:title, '%'))) " +
            "order by b.title asc")
    List<Book> findByTitle(@Param("title") String title);


    @Query("select b from Book b where b.publicationDate = :date ")
    List<Book> findByPublicationDate(@Param("date") Date date);

}
