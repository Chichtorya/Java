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
//    public static void main(String[] args) {
//       String pass = "abc sad";
//        if(pass.length()>20){
//            System.out.println("a");
//        }else{
//            System.out.println("b");
//        }
//    }
}
