package org.example.controller;

import java.sql.*;

public class UserController {
    public Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/TaskManagement";
        String user="postgres";
        String password="12345";
        return DriverManager.getConnection(url,user,password);
    }

    // Método para insertar datos en la base de datos
    public void insertData(int userId,String userName, String userPassword) {
        String query = "INSERT INTO public.users(id, name, password) VALUES (?, ?, ?);";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1,userId);
            pstmt.setString(2, userName);
            pstmt.setString(3, userPassword);
            pstmt.executeUpdate();

            System.out.println("Datos insertados correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para leer datos de la base de datos
    public void readData() {
        String query = "SELECT * FROM users";

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("id") + ", User name: " + rs.getString("name")+" Password: "+rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
    // Método para actualizar datos en la base de datos
    public void updateData(String nombreNuevo, String apellidoNuevo, int id) {
        String query = "UPDATE tabla_ejemplo SET nombre = ?, apellido = ? WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, nombreNuevo);
            pstmt.setString(2, apellidoNuevo);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();

            System.out.println("Datos actualizados correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar datos de la base de datos
    public void deleteData(int id) {
        String query = "DELETE FROM tabla_ejemplo WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Datos eliminados correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método principal para probar las operaciones CRUD
    public static void main(String[] args) {
        CRUDExample example = new CRUDExample();

        // Insertar datos
        example.insertData("John", "Doe");

        // Leer datos
        example.readData();

        // Actualizar datos
        example.updateData("Jane", "Doe", 1);

        // Eliminar datos
        example.deleteData(1);
    }*/
}

