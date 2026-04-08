package org.example.demo22.model;

import java.util.Date;

public class project {
    private int id;
    private String name;
    private String description;
    private String manager;
    private Date StartDate;
    private Date EndDate;
    private int TotalPersonnel;

    public project() {
    }

    public project(int id, String name, String description, String manager, Date startDate, Date endDate, int totalPersonnel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.manager = manager;
        StartDate = startDate;
        EndDate = endDate;
        TotalPersonnel = totalPersonnel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public int getTotalPersonnel() {
        return TotalPersonnel;
    }

    public void setTotalPersonnel(int totalPersonnel) {
        TotalPersonnel = totalPersonnel;
    }
}
