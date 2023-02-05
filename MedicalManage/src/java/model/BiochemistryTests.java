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
    private int MedicalTestId;
    private float Fasting;
    private float pp;
    private float Urea;
    private float S_Creatinine;
    private float Sodium;
    private float Potassium;
    private float Choloride;
    private float TotalCalcium;
    private float UricAcid;
    private float TotalBilirubin;
    private float AlkalinePhosphate;
    private float TotalProtein;
    private float Albumin;
    private float TotalCholesterol;
    private float Triglyceride;
    private float ADA;

    public BiochemistryTests() {
    }
    public BiochemistryTests( int MedicalTestId, float Fasting, float pp, float Urea, float S_Creatinine, float Sodium, float Potassium, float Choloride, float TotalCalcium, float UricAcid, float TotalBilirubin, float AlkalinePhosphate, float TotalProtein, float Albumin, float TotalCholesterol, float Triglyceride, float ADA) {
 
        this.MedicalTestId = MedicalTestId;
        this.Fasting = Fasting;
        this.pp = pp;
        this.Urea = Urea;
        this.S_Creatinine = S_Creatinine;
        this.Sodium = Sodium;
        this.Potassium = Potassium;
        this.Choloride = Choloride;
        this.TotalCalcium = TotalCalcium;
        this.UricAcid = UricAcid;
        this.TotalBilirubin = TotalBilirubin;
        this.AlkalinePhosphate = AlkalinePhosphate;
        this.TotalProtein = TotalProtein;
        this.Albumin = Albumin;
        this.TotalCholesterol = TotalCholesterol;
        this.Triglyceride = Triglyceride;
        this.ADA = ADA;
    }

    public BiochemistryTests(int BioID, int MedicalTestId, float Fasting, float pp, float Urea, float S_Creatinine, float Sodium, float Potassium, float Choloride, float TotalCalcium, float UricAcid, float TotalBilirubin, float AlkalinePhosphate, float TotalProtein, float Albumin, float TotalCholesterol, float Triglyceride, float ADA) {
        this.BioID = BioID;
        this.MedicalTestId = MedicalTestId;
        this.Fasting = Fasting;
        this.pp = pp;
        this.Urea = Urea;
        this.S_Creatinine = S_Creatinine;
        this.Sodium = Sodium;
        this.Potassium = Potassium;
        this.Choloride = Choloride;
        this.TotalCalcium = TotalCalcium;
        this.UricAcid = UricAcid;
        this.TotalBilirubin = TotalBilirubin;
        this.AlkalinePhosphate = AlkalinePhosphate;
        this.TotalProtein = TotalProtein;
        this.Albumin = Albumin;
        this.TotalCholesterol = TotalCholesterol;
        this.Triglyceride = Triglyceride;
        this.ADA = ADA;
    }

    public int getBioID() {
        return BioID;
    }

    public int getMedicalTestId() {
        return MedicalTestId;
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

    public float getCholoride() {
        return Choloride;
    }

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

    public void setMedicalTestId(int MedicalTestId) {
        this.MedicalTestId = MedicalTestId;
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

    public void setCholoride(float Choloride) {
        this.Choloride = Choloride;
    }

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
