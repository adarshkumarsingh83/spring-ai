DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  dept_id INT AUTO_INCREMENT  PRIMARY KEY,
  dept_name VARCHAR(250) NOT NULL,
  project VARCHAR(250) DEFAULT NULL
);

INSERT INTO employee ( dept_name, project) VALUES
  ( 'It','ai-work'),
  ('IT','ai-work'),
  ( 'IT','ai-research'),
  ( 'Finance','audit');
