package com.vtu.examportal.dao;

import com.vtu.examportal.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Repository
public class SubjectDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Subject> getSubjectsBySemAndDept(int semester, String branch) {
        String sql = "SELECT * FROM subjects WHERE semester = ? AND department = ?";
        return jdbcTemplate.query(sql, new SubjectRowMapper(), semester, branch);
    }

    public List<Subject> getSubjectsByCodes(List<String> codes) {
        if (codes == null || codes.isEmpty()) {
            return Collections.emptyList();
        }
        String placeholders = String.join(",", Collections.nCopies(codes.size(), "?"));
        String sql = "SELECT * FROM subjects WHERE subject_code IN (" + placeholders + ")";
        return jdbcTemplate.query(sql, new SubjectRowMapper(), codes.toArray());
    }

    private static class SubjectRowMapper implements RowMapper<Subject> {
        @Override
        public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
            Subject subject = new Subject();
            subject.setSubjectCode(rs.getString("subject_code"));
            subject.setSubjectName(rs.getString("subject_name"));
            subject.setSemester(rs.getInt("semester"));
            subject.setDepartment(rs.getString("department"));
            subject.setCredits(rs.getInt("credits"));
            subject.setFee(rs.getDouble("fee"));
            return subject;
        }
    }
}
