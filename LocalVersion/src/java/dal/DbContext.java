/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbContext {
   protected Connection connection;
//    public Connection getConnect() {
//        String jdbcURL = "jdbc:mysql://localhost:3306/G6MedicalData";
//        String jdbcUsername = "root";
//        String jdbcPassword = "sasa";
//       
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
//      public Connection getConnection() {
//        return connection;
//    }
   
   //demoFunc
    public DbContext() {
        String jdbcURL = "jdbc:mysql://localhost:3306/g63";
        String jdbcUsername = "root";
        String jdbcPassword = "sasa";
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
      
    }
      public Connection getConnection() {
        return connection;
    }
    
    public static void main(String[] args) {
        DbContext db = new DbContext();
        System.out.println(db.getConnection());
    }
}

 

