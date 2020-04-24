CREATE DATABASE IF NOT EXISTS springwebappdb;

USE springwebappdb;

DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(30) NOT NULL,
    name VARCHAR(30) DEFAULT NULL,
    email VARCHAR(30) DEFAULT NULL,
    role VARCHAR(30)
);

INSERT INTO users (username, password, name, email, role) VALUES('admin', 'admin', 'admin', 'admin@gmail.com', 'Admin');
INSERT INTO users (username, password, name, email, role) VALUES('user', 'qwerty123456', 'user', 'user@mail.ru', 'User');

DROP TABLE IF EXISTS query;

CREATE TABLE query
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    user VARCHAR(20) NOT NULL,
    query VARCHAR(255) NOT NULL,
    result VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS stafflist;

CREATE TABLE stafflist
(
    name VARCHAR(30) NOT NULL,
    position VARCHAR(30) NOT NULL,
    contracfrom DATE DEFAULT NULL,
    contractto DATE DEFAULT NULL,
    email VARCHAR(30) DEFAULT NULL,
    phone VARCHAR(12) DEFAULT NULL
);

INSERT INTO stafflist (name, position, contracfrom, contractto, email, phone) VALUES
    ( 'Ivan Bunin', 'Accountant', '2019-08-17' , '2020-08-17' ,'viksvin@yandex.ru', '375642786457'),
    ( 'Ray Bradbury', 'Manager', '2018-03-14' , '2020-03-14', 'knvserg@mail.ru', '375653874562'),
    ( 'Ayn Rand', 'Lawyer', '2020-02-23' , '2020-08-23', 'whotfcares@gmail.com', '375165438762'),
    ( 'Chuck Palahniuk', 'Driver', '2014-10-18' , '2024-10-18', 'driverme@mail.ru', '375296543786'),
    ( 'George Orwell', 'IT-specialist', '2020-03-05' , '2020-09-05', 'Danstarlingg@mail.ru', '375293609792');

DROP TABLE IF EXISTS rooster;

CREATE TABLE rooster
(
    nickname VARCHAR(30),
    fname VARCHAR(20) NOT NULL,
    sname VARCHAR(20) NOT NULL,
    position VARCHAR(2) NOT NULL,
    birthday DATE DEFAULT NULL,
    weight INT DEFAULT NULL,
    height INT DEFAULT NULL,
    birthstate VARCHAR(2) DEFAULT NULL
);

INSERT INTO rooster(nickname, fname, sname, position, birthday, weight, height, birthstate) VALUES
    ('Adamlem', 'Mike', 'Adamele', 'RW', '1985-09-21', '73', '170', 'CT'),
    ('Adamler', 'Roy', 'Adamele', 'D', '1983-06-15', '80', '175', 'CT'),
    ('Lucky', 'Denzel', 'Washington', 'LW', '1990-12-25', '68', '174', 'UK'),
    ('Chin', 'Ivan', 'Eremin', 'D', '1988-03-16', '85', '185', 'RU');

