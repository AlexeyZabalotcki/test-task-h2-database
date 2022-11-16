DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS
(
    id               bigint auto_increment,
    author           varchar(30),
    title            varchar(30),
    publisher        varchar(30),
    publication_date date,
    primary key (id)
);

DROP TABLE IF EXISTS MAGAZINES;
CREATE TABLE MAGAZINES
(
    id               bigint auto_increment,
    editor           varchar(30),
    title            varchar(30),
    publisher        varchar(30),
    publication_date date,
    primary key (id)
);

DROP TABLE IF EXISTS NEWSPAPERS;
CREATE TABLE NEWSPAPERS
(
    id               bigint auto_increment,
    author           varchar(30),
    title            varchar(30),
    publisher        varchar(30),
    publication_date date,
    primary key (id)
);