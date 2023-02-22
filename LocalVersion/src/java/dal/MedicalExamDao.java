/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DbContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Examination;
import java.sql.Date;
import java.sql.Statement;
import java.util.List;
import model.BloodTests;

/**
 *
 * @author chich
 */
public class MedicalExamDao extends DbContext {

    public void newMedicalExam(Examination exam) {
        String sql = "INSERT INTO examination values(0,?,?,?,?,?,?,?,?) ;;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, exam.getDoctor_In_Charge());
            st.setInt(2, exam.getId_user());
            st.setDate(3, new java.sql.Date(exam.getVisitTime().getTime()));

            st.setString(4, exam.getDisease_Description());
            st.setString(5, exam.getDiagnose());
            st.setString(6, exam.getConclusion());
            st.setDouble(7, exam.getTotalPrice());
            st.setInt(8, exam.getSatatus());
         

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    // not fix
//     public int deleteMedicalExam(Examination ME) {
//        String sql = "delete from examination where Medical_Recod_id= ? and Id = ? ;";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, ME.getMedicalRecodID());
//            st.setInt(2, ME.getMedicalRqecodID());
//            return st.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return 0;
//    }
    //not fix

    public void UpdateMedicalExam(Examination exam) {
        String sql = "UPDATE examination SET Doctor_In_Charge = ?, Visit_Time = ?,Id_user= ?,Disease_Description= ?,Diagnose= ?,Conclusion= ?, Total_Test_Price = ? status = ? where id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, exam.getDoctor_In_Charge());
            statement.setDate(2, new java.sql.Date(exam.getVisitTime().getTime()));
            statement.setInt(3, exam.getId_user());
    
            statement.setString(4, exam.getDisease_Description());
            statement.setString(5, exam.getDiagnose());
            statement.setString(6, exam.getConclusion());
            statement.setDouble(7, exam.getTotalPrice());
            statement.setInt(8, exam.getSatatus());
            statement.setInt(9, exam.getExaminationID());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void delete(int id) {
        String sql = "DELETE FROM examination WHERE id = ?";
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Examination get(int id) {
        String sql = "SELECT * FROM Examination WHERE id = ?";
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Examination exam = new Examination();
                exam.setExaminationID(resultSet.getInt("id"));

                exam.setDoctor_In_Charge(resultSet.getInt("Doctor_In_Charge"));
                exam.setId_user(resultSet.getInt("id_user"));
                exam.setVisitTime(resultSet.getDate("VisitTime"));
         
                exam.setDisease_Description(resultSet.getString("Disease_Description"));
                exam.setDiagnose(resultSet.getString("Diagnose"));
                exam.setConclusion(resultSet.getString("Conclusion"));
                exam.setTotalPrice(resultSet.getDouble("TotalPrice"));
                exam.setSatatus(resultSet.getInt("status"));
                return exam;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // Get a list of all Examination records from the database

    public List<Examination> getAll() {
        List<Examination> exams = new ArrayList<>();
        String sql = "SELECT * FROM Examination";
        try (
                 Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Examination exam = new Examination();
               exam.setExaminationID(resultSet.getInt("id"));

                exam.setDoctor_In_Charge(resultSet.getInt("Doctor_In_Charge"));
                exam.setId_user(resultSet.getInt("id_user"));
                exam.setVisitTime(resultSet.getDate("VisitTime"));
         
                exam.setDisease_Description(resultSet.getString("Disease_Description"));
                exam.setDiagnose(resultSet.getString("Diagnose"));
                exam.setConclusion(resultSet.getString("Conclusion"));
                exam.setTotalPrice(resultSet.getDouble("TotalPrice"));
                exam.setSatatus(resultSet.getInt("status"));
                exams.add(exam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }
       public  int getLatestExaminationIdForUser(int userId) {
     
        int examinationId = -1;

        try {
            // create a connection to the database
        
            // prepare a statement to retrieve the latest examination ID for the specified user
    PreparedStatement st      = connection.prepareStatement("SELECT id FROM Examination WHERE id_user = ? ORDER BY id DESC LIMIT 1");
            st.setInt(1, userId);

            // execute the query and retrieve the result set
           ResultSet resultSe = st.executeQuery();

            // if the result set contains a row, get the examination ID from the row
            if (resultSe.next()) {
                examinationId = resultSe.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return examinationId;
    }
       public static void main(String[] args) {
        MedicalExamDao d = new MedicalExamDao();
           System.out.println(d.getLatestExaminationIdForUser(28));
    }

}


