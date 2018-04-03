drop database if exists adlister_db;
create database adlister_db;
use adlister_db;
create user 'adlister_user'@'localhost' identified by 'P@55w0rd';
grant all privileges on adlister_db.* to 'adlister_user'@'localhost';
CREATE TABLE users
(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  CONSTRAINT users_ads FOREIGN KEY (user_id) REFERENCES ads (id)
);
CREATE TABLE ads
(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  user_id int NOT NULL,
  title varchar(255) NOT NULL,
  description varchar(255) NOT NULL,
  CONSTRAINT users_ads FOREIGN KEY (id) REFERENCES users (user_id)
)