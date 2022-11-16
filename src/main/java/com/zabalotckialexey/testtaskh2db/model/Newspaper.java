package com.zabalotckialexey.testtaskh2db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NEWSPAPERS")
public class Newspaper {

    @Id
    private Long id;
    @NotEmpty(message = "Please, enter author name")
    private String author;
    @NotNull(message = "Please, enter book's title")
    private String title;
    @NotNull(message = "Please, enter publisher's name")
    private String publisher;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column("PUBLICATION_DATE")
    @NotNull(message = "Please, enter a date")
    private Date publicationDate;

}
