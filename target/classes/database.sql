-- # -- Table: users
-- # CREATE TABLE users (
-- #                        id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
-- #                        username VARCHAR(255) NOT NULL,
-- #                        password VARCHAR(255) NOT NULL
-- # )
-- #     ENGINE = InnoDB;
-- #
-- # -- Table: roles
-- # CREATE TABLE roles (
-- #                        id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
-- #                        name VARCHAR(100) NOT NULL
-- # )
-- #     ENGINE = InnoDB;
-- #
-- # -- Table for mapping user and roles: user_roles
-- # CREATE TABLE user_roles (
-- #                             user_id INT NOT NULL,
-- #                             role_id INT NOT NULL,
-- #
-- #                             FOREIGN KEY (user_id) REFERENCES users(id),
-- #                             FOREIGN KEY (role_id) REFERENCES roles (id),
-- #
-- #                             UNIQUE (user_id, role_id)
-- # )
-- #     ENGINE = InnoDB;
-- #
-- # INSERT INTO users VALUES (1, 'test', 'test');
-- #
-- # INSERT INTO roles VALUES (1, 'ROLE_USER');
-- # INSERT INTO roles VALUES (2, 'ROLE_ADMIN');
-- #
-- # INSERT INTO user_roles VALUES (1, 2);
-- #
--
CREATE TABLE orders (
                          id            INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          user_id       INT NOT NULL,
                          order_date    DATETIME NOT NULL ,
                          total_price   DOUBLE   NOT NULL,
                          status enum('shipped','submitted'),
                          FOREIGN KEY (user_id) REFERENCES users(id)
)
    ENGINE = InnoDB;
#
# INSERT INTO products VALUES (1,'Milk',5,1.20);
# INSERT INTO products VALUES (2,'Water',15,0.99);


drop table orders;