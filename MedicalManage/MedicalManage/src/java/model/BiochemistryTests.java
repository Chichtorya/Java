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

    private int id;
    private User id_doctor;
    private Exam id_exam;
    private float Fasting;
    private float pp;//Post Prandial
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
    private String resutl;

    public BiochemistryTests() {
    }

    public BiochemistryTests(int id, User id_doctor, Exam id_exam, float Fasting, float pp, float Urea, float S_Creatinine, float Sodium, float Potassium, float Chloride, float TotalCalcium, float S_Calcium, float UricAcid, float TotalBilirubin, float AlkalinePhosphate, float TotalProtein, float Albumin, float TotalCholesterol, float Triglyceride, float ADA, String resutl) {
        this.id = id;
        this.id_doctor = id_doctor;
        this.id_exam = id_exam;
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
        this.resutl = resutl;
    }
    public BiochemistryTests( User id_doctor, Exam id_exam, float Fasting, float pp, float Urea, float S_Creatinine, float Sodium, float Potassium, float Chloride, float TotalCalcium, float S_Calcium, float UricAcid, float TotalBilirubin, float AlkalinePhosphate, float TotalProtein, float Albumin, float TotalCholesterol, float Triglyceride, float ADA, String resutl) {
        this.id_doctor = id_doctor;
        this.id_exam = id_exam;
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
        this.resutl = resutl;
    }

    public BiochemistryTests(int id, User id_doctor, Exam id_exam, float Fasting, float pp, float Urea, float S_Creatinine, float Sodium, float Potassium, float Chloride, float TotalCalcium, float S_Calcium, float UricAcid, float TotalBilirubin, float AlkalinePhosphate, float TotalProtein, float Albumin, float TotalCholesterol, float Triglyceride, float ADA) {
        this.id = id;
        this.id_doctor = id_doctor;
        this.id_exam = id_exam;
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
    public BiochemistryTests( User id_doctor, Exam id_exam, float Fasting, float pp, float Urea, float S_Creatinine, float Sodium, float Potassium, float Chloride, float TotalCalcium, float S_Calcium, float UricAcid, float TotalBilirubin, float AlkalinePhosphate, float TotalProtein, float Albumin, float TotalCholesterol, float Triglyceride, float ADA) {
        this.id_doctor = id_doctor;
        this.id_exam = id_exam;
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

    @Override
    public String toString() {
        return "BiochemistryTests{" + "id=" + id + ", id_doctor=" + id_doctor + ", id_exam=" + id_exam + ", Fasting=" + Fasting + ", pp=" + pp + ", Urea=" + Urea + ", S_Creatinine=" + S_Creatinine + ", Sodium=" + Sodium + ", Potassium=" + Potassium + ", Chloride=" + Chloride + ", TotalCalcium=" + TotalCalcium + ", S_Calcium=" + S_Calcium + ", UricAcid=" + UricAcid + ", TotalBilirubin=" + TotalBilirubin + ", AlkalinePhosphate=" + AlkalinePhosphate + ", TotalProtein=" + TotalProtein + ", Albumin=" + Albumin + ", TotalCholesterol=" + TotalCholesterol + ", Triglyceride=" + Triglyceride + ", ADA=" + ADA + ", resutl=" + resutl + '}';
    }

    public Exam getId_exam() {
        return id_exam;
    }

    public void setId_exam(Exam id_exam) {
        this.id_exam = id_exam;
    }

    public String getResutl() {
        return resutl;
    }

    public void setResutl(String resutl) {
        this.resutl = resutl;
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

    public float getFasting() {
        return Fasting;
    }

    public void setFasting(float Fasting) {
        this.Fasting = Fasting;
    }

    public float getPp() {
        return pp;
    }

    public void setPp(float pp) {
        this.pp = pp;
    }

    public float getUrea() {
        return Urea;
    }

    public void setUrea(float Urea) {
        this.Urea = Urea;
    }

    public float getS_Creatinine() {
        return S_Creatinine;
    }

    public void setS_Creatinine(float S_Creatinine) {
        this.S_Creatinine = S_Creatinine;
    }

    public float getSodium() {
        return Sodium;
    }

    public void setSodium(float Sodium) {
        this.Sodium = Sodium;
    }

    public float getPotassium() {
        return Potassium;
    }

    public void setPotassium(float Potassium) {
        this.Potassium = Potassium;
    }

    public float getChloride() {
        return Chloride;
    }

    public void setChloride(float Chloride) {
        this.Chloride = Chloride;
    }

    public float getTotalCalcium() {
        return TotalCalcium;
    }

    public void setTotalCalcium(float TotalCalcium) {
        this.TotalCalcium = TotalCalcium;
    }

    public float getS_Calcium() {
        return S_Calcium;
    }

    public void setS_Calcium(float S_Calcium) {
        this.S_Calcium = S_Calcium;
    }

    public float getUricAcid() {
        return UricAcid;
    }

    public void setUricAcid(float UricAcid) {
        this.UricAcid = UricAcid;
    }

    public float getTotalBilirubin() {
        return TotalBilirubin;
    }

    public void setTotalBilirubin(float TotalBilirubin) {
        this.TotalBilirubin = TotalBilirubin;
    }

    public float getAlkalinePhosphate() {
        return AlkalinePhosphate;
    }

    public void setAlkalinePhosphate(float AlkalinePhosphate) {
        this.AlkalinePhosphate = AlkalinePhosphate;
    }

    public float getTotalProtein() {
        return TotalProtein;
    }

    public void setTotalProtein(float TotalProtein) {
        this.TotalProtein = TotalProtein;
    }

    public float getAlbumin() {
        return Albumin;
    }

    public void setAlbumin(float Albumin) {
        this.Albumin = Albumin;
    }

    public float getTotalCholesterol() {
        return TotalCholesterol;
    }

    public void setTotalCholesterol(float TotalCholesterol) {
        this.TotalCholesterol = TotalCholesterol;
    }

    public float getTriglyceride() {
        return Triglyceride;
    }

    public void setTriglyceride(float Triglyceride) {
        this.Triglyceride = Triglyceride;
    }

    public float getADA() {
        return ADA;
    }

    public void setADA(float ADA) {
        this.ADA = ADA;
    }

    
}
