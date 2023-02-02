/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Admin
 */
public class AccountDAO extends DbContext {

    public AccountDTO getAccount(String gmail, String password) {
        String mySql = "select*\n"
                + "From accountData\n"
                + "Where Gmail = ? and Password = ?";
        AccountDTO userAccount = null;
      
        try {
            PreparedStatement st = connection.prepareStatement(mySql);
            st = connection.prepareStatement(mySql);
            st.setString(1,gmail);
            st.setString(2,password);
           ResultSet rs  = st.executeQuery();
            while (rs.next()) {
                String getId = rs.getString("Id");
                String getGmail = rs.getString("Gmail");
                String getPass = rs.getString("Password");
                userAccount = new AccountDTO(getId,getGmail,getPass);
            }
     } catch (SQLException e) {
            System.out.println(e);
        }

        return userAccount;
    }
    public static void main(String[] args) {
        AccountDAO a = new AccountDAO();
        System.out.println(a.getAccount("khanh","12345678"));
    }
}
