package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbContext {
   protected Connection connection;
    public DbContext() {
        String jdbcURL = "jdbc:mysql://localhost:3306/G6";
        String jdbcUsername = "root";
        String jdbcPassword = "12345678";
       
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
    ///<Sumary>
    /// Test Connection With MySql
    ///</Sumary>
    public static void main(String[] args) {
        DbContext db = new DbContext();
        System.out.println(db.getConnection());
    }
}
