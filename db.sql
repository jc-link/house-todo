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

CREATE TABLE "app_user" (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(30),
    user_group_id INT
);

CREATE TABLE "user_group" (
    user_group_id SERIAL PRIMARY KEY,
    name VARCHAR(30),
    code VARCHAR(36),
    admin_id INT,
    FOREIGN KEY (admin_id) REFERENCES "app_user" (user_id)
);

ALTER TABLE "app_user"
    ADD CONSTRAINT fk_user_group
    FOREIGN KEY (user_group_id) REFERENCES "user_group" (user_group_id);

CREATE TABLE "task" (
    task_id SERIAL PRIMARY KEY,
    name VARCHAR(30),
    user_group_id INT,
    FOREIGN KEY (user_group_id) REFERENCES "user_group" (user_group_id)
);

CREATE TABLE "task_schedule" (
    task_schedule_id SERIAL PRIMARY KEY,
    task_id INT,
    created_by INT,
    took_by INT,
    completed BOOLEAN,
    creation_date DATE,
    completed_date DATE,
    FOREIGN KEY (task_id) REFERENCES "task" (task_id),
    FOREIGN KEY (created_by) REFERENCES "app_user" (user_id),
    FOREIGN KEY (took_by) REFERENCES "app_user" (user_id)
);
