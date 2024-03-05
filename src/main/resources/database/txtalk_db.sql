--@block: create-database
DROP DATABASE IF EXISTS txtalk_db;
--@block: create-database
CREATE DATABASE txtalk_db;
USE txtalk_db;
--@block: create-table
CREATE TABLE txtalk_db.user (
  user_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(255) NOT NULL,
  lastname VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(255) NOT NULL
);
--@block:
CREATE TABLE txtalk_db.message (
  message_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  message_content TEXT NOT NULL,
  user_id INT NOT NULL,
  chat_id INT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES txtalk_db.user(user_id),
  FOREIGN KEY (chat_id) REFERENCES txtalk_db.chat(chat_id)
);
--@block:
CREATE TABLE txtalk_db.chat (
  chat_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  chat_name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
--@block:
INSERT INTO txtalk_db.user (firstname, lastname, email, password, role)
VALUES
('test1', 'NameAdmin', 'test1@example.com', 'pw', 'admin'),
('test2', 'NameUser', 'test2@example.com', 'pw', 'user'),
('test3', 'NameUser', 'test3@example.com', 'pw', 'user'),
('test4', 'NameUser', 'test4@example.com', 'pw', 'user'),
('test5', 'NameUser', 'test5@example.com', 'pw', 'user');

--@block:
SELECT *
FROM txtalk_db.user;
--@block:
SELECT *
FROM user u
WHERE u.email = "test1@example.com";