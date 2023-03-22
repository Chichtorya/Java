/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Exam;

/**
 *
 * @author dell
 */
public class ExamDAO extends DbContext {

    public void updateExam(int id_bio, int id_blo, int id_immu, int id) {
        String sql = "update Examination set id_bio = ? , id_blood = ? , id_immu = ? where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_bio);
            st.setInt(2, id_blo);
            st.setInt(3, id_immu);
            st.setInt(4, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
     public void UpdateExamToComplete(Exam exam,int id) {
        String sql = "update examination set Disease_Description = ?"
                + " ,Diagnose = ? ,Conclusion = ?, status = 1 where id = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(4,id);
            st.setString(1, exam.getDescription());
            st.setString(2, exam.getDiagnose());
            st.setString(3, exam.getConclusion());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public Exam getExamById(int id) {
        UserDAO dao = new UserDAO();
        String sql = "select * from Examination where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Exam(rs.getInt("id"),
                        dao.getUserById(rs.getInt("Doctor_In_Charge")),
                        dao.getUserById(rs.getInt("id_user")),
                        rs.getInt("id_bio"),
                        rs.getInt("id_blood"),
                        rs.getInt("id_immu"),
                        rs.getString("Visit_Time"),
                        rs.getString("Disease_Description"),
                        rs.getString("Diagnose"),
                        rs.getString("Conclusion"),
                        rs.getFloat("Total_Test_Price"),
                        rs.getInt("status"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int createExam(Exam e) {
        String sql = "INSERT INTO Examination \n"
                + "(Doctor_In_Charge, id_user, id_bio, id_blood, id_immu, Visit_Time,\n"
                + " Disease_Description, Diagnose, Conclusion, status) VALUES\n"
                + " (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, e.getId_doctor().getId());
            ps.setInt(2, e.getId_patient().getId());
            ps.setInt(3, e.getId_bio());
            ps.setInt(4, e.getId_blood());
            ps.setInt(5, e.getId_immu());
            ps.setString(6, e.getTime());
            ps.setString(7, e.getDescription());
            ps.setString(8, e.getDiagnose());
            ps.setString(9, e.getConclusion());
            ps.setInt(10, e.getStatus());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException s) {
            System.out.println(s);
        }
        return -1;
    }

    public void UpdateMoney(float total, int exam) {
        String sql = "update Examination set Total_Test_Price = ? where id = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setFloat(1, total);
            st.setInt(2, exam);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void UpdateStatus(int status, int id) {
        String sql = "update Examination set status = ? where id = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, status);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Float getMoney(Exam e) {
        ScheduleDAO sdao = new ScheduleDAO();
        float totalMoney = 0;
        if (e.getId_bio() == 1) {
            totalMoney += sdao.getTypeTestById(1).getPrice();
        }
        if (e.getId_blood() == 1) {
            totalMoney += sdao.getTypeTestById(2).getPrice();
        }
        if (e.getId_immu() == 1) {
            totalMoney += sdao.getTypeTestById(3).getPrice();
        }
        return totalMoney;
    }

    public ArrayList<Exam> getAllExam() {
        UserDAO dao = new UserDAO();
        ArrayList<Exam> list = new ArrayList<>();
        String sql = "select * from Examination ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Exam(rs.getInt("id"),
                        dao.getUserById(rs.getInt("Doctor_In_Charge")),
                        dao.getUserById(rs.getInt("id_user")),
                        rs.getInt("id_bio"),
                        rs.getInt("id_blood"),
                        rs.getInt("id_immu"),
                        rs.getString("Visit_Time"),
                        rs.getString("Disease_Description"),
                        rs.getString("Diagnose"),
                        rs.getString("Conclusion"),
                        rs.getFloat("Total_Test_Price"),
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Exam> getAllExamByDoctorAndStatus() {
        UserDAO dao = new UserDAO();
        ArrayList<Exam> list = new ArrayList<>();
        String sql = "select * from Examination where id_doctor = ? and status = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Exam(rs.getInt("id"),
                        dao.getUserById(rs.getInt("Doctor_In_Charge")),
                        dao.getUserById(rs.getInt("id_user")),
                        rs.getInt("id_bio"),
                        rs.getInt("id_blood"),
                        rs.getInt("id_immu"),
                        rs.getString("Visit_Time"),
                        rs.getString("Disease_Description"),
                        rs.getString("Diagnose"),
                        rs.getString("Conclusion"),
                        rs.getFloat("Total_Test_Price"),
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Exam> getAllExamByUser(int id, int status) {
        UserDAO dao = new UserDAO();
        ArrayList<Exam> list = new ArrayList<>();
        String sql = "select * from Examination where id_user = ? and status = ? order by Visit_Time desc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Exam(rs.getInt("id"),
                        dao.getUserById(rs.getInt("Doctor_In_Charge")),
                        dao.getUserById(rs.getInt("id_user")),
                        rs.getInt("id_bio"),
                        rs.getInt("id_blood"),
                        rs.getInt("id_immu"),
                        rs.getString("Visit_Time"),
                        rs.getString("Disease_Description"),
                        rs.getString("Diagnose"),
                        rs.getString("Conclusion"),
                        rs.getFloat("Total_Test_Price"),
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        ExamDAO dao = new ExamDAO();
//     Exam e = dao.getExamById(2);
//        System.out.println(e);
        int bio1 = 0, blood1 = 0, immu1 = 0;
        int[] x = {1, 2};
        for (int a : x) {
            if (a == 1) {
                bio1 = 1;
            }
            if (a == 2) {
                blood1 = 1;
            }
            if (a == 3) {
                immu1 = 1;
            }

        }
        System.out.println(bio1 +","+blood1+","+immu1);
    }
}
