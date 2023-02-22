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
public class Examination {
    private int ExaminationID;

    private int Doctor_In_Charge;
    private int id_user;
    private Date VisitTime;
    private String Disease_Description;
    private String Diagnose;
    private String Conclusion;
    private double TotalPrice;
    private int satatus;
    public Examination() {
    }

    public Examination(int ExaminationID, int Doctor_In_Charge, int id_user, Date VisitTime, String Disease_Description, String Diagnose, String Conclusion, double TotalPrice, int satatus) {
        this.ExaminationID = ExaminationID;
        this.Doctor_In_Charge = Doctor_In_Charge;
        this.id_user = id_user;
        this.VisitTime = VisitTime;
        this.Disease_Description = Disease_Description;
        this.Diagnose = Diagnose;
        this.Conclusion = Conclusion;
        this.TotalPrice = TotalPrice;
        this.satatus = satatus;
    }

    public Examination(int Doctor_In_Charge, int id_user, Date VisitTime, String Disease_Description, String Diagnose, String Conclusion, double TotalPrice, int satatus) {
        this.Doctor_In_Charge = Doctor_In_Charge;
        this.id_user = id_user;
        this.VisitTime = VisitTime;
        this.Disease_Description = Disease_Description;
        this.Diagnose = Diagnose;
        this.Conclusion = Conclusion;
        this.TotalPrice = TotalPrice;
        this.satatus = satatus;
    }

    public Examination(int Doctor_In_Charge, int id_user, Date VisitTime, String Disease_Description, String Diagnose, String Conclusion, double TotalPrice) {
        this.Doctor_In_Charge = Doctor_In_Charge;
        this.id_user = id_user;
        this.VisitTime = VisitTime;
        this.Disease_Description = Disease_Description;
        this.Diagnose = Diagnose;
        this.Conclusion = Conclusion;
        this.TotalPrice = TotalPrice;
    }

    public int getExaminationID() {
        return ExaminationID;
    }

    public int getId_user() {
        return id_user;
    }

    public int getSatatus() {
        return satatus;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setSatatus(int satatus) {
        this.satatus = satatus;
    }

  
    

    public int getDoctor_In_Charge() {
        return Doctor_In_Charge;
    }

    public Date getVisitTime() {
        return VisitTime;
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

    public void setExaminationID(int ExaminationID) {
        this.ExaminationID = ExaminationID;
    }


    public void setDoctor_In_Charge(int Doctor_In_Charge) {
        this.Doctor_In_Charge = Doctor_In_Charge;
    }

    public void setVisitTime(Date VisitTime) {
        this.VisitTime = VisitTime;
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
