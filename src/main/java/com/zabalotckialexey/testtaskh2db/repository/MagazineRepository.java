package com.zabalotckialexey.testtaskh2db.repository;

import com.zabalotckialexey.testtaskh2db.model.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine, Long> {
    @Query("SELECT m from Magazine m where " +
            "(:title is null or :title='' or lower(m.title) like lower(concat('%',:title, '%'))) " +
            "order by m.title asc")
    List<Magazine> findByTitle(@Param("title") String title);

    @Query("SELECT m from Magazine m where " +
            "(:editor is null or :editor='' or lower(m.editor) like lower(concat('%',:editor, '%'))) " +
            "order by m.editor asc")
    List<Magazine> findByEditor(@Param("editor") String editor);

    @Query("SELECT m from Magazine m where " +
            "(:publisher is null or :publisher='' or lower(m.publisher) like lower(concat('%',:publisher, '%'))) " +
            "order by m.publisher asc")
    List<Magazine> findByPublisher(@Param("publisher") String publisher);

    @Query("select m from Magazine m where m.publicationDate = (concat('',:publication_date,''))")
    List<Magazine> findByPublicationDate(@Param("publication_date") String date);

}
