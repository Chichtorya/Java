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
import model.MedicalExam;
import java.sql.Date;
import model.BloodTests;
/**
 *
 * @author chich
 */
public class MedicalExamDao extends DbContext{
    public void newMedicalExam(MedicalExam ME){
            String sql = "INSERT INTO Medical_Examination values(0,?,?,?,?,?,?,?,?) ;;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
        
            st.setInt(1, ME.getMedicalRecodID());
            st.setInt(2, ME.getDoctor_In_Charge());
            st.setDate(3, new Date(ME.getVisitTime().getTime()));
            st.setBoolean(4, ME.IsTests());
            st.setString(5, ME.getDisease_Description());
            st.setString(6, ME.getDiagnose());
            st.setString(7, ME.getConclusion());
            st.setDouble(8, ME.getTotalPrice());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
     public int deleteMedicalExam(MedicalExam ME) {
        String sql = "delete from Medical_Examination where Medical_Recod_id= ? and Id = ? ;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, ME.getMedicalRecodID());
            st.setInt(2, ME.getMedicalExamID());
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public void UpdateMedicalExam(MedicalExam ME) {
        String sql = "UPDATE Medical_Examination SET Doctor_In_Charge = ?, Visit_Time = ?,Is_Test= ?,Disease_Description= ?,Diagnose= ?,Conclusion= ?, Total_Test_Price = ? WHERE Medical_Recod_id = ? and Id = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(9, ME.getMedicalExamID());
            st.setInt(8, ME.getMedicalRecodID());
      
            st.setInt(1, ME.getDoctor_In_Charge());
            st.setDate(2, new Date(ME.getVisitTime().getTime()));
            st.setBoolean(3, ME.IsTests());
            st.setString(4, ME.getDisease_Description());
            st.setString(5, ME.getDiagnose());
            st.setString(6, ME.getConclusion());
            st.setDouble(7, ME.getTotalPrice());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
