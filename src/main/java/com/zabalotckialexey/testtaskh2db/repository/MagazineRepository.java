package com.zabalotckialexey.testtaskh2db.repository;

import com.zabalotckialexey.testtaskh2db.model.Magazine;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagazineRepository extends CrudRepository<Magazine, Long> {

    List<Magazine> findByTitleContains(String title);

    List<Magazine> findAllByEditorContains(String author);

    List<Magazine> findByPublisherContains(String publisher);

    @Query("Select * From MAGAZINES Where PUBLICATION_DATE = :publicationDate ")
    List<Magazine> findAllByPublicationDateContaining(String publicationDate);

    List<Magazine> findAll();
}
