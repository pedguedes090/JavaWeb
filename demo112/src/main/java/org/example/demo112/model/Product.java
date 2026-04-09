package org.example.demo112.model;

import java.util.Date;

public class Product {
    private String Id;
    private String Name;
    private String description;
    private String manager;
    private Date createDate;
    private Date expireDate;
    private int totalpersonnel;

    public Product() {
    }

    public Product(String id, String name, String description, String manager, Date createDate, Date expireDate, int totalpersonnel) {
        Id = id;
        Name = name;
        this.description = description;
        this.manager = manager;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.totalpersonnel = totalpersonnel;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public int getTotalpersonnel() {
        return totalpersonnel;
    }

    public void setTotalpersonnel(int totalpersonnel) {
        this.totalpersonnel = totalpersonnel;
    }
}
