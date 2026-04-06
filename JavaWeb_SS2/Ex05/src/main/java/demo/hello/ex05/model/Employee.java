package demo.hello.ex05.model;

import java.util.Date;

public class Employee {
    private String code, name, department, status;
    private int salary;
    private Date joinDate;

    public Employee(String code, String name, String department, int salary, Date joinDate, String status) {
        this.code = code;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public String getStatus() {
        return status;
    }
}