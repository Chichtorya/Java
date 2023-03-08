/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dell
 */
public class DbContext {
    protected Connection connection;
    public  DbContext() {
        String jdbcURL = "jdbc:mysql://localhost:3306/G62";
        String jdbcUsername = "root";
        String jdbcPassword = "12345";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        }
//    protected Connection connection;
//    public DbContext()
//    {
//        try {
//            // Edit URL , username, password to authenticate with your MS SQL Server
//            String url = "jdbc:sqlserver://localhost:1433;databaseName= g62";
//            String username = "sa";
//            String password = "123";
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            connection = DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException | SQLException ex) {
//            System.out.println(ex);
//        }
//    
//    }
    public static void main(String[] args) {
        DbContext d = new DbContext();
        System.out.println(d.connection);
    }
}
