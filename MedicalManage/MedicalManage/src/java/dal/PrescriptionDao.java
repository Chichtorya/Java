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
import java.util.List;
import model.Prescription;

public class PrescriptionDao extends DbContext {

    public String addPrescription(Prescription prescription) {
        String sql = "INSERT INTO Prescription_Detail (exam_id, drug_name, dosage, note) VALUES (?, ?, ?, ?)";
        try {

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, prescription.getExamId());
            statement.setString(2, prescription.getDrugName());
            statement.setString(3, prescription.getDosage());
            statement.setString(4, prescription.getNote());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                return "Failed to insert Prescription";
            }

            try ( ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    prescription.setId(generatedKeys.getInt(1));
                    return "Success";
                } else {
                    return ("Failed to retrieve ID for Prescription");
                }
            }

        } catch (Exception e) {
            return e.toString();
        }

    }

    // Update an existing Prescription in the database
    public String updatePrescription(Prescription prescription) throws SQLException {
        String sql = "UPDATE Prescription_Detail SET exam_id = ?, drug_name = ?, dosage = ?, note = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, prescription.getExamId());
        statement.setString(2, prescription.getDrugName());
        statement.setString(3, prescription.getDosage());
        statement.setString(4, prescription.getNote());
        statement.setInt(5, prescription.getId());
        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            return ("Failed to update Prescription");
        }
        return "Success";
    }

    // Delete an existing Prescription from the database
    public String deletePrescription(Prescription prescription) throws SQLException {
        String sql = "DELETE FROM Prescription_Detail WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, prescription.getId());
        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            return ("Failed to delete Prescription");
        }
        return "Success";
    }

    // Retrieve all Prescriptions from the database
    public ArrayList<Prescription> getAllPrescriptions(int id) throws SQLException {
        String sql = "SELECT * FROM Prescription_Detail where Exam_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Prescription> prescriptions = new ArrayList<>();

        while (resultSet.next()) {
            Prescription prescription = new Prescription();
            prescription.setId(resultSet.getInt("id"));
            prescription.setExamId(resultSet.getInt("exam_id"));
            prescription.setDrugName(resultSet.getString("drug_name"));
            prescription.setDosage(resultSet.getString("dosage"));
            prescription.setNote(resultSet.getString("note"));
            prescriptions.add(prescription);
        }

        return prescriptions;
    }

    // Retrieve a single Prescription by ID from the database
    public Prescription getPrescriptionByIdExam(int id) throws SQLException {
        String sql = "SELECT * FROM Prescription_Detail WHERE exam_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Prescription prescription = new Prescription();
            prescription.setId(resultSet.getInt("id"));
            prescription.setExamId(resultSet.getInt("exam_id"));
            prescription.setDrugName(resultSet.getString("drug_name"));
            prescription.setDosage(resultSet.getString("dosage"));
            prescription.setNote(resultSet.getString("note"));
            return prescription;
        }

        return null;
    }

    public static void main(String[] args) {
        PrescriptionDao a = new PrescriptionDao();
        Prescription prescription = new Prescription();
        prescription.setId(1);
        prescription.setExamId(12);
        prescription.setDrugName("Aspirin");
        prescription.setDosage("100 mg");
        prescription.setNote("Take with food");
        String mess = a.addPrescription(prescription);
        System.out.println(mess);

    }
}
