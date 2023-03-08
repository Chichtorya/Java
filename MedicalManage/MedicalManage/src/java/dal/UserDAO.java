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
import model.Major;
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

    public Major getMajorById(int id) {
        String sql = "select * from Majors where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Major(rs.getInt("id"),
                        rs.getString("room"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public float getMoneyByMonth(int begin, int last, int month, int id_major) {
        String sql = "select sum(e.Total_Test_Price) as 'money' from Examination e\n"
                + "inner join Schedule s on s.id_exam = e.id\n"
                + "where DAY(Visit_Time) >= ? and DAY(Visit_Time) <= ? and MONTH(Visit_Time) = ? and s.id_majors = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, begin);
            ps.setInt(2, last);
            ps.setInt(3, month);
            ps.setInt(4, id_major);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getFloat("money");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    public float getTotalMoneyByMonth(int begin, int last, int month, int id_major) {
        String sql = "select sum(e.Total_Test_Price) as 'money' from Examination e\n"
                + "inner join Schedule s on s.id_exam = e.id\n"
                + "where DAY(Visit_Time) >= ? and DAY(Visit_Time) <= ? and MONTH(Visit_Time) = ? and s.id_majors != ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, begin);
            ps.setInt(2, last);
            ps.setInt(3, month);
            ps.setInt(4, id_major);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getFloat("money");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public float getTotalByMonth(int month) {
        String sql = "select sum(e.Total_Test_Price) as 'money' from Examination e\n"
                + "inner join Schedule s on s.id_exam = e.id\n"
                + "where  MONTH(Visit_Time) = ? and s.id_majors !=4 ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, month);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getFloat("money");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    public float getTotalByMonthByMajor(int month,int majors) {
        String sql = "select sum(e.Total_Test_Price) as 'money' from Examination e\n"
                + "inner join Schedule s on s.id_exam = e.id\n"
                + "where  MONTH(Visit_Time) = ? and s.id_majors =? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, month);
            ps.setInt(2, majors);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getFloat("money");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        User u = dao.getUserById(1);
        System.out.println(u);
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
                int id_major = rs.getInt("id_majors");
                Major major = getMajorById(id_major);
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
                        major,
                        rs.getInt("isBlock"),
                        rs.getFloat("salary"),
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

    public ArrayList<Major> getAllMajor() {
        ArrayList<Major> list = new ArrayList<>();
        String sql = "select * from Majors";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Major(rs.getInt("Id"),
                        rs.getString("room")));
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
                int id_major = rs.getInt("id_majors");
                Major major = getMajorById(id_major);
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
                        major,
                        rs.getInt("isBlock"),
                          rs.getFloat("salary"),
                        rs.getString("Gmail"),
                        rs.getString("Password")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<User> getAllUserBlock(int iblock) {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from users where isBlock = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, iblock);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_role = rs.getInt("id_role");
                Role role = getRoleById(id_role);
                int id_major = rs.getInt("id_majors");
                Major major = getMajorById(id_major);
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
                        major,
                        rs.getInt("isBlock"),
                          rs.getFloat("salary"),
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
                int id_major = rs.getInt("id_majors");
                Major major = getMajorById(id_major);
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
                        major,
                        rs.getInt("isBlock"),
                          rs.getFloat("salary"),
                        rs.getString("Gmail"),
                        rs.getString("Password")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int getNumberByRole(int id) {
        String sql = "select count(id) as 'number' from Users where id_role = ?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("number");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public ArrayList<User> getAllUserByRole(int id_role, int isBlock) {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from users where id_role = ? and isBlock = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_role);
            ps.setInt(2, isBlock);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = getRoleById(id_role);
                int id_major = rs.getInt("id_majors");
                Major major = getMajorById(id_major);
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
                        major,
                        rs.getInt("isBlock"),
                          rs.getFloat("salary"),
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
        String sql = "INSERT INTO Users (name, img, phone, Date_Of_Birth, Gender, Citizen_Id, Health_Id, Address, id_role, isBlock, gmail, password) values (?,?,?,?,?,?,?,?,?,?,?,?)";
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

    public void createUserByAdmin1(User pro) {
        String sql = "INSERT INTO Users (name, img, phone, Date_Of_Birth, Gender, Citizen_Id, Health_Id, Address, id_role,id_majors, isBlock,salary, gmail, password) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setInt(10, pro.getMajor().getId());
            ps.setInt(11, 1);
            ps.setFloat(12, pro.getSalary());
            ps.setString(13, pro.getGmail());
            ps.setString(14, pass);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

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

    public void ChangePass(String acc, String pass) {
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

    public ArrayList<User> getListByPage(ArrayList<User> list1, int start, int end) {
        ArrayList<User> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list1.get(i));
        }
        return arr;
    }
//

    public ArrayList<User> getAllUserByName(int isBlock, String name1) {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from Users where isBlock = ? and name like '%" + name1 + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, isBlock);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_role = rs.getInt("id_role");
                Role role = getRoleById(id_role);
                int id_major = rs.getInt("id_majors");
                Major major = getMajorById(id_major);
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
                        major,
                        rs.getInt("isBlock"),
                          rs.getFloat("salary"),
                        rs.getString("Gmail"),
                        rs.getString("Password")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<User> getAllUserByNameAndRole(int isBlock, String name1, int r1) {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from Users where isBlock = ? and name like '%" + name1 + "%' and id_role =" + r1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, isBlock);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_role = rs.getInt("id_role");
                Role role = getRoleById(id_role);
                int id_major = rs.getInt("id_majors");
                Major major = getMajorById(id_major);
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
                        major,
                        rs.getInt("isBlock"),
                          rs.getFloat("salary"),
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
        String spl = "UPDATE users SET name = ?,phone = ?, "
                + "Date_Of_Birth = ?, Gender = ?, Citizen_Id = ?,"
                + "Health_Id = ?, Address = ?, Gmail = ? WHERE Id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(spl);
            ps.setInt(9, id);
            ps.setString(1, pro.getName());
            ps.setString(2, pro.getPhone());
            ps.setString(3, pro.getDate_Of_Birth());
            ps.setInt(4, pro.getGender());
            ps.setString(5, pro.getCitizen_Id());
            ps.setString(6, pro.getHealth_Id());
            ps.setString(7, pro.getAddress());
            ps.setString(8, pro.getGmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editUserByAdmin(User pro, int id) {
        String spl = "UPDATE users SET name = ?,Gender = ?, "
                + "Date_Of_Birth = ?, Citizen_Id = ?,"
                + "Health_Id = ?, Address = ?,id_role = ?,id_majors = ?,salary=?,phone = ?, Gmail = ? WHERE Id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(spl);
            ps.setInt(12, id);
            ps.setString(1, pro.getName());
            ps.setInt(2, pro.getGender());
            ps.setString(3, pro.getDate_Of_Birth());
            ps.setString(4, pro.getCitizen_Id());
            ps.setString(5, pro.getHealth_Id());
            ps.setString(6, pro.getAddress());
            ps.setInt(7, pro.getRole().getId());
            ps.setInt(8, pro.getMajor().getId());
            ps.setFloat(9, pro.getSalary());
            ps.setString(10, pro.getPhone());
            ps.setString(11, pro.getGmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editUserByAdmin1(User pro, int id) {
        String spl = "UPDATE users SET name = ?,Gender = ?, "
                + "Date_Of_Birth = ?, Citizen_Id = ?,"
                + "Health_Id = ?, Address = ?,id_role = ?,id_majors = null,salary =null,phone = ?, Gmail = ? WHERE Id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(spl);
            ps.setInt(10, id);
            ps.setString(1, pro.getName());
            ps.setInt(2, pro.getGender());
            ps.setString(3, pro.getDate_Of_Birth());
            ps.setString(4, pro.getCitizen_Id());
            ps.setString(5, pro.getHealth_Id());
            ps.setString(6, pro.getAddress());
            ps.setInt(7, pro.getRole().getId());
            ps.setString(8, pro.getPhone());
            ps.setString(9, pro.getGmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void ResetPass(String pass, String gmail) {
        String sql = "update Users set password = ? where gmail = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            String pass1 = MD5(pass);
            ps.setString(1, pass1);
            ps.setString(2, gmail);
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
                int id_major = rs.getInt("id_majors");
                Major major = getMajorById(id_major);
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
                        major,
                        rs.getInt("isBlock"),
                        rs.getFloat("salary"),
                        rs.getString("Gmail"),
                        rs.getString("Password"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

//    public static void main(String[] args) {
//        UserDAO dao = new UserDAO();
//        String x = "";
//        try{
//            int y = Integer.parseInt(x);
//            System.out.println(y);
//        }catch(NumberFormatException e){
//            System.out.println(e);
//        }
//        Role role = dao.getRoleById(1);
//        User u = new User("admin", "user.png", "0359265186", "2001-08-28", 1, "12434", "122134", "hn",role,1, "admin@gmail.com","dat123");
//        dao.createUserByAdmin(u);
//        System.out.println(u);
//        dao.createUser(u);
//        dao.deleteUserById(1);
//        dao.editUser(u, 2);
//dao.ChangePass("abc12344555", 2);
//        User u = dao.checkUser("abc@gmail.com", "abc");
//        System.out.println(u);
//          Major m = dao.getMajorById(1);
//          System.out.println(m);
//          LocalTime time = java.time.LocalTime.now();
//          String time1 = time.toString();
//          System.out.println(time1);
//          User u = dao.getUserById(1);
//          System.out.println(u);
//        ArrayList<User> list = dao.getAllUserByName(1,"a");
//        for (User a : list) {
//            System.out.println(a);
//        }
//    }
}
