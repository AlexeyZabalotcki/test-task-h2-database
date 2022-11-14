package com.zabalotckialexey.testtaskh2db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "magazines")
public class Magazine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String editor;
    private String title;
    private String publisher;
    @Temporal(TemporalType.DATE)
    @Column(name = "publication_date")
    private Date publicationDate;
}
