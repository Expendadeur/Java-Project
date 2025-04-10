/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ISSA 2025
 */
public class DatabaseConnection {
     private static final String URL = "jdbc:mysql://localhost:3306/gestioncourierpostal";
    private static final String USER = "root";
    private static final String PASSWORD = ""; 

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            //System.out.println("Connection établie avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
