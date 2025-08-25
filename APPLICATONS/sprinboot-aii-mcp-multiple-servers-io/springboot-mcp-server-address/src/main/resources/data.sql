DROP TABLE IF EXISTS address;

CREATE TABLE address (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  address_id VARCHAR(250) NOT NULL,
  street VARCHAR(250) NOT NULL,
  city VARCHAR(250) DEFAULT NULL
);

INSERT INTO address (address_id, street, city) VALUES
  ('100','indian street','New York'),
  ( '200', 'american street','Los Angeles'),
  ( '300', 'british street','London'),
  ( '400', 'german street','Berlin');

