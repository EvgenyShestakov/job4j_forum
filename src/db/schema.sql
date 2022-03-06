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
