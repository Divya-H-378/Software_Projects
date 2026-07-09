package com.vtu.examportal.model;

public class Subject {
    private String subjectCode;
    private String subjectName;
    private int semester;
    private String department;
    private int credits;
    private double fee;

    public Subject() {}

    public Subject(String subjectCode, String subjectName, int semester, String department, int credits, double fee) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.semester = semester;
        this.department = department;
        this.credits = credits;
        this.fee = fee;
    }

    public String getSubjectCode() { return subjectCode; }
    public void setSubjectCode(String subjectCode) { this.subjectCode = subjectCode; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }
}
