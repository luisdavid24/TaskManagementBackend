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

    // Método para actualizar datos en la base de datos
    public void updateData(String Username, String userPassword, int id) {
        String query = "UPDATE public.users SET  id = ?, name = ?, password = ? WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, Username);
            pstmt.setString(3, userPassword);
            pstmt.setInt(4, id);

            pstmt.executeUpdate();

            System.out.println("Datos actualizados correctamente.");
        } catch (SQLException e) {
            System.out.println("Los datos no fueron actualizados.");
            e.printStackTrace();
        }
    }

    public void deleteData(int id) {
        String query = "DELETE FROM users WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Datos eliminados correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

