package com.vtu.examportal.dao;

import com.vtu.examportal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveStudent(Student student) {
        String sql = "INSERT INTO students (usn, name, college_code, branch, semester, email, phone) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE name=?, college_code=?, branch=?, semester=?, email=?, phone=?";
        return jdbcTemplate.update(sql,
                student.getUsn(), student.getName(), student.getCollegeCode(), student.getBranch(), student.getSemester(), student.getEmail(), student.getPhone(),
                student.getName(), student.getCollegeCode(), student.getBranch(), student.getSemester(), student.getEmail(), student.getPhone());
    }

    public Student getStudentByUsn(String usn) {
        String sql = "SELECT * FROM students WHERE usn = ?";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper(), usn);
        return students.isEmpty() ? null : students.get(0);
    }

    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setUsn(rs.getString("usn"));
            student.setName(rs.getString("name"));
            student.setCollegeCode(rs.getString("college_code"));
            student.setBranch(rs.getString("branch"));
            student.setSemester(rs.getInt("semester"));
            student.setEmail(rs.getString("email"));
            student.setPhone(rs.getString("phone"));
            return student;
        }
    }
}
