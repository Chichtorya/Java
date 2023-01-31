/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dao.MySQLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Patien_Info;

/**
 *
 * @author dell
 */
public class PatientDAO extends MySQLConnection {

    public ArrayList<Patien_Info> getAllPatient() {
        ArrayList<Patien_Info> list = new ArrayList<>();
        String sql = "select * from Patien_Info";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Patien_Info(rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("Citizen_Identity_Id"),
                        rs.getString("Health_Insurance_Id"),
                        rs.getString("Phone_Number"),
                        rs.getString("Date_Of_Birth"),
                        rs.getString("Gender"),
                        rs.getString("Address")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean checkPhone(String phone) {
        ArrayList<Patien_Info> list = getAllPatient();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhone_Number().equals(phone)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkCitizenId(String citizenId) {
        ArrayList<Patien_Info> list = getAllPatient();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCitizen_Identity_Id().equals(citizenId)) {
                return false;
            }
        }
        return true;
    }

    public Patien_Info getPatientById(int id) {
        ArrayList<Patien_Info> list = getAllPatient();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return list.get(i);
            }
        }
        return null;
    }

    public void createPatient(Patien_Info pro) {
        String sql = "insert into Patien_Info (`name`, `Citizen_Identity_Id`, `Health_Insurance_Id`, `Phone_Number`, `Date_Of_Birth`, `Gender`, `Address`) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pro.getName());
            ps.setString(2, pro.getCitizen_Identity_Id());
            ps.setString(3, pro.getHealth_Insurance_Id());
            ps.setString(4, pro.getPhone_Number());
            ps.setString(5, pro.getDate_Of_Birth());
            ps.setString(6, pro.getGender());
            ps.setString(7, pro.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deletePatientById(int id) {
        try {
            String sql = "delete from Patien_Info where Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Patien_Info> getAllPatientByName(String name1) {
        ArrayList<Patien_Info> list = new ArrayList<>();
        String sql = "select * from Patien_Info where name like '%" + name1 + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Patien_Info(rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("Citizen_Identity_Id"),
                        rs.getString("Health_Insurance_Id"),
                        rs.getString("Phone_Number"),
                        rs.getString("Date_Of_Birth"),
                        rs.getString("Gender"),
                        rs.getString("Address")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void editPatient(Patien_Info pro,int id) {
        String spl = "UPDATE Patien_Info set name = ?,Citizen_Identity_Id = ?,Health_Insurance_Id= ?, Phone_Number = ? ,Date_Of_Birth= ? ,Gender = ? ,Address = ? where Id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(spl);
            ps.setInt(8, id);
            ps.setString(1, pro.getName());
            ps.setString(2, pro.getCitizen_Identity_Id());
            ps.setString(3, pro.getHealth_Insurance_Id());
            ps.setString(4, pro.getPhone_Number());
            ps.setString(5, pro.getDate_Of_Birth());
            ps.setString(6, pro.getGender());
            ps.setString(7, pro.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        PatientDAO dao = new PatientDAO();
//        dao.deletePatientById(1);
//        dao.createPatient(pro);
//        ArrayList<Patien_Info> list = dao.getAllPatient();
//        for (Patien_Info a : list) {
//            System.out.println(a);
//        }
        String phone = "2312443";
        System.out.println(dao.checkPhone(phone));
    }
}
