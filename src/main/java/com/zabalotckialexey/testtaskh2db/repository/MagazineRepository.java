package com.zabalotckialexey.testtaskh2db.repository;

import com.zabalotckialexey.testtaskh2db.model.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine, Long> {
    @Query("SELECT m from Magazine m where " +
            "(:title is null or :title='' or lower(m.title) like lower(concat('%',:title, '%'))) " +
            "order by m.title asc")
    List<Magazine> findByTitle(@Param("title") String title);


    @Query("select m from Magazine m where m.publicationDate = :date ")
    List<Magazine> findByPublicationDate(@Param("date") Date date);

}
