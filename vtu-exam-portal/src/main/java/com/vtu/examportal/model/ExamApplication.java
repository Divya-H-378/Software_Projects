package com.vtu.examportal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamApplication {
    private int id;
    private String usn;
    private Date appliedDate;
    private double totalFee;
    private String status; // PENDING, APPROVED, REJECTED

    // Transient fields
    private String studentName;
    private List<String> subjectCodes = new ArrayList<>();
    private List<Subject> appliedSubjects = new ArrayList<>();

    public ExamApplication() {}

    public ExamApplication(int id, String usn, Date appliedDate, double totalFee, String status) {
        this.id = id;
        this.usn = usn;
        this.appliedDate = appliedDate;
        this.totalFee = totalFee;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsn() { return usn; }
    public void setUsn(String usn) { this.usn = usn; }

    public Date getAppliedDate() { return appliedDate; }
    public void setAppliedDate(Date appliedDate) { this.appliedDate = appliedDate; }

    public double getTotalFee() { return totalFee; }
    public void setTotalFee(double totalFee) { this.totalFee = totalFee; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public List<String> getSubjectCodes() { return subjectCodes; }
    public void setSubjectCodes(List<String> subjectCodes) { this.subjectCodes = subjectCodes; }

    public List<Subject> getAppliedSubjects() { return appliedSubjects; }
    public void setAppliedSubjects(List<Subject> appliedSubjects) { this.appliedSubjects = appliedSubjects; }
}
