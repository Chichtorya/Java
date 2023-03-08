/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author chich
 */
public class BloodTests {
    private int id;
    private User id_doctor;
    private Exam id_exam;
    private float Red_Blood_Cell;
    private float White_Blood_Cell;
    private float Platelets;
    private float Hemoglobin ;
    private float Hemattocrit ;
    private int Mean_Corpuscular_Volume;
    private String result;

    public BloodTests() {
    }

    public BloodTests(int id, User id_doctor, Exam id_exam, float Red_Blood_Cell, float White_Blood_Cell, float Platelets, float Hemoglobin, float Hemattocrit, int Mean_Corpuscular_Volume, String result) {
        this.id = id;
        this.id_doctor = id_doctor;
        this.id_exam = id_exam;
        this.Red_Blood_Cell = Red_Blood_Cell;
        this.White_Blood_Cell = White_Blood_Cell;
        this.Platelets = Platelets;
        this.Hemoglobin = Hemoglobin;
        this.Hemattocrit = Hemattocrit;
        this.Mean_Corpuscular_Volume = Mean_Corpuscular_Volume;
        this.result = result;
    }
    public BloodTests( User id_doctor, Exam id_exam, float Red_Blood_Cell, float White_Blood_Cell, float Platelets, float Hemoglobin, float Hemattocrit, int Mean_Corpuscular_Volume, String result) {
        this.id_doctor = id_doctor;
        this.id_exam = id_exam;
        this.Red_Blood_Cell = Red_Blood_Cell;
        this.White_Blood_Cell = White_Blood_Cell;
        this.Platelets = Platelets;
        this.Hemoglobin = Hemoglobin;
        this.Hemattocrit = Hemattocrit;
        this.Mean_Corpuscular_Volume = Mean_Corpuscular_Volume;
        this.result = result;
    }

    public BloodTests(int id, User id_doctor, Exam id_exam, float Red_Blood_Cell, float White_Blood_Cell, float Platelets, float Hemoglobin, float Hemattocrit, int Mean_Corpuscular_Volume) {
        this.id = id;
        this.id_doctor = id_doctor;
        this.id_exam = id_exam;
        this.Red_Blood_Cell = Red_Blood_Cell;
        this.White_Blood_Cell = White_Blood_Cell;
        this.Platelets = Platelets;
        this.Hemoglobin = Hemoglobin;
        this.Hemattocrit = Hemattocrit;
        this.Mean_Corpuscular_Volume = Mean_Corpuscular_Volume;
    }
    public BloodTests( User id_doctor, Exam id_exam, float Red_Blood_Cell, float White_Blood_Cell, float Platelets, float Hemoglobin, float Hemattocrit, int Mean_Corpuscular_Volume) {
        this.id_doctor = id_doctor;
        this.id_exam = id_exam;
        this.Red_Blood_Cell = Red_Blood_Cell;
        this.White_Blood_Cell = White_Blood_Cell;
        this.Platelets = Platelets;
        this.Hemoglobin = Hemoglobin;
        this.Hemattocrit = Hemattocrit;
        this.Mean_Corpuscular_Volume = Mean_Corpuscular_Volume;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BloodTests{" + "id=" + id + ", id_doctor=" + id_doctor + ", id_exam=" + id_exam + ", Red_Blood_Cell=" + Red_Blood_Cell + ", White_Blood_Cell=" + White_Blood_Cell + ", Platelets=" + Platelets + ", Hemoglobin=" + Hemoglobin + ", Hemattocrit=" + Hemattocrit + ", Mean_Corpuscular_Volume=" + Mean_Corpuscular_Volume + ", result=" + result + '}';
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(User id_doctor) {
        this.id_doctor = id_doctor;
    }

    public Exam getId_exam() {
        return id_exam;
    }

    public void setId_exam(Exam id_exam) {
        this.id_exam = id_exam;
    }

    public float getRed_Blood_Cell() {
        return Red_Blood_Cell;
    }

    public void setRed_Blood_Cell(float Red_Blood_Cell) {
        this.Red_Blood_Cell = Red_Blood_Cell;
    }

    public float getWhite_Blood_Cell() {
        return White_Blood_Cell;
    }

    public void setWhite_Blood_Cell(float White_Blood_Cell) {
        this.White_Blood_Cell = White_Blood_Cell;
    }

    public float getPlatelets() {
        return Platelets;
    }

    public void setPlatelets(float Platelets) {
        this.Platelets = Platelets;
    }

    public float getHemoglobin() {
        return Hemoglobin;
    }

    public void setHemoglobin(float Hemoglobin) {
        this.Hemoglobin = Hemoglobin;
    }

    public float getHemattocrit() {
        return Hemattocrit;
    }

    public void setHemattocrit(float Hemattocrit) {
        this.Hemattocrit = Hemattocrit;
    }

    public int getMean_Corpuscular_Volume() {
        return Mean_Corpuscular_Volume;
    }

    public void setMean_Corpuscular_Volume(int Mean_Corpuscular_Volume) {
        this.Mean_Corpuscular_Volume = Mean_Corpuscular_Volume;
    }
    

}
