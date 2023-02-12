/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author chich
 */
public class MedicalExam {
    private int MedicalExamID;
    private int MedicalRecodID;
    private int Doctor_In_Charge;
    private Date VisitTime;
    private boolean IsTest;
    private String Disease_Description;
    private String Diagnose;
    private String Conclusion;
    private double TotalPrice;

    public MedicalExam() {
    }

    public MedicalExam(int MedicalRecodID, int Doctor_In_Charge, Date VisitTime, boolean IsTest, String Disease_Description, String Diagnose, String Conclusion, double TotalPrice) {
        this.MedicalRecodID = MedicalRecodID;
        this.Doctor_In_Charge = Doctor_In_Charge;
        this.VisitTime = VisitTime;
        this.IsTest = IsTest;
        this.Disease_Description = Disease_Description;
        this.Diagnose = Diagnose;
        this.Conclusion = Conclusion;
        this.TotalPrice = TotalPrice;
    }

    public MedicalExam(int MedicalExamID, int MedicalRecodID, int Doctor_In_Charge, Date VisitTime, boolean IsTest, String Disease_Description, String Diagnose, String Conclusion, double TotalPrice) {
        this.MedicalExamID = MedicalExamID;
        this.MedicalRecodID = MedicalRecodID;
        this.Doctor_In_Charge = Doctor_In_Charge;
        this.VisitTime = VisitTime;
        this.IsTest = IsTest;
        this.Disease_Description = Disease_Description;
        this.Diagnose = Diagnose;
        this.Conclusion = Conclusion;
        this.TotalPrice = TotalPrice;
    }

    public int getMedicalExamID() {
        return MedicalExamID;
    }

    public int getMedicalRecodID() {
        return MedicalRecodID;
    }

    public int getDoctor_In_Charge() {
        return Doctor_In_Charge;
    }

    public Date getVisitTime() {
        return VisitTime;
    }

    public boolean IsTests() {
        return IsTest;
    }

    public String getDisease_Description() {
        return Disease_Description;
    }

    public String getDiagnose() {
        return Diagnose;
    }

    public String getConclusion() {
        return Conclusion;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setMedicalExamID(int MedicalExamID) {
        this.MedicalExamID = MedicalExamID;
    }

    public void setMedicalRecodID(int MedicalRecodID) {
        this.MedicalRecodID = MedicalRecodID;
    }

    public void setDoctor_In_Charge(int Doctor_In_Charge) {
        this.Doctor_In_Charge = Doctor_In_Charge;
    }

    public void setVisitTime(Date VisitTime) {
        this.VisitTime = VisitTime;
    }

    public void setIsTest(boolean IsTest) {
        this.IsTest = IsTest;
    }

    public void setDisease_Description(String Disease_Description) {
        this.Disease_Description = Disease_Description;
    }

    public void setDiagnose(String Diagnose) {
        this.Diagnose = Diagnose;
    }

    public void setConclusion(String Conclusion) {
        this.Conclusion = Conclusion;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    
    
}
