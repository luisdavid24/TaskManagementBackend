package org.example.Models;

public class Details {
    private int idUser;
    private int idTask;

    public Details(int idUser, int idTask) {
        this.idUser = idUser;
        this.idTask = idTask;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }
}
