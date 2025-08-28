DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  dept_id VARCHAR(250) NOT NULL,
  dept_name VARCHAR(250) NOT NULL,
  project VARCHAR(250) DEFAULT NULL
);

INSERT INTO employee (dept_id, dept_name, project) VALUES
  ( '100','It','ai-work'),
  ( '200','IT','ai-work'),
  ( '300','IT','ai-research'),
  ( '400','Finance','audit');
