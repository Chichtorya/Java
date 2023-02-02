/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.TestObj;

import java.time.LocalTime;

/**
 *
 * @author lebac
 */
public class RegularSchedule {
    private int Id;
    private int User_Id;
    private Enum Day;
    private LocalTime Time;
    private int Patien_Id;

    public RegularSchedule() {
    }

    public RegularSchedule(int Id, int User_Id, Enum Day, LocalTime Time, int Patien_Id) {
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

    public Enum getDay() {
        return Day;
    }

    public LocalTime getTime() {
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

    public void setDay(Enum Day) {
        this.Day = Day;
    }

    public void setTime(LocalTime Time) {
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
