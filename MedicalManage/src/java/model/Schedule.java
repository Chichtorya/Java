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
    private String date;
    private String time ;
    private int status;

    public Schedule() {
    }

    public Schedule(int id, Major major, User user, String descrip, String date, String time, int status) {
        this.id = id;
        this.major = major;
        this.user = user;
        this.descrip = descrip;
        this.date = date;
        this.time = time;
        this.status = status;
    }
    public Schedule( Major major, User user, String descrip, String date, String time, int status) {
        this.major = major;
        this.user = user;
        this.descrip = descrip;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Schedule{" + "id=" + id + ", major=" + major + ", user=" + user + ", descrip=" + descrip + ", date=" + date + ", time=" + time + ", status=" + status + '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
}
