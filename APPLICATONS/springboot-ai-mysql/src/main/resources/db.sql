
-- Table: Student
DROP TABLE IF EXISTS Student;
CREATE TABLE Student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


-- Table: Course
DROP TABLE IF EXISTS Course;
CREATE TABLE Course (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table: StudentCourse (Mapping table for many-to-many relationship)
DROP TABLE IF EXISTS StudentCourse;
CREATE TABLE StudentCourse (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES Student(id),
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES Course(id)
);
CREATE INDEX idx_student_id ON StudentCourse(student_id);
CREATE INDEX idx_course_id ON StudentCourse(course_id);

-- Insert Students
INSERT INTO Student (name) VALUES ('Adarsh'), ('Radha'), ('Shakti'),('amit'),('monu');

-- Insert Courses
INSERT INTO Course (name) VALUES ('Java'), ('Oracle'), ('React JS'),('Spring AI'),('Cloud');

-- Map Students to Courses
INSERT INTO StudentCourse (student_id, course_id) VALUES
(1, 4),
(2, 5),
(3, 5),
(4, 4),
(5, 5);
