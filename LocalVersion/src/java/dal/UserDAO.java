/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Role;
import model.User;

/**
 *
 * @author dell
 */
public class UserDAO extends DbContext {

    public Role getRoleById(int id) {
        String sql = "select * from Role where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Role(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String MD5(String srcText) {
        String enrText;
        try {

            MessageDigest msd = MessageDigest.getInstance("MD5");
            byte[] srcTextBytes = srcText.getBytes("UTF-8");
            byte[] enTextBytes = msd.digest(srcTextBytes);
            BigInteger bigInt = new BigInteger(1, enTextBytes);
            enrText = bigInt.toString(16);
            return enrText;
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
        return null;
    }

    public User getUserById(int id) {
        String sql = "select * from Users where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_role = rs.getInt("id_role");
                Role role = getRoleById(id_role);
                return new User(rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("img"),
                        rs.getString("phone"),
                        rs.getString("Date_Of_Birth"),
                        rs.getInt("Gender"),
                        rs.getString("Citizen_Id"),
                        rs.getString("Health_Id"),
                        rs.getString("Address"),
                        role,
                        rs.getInt("isBlock"),
                        rs.getString("Gmail"),
                        rs.getString("Password"));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Role> getAllRole() {
        ArrayList<Role> list = new ArrayList<>();
        String sql = "select * from Role";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Role(rs.getInt("Id"),
                        rs.getString("name")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<User> getAllUser() {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from users";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_role = rs.getInt("id_role");
                Role role = getRoleById(id_role);
                list.add(new User(rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("img"),
                        rs.getString("phone"),
                        rs.getString("Date_Of_Birth"),
                        rs.getInt("Gender"),
                        rs.getString("Citizen_Id"),
                        rs.getString("Health_Id"),
                        rs.getString("Address"),
                        role,
                        rs.getInt("isBlock"),
                        rs.getString("Gmail"),
                        rs.getString("Password")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<User> getTop3User(int id_role) {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from Users \n"
                + "where id_role = ?\n"
                + "order by id asc limit 3\n"
                + ";";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_role);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = getRoleById(id_role);
                list.add(new User(rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("img"),
                        rs.getString("phone"),
                        rs.getString("Date_Of_Birth"),
                        rs.getInt("Gender"),
                        rs.getString("Citizen_Id"),
                        rs.getString("Health_Id"),
                        rs.getString("Address"),
                        role,
                        rs.getInt("isBlock"),
                        rs.getString("Gmail"),
                        rs.getString("Password")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<User> getAllUserByRole(int id_role) {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from users where id_role = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_role);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = getRoleById(id_role);
                list.add(new User(rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("img"),
                        rs.getString("phone"),
                        rs.getString("Date_Of_Birth"),
                        rs.getInt("Gender"),
                        rs.getString("Citizen_Id"),
                        rs.getString("Health_Id"),
                        rs.getString("Address"),
                        role,
                        rs.getInt("isBlock"),
                        rs.getString("Gmail"),
                        rs.getString("Password")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
//

    public void updatePhoto(String photo, int id) {
        String sql = "update Users set img = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, photo);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkPhone(String phone) {
        ArrayList<User> list = getAllUser();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }
    

    public boolean checkGmail(String gmail) {
        ArrayList<User> list = getAllUser();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getGmail().equals(gmail)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkHealthId(String healthId) {
        ArrayList<User> list = getAllUser();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getHealth_Id().equals(healthId)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCitizenId(String citizen_id) {
        ArrayList<User> list = getAllUser();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCitizen_Id().equals(citizen_id)) {
                return true;
            }
        }
        return false;
    }

    public void createUserByAdmin(User pro) {
        String sql = "INSERT INTO `g62`.`Users` (`name`, `img`, `phone`, `Date_Of_Birth`, `Gender`, `Citizen_Id`, `Health_Id`, `Address`, `id_role`, `isBlock`, `gmail`, `password`) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            String pass = MD5(pro.getPassword());
            ps.setString(1, pro.getName());
            ps.setString(2, pro.getImg());
            ps.setString(3, pro.getPhone());
            ps.setString(4, pro.getDate_Of_Birth());
            ps.setInt(5, pro.getGender());
            ps.setString(6, pro.getCitizen_Id());
            ps.setString(7, pro.getHealth_Id());
            ps.setString(8, pro.getAddress());
            ps.setInt(9, pro.getRole().getId());
            ps.setInt(10, 1);
            ps.setString(11, pro.getGmail());
            ps.setString(12, pass);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

//    public void createUserByCustomer(User pro) {
//        String sql = "INSERT INTO `g62`.`Users` (`name`, `img`, `phone`, `Date_Of_Birth`, `Gender`, `Citizen_Id`, `Health_Id`, `Address`, `id_role`, `isBlock`, `gmail`, `password`) values (?,?,?,?,?,?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, pro.getName());
//            ps.setString(2, pro.getImg());
//            ps.setString(3, pro.getPhone());
//            ps.setString(4, pro.getDate_Of_Birth());
//            ps.setInt(5, pro.getGender());
//            ps.setString(6, pro.getCitizen_Id());
//            ps.setString(7, pro.getHealth_Id());
//            ps.setString(8, pro.getAddress());
//            ps.setInt(9, 4);
//            ps.setInt(10, 1);
//            ps.setString(11, pro.getGmail());
//            ps.setString(12, "abc123");
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
    public void BlockUser(int isBlock, int id) {
        try {
            String sql = "update  Users set isBlock = ? where Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, isBlock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ChangePass(String acc,String pass) {
        try {
            String sql = "update  Users set password = ? where gmail = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            String pass1 = MD5(pass);
            ps.setString(1, pass1);
            ps.setString(2, acc);
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//

    public ArrayList<User> getAllUserByName(String name1) {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from Users where name like '%" + name1 + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_role = rs.getInt("id_role");
                Role role = getRoleById(id_role);
                list.add(new User(rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("img"),
                        rs.getString("phone"),
                        rs.getString("Date_Of_Birth"),
                        rs.getInt("Gender"),
                        rs.getString("Citizen_Id"),
                        rs.getString("Health_Id"),
                        rs.getString("Address"),
                        role,
                        rs.getInt("isBlock"),
                        rs.getString("Gmail"),
                        rs.getString("Password")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void editUserByCustomer(User pro, int id) {
        String spl = "UPDATE users SET name = ?, img =?,phone = ?, "
                + "Date_Of_Birth = ?, Gender = ?, Citizen_Id = ?,"
                + "Health_Id = ?, Address = ?, Gmail = ? WHERE Id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(spl);
            ps.setInt(10, id);
            ps.setString(1, pro.getName());
            ps.setString(2, pro.getImg());
            ps.setString(3, pro.getPhone());
            ps.setString(4, pro.getDate_Of_Birth());
            ps.setInt(5, pro.getGender());
            ps.setString(6, pro.getCitizen_Id());
            ps.setString(7, pro.getHealth_Id());
            ps.setString(8, pro.getAddress());
            ps.setString(9, pro.getGmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editUserByAdmin(User pro, int id) {
        String spl = "UPDATE users SET name = ?, img =?,phone = ?, "
                + "Date_Of_Birth = ?, Gender = ?, Citizen_Id = ?,"
                + "Health_Id = ?, Address = ?,id_role = ?, Gmail = ? WHERE Id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(spl);
            ps.setInt(11, id);
            ps.setString(1, pro.getName());
            ps.setString(2, pro.getImg());
            ps.setString(3, pro.getPhone());
            ps.setString(4, pro.getDate_Of_Birth());
            ps.setInt(5, pro.getGender());
            ps.setString(6, pro.getCitizen_Id());
            ps.setString(7, pro.getHealth_Id());
            ps.setString(8, pro.getAddress());
            ps.setInt(9, pro.getRole().getId());
            ps.setString(10, pro.getGmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void ResetPass(int id) {
        String sql = "update Users set password = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            String pass = MD5("abc123");
            ps.setString(1, pass);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User checkUser(String gmail, String pass) {
        String sql = "select * from Users where gmail =? and password=?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            String pass1 = MD5(pass);
            ps.setString(1, gmail);
            ps.setString(2, pass1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_role = rs.getInt("id_role");
                Role role = getRoleById(id_role);
                return new User(rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("img"),
                        rs.getString("phone"),
                        rs.getString("Date_Of_Birth"),
                        rs.getInt("Gender"),
                        rs.getString("Citizen_Id"),
                        rs.getString("Health_Id"),
                        rs.getString("Address"),
                        role,
                        rs.getInt("isBlock"),
                        rs.getString("Gmail"),
                        rs.getString("Password"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
  public User getsmallUserById(int id) {
        String sql = "select * from Users where id = ?";
          User user = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));

            user.setGender(rs.getInt("Gender"));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
 return user;
    }
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
//        User u = new User("abc", "ac", "0123123", "2010-10-10", 1, "12434", "122134", "hn", "abc34@gmail.com");
//        dao.createUserByCustomer(u);
//        System.out.println(u);
//        dao.createUser(u);
//        dao.deleteUserById(1);
//        dao.editUser(u, 2);
//dao.ChangePass("abc12344555", 2);
//        User u = dao.checkUser("abc@gmail.com", "abc");
//        System.out.println(u);
        System.out.println(dao.getsmallUserById(28));
    }

}
