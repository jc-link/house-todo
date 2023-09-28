DROP DATABASE IF EXISTS "house-todo";

CREATE DATABASE "house-todo"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE "user_group" (
    user_group_id SERIAL PRIMARY KEY,
    name VARCHAR(30),
    code VARCHAR(36)
);

CREATE TABLE "task" (
    task_id SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE "user" (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(30),
    user_group_id INT,
    FOREIGN KEY (user_group_id) REFERENCES "user_group" (user_group_id)
);


CREATE TABLE "task_schedule" (
    task_schedule_id SERIAL PRIMARY KEY,
    task_id INT,
    user_id INT,
    do_until DATE,
    completed BOOLEAN,
    FOREIGN KEY (task_id) REFERENCES "task" (task_id),
    FOREIGN KEY (user_id) REFERENCES "user" (user_id)
);
