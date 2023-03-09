package model;


/**
 *
 * @author chich
 */
public class Prescription {

    private int id;
    private int examId;
    private String drugName;
    private String dosage;
    private String note;
    
    // Constructor
    
    public Prescription() {
    }

    public Prescription(int examId, String drugName, String dosage, String note) {
        this.examId = examId;
        this.drugName = drugName;
        this.dosage = dosage;
        this.note = note;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}