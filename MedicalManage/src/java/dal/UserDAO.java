/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;



import Enum.Gender;
import Enum.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.UserProfile;


/**
 *
 * @author dell
 */
public class UserDAO extends DbContext {

    public ArrayList<UserProfile> getAllUser() {
        ArrayList<UserProfile> list = new ArrayList<>();
        String sql = "select * from user_profile";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                list.add(new UserProfile(rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("Phone_Number"),
                        rs.getString("Date_Of_Birth"),
                        Gender.valueOf(rs.getString("Gender")),                       
                        Role.valueOf(rs.getString("Role")),
                        rs.getString("Addr"),
                        rs.getString("Gmail"),
                        rs.getString("Password")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean checkPhone(String phone) {
        ArrayList<UserProfile> list = getAllUser();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhone_Number().equals(phone)) {
                return false;
            }
        }
        return true;
    }

    public UserProfile getUserById(int id) {
        ArrayList<UserProfile> list = getAllUser();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return list.get(i);
            }
        }
        return null;
    }

    public void createUser(UserProfile pro) {
        String sql = "insert into  user_profile(name, Phone_Number, Date_Of_Birth, Gender,Role,Addr,Gmail,Password) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pro.getName());
            ps.setString(2, pro.getPhone_Number());
            ps.setString(3, pro.getDate_Of_Birth());
            ps.setString(4, pro.getGender().toString());
            ps.setString(5, pro.getRole().toString());
            ps.setString(6, pro.getAddress());
            ps.setString(7, pro.getGmail());
            ps.setString(8, pro.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteUserById(int id) {
        try {
            String sql = "delete from User_Profile where Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<UserProfile> getAllUserByName(String name1) {
        ArrayList<UserProfile> list = new ArrayList<>();
        String sql = "select * from User_Profile where name like '%" + name1 + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new UserProfile(
                        rs.getString("name"),
                        rs.getString("Phone_Number"),
                        rs.getString("Date_Of_Birth"),
                        Gender.valueOf(rs.getString("Gender")),                       
                        Role.valueOf(rs.getString("Role")),
                        rs.getString("Addr"),
                        rs.getString("Gmail"),
                        rs.getString("Password")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void editUser(UserProfile pro,int id) {
        String spl = "UPDATE User_Profile set name = ?,Phone_Number = ?, Date_Of_Birth = ? ,Gender= ? ,Role = ? ,Address = ? ,Gmail = ? where Id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(spl);
            ps.setString(1, pro.getName());
            ps.setString(2, pro.getPhone_Number());
            ps.setString(3, pro.getDate_Of_Birth());
            ps.setString(4, pro.getGender().toString());
            ps.setString(5, pro.getRole().toString());
            ps.setString(6, pro.getAddress());
            ps.setString(7, pro.getGmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
//        UserProfile u = new UserProfile("aaaa", "088767", "2010-10-10", Gender.Unknow, Role.Other, "hn","abc@gmail.com", "123");
//        dao.createUser(u);
//        dao.deleteUserById(1);
        ArrayList<UserProfile> list = dao.getAllUser();
        for(UserProfile a : list ){
            System.out.println(a);
        }

    }   


}