/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class AccountDAO implements Serializable {

    public AccountDTO getAccount(String gmail, String password) throws SQLException {
        String mySql = "select*\n"
                + "From webdatabase.useraccount\n"
                + "Where Gmail = ? and Password = ?";
        AccountDTO userAccount = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            con = Connect_mySql.getConnect();
            pre = con.prepareStatement(mySql);
            pre.setString(1,gmail);
            pre.setString(2,password);
            res = pre.executeQuery();
            while (res.next()) {
                String getId = res.getString("Id");
                String getGmail = res.getString("Gmail");
                String getPass = res.getString("Password");
                userAccount = new AccountDTO(getId,getGmail,getPass);
            }
        } catch (Exception e) {
        }

        return userAccount;
    }
}
