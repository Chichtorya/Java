/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dell
 */
public class FeedBack {
    private int id;
    private User user;
    private String feedback;
    private String date;

    public FeedBack() {
    }

    public FeedBack(int id, User user, String feedback, String date) {
        this.id = id;
        this.user = user;
        this.feedback = feedback;
        this.date = date;
    }
    public FeedBack( User user, String feedback, String date) {
        this.user = user;
        this.feedback = feedback;
        this.date = date;
    }
    public FeedBack( User user, String feedback) {
        this.user = user;
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "FeedBack{" + "id=" + id + ", user=" + user + ", feedback=" + feedback + ", date=" + date + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
}
