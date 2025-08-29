DROP TABLE IF EXISTS address;

CREATE TABLE address (
  address_id INT AUTO_INCREMENT  PRIMARY KEY,
  street VARCHAR(250) NOT NULL,
  city VARCHAR(250) DEFAULT NULL
);

INSERT INTO address ( street, city) VALUES
  ('indian street','New York'),
  (  'american street','Los Angeles'),
  (  'british street','London'),
  (  'german street','Berlin');

