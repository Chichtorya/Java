/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author chich
 */
public class ImmunoassTest {

    private int id;
    private User id_doctor;
    private Exam id_exam;
    private float Digoxin;
    private float Estradiol;
    private float Ferritin;
    private float FolicAcid;
    private float Progesterone;
    private float Prolactin;
    private float TroponinT;
    private float Testosterone;
    private float TotalPSA;
    private String result;

    public ImmunoassTest(int id, User id_doctor, Exam id_exam, float Digoxin, float Estradiol, float Ferritin, float FolicAcid, float Progesterone, float Prolactin, float TroponinT, float Testosterone, float TotalPSA, String result) {
        this.id = id;
        this.id_doctor = id_doctor;
        this.id_exam = id_exam;
        this.Digoxin = Digoxin;
        this.Estradiol = Estradiol;
        this.Ferritin = Ferritin;
        this.FolicAcid = FolicAcid;
        this.Progesterone = Progesterone;
        this.Prolactin = Prolactin;
        this.TroponinT = TroponinT;
        this.Testosterone = Testosterone;
        this.TotalPSA = TotalPSA;
        this.result = result;
    }

    public ImmunoassTest(User id_doctor, Exam id_exam, float Digoxin, float Estradiol, float Ferritin, float FolicAcid, float Progesterone, float Prolactin, float TroponinT, float Testosterone, float TotalPSA, String result) {
        this.id_doctor = id_doctor;
        this.id_exam = id_exam;
        this.Digoxin = Digoxin;
        this.Estradiol = Estradiol;
        this.Ferritin = Ferritin;
        this.FolicAcid = FolicAcid;
        this.Progesterone = Progesterone;
        this.Prolactin = Prolactin;
        this.TroponinT = TroponinT;
        this.Testosterone = Testosterone;
        this.TotalPSA = TotalPSA;
        this.result = result;
    }

    public ImmunoassTest() {
    }

    public ImmunoassTest(int id, User id_doctor, Exam id_exam, float Digoxin, float Estradiol, float Ferritin, float FolicAcid, float Progesterone, float Prolactin, float TroponinT, float Testosterone, float TotalPSA) {
        this.id = id;
        this.id_doctor = id_doctor;
        this.id_exam = id_exam;
        this.Digoxin = Digoxin;
        this.Estradiol = Estradiol;
        this.Ferritin = Ferritin;
        this.FolicAcid = FolicAcid;
        this.Progesterone = Progesterone;
        this.Prolactin = Prolactin;
        this.TroponinT = TroponinT;
        this.Testosterone = Testosterone;
        this.TotalPSA = TotalPSA;
    }

    public ImmunoassTest(User id_doctor, Exam id_exam, float Digoxin, float Estradiol, float Ferritin, float FolicAcid, float Progesterone, float Prolactin, float TroponinT, float Testosterone, float TotalPSA) {
        this.id_doctor = id_doctor;
        this.id_exam = id_exam;
        this.Digoxin = Digoxin;
        this.Estradiol = Estradiol;
        this.Ferritin = Ferritin;
        this.FolicAcid = FolicAcid;
        this.Progesterone = Progesterone;
        this.Prolactin = Prolactin;
        this.TroponinT = TroponinT;
        this.Testosterone = Testosterone;
        this.TotalPSA = TotalPSA;
    }

    @Override
    public String toString() {
        return "ImmunoassTest{" + "id=" + id + ", id_doctor=" + id_doctor + ", id_exam=" + id_exam + ", Digoxin=" + Digoxin + ", Estradiol=" + Estradiol + ", Ferritin=" + Ferritin + ", FolicAcid=" + FolicAcid + ", Progesterone=" + Progesterone + ", Prolactin=" + Prolactin + ", TroponinT=" + TroponinT + ", Testosterone=" + Testosterone + ", TotalPSA=" + TotalPSA + ", result=" + result + '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public float getDigoxin() {
        return Digoxin;
    }

    public void setDigoxin(float Digoxin) {
        this.Digoxin = Digoxin;
    }

    public float getEstradiol() {
        return Estradiol;
    }

    public void setEstradiol(float Estradiol) {
        this.Estradiol = Estradiol;
    }

    public float getFerritin() {
        return Ferritin;
    }

    public void setFerritin(float Ferritin) {
        this.Ferritin = Ferritin;
    }

    public float getFolicAcid() {
        return FolicAcid;
    }

    public void setFolicAcid(float FolicAcid) {
        this.FolicAcid = FolicAcid;
    }

    public float getProgesterone() {
        return Progesterone;
    }

    public void setProgesterone(float Progesterone) {
        this.Progesterone = Progesterone;
    }

    public float getProlactin() {
        return Prolactin;
    }

    public void setProlactin(float Prolactin) {
        this.Prolactin = Prolactin;
    }

    public float getTroponinT() {
        return TroponinT;
    }

    public void setTroponinT(float TroponinT) {
        this.TroponinT = TroponinT;
    }

    public float getTestosterone() {
        return Testosterone;
    }

    public void setTestosterone(float Testosterone) {
        this.Testosterone = Testosterone;
    }

    public float getTotalPSA() {
        return TotalPSA;
    }

    public void setTotalPSA(float TotalPSA) {
        this.TotalPSA = TotalPSA;
    }

}
