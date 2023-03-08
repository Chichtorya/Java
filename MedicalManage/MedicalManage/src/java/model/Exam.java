/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dell
 */
public class Exam {
    private int id ;
    private User id_doctor ;
    private User id_patient;
    private int id_bio ;
    private int id_blood ;
    private int id_immu ;
    private String time  ;
    private String description;
    private String diagnose;
    private String conclusion ;
    private float totalPrice;
    private int status ;

    public Exam() {
    }

    public Exam(int id, User id_doctor, User id_patient, int id_bio, int id_blood, int id_immu, String time, String description, String diagnose, String conclusion, float totalPrice, int status) {
        this.id = id;
        this.id_doctor = id_doctor;
        this.id_patient = id_patient;
        this.id_bio = id_bio;
        this.id_blood = id_blood;
        this.id_immu = id_immu;
        this.time = time;
        this.description = description;
        this.diagnose = diagnose;
        this.conclusion = conclusion;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    public Exam( User id_doctor, User id_patient, int id_bio, int id_blood, int id_immu, String time, String description, String diagnose, String conclusion, float totalPrice, int status) {
        this.id_doctor = id_doctor;
        this.id_patient = id_patient;
        this.id_bio = id_bio;
        this.id_blood = id_blood;
        this.id_immu = id_immu;
        this.time = time;
        this.description = description;
        this.diagnose = diagnose;
        this.conclusion = conclusion;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    public Exam( User id_doctor, User id_patient, int id_bio, int id_blood, int id_immu, String time, String description, String diagnose, String conclusion, int status) {
        this.id_doctor = id_doctor;
        this.id_patient = id_patient;
        this.id_bio = id_bio;
        this.id_blood = id_blood;
        this.id_immu = id_immu;
        this.time = time;
        this.description = description;
        this.diagnose = diagnose;
        this.conclusion = conclusion;
        this.status = status;
    }
    public Exam( User id_doctor, User id_patient, String time, String description, String diagnose, String conclusion, int status) {
        this.id_doctor = id_doctor;
        this.id_patient = id_patient;
        this.time = time;
        this.description = description;
        this.diagnose = diagnose;
        this.conclusion = conclusion;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Exam{" + "id=" + id + ", id_doctor=" + id_doctor + ", id_patient=" + id_patient + ", id_bio=" + id_bio + ", id_blood=" + id_blood + ", id_immu=" + id_immu + ", time=" + time + ", description=" + description + ", diagnose=" + diagnose + ", conclusion=" + conclusion + ", totalPrice=" + totalPrice + ", status=" + status + '}';
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

    public User getId_patient() {
        return id_patient;
    }

    public void setId_patient(User id_patient) {
        this.id_patient = id_patient;
    }

    public int getId_bio() {
        return id_bio;
    }

    public void setId_bio(int id_bio) {
        this.id_bio = id_bio;
    }

    public int getId_blood() {
        return id_blood;
    }

    public void setId_blood(int id_blood) {
        this.id_blood = id_blood;
    }

    public int getId_immu() {
        return id_immu;
    }

    public void setId_immu(int id_immu) {
        this.id_immu = id_immu;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
   
    

    
}
