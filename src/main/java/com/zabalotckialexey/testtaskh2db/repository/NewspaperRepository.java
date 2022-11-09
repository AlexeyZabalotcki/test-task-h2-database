package com.zabalotckialexey.testtaskh2db.repository;

import com.zabalotckialexey.testtaskh2db.model.Newspaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewspaperRepository extends JpaRepository<Newspaper, Long> {

    @Query("SELECT n from Newspaper n where " +
            "(:title is null or :title='' or lower(n.title) like lower(concat('%',:title, '%'))) " +
            "order by n.title asc")
    List<Newspaper> findByTitle(@Param("title") String title);

    @Query("select n from Newspaper n where n.publicationDate = (concat('',:publication_date,''))")
    List<Newspaper> findByPublicationDate(@Param("publication_date") String date);
}
