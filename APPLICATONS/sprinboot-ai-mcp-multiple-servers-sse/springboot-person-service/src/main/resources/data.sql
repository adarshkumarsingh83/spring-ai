DROP TABLE IF EXISTS person;

CREATE TABLE person (
  person_id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL
);

INSERT INTO person( first_name, last_name) VALUES
( 'adarsh', 'kumar'),
('radha', 'singh'),
('sonu', 'singh'),
( 'amit', 'kumar');

