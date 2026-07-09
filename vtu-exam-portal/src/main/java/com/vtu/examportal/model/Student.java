package com.vtu.examportal.model;

public class Student {
    private String usn;
    private String name;
    private String collegeCode;
    private String branch;
    private int semester;
    private String email;
    private String phone;

    public Student() {}

    public Student(String usn, String name, String collegeCode, String branch, int semester, String email, String phone) {
        this.usn = usn;
        this.name = name;
        this.collegeCode = collegeCode;
        this.branch = branch;
        this.semester = semester;
        this.email = email;
        this.phone = phone;
    }

    public String getUsn() { return usn; }
    public void setUsn(String usn) { this.usn = usn; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCollegeCode() { return collegeCode; }
    public void setCollegeCode(String collegeCode) { this.collegeCode = collegeCode; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
