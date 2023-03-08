/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Bill {
    private int id ;
    private User id_user;
    private Exam id_exam ;
    private float totalPrice;
    private int status;

    public Bill() {
    }

    public Bill(int id, User id_user, Exam id_exam, float totalPrice, int status) {
        this.id = id;
        this.id_user = id_user;
        this.id_exam = id_exam;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    public Bill( User id_user, Exam id_exam, float totalPrice, int status) {
        this.id_user = id_user;
        this.id_exam = id_exam;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    public Bill( User id_user, Exam id_exam, int status) {
        this.id_user = id_user;
        this.id_exam = id_exam;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", id_user=" + id_user + ", id_exam=" + id_exam + ", totalPrice=" + totalPrice + ", status=" + status + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public Exam getId_exam() {
        return id_exam;
    }

    public void setId_exam(Exam id_exam) {
        this.id_exam = id_exam;
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
