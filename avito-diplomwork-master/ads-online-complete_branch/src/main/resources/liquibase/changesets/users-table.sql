-- liquibase formatted sql

-- changeset V:2
CREATE TABLE IF NOT EXISTS users (
    id              SERIAL PRIMARY KEY,
    username        VARCHAR(255) UNIQUE NOT NULL,
    first_name      VARCHAR(255) NOT NULL,
    last_name       VARCHAR(255) NOT NULL,
    phone           VARCHAR(255) NOT NULL,
    password        VARCHAR(255) NOT NULL,
    enabled         BOOLEAN,
    role            VARCHAR(10),
    image_id       INTEGER REFERENCES image(id)
);
