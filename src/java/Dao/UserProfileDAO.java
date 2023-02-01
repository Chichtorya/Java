/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.User_Profile.UserProfile;
import Enum_Type.Gender;
import Enum_Type.Role;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class UserProfileDAO extends DbContext implements Serializable {

    ///<Summary>
    /// Check If Account Is Exists.
    ///</Summary>
    public boolean CheckAccount(String Gmail, String Password) {
        String mySql = "select*\n"
                + "From user_profile\n"
                + "Where Gmail = ? and Password = ?;";
        Connection con = connection;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            pre = con.prepareStatement(mySql);
            pre.setString(1, Gmail);
            pre.setString(2, Password);
            res = pre.executeQuery();
            while (res.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    ///<Summary>
    /// Create Account By Gmail and Password.
    ///</Summary>
    public int CreateAccount(String Gmail, String Password) {
        String mySQL = "insert into user_profile(Gmail,Password)\n"
                + "values(?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(mySQL);
            st.setString(1, Gmail);
            st.setString(2, Password);
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public UserProfile GetUserData(String gmail, String password) throws SQLException {
        String mySql = "select*\n"
                + "From user_profile\n"
                + "Where Gmail = ? and Password = ?;";
        Connection con = connection;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            pre = con.prepareStatement(mySql);
            pre.setString(1, gmail);
            pre.setString(2, password);
            res = pre.executeQuery();
            while (res.next()) {
                int Id = res.getInt("Id");
                String Name = res.getString("name");
                String Phone_Number = res.getString("Phone_Number");
                String Date_Of_Birth = null;
                Gender gender = null;//Gender.valueOf(res.getString("Gender"));
                Role role = null;//Role.valueOf(res.getString("Role"));
                String Address = res.getString("Addr");
                String Gmail = res.getString("Gmail");
                String Password = res.getString("Password");
                return new UserProfile(Id, Name, Phone_Number, Date_Of_Birth, gender, role, Address, Gmail, Password);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int UpdateUserProfile(UserProfile newUserProfile) {
        String mySQL = "Update user_profile\n"
                + "Set \n"
                + "name = ?,\n"
                + "Phone_Number = ?,\n"
                + "Date_Of_Birth = ?,\n"
                + "Gender = ?,\n"
                + "Role = ?,\n"
                + "Addr = ?,\n"
                + "Password = ?\n"
                + "WHERE Id = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(mySQL);
            st.setString(1, newUserProfile.getName());
            st.setString(2, newUserProfile.getPhone_Number());
            st.setString(3, null);
            st.setString(4, newUserProfile.getGender().toString());
            st.setString(5, newUserProfile.getRole().toString());
            st.setString(6, newUserProfile.getAddress());
            st.setString(7, newUserProfile.getPassword());
            st.setInt(8, newUserProfile.getId());
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    ///<Summary>
    /// Delete User Account By Gmail
    ///</Summary>
    public int DeleteAccountByGmail(String Gmail) {
        String mySQL = "DELETE FROM user_profile WHERE Gmail = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(mySQL);
            st.setString(1, Gmail);
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    ///<Summary>
    /// Delete User Account By ID
    ///</Summary>
    public int DeleteAccountByID(int ID) {
        String mySQL = "DELETE FROM user_profile WHERE Gmail = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(mySQL);
            st.setInt(1, ID);
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    ///<Summary>
    /// Search userProfile by their name
    ///</Summary>
    public List<UserProfile> SearchUser(String name) {
        List<UserProfile> userList = new ArrayList<UserProfile>();
        String mySql = "select*\n"
                + "From user_profile;";
        Connection con = connection;
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            pre = con.prepareStatement(mySql);
            res = pre.executeQuery();
            while (res.next()) {
                if (isContain(res.getString("name"), name)) {
                    int Id = res.getInt("Id");
                    String Name = res.getString("name");
                    String Phone_Number = res.getString("Phone_Number");
                    String Date_Of_Birth = null;
                    Gender gender = Gender.valueOf(res.getString("Gender"));
                    Role role = Role.valueOf(res.getString("Role"));
                    String Address = res.getString("Addr");
                    String Gmail = res.getString("Gmail");
                    String Password = res.getString("Password");
                    UserProfile userProfile = new UserProfile(Id, Name, Phone_Number, Date_Of_Birth, gender, role, Address, Gmail, Password);
                    userList.add(userProfile);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (userList.isEmpty()) {
            return null;
        } else {
            return userList;
        }
    }

    ///<Summary>
    /// Check if string contain a word
    ///</Summary>
    private static boolean isContain(String source, String subItem) {
        String pattern = "\\b" + subItem + "\\b";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        return m.find();
    }

    public static void main(String[] args) {
        UserProfileDAO test = new UserProfileDAO();
        try {
            //System.out.println(test.CreateAccount("khanh","123"));
            //System.out.println(test.DeleteAccountByGmail("khanhbui@gmail.com"));
            System.out.println(test.GetUserData("khanh", "123"));
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
