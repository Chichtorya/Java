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
    private int Medical_Test_Id;

    private String Doctor;
    private String Description;

    private double Price;

    public PatientTest(int Medical_Test_Id, String Doctor, String Description, double Price) {
        this.Medical_Test_Id = Medical_Test_Id;
        this.Doctor = Doctor;
        this.Description = Description;
        this.Price = Price;
    }

    public PatientTest(int PaID, int Medical_Test_Id, String Doctor, String Description, double Price) {
        this.PaID = PaID;
        this.Medical_Test_Id = Medical_Test_Id;

        this.Doctor = Doctor;
        this.Description = Description;

        this.Price = Price;
    }

    public void setPaID(int PaID) {
        this.PaID = PaID;
    }

    public int getPaID() {
        return PaID;
    }

    public PatientTest() {
    }

    public int getMedical_Test_Id() {
        return Medical_Test_Id;
    }

    public String getDoctor() {
        return Doctor;
    }

    public String getDescription() {
        return Description;
    }

    public double getPrice() {
        return Price;
    }

    public void setMedical_Test_Id(int Medical_Test_Id) {
        this.Medical_Test_Id = Medical_Test_Id;
    }

    public void setDoctor(String Doctor) {
        this.Doctor = Doctor;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "PatientTest{" + "Medical_Test_Id=" + Medical_Test_Id + ", Doctor=" + Doctor + ", Description=" + Description + ", Price=" + Price + '}';
    }

}
