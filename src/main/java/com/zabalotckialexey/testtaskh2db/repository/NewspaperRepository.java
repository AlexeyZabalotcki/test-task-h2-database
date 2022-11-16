package com.zabalotckialexey.testtaskh2db.repository;

import com.zabalotckialexey.testtaskh2db.model.Newspaper;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewspaperRepository extends CrudRepository<Newspaper, Long> {

    List<Newspaper> findByTitleContains(String title);

    List<Newspaper> findAllByAuthorContains(String author);

    List<Newspaper> findByPublisherContains(String publisher);

    @Query("Select * From NEWSPAPERS Where PUBLICATION_DATE = :publicationDate ")
    List<Newspaper> findAllByPublicationDateContaining(String publicationDate);

    List<Newspaper> findAll();
}
