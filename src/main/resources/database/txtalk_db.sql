--@block: drop-database
DROP DATABASE IF EXISTS txtalk_db;
--@block: create-database
CREATE DATABASE txtalk_db;
USE txtalk_db;
--@block: create-table
CREATE TABLE txtalk_db.user (
  user_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nickname VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(255) NOT NULL
);
CREATE TABLE txtalk_db.chat (
  chat_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  chat_name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
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
INSERT INTO txtalk_db.user (nickname, email, password, role)
VALUES ('test1', 'test1@example.com', 'pw', 'admin'),
  ('test2', 'test2@example.com', 'pw', 'user'),
  ('test3', 'test3@example.com', 'pw', 'user'),
  ('test4', 'test4@example.com', 'pw', 'user'),
  ('test5', 'test5@example.com', 'pw', 'user');
INSERT INTO txtalk_db.chat (chat_name)
VALUES ('Chat1'),
  ('Chat2'),
  ('Chat3');
INSERT INTO txtalk_db.message (message_content, user_id, chat_id)
VALUES ('Hello, this is test1', 1, 1),
  ('Hello, this is test2', 2, 1),
  ('Hello, this is test3', 3, 1),
  ('How are you, test2 and test3?', 1, 1),
  ('I am fine, thank you, test1!', 2, 1),
  ('Hello, this is test4', 4, 2),
  ('Hello, this is test5', 5, 2),
  ('How are you, test4 and test5?', 1, 2),
  ('I am fine, thank you, test1!', 4, 2),
  ('Hello, this is test1', 1, 3),
  ('Hello, this is test2', 2, 3),
  ('Hello, this is test3', 3, 3),
  ('How are you, test2 and test3?', 1, 3),
  ('I am fine, thank you, test1!', 2, 3),
  ('Hello, this is test4', 4, 3),
  ('Hello, this is test5', 5, 3),
  ('How are you, test4 and test5?', 1, 3),
  ('I am fine, thank you, test1!', 4, 3),
  ('Hello, this is test1 again in chat1', 1, 1),
  ('Hello, this is test2 again in chat1', 2, 1);
-- 
-- 
-- 
-- 
-- 
-- 
-- TESTING SOME QUERIES
-- 
-- 
-- 
--@block:
SELECT *
FROM txtalk_db.user;

--@block:
SELECT *
FROM txtalk_db.chat;
--@block:
SELECT *
FROM user u
WHERE u.email = "test1@example.com";
--@block:
SELECT nickname
FROM user u
WHERE u.email = "test1@example.com";
--@block:
SELECT m.message_id,
  m.message_content,
  m.created_at,
  c.chat_name,
  u.nickname
FROM txtalk_db.message m
  JOIN txtalk_db.user u ON m.user_id = u.user_id
  JOIN txtalk_db.chat c ON m.chat_id = c.chat_id
WHERE u.nickname = 'test1';
--@block:
SELECT m.message_id,
  m.message_content,
  m.created_at,
  u.nickname
FROM txtalk_db.message m
  JOIN txtalk_db.user u ON m.user_id = u.user_id
  JOIN txtalk_db.chat c ON m.chat_id = c.chat_id
WHERE c.chat_name = 'chat1';

--@block:
SELECT DISTINCT u.nickname
FROM txtalk_db.user u
JOIN txtalk_db.message m ON u.user_id = m.user_id
JOIN txtalk_db.chat c ON m.chat_id = c.chat_id
WHERE c.chat_name = 'chat2';