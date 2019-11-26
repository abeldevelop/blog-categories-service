CREATE SCHEMA IF NOT EXISTS blog_db;

CREATE TABLE blog_db.categories (
  code varchar(25) NOT NULL,
  name varchar(25) NOT NULL,
  state varchar(25) NOT NULL,
  PRIMARY KEY (code),
  UNIQUE KEY `BLOG_DB_CATEGORIES_UNIQUE_NAME` (`name`)
);