CREATE TABLE IF NOT EXISTS students (
    usn VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    college_code VARCHAR(10) NOT NULL,
    branch VARCHAR(50) NOT NULL,
    semester INT NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS subjects (
    subject_code VARCHAR(20) PRIMARY KEY,
    subject_name VARCHAR(150) NOT NULL,
    semester INT NOT NULL,
    department VARCHAR(50) NOT NULL,
    credits INT NOT NULL,
    fee DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS applications (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usn VARCHAR(20) NOT NULL,
    applied_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_fee DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    FOREIGN KEY (usn) REFERENCES students(usn) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS application_subjects (
    application_id INT NOT NULL,
    subject_code VARCHAR(20) NOT NULL,
    PRIMARY KEY (application_id, subject_code),
    FOREIGN KEY (application_id) REFERENCES applications(id) ON DELETE CASCADE,
    FOREIGN KEY (subject_code) REFERENCES subjects(subject_code) ON DELETE CASCADE
);
