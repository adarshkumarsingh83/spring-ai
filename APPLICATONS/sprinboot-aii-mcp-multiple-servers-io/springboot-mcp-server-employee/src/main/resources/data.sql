DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  dept VARCHAR(250) NOT NULL,
  project VARCHAR(250) DEFAULT NULL
);

INSERT INTO employee (dept, project) VALUES
  ( 'It','ai-work'),
  ( 'IT','ai-work'),
  ( 'IT','ai-research'),
  ( 'Finance','audit');
