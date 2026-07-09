package com.vtu.examportal.dao;

import com.vtu.examportal.model.ExamApplication;
import com.vtu.examportal.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class ApplicationDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SubjectDao subjectDao;

    public int saveApplication(ExamApplication application) {
        String sql = "INSERT INTO applications (usn, total_fee, status) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, application.getUsn());
            ps.setDouble(2, application.getTotalFee());
            ps.setString(3, application.getStatus());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key == null) {
            throw new RuntimeException("Failed to save application, no ID generated.");
        }
        int id = key.intValue();
        application.setId(id);

        // Save selected subjects
        for (String subjectCode : application.getSubjectCodes()) {
            jdbcTemplate.update("INSERT INTO application_subjects (application_id, subject_code) VALUES (?, ?)", id, subjectCode);
        }

        return id;
    }

    public ExamApplication getApplicationById(int id) {
        String sql = "SELECT a.*, s.name as student_name FROM applications a " +
                     "JOIN students s ON a.usn = s.usn " +
                     "WHERE a.id = ?";
        List<ExamApplication> apps = jdbcTemplate.query(sql, new ApplicationRowMapper(), id);
        if (apps.isEmpty()) {
            return null;
        }
        ExamApplication app = apps.get(0);
        populateSubjects(app);
        return app;
    }

    public List<ExamApplication> getApplicationsByUsn(String usn) {
        String sql = "SELECT a.*, s.name as student_name FROM applications a " +
                     "JOIN students s ON a.usn = s.usn " +
                     "WHERE a.usn = ? " +
                     "ORDER BY a.applied_date DESC";
        List<ExamApplication> apps = jdbcTemplate.query(sql, new ApplicationRowMapper(), usn);
        for (ExamApplication app : apps) {
            populateSubjects(app);
        }
        return apps;
    }

    public List<ExamApplication> getAllApplications() {
        String sql = "SELECT a.*, s.name as student_name FROM applications a " +
                     "JOIN students s ON a.usn = s.usn " +
                     "ORDER BY a.applied_date DESC";
        List<ExamApplication> apps = jdbcTemplate.query(sql, new ApplicationRowMapper());
        for (ExamApplication app : apps) {
            populateSubjects(app);
        }
        return apps;
    }

    public int updateStatus(int applicationId, String status) {
        String sql = "UPDATE applications SET status = ? WHERE id = ?";
        return jdbcTemplate.update(sql, status, applicationId);
    }

    private void populateSubjects(ExamApplication app) {
        String sql = "SELECT subject_code FROM application_subjects WHERE application_id = ?";
        List<String> codes = jdbcTemplate.queryForList(sql, String.class, app.getId());
        System.out.println("DEBUG: app.getId() = " + app.getId() + ", retrieved codes: " + codes);
        app.setSubjectCodes(codes);

        if (!codes.isEmpty()) {
            List<Subject> subjects = subjectDao.getSubjectsByCodes(codes);
            System.out.println("DEBUG: retrieved subjects list size: " + (subjects != null ? subjects.size() : 0));
            if (subjects != null) {
                for (Subject s : subjects) {
                    System.out.println("DEBUG: subject: " + s.getSubjectCode() + " - " + s.getSubjectName());
                }
            }
            app.setAppliedSubjects(subjects);
        }
    }

    private static class ApplicationRowMapper implements RowMapper<ExamApplication> {
        @Override
        public ExamApplication mapRow(ResultSet rs, int rowNum) throws SQLException {
            ExamApplication app = new ExamApplication();
            app.setId(rs.getInt("id"));
            app.setUsn(rs.getString("usn"));
            app.setAppliedDate(rs.getTimestamp("applied_date"));
            app.setTotalFee(rs.getDouble("total_fee"));
            app.setStatus(rs.getString("status"));
            app.setStudentName(rs.getString("student_name"));
            return app;
        }
    }
}
