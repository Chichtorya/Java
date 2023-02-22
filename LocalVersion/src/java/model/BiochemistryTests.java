/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author chich
 */
public class BiochemistryTests {

    private int BioID;
    private int id_user;
    private int id_test;
    private float Fasting;
    private float pp;
    private float Urea;
    private float S_Creatinine;
    private float Sodium;
    private float Potassium;
    private float Chloride;
    private float TotalCalcium;
    private float S_Calcium;
    private float UricAcid;
    private float TotalBilirubin;
    private float AlkalinePhosphate;
    private float TotalProtein;
    private float Albumin;
    private float TotalCholesterol;
    private float Triglyceride;
    private float ADA;

    public BiochemistryTests(float Fasting, float pp, float Urea, float S_Creatinine, float Sodium, float Potassium, float Chloride, float TotalCalcium, float S_Calcium, float UricAcid, float TotalBilirubin, float AlkalinePhosphate, float TotalProtein, float Albumin, float TotalCholesterol, float Triglyceride, float ADA) {
        this.Fasting = Fasting;
        this.pp = pp;
        this.Urea = Urea;
        this.S_Creatinine = S_Creatinine;
        this.Sodium = Sodium;
        this.Potassium = Potassium;
        this.Chloride = Chloride;
        this.TotalCalcium = TotalCalcium;
        this.S_Calcium = S_Calcium;
        this.UricAcid = UricAcid;
        this.TotalBilirubin = TotalBilirubin;
        this.AlkalinePhosphate = AlkalinePhosphate;
        this.TotalProtein = TotalProtein;
        this.Albumin = Albumin;
        this.TotalCholesterol = TotalCholesterol;
        this.Triglyceride = Triglyceride;
        this.ADA = ADA;
    }

    public BiochemistryTests(int id_user, int id_test, float Fasting, float pp, float Urea, float S_Creatinine, float Sodium, float Potassium, float Chloride, float TotalCalcium, float S_Calcium, float UricAcid, float TotalBilirubin, float AlkalinePhosphate, float TotalProtein, float Albumin, float TotalCholesterol, float Triglyceride, float ADA) {
        this.id_user = id_user;
        this.id_test = id_test;
        this.Fasting = Fasting;
        this.pp = pp;
        this.Urea = Urea;
        this.S_Creatinine = S_Creatinine;
        this.Sodium = Sodium;
        this.Potassium = Potassium;
        this.Chloride = Chloride;
        this.TotalCalcium = TotalCalcium;
        this.S_Calcium = S_Calcium;
        this.UricAcid = UricAcid;
        this.TotalBilirubin = TotalBilirubin;
        this.AlkalinePhosphate = AlkalinePhosphate;
        this.TotalProtein = TotalProtein;
        this.Albumin = Albumin;
        this.TotalCholesterol = TotalCholesterol;
        this.Triglyceride = Triglyceride;
        this.ADA = ADA;
    }

    public BiochemistryTests(int BioID, int id_user, int id_test, float Fasting, float pp, float Urea, float S_Creatinine, float Sodium, float Potassium, float Chloride, float TotalCalcium, float S_Calcium, float UricAcid, float TotalBilirubin, float AlkalinePhosphate, float TotalProtein, float Albumin, float TotalCholesterol, float Triglyceride, float ADA) {
        this.BioID = BioID;
        this.id_user = id_user;
        this.id_test = id_test;
        this.Fasting = Fasting;
        this.pp = pp;
        this.Urea = Urea;
        this.S_Creatinine = S_Creatinine;
        this.Sodium = Sodium;
        this.Potassium = Potassium;
        this.Chloride = Chloride;
        this.TotalCalcium = TotalCalcium;
        this.S_Calcium = S_Calcium;
        this.UricAcid = UricAcid;
        this.TotalBilirubin = TotalBilirubin;
        this.AlkalinePhosphate = AlkalinePhosphate;
        this.TotalProtein = TotalProtein;
        this.Albumin = Albumin;
        this.TotalCholesterol = TotalCholesterol;
        this.Triglyceride = Triglyceride;
        this.ADA = ADA;
    }

    public BiochemistryTests() {
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_test(int id_test) {
        this.id_test = id_test;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_test() {
        return id_test;
    }

    public void setUser_Id(int id_user) {
        this.id_user = id_user;
    }

    public void setChloride(float Chloride) {
        this.Chloride = Chloride;
    }

    public void setS_Calcium(float S_Calcium) {
        this.S_Calcium = S_Calcium;
    }

    public float getChloride() {
        return Chloride;
    }

    public float getS_Calcium() {
        return S_Calcium;
    }

    public int getBioID() {
        return BioID;
    }

    public int getid_user() {
        return id_user;
    }

    public float getFasting() {
        return Fasting;
    }

    public float getPp() {
        return pp;
    }

    public float getUrea() {
        return Urea;
    }

    public float getS_Creatinine() {
        return S_Creatinine;
    }

    public float getSodium() {
        return Sodium;
    }

    public float getPotassium() {
        return Potassium;
    }
//
//    public float getCholoride() {
//        return Choloride;
//    }

    public float getTotalCalcium() {
        return TotalCalcium;
    }

    public float getUricAcid() {
        return UricAcid;
    }

    public float getTotalBilirubin() {
        return TotalBilirubin;
    }

    public float getAlkalinePhosphate() {
        return AlkalinePhosphate;
    }

    public float getTotalProtein() {
        return TotalProtein;
    }

    public float getAlbumin() {
        return Albumin;
    }

    public float getTotalCholesterol() {
        return TotalCholesterol;
    }

    public float getTriglyceride() {
        return Triglyceride;
    }

    public float getADA() {
        return ADA;
    }

    public void setBioID(int BioID) {
        this.BioID = BioID;
    }

    public void setid_user(int id_user) {
        this.id_user = id_user;
    }

    public void setFasting(float Fasting) {
        this.Fasting = Fasting;
    }

    public void setPp(float pp) {
        this.pp = pp;
    }

    public void setUrea(float Urea) {
        this.Urea = Urea;
    }

    public void setS_Creatinine(float S_Creatinine) {
        this.S_Creatinine = S_Creatinine;
    }

    public void setSodium(float Sodium) {
        this.Sodium = Sodium;
    }

    public void setPotassium(float Potassium) {
        this.Potassium = Potassium;
    }
//
//    public void setCholoride(float Choloride) {
//        this.Choloride = Choloride;
//    }

    public void setTotalCalcium(float TotalCalcium) {
        this.TotalCalcium = TotalCalcium;
    }

    public void setUricAcid(float UricAcid) {
        this.UricAcid = UricAcid;
    }

    public void setTotalBilirubin(float TotalBilirubin) {
        this.TotalBilirubin = TotalBilirubin;
    }

    public void setAlkalinePhosphate(float AlkalinePhosphate) {
        this.AlkalinePhosphate = AlkalinePhosphate;
    }

    public void setTotalProtein(float TotalProtein) {
        this.TotalProtein = TotalProtein;
    }

    public void setAlbumin(float Albumin) {
        this.Albumin = Albumin;
    }

    public void setTotalCholesterol(float TotalCholesterol) {
        this.TotalCholesterol = TotalCholesterol;
    }

    public void setTriglyceride(float Triglyceride) {
        this.Triglyceride = Triglyceride;
    }

    public void setADA(float ADA) {
        this.ADA = ADA;
    }

}
