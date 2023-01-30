/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.TestObj;

/**
 *
 * @author chich
 */
public class ImmunoassTest {
   private int ImID;
   private int MedicalTestId;
   private float  Digoxin;
   private float Estradiol;
   private float Ferritin;
   private float FolicAcid;
   private float Progesterone;
   private float Prolactin;
   private float TroponinT;
   private float Testosterone;
   private float TotalPSA;

    public ImmunoassTest() {
    }

    public ImmunoassTest(int ImID, int MedicalTestId, float Digoxin, float Estradiol, float Ferritin, float FolicAcid, float Progesterone, float Prolactin, float TroponinT, float Testosterone, float TotalPSA) {
        this.ImID = ImID;
        this.MedicalTestId = MedicalTestId;
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

    public int getImID() {
        return ImID;
    }

    public int getMedicalTestId() {
        return MedicalTestId;
    }

    public float getDigoxin() {
        return Digoxin;
    }

    public float getEstradiol() {
        return Estradiol;
    }

    public float getFerritin() {
        return Ferritin;
    }

    public float getFolicAcid() {
        return FolicAcid;
    }

    public float getProgesterone() {
        return Progesterone;
    }

    public float getProlactin() {
        return Prolactin;
    }

    public float getTroponinT() {
        return TroponinT;
    }

    public float getTestosterone() {
        return Testosterone;
    }

    public float getTotalPSA() {
        return TotalPSA;
    }

    public void setImID(int ImID) {
        this.ImID = ImID;
    }

    public void setMedicalTestId(int MedicalTestId) {
        this.MedicalTestId = MedicalTestId;
    }

    public void setDigoxin(float Digoxin) {
        this.Digoxin = Digoxin;
    }

    public void setEstradiol(float Estradiol) {
        this.Estradiol = Estradiol;
    }

    public void setFerritin(float Ferritin) {
        this.Ferritin = Ferritin;
    }

    public void setFolicAcid(float FolicAcid) {
        this.FolicAcid = FolicAcid;
    }

    public void setProgesterone(float Progesterone) {
        this.Progesterone = Progesterone;
    }

    public void setProlactin(float Prolactin) {
        this.Prolactin = Prolactin;
    }

    public void setTroponinT(float TroponinT) {
        this.TroponinT = TroponinT;
    }

    public void setTestosterone(float Testosterone) {
        this.Testosterone = Testosterone;
    }

    public void setTotalPSA(float TotalPSA) {
        this.TotalPSA = TotalPSA;
    }
    
    
}
