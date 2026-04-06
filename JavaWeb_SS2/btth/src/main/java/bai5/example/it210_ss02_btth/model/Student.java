package bai5.example.it210_ss02_btth.model;

public class Student {
    private String msv;
    private String name;
    private String faculty;
    private int year;
    private double gpa;

    public Student(String msv, String name, String faculty, int year, double gpa) {
        this.msv = msv;
        this.name = name;
        this.faculty = faculty;
        this.year = year;
        this.gpa = gpa;
    }

    public String getMsv() { return msv; }
    public String getName() { return name; }
    public String getFaculty() { return faculty; }
    public int getYear() { return year; }
    public double getGpa() { return gpa; }
}