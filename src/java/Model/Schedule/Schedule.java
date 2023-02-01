/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Schedule;

/**
 *
 * @author Admin
 */
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

/**
 *
 * @author lebac
 */
public class Schedule {
    private int Id;
    private int User_Id;
    private Date Day;
    private Time Time;
    private int Patien_Id;

    public Schedule() {
    }

    public Schedule(int Id, int User_Id, Date Day, Time Time, int Patien_Id) {
        this.Id = Id;
        this.User_Id = User_Id;
        this.Day = Day;
        this.Time = Time;
        this.Patien_Id = Patien_Id;
    }

    public int getId() {
        return Id;
    }

    public int getUser_Id() {
        return User_Id;
    }

    public Date getDay() {
        return Day;
    }

    public Time getTime() {
        return Time;
    }

    public int getPatien_Id() {
        return Patien_Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setUser_Id(int User_Id) {
        this.User_Id = User_Id;
    }

    public void setDay(Date Day) {
        this.Day = Day;
    }

    public void setTime(Time Time) {
        this.Time = Time;
    }

    public void setPatien_Id(int Patien_Id) {
        this.Patien_Id = Patien_Id;
    }

    @Override
    public String toString() {
        return "RegularSchedule{" + "Id=" + Id + ", User_Id=" + User_Id + ", Day=" + Day + ", Time=" + Time + ", Patien_Id=" + Patien_Id + '}';
    }
    
}
