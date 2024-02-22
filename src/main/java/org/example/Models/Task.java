package org.example.Models;

import java.util.Date;

public class Task {
    private String titule;
    private String description;
    private Date   expirationDate;
    private boolean completed;

    private int id;

    public Task(String titule, String description, Date expirationDate, boolean completed, int id) {
        this.titule = titule;
        this.description = description;
        this.expirationDate = expirationDate;
        this.completed = completed;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitule() {
        return titule;
    }

    public void setTitule(String titule) {
        this.titule = titule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
