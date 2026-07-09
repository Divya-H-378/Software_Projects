-- =========================================================================
-- SUBJECT SEED DATA FOR ALL SEMESTERS (3-8) AND DEPARTMENTS (NO FEES)
-- =========================================================================

-- -------------------------------------------------------------------------
-- DEPARTMENT: Computer Science
-- -------------------------------------------------------------------------
-- Semester 3
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21CS31', 'Transform Calculus & Fourier Series', 3, 'Computer Science', 4, 0.00),
('21CS32', 'Data Structures and Applications', 3, 'Computer Science', 4, 0.00),
('21CS33', 'Analog and Digital Electronics', 3, 'Computer Science', 3, 0.00),
('21CS34', 'Computer Organization & Architecture', 3, 'Computer Science', 3, 0.00);

-- Semester 4
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21CS41', 'Mathematical Foundations for Computing', 4, 'Computer Science', 4, 0.00),
('21CS42', 'Operating Systems Principles', 4, 'Computer Science', 4, 0.00),
('21CS43', 'Design and Analysis of Algorithms', 4, 'Computer Science', 3, 0.00),
('21CS44', 'Microcontrollers & Embedded Systems', 4, 'Computer Science', 3, 0.00);

-- Semester 5
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21CS51', 'Database Management System', 5, 'Computer Science', 4, 0.00),
('21CS52', 'Automata Theory and Computability', 5, 'Computer Science', 4, 0.00),
('21CS53', 'Computer Networks & Security', 5, 'Computer Science', 3, 0.00),
('21CS54', 'Elective: Advanced Java Programming', 5, 'Computer Science', 3, 0.00);

-- Semester 6
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21CS61', 'Software Engineering & Testing', 6, 'Computer Science', 4, 0.00),
('21CS62', 'Full Stack Development', 6, 'Computer Science', 4, 0.00),
('21CS63', 'Machine Learning & Applications', 6, 'Computer Science', 3, 0.00),
('21CS64', 'Elective: Cloud Computing', 6, 'Computer Science', 3, 0.00);

-- Semester 7
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21CS71', 'Big Data Analytics', 7, 'Computer Science', 4, 0.00),
('21CS72', 'Cryptography & Network Security', 7, 'Computer Science', 4, 0.00),
('21CS73', 'Elective: Block Chain Technology', 7, 'Computer Science', 3, 0.00);

-- Semester 8
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21CS81', 'Project Work Phase-II', 8, 'Computer Science', 10, 0.00),
('21CS82', 'Technical Seminar', 8, 'Computer Science', 2, 0.00),
('21CS83', 'Elective: Storage Area Networks', 8, 'Computer Science', 3, 0.00);


-- -------------------------------------------------------------------------
-- DEPARTMENT: Electronics & Communication
-- -------------------------------------------------------------------------
-- Semester 3
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21EC31', 'Network Analysis', 3, 'Electronics & Communication', 4, 0.00),
('21EC32', 'Electronic Devices & Circuits', 3, 'Electronics & Communication', 4, 0.00),
('21EC33', 'Digital System Design', 3, 'Electronics & Communication', 3, 0.00);

-- Semester 4
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21EC41', 'Signals and Systems', 4, 'Electronics & Communication', 4, 0.00),
('21EC42', 'Linear Integrated Circuits', 4, 'Electronics & Communication', 4, 0.00),
('21EC43', 'Control Systems', 4, 'Electronics & Communication', 3, 0.00);

-- Semester 5
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21EC51', 'Digital Signal Processing', 5, 'Electronics & Communication', 4, 0.00),
('21EC52', 'Information Theory & Coding', 5, 'Electronics & Communication', 4, 0.00),
('21EC53', 'Elective: Digital System Design using Verilog', 5, 'Electronics & Communication', 3, 0.00);

-- Semester 6
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21EC61', 'Digital Communication Systems', 6, 'Electronics & Communication', 4, 0.00),
('21EC62', 'Embedded Systems & RTOS', 6, 'Electronics & Communication', 4, 0.00),
('21EC63', 'VLSI Design & Technology', 6, 'Electronics & Communication', 3, 0.00),
('21EC64', 'Elective: Internet of Things Systems', 6, 'Electronics & Communication', 3, 0.00);

-- Semester 7
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21EC71', 'Microwave and Antennas', 7, 'Electronics & Communication', 4, 0.00),
('21EC72', 'Optical Fiber Communication', 7, 'Electronics & Communication', 4, 0.00),
('21EC73', 'Elective: Satellite Communication', 7, 'Electronics & Communication', 3, 0.00);

-- Semester 8
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21EC81', 'Project Work Phase-II', 8, 'Electronics & Communication', 10, 0.00),
('21EC82', 'Technical Seminar', 8, 'Electronics & Communication', 2, 0.00);


-- -------------------------------------------------------------------------
-- DEPARTMENT: Information Science
-- -------------------------------------------------------------------------
-- Semester 3
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21IS31', 'Data Structures and Applications', 3, 'Information Science', 4, 0.00),
('21IS32', 'Computer Organization & Design', 3, 'Information Science', 4, 0.00),
('21IS33', 'Discrete Mathematical Structures', 3, 'Information Science', 3, 0.00);

-- Semester 4
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21IS41', 'Operating Systems Principles', 4, 'Information Science', 4, 0.00),
('21IS42', 'Design and Analysis of Algorithms', 4, 'Information Science', 4, 0.00),
('21IS43', 'Object Oriented Concepts', 4, 'Information Science', 3, 0.00);

-- Semester 5
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21IS51', 'Database Management System', 5, 'Information Science', 4, 0.00),
('21IS52', 'Computer Networks & Security', 5, 'Information Science', 4, 0.00),
('21IS53', 'Elective: Advanced Web Technologies', 5, 'Information Science', 3, 0.00);

-- Semester 6
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21IS61', 'Software Engineering & Testing', 6, 'Information Science', 4, 0.00),
('21IS62', 'Web Technology & Applications', 6, 'Information Science', 4, 0.00),
('21IS63', 'Big Data Analytics', 6, 'Information Science', 3, 0.00),
('21IS64', 'Elective: Mobile Application Development', 6, 'Information Science', 3, 0.00);

-- Semester 7
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21IS71', 'Data Mining & Data Warehousing', 7, 'Information Science', 4, 0.00),
('21IS72', 'Cloud Computing Architecture', 7, 'Information Science', 4, 0.00),
('21IS73', 'Elective: Machine Learning Algorithms', 7, 'Information Science', 3, 0.00);

-- Semester 8
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21IS81', 'Project Work Phase-II', 8, 'Information Science', 10, 0.00),
('21IS82', 'Technical Seminar', 8, 'Information Science', 2, 0.00);


-- -------------------------------------------------------------------------
-- DEPARTMENT: Electrical and Electronics
-- -------------------------------------------------------------------------
-- Semester 3
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21EE31', 'Electric Circuit Analysis', 3, 'Electrical and Electronics', 4, 0.00),
('21EE32', 'Analog Electronic Circuits', 3, 'Electrical and Electronics', 4, 0.00),
('21EE33', 'Electrical Machines-I', 3, 'Electrical and Electronics', 3, 0.00);

-- Semester 4
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21EE41', 'Electromagnetic Field Theory', 4, 'Electrical and Electronics', 4, 0.00),
('21EE42', 'Electrical Machines-II', 4, 'Electrical and Electronics', 4, 0.00),
('21EE43', 'Power System Transmission', 4, 'Electrical and Electronics', 3, 0.00);

-- Semester 5
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21EE51', 'Power Electronics', 5, 'Electrical and Electronics', 4, 0.00),
('21EE52', 'Control Systems Engineering', 5, 'Electrical and Electronics', 4, 0.00),
('21EE53', 'Elective: Solar Energy Systems', 5, 'Electrical and Electronics', 3, 0.00);

-- Semester 6
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21EE61', 'Power System Analysis-I', 6, 'Electrical and Electronics', 4, 0.00),
('21EE62', 'Electrical Machine Design', 6, 'Electrical and Electronics', 4, 0.00),
('21EE63', 'High Voltage Engineering', 6, 'Electrical and Electronics', 3, 0.00),
('21EE64', 'Elective: Renewable Energy Sources', 6, 'Electrical and Electronics', 3, 0.00);

-- Semester 7
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21EE71', 'Power System Protection', 7, 'Electrical and Electronics', 4, 0.00),
('21EE72', 'Power System Analysis-II', 7, 'Electrical and Electronics', 4, 0.00),
('21EE73', 'Elective: Industrial Drives & Control', 7, 'Electrical and Electronics', 3, 0.00);

-- Semester 8
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21EE81', 'Project Work Phase-II', 8, 'Electrical and Electronics', 10, 0.00),
('21EE82', 'Technical Seminar', 8, 'Electrical and Electronics', 2, 0.00);


-- -------------------------------------------------------------------------
-- DEPARTMENT: BioTechnology
-- -------------------------------------------------------------------------
-- Semester 3
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21BT31', 'Biochemistry & Biophysics', 3, 'BioTechnology', 4, 0.00),
('21BT32', 'Microbiology & Cell Biology', 3, 'BioTechnology', 4, 0.00),
('21BT33', 'Process Calculations', 3, 'BioTechnology', 3, 0.00);

-- Semester 4
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21BT41', 'Biostatics & Biomathematics', 4, 'BioTechnology', 4, 0.00),
('21BT42', 'Molecular Biology & Genetics', 4, 'BioTechnology', 4, 0.00),
('21BT43', 'Bioprocess Thermodynamics', 4, 'BioTechnology', 3, 0.00);

-- Semester 5
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21BT51', 'Bioprocess Engineering', 5, 'BioTechnology', 4, 0.00),
('21BT52', 'Genetic Engineering', 5, 'BioTechnology', 4, 0.00),
('21BT53', 'Elective: Bioinformatics & Computational Biology', 5, 'BioTechnology', 3, 0.00);

-- Semester 6
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21BT61', 'Bioreactor Design & Control', 6, 'BioTechnology', 4, 0.00),
('21BT62', 'Plant and Animal Biotechnology', 6, 'BioTechnology', 4, 0.00),
('21BT63', 'Enzyme Technology & Industrial Biotech', 6, 'BioTechnology', 3, 0.00),
('21BT64', 'Elective: Food Biotechnology', 6, 'BioTechnology', 3, 0.00);

-- Semester 7
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21BT71', 'Downstream Process Technology', 7, 'BioTechnology', 4, 0.00),
('21BT72', 'Biotechnology Regulations & Safety', 7, 'BioTechnology', 4, 0.00),
('21BT73', 'Elective: Nanobiotechnology', 7, 'BioTechnology', 3, 0.00);

-- Semester 8
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21BT81', 'Project Work Phase-II', 8, 'BioTechnology', 10, 0.00),
('21BT82', 'Technical Seminar', 8, 'BioTechnology', 2, 0.00);


-- -------------------------------------------------------------------------
-- DEPARTMENT: AI And Data Science
-- -------------------------------------------------------------------------
-- Semester 3
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21AD31', 'Mathematical Foundations for Data Science', 3, 'AI And Data Science', 4, 0.00),
('21AD32', 'Data Structures & OOPs using Java', 3, 'AI And Data Science', 4, 0.00),
('21AD33', 'Digital Design & Computer Architecture', 3, 'AI And Data Science', 3, 0.00);

-- Semester 4
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21AD41', 'Design & Analysis of Algorithms', 4, 'AI And Data Science', 4, 0.00),
('21AD42', 'Database Management Systems', 4, 'AI And Data Science', 4, 0.00),
('21AD43', 'Operating Systems Principles', 4, 'AI And Data Science', 3, 0.00);

-- Semester 5
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21AD51', 'Introduction to Artificial Intelligence', 5, 'AI And Data Science', 4, 0.00),
('21AD52', 'Data Warehousing & Data Mining', 5, 'AI And Data Science', 4, 0.00),
('21AD53', 'Elective: Statistical Methods in AI', 5, 'AI And Data Science', 3, 0.00);

-- Semester 6
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21AD61', 'Machine Learning Algorithms & Models', 6, 'AI And Data Science', 4, 0.00),
('21AD62', 'Deep Learning Architectures', 6, 'AI And Data Science', 4, 0.00),
('21AD63', 'Big Data Technologies', 6, 'AI And Data Science', 3, 0.00),
('21AD64', 'Elective: Natural Language Processing', 6, 'AI And Data Science', 3, 0.00);

-- Semester 7
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21AD71', 'Business Intelligence & Visualization', 7, 'AI And Data Science', 4, 0.00),
('21AD72', 'Cloud Virtualization & Big Data', 7, 'AI And Data Science', 4, 0.00),
('21AD73', 'Elective: AI in Healthcare & Robotics', 7, 'AI And Data Science', 3, 0.00);

-- Semester 8
INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES
('21AD81', 'Project Work Phase-II', 8, 'AI And Data Science', 10, 0.00),
('21AD82', 'Technical Seminar', 8, 'AI And Data Science', 2, 0.00);
