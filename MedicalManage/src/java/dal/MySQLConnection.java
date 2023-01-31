/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dell
 */
public class MySQLConnection {
    protected Connection connection;
    public  MySQLConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/G6";
        String jdbcUsername = "root";
        String jdbcPassword = "12345";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        MySQLConnection con = new MySQLConnection();
        System.out.println(con);
    }
}
