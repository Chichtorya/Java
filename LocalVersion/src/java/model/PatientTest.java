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
    private int user_Id;
    private int Id_bio;
    private int Id_blood;
    private int Id_Immu;
   private int doctor;
    private String Description;
     private String Result;
    private double Price;

    public PatientTest(int user_Id, int doctor, String Description, String Result, double Price) {
        this.user_Id = user_Id;
        this.doctor = doctor;
        this.Description = Description;
        this.Result = Result;
        this.Price = Price;
    }

    public PatientTest() {
    }

    public PatientTest(int user_Id, int Id_bio, int Id_blood, int Id_Immu, int doctor, String Description, String Result, double Price) {
        this.user_Id = user_Id;
        this.Id_bio = Id_bio;
        this.Id_blood = Id_blood;
        this.Id_Immu = Id_Immu;
        this.doctor = doctor;
        this.Description = Description;
        this.Result = Result;
        this.Price = Price;
    }

    public PatientTest(int PaID, int user_Id, int Id_bio, int Id_blood, int Id_Immu, int doctor, String Description, String Result, double Price) {
        this.PaID = PaID;
        this.user_Id = user_Id;
        this.Id_bio = Id_bio;
        this.Id_blood = Id_blood;
        this.Id_Immu = Id_Immu;
        this.doctor = doctor;
        this.Description = Description;
        this.Result = Result;
        this.Price = Price;
    }

    public int getPaID() {
        return PaID;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public int getId_bio() {
        return Id_bio;
    }

    public int getId_blood() {
        return Id_blood;
    }

    public int getId_Immu() {
        return Id_Immu;
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

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public void setId_bio(int Id_bio) {
        this.Id_bio = Id_bio;
    }

    public void setId_blood(int Id_blood) {
        this.Id_blood = Id_blood;
    }

    public void setId_Immu(int Id_Immu) {
        this.Id_Immu = Id_Immu;
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
