/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */


/**
 *
 * @author lebac
 */
public class Schedule {
    private int id;
    private Major major;
    private User user;
    private String descrip;
    private String datetime;
    private Exam exam;
    private TypeTest type;
    private int status;

    public Schedule() {
    }

    public Schedule(int id, Major major, User user, String descrip, String datetime, Exam exam, TypeTest type, int status) {
        this.id = id;
        this.major = major;
        this.user = user;
        this.descrip = descrip;
        this.datetime = datetime;
        this.exam = exam;
        this.type = type;
        this.status = status;
    }
    public Schedule( Major major, User user, String descrip, String datetime, Exam exam, TypeTest type, int status) {
        this.major = major;
        this.user = user;
        this.descrip = descrip;
        this.datetime = datetime;
        this.exam = exam;
        this.type = type;
        this.status = status;
    }

   
    public Schedule(int id, Major major, User user, String descrip, String datetime, Exam exam, int status) {
        this.id = id;
        this.major = major;
        this.user = user;
        this.descrip = descrip;
        this.datetime = datetime;
        this.exam = exam;
        this.status = status;
    }
    public Schedule(int id, Major major, User user, String descrip, String datetime, int status) {
        this.id = id;
        this.major = major;
        this.user = user;
        this.descrip = descrip;
        this.datetime = datetime;
        this.status = status;
    }
    public Schedule( Major major, User user, String descrip, String datetime, Exam exam, int status) {
        this.major = major;
        this.user = user;
        this.descrip = descrip;
        this.datetime = datetime;
        this.exam = exam;
        this.status = status;
    }
    public Schedule( Major major, User user, String descrip, String datetime, int status) {
        this.major = major;
        this.user = user;
        this.descrip = descrip;
        this.datetime = datetime;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Schedule{" + "id=" + id + ", major=" + major + ", user=" + user + ", descrip=" + descrip + ", datetime=" + datetime + ", exam=" + exam + ", type=" + type + ", status=" + status + '}';
    }

    public TypeTest getType() {
        return type;
    }

    public void setType(TypeTest type) {
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }



    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

 
}
