CREATE TABLE posts (
id serial PRIMARY KEY,
name varchar(2000),
created timestamp
);

CREATE TABLE messages (
id serial PRIMARY KEY,
message TEXT,
posts_id int NOT NULL REFERENCES posts(id)
);

insert into posts (name) values ('О чем этот форум?');
insert into posts (name) values ('Правила форума.');