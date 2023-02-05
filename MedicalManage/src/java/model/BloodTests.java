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
    private int BlID;
    private int Medical_Test_Id;
    private double Red_Blood_Cell;
    private double White_Blood_Cell;
    private double Platelets;
    private float Hemoglobin ;
    private float Hemattocrit ;
    private int Mean_Corpuscular_Volume;

    public BloodTests() {
    }

    public BloodTests(int BlID, int Medical_Test_Id, double Red_Blood_Cell, double White_Blood_Cell, double Platelets, float Hemoglobin, float Hemattocrit, int Mean_Corpuscular_Volume) {
        this.BlID = BlID;
        this.Medical_Test_Id = Medical_Test_Id;
        this.Red_Blood_Cell = Red_Blood_Cell;
        this.White_Blood_Cell = White_Blood_Cell;
        this.Platelets = Platelets;
        this.Hemoglobin = Hemoglobin;
        this.Hemattocrit = Hemattocrit;
        this.Mean_Corpuscular_Volume = Mean_Corpuscular_Volume;
    }

    public void setBlID(int BlID) {
        this.BlID = BlID;
    }

    public void setMedical_Test_Id(int Medical_Test_Id) {
        this.Medical_Test_Id = Medical_Test_Id;
    }

    public void setRed_Blood_Cell(double Red_Blood_Cell) {
        this.Red_Blood_Cell = Red_Blood_Cell;
    }

    public void setWhite_Blood_Cell(double White_Blood_Cell) {
        this.White_Blood_Cell = White_Blood_Cell;
    }

    public void setPlatelets(double Platelets) {
        this.Platelets = Platelets;
    }

    public void setHemoglobin(float Hemoglobin) {
        this.Hemoglobin = Hemoglobin;
    }

    public void setHemattocrit(float Hemattocrit) {
        this.Hemattocrit = Hemattocrit;
    }

    public void setMean_Corpuscular_Volume(int Mean_Corpuscular_Volume) {
        this.Mean_Corpuscular_Volume = Mean_Corpuscular_Volume;
    }

    public int getBlID() {
        return BlID;
    }

    public int getMedical_Test_Id() {
        return Medical_Test_Id;
    }

    public double getRed_Blood_Cell() {
        return Red_Blood_Cell;
    }

    public double getWhite_Blood_Cell() {
        return White_Blood_Cell;
    }

    public double getPlatelets() {
        return Platelets;
    }

    public float getHemoglobin() {
        return Hemoglobin;
    }

    public float getHemattocrit() {
        return Hemattocrit;
    }

    public int getMean_Corpuscular_Volume() {
        return Mean_Corpuscular_Volume;
    }
    public static void main(String[] args) {
        BloodTests a = new BloodTests();
      
        System.out.println(a.getBlID());
    }
}
