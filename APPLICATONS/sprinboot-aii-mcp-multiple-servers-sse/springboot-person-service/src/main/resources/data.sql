DROP TABLE IF EXISTS person;

CREATE TABLE person (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  person_id VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL
);

INSERT INTO person(person_id, first_name, last_name) VALUES
('100', 'adarsh', 'kumar'),
('200','radha', 'singh'),
('300', 'sonu', 'singh'),
('400', 'amit', 'kumar');

