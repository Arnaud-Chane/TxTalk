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
  sender_id INT NOT NULL,
  chat_id INT NOT NULL,
  message TEXT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--@block:
CREATE TABLE txtalk_db.chat (
  chat_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- create a join table to join users and messages tables 
--@block:
CREATE TABLE txtalk_db.user_message (
  user_id INT NOT NULL,
  message_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(user_id),
  FOREIGN KEY (message_id) REFERENCES message(message_id)
);

-- create a join table to join chats and messages tables 
--@block:
CREATE TABLE txtalk_db.chat_message (
  chat_id INT NOT NULL,
  message_id INT NOT NULL,
  FOREIGN KEY (chat_id) REFERENCES chat(chat_id),
  FOREIGN KEY (message_id) REFERENCES message(message_id)
);

--@block:
INSERT INTO txtalk_db.user (firstname, lastname, email, password, role) VALUES
('John', 'Doe', 'john.doe@example.com', 'password1', 'admin'),
('Jane', 'Doe', 'jane.doe@example.com', 'password2', 'user'),
('Alice', 'Smith', 'alice.smith@example.com', 'password3', 'user'),
('Bob', 'Johnson', 'bob.johnson@example.com', 'password4', 'user'),
('Charlie', 'Brown', 'charlie.brown@example.com', 'password5', 'admin');

--@block:
SELECT * FROM txtalk_db.user;

--@block:
SELECT * FROM user u WHERE u.email = "john.doe@example.com";
