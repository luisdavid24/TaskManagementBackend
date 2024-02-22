package org.example;

import org.example.controller.UserController;

import javax.xml.transform.Result;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserController controller= new UserController();
        //controller.insertData(2,"David","pass");
        //controller.readData();
        //controller.updateData("DavidNew","passNEw",2);
        //controller.deleteData(2);
    }
}

/*String user="postgres";
        String password="12345";
        Connection conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/TaskManagement",user,password);
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users")){
            while(rs.next()){
                int id= rs.getInt("id");
                String name= rs.getString("name");
                String pass= rs.getString("password");
                System.out.println(id+" "+name+" "+pass);

            }
        }*/


/*

CREATE TABLE Details (
    idUser SERIAL,
   	idTask SERIAL,
	PRIMARY KEY (idUser,idTask),
	FOREIGN KEY (idUser) REFERENCES users(id),
	FOREIGN KEY (idTask) REFERENCES tasks(id)
);


CREATE TABLE user (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    expiration_date DATE,
    completed BOOLEAN NOT NULL DEFAULT FALSE
);

 */