drop table if exists users;
CREATE TABLE users (
                       id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       balance int
);

