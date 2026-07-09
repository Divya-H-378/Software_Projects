package com.vtu.examportal.dao;

import com.vtu.examportal.model.ExamApplication;
import com.vtu.examportal.model.Student;
import com.vtu.examportal.model.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ApplicationDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private ApplicationDao applicationDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testSaveAndRetrieveApplicationWithSubjects() {
        // 1. Setup Student
        Student student = new Student();
        student.setUsn("TESTUSN001");
        student.setName("JUnit Test Student");
        student.setCollegeCode("1SG");
        student.setBranch("Computer Science");
        student.setSemester(6);
        student.setEmail("test@vtu.com");
        student.setPhone("9999999999");
        studentDao.saveStudent(student);

        // 2. Setup Subjects (Ensure they exist in DB)
        jdbcTemplate.update("INSERT IGNORE INTO subjects (subject_code, subject_name, semester, department, credits, fee) VALUES " +
                "('21TEST1', 'Test Subject 1', 6, 'Computer Science', 4, 0.00), " +
                "('21TEST2', 'Test Subject 2', 6, 'Computer Science', 3, 0.00)");

        // 3. Create Application
        ExamApplication app = new ExamApplication();
        app.setUsn("TESTUSN001");
        app.setStatus("APPROVED");
        app.setTotalFee(0.00);
        app.setAppliedDate(new Date());
        app.setSubjectCodes(Arrays.asList("21TEST1", "21TEST2"));

        // 4. Save
        int appId = applicationDao.saveApplication(app);
        assertTrue(appId > 0);

        // 5. Retrieve and Verify
        ExamApplication retrievedApp = applicationDao.getApplicationById(appId);
        assertNotNull(retrievedApp);
        assertEquals("TESTUSN001", retrievedApp.getUsn());
        assertEquals("APPROVED", retrievedApp.getStatus());
        
        List<String> codes = retrievedApp.getSubjectCodes();
        assertNotNull(codes);
        assertEquals(2, codes.size());
        assertTrue(codes.contains("21TEST1"));
        assertTrue(codes.contains("21TEST2"));

        List<Subject> subjects = retrievedApp.getAppliedSubjects();
        assertNotNull(subjects);
        assertEquals(2, subjects.size());
        assertEquals("Test Subject 1", subjects.get(0).getSubjectName());
        assertEquals("Test Subject 2", subjects.get(1).getSubjectName());

        System.out.println("DEBUG JUNIT: Retrieve successful. Subject 1: " + subjects.get(0).getSubjectName());
    }
}
