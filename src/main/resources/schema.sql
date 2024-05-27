CREATE TABLE movie (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       release_year INT NOT NULL,
                       director VARCHAR(255)  NULL,
                       country VARCHAR(255)  NULL,
                       genre VARCHAR(255) NOT NULL
);