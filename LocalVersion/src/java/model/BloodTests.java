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
    private int id_user;
    private int id_test;
    private float Red_Blood_Cell;
    private float White_Blood_Cell;
    private float Platelets;
    private float Hemoglobin ;
    private float Hemattocrit ;
    private int Mean_Corpuscular_Volume;

    public BloodTests() {
    }

    public BloodTests(int BlID, int id_user, int id_test, float Red_Blood_Cell, float White_Blood_Cell, float Platelets, float Hemoglobin, float Hemattocrit, int Mean_Corpuscular_Volume) {
        this.BlID = BlID;
        this.id_user = id_user;
        this.id_test = id_test;
        this.Red_Blood_Cell = Red_Blood_Cell;
        this.White_Blood_Cell = White_Blood_Cell;
        this.Platelets = Platelets;
        this.Hemoglobin = Hemoglobin;
        this.Hemattocrit = Hemattocrit;
        this.Mean_Corpuscular_Volume = Mean_Corpuscular_Volume;
    }

    public BloodTests(float Red_Blood_Cell, float White_Blood_Cell, float Platelets, float Hemoglobin, float Hemattocrit, int Mean_Corpuscular_Volume) {
        this.Red_Blood_Cell = Red_Blood_Cell;
        this.White_Blood_Cell = White_Blood_Cell;
        this.Platelets = Platelets;
        this.Hemoglobin = Hemoglobin;
        this.Hemattocrit = Hemattocrit;
        this.Mean_Corpuscular_Volume = Mean_Corpuscular_Volume;
    }

    public BloodTests(int id_user, int id_test, float Red_Blood_Cell, float White_Blood_Cell, float Platelets, float Hemoglobin, float Hemattocrit, int Mean_Corpuscular_Volume) {
        this.id_user = id_user;
        this.id_test = id_test;
        this.Red_Blood_Cell = Red_Blood_Cell;
        this.White_Blood_Cell = White_Blood_Cell;
        this.Platelets = Platelets;
        this.Hemoglobin = Hemoglobin;
        this.Hemattocrit = Hemattocrit;
        this.Mean_Corpuscular_Volume = Mean_Corpuscular_Volume;
    }
   



    public int getId_user() {
        return id_user;
    }

    public int getId_test() {
        return id_test;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_test(int id_test) {
        this.id_test = id_test;
    }

  

 

    public void setBlID(int BlID) {
        this.BlID = BlID;
    }

    public void setid_user(int id_user) {
        this.id_user = id_user;
    }

    public void setRed_Blood_Cell(float Red_Blood_Cell) {
        this.Red_Blood_Cell = Red_Blood_Cell;
    }

    public void setWhite_Blood_Cell(float White_Blood_Cell) {
        this.White_Blood_Cell = White_Blood_Cell;
    }

    public void setPlatelets(float Platelets) {
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

    public int getid_user() {
        return id_user;
    }

    public float getRed_Blood_Cell() {
        return Red_Blood_Cell;
    }

    public float getWhite_Blood_Cell() {
        return White_Blood_Cell;
    }

    public float getPlatelets() {
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
