/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author chich
 */
public class PatientTest {

    private int PaID;


   private int doctor;
    private String Description;
     private String Result;
    private double Price;
    private  int id_exam;


    public PatientTest() {
    }

    public PatientTest(int doctor, String Description, String Result, double Price) {
        this.doctor = doctor;
        this.Description = Description;
        this.Result = Result;
        this.Price = Price;
    }

    public PatientTest(int PaID, int doctor, String Description, String Result, double Price) {
        this.PaID = PaID;
        this.doctor = doctor;
        this.Description = Description;
        this.Result = Result;
        this.Price = Price;
    }

    public PatientTest(int doctor, String Description, String Result, double Price, int id_exam) {
        this.doctor = doctor;
        this.Description = Description;
        this.Result = Result;
        this.Price = Price;
        this.id_exam = id_exam;
    }

    public PatientTest(int PaID, int doctor, String Description, String Result, double Price, int id_exam) {
        this.PaID = PaID;
        this.doctor = doctor;
        this.Description = Description;
        this.Result = Result;
        this.Price = Price;
        this.id_exam = id_exam;
    }


    public int getPaID() {
        return PaID;
    }

    public int getId_exam() {
        return id_exam;
    }

    public void setId_exam(int id_exam) {
        this.id_exam = id_exam;
    }



 

    public int getDoctor() {
        return doctor;
    }

    public String getDescription() {
        return Description;
    }

    public String getResult() {
        return Result;
    }

    public double getPrice() {
        return Price;
    }

    public void setPaID(int PaID) {
        this.PaID = PaID;
    }


    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

   

}
