/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dell
 */
public class Patien_Info {
    private int id ;
    private String name;
    private String citizen_Identity_Id;
    private String health_Insurance_Id;
    private String phone_Number;
    private String date_Of_Birth;
    private String gender;
    private String address;

    public Patien_Info(String name, String date_Of_Birth, String address) {
        this.name = name;
        this.date_Of_Birth = date_Of_Birth;
        this.address = address;
    }

    public Patien_Info(int id, String name, String date_Of_Birth, String address) {
        this.id = id;
        this.name = name;
        this.date_Of_Birth = date_Of_Birth;
        this.address = address;
    }

    public Patien_Info(int id, String name, String citizen_Identity_Id, String health_Insurance_Id, String phone_Number, String date_Of_Birth, String gender, String address) {
        this.id = id;
        this.name = name;
        this.citizen_Identity_Id = citizen_Identity_Id;
        this.health_Insurance_Id = health_Insurance_Id;
        this.phone_Number = phone_Number;
        this.date_Of_Birth = date_Of_Birth;
        this.gender = gender;
        this.address = address;
    }
     public Patien_Info( String name, String citizen_Identity_Id, String health_Insurance_Id, String phone_Number, String date_Of_Birth, String gender, String address) {
        this.name = name;
        this.citizen_Identity_Id = citizen_Identity_Id;
        this.health_Insurance_Id = health_Insurance_Id;
        this.phone_Number = phone_Number;
        this.date_Of_Birth = date_Of_Birth;
        this.gender = gender;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patien_Info{" + "id=" + id + ", name=" + name + ", citizen_Identity_Id=" + citizen_Identity_Id + ", health_Insurance_Id=" + health_Insurance_Id + ", phone_Number=" + phone_Number + ", date_Of_Birth=" + date_Of_Birth + ", gender=" + gender + ", address=" + address + '}';
    }
     
    public Patien_Info() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitizen_Identity_Id() {
        return citizen_Identity_Id;
    }

    public void setCitizen_Identity_Id(String citizen_Identity_Id) {
        this.citizen_Identity_Id = citizen_Identity_Id;
    }

    public String getHealth_Insurance_Id() {
        return health_Insurance_Id;
    }

    public void setHealth_Insurance_Id(String health_Insurance_Id) {
        this.health_Insurance_Id = health_Insurance_Id;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    public String getDate_Of_Birth() {
        return date_Of_Birth;
    }

    public void setDate_Of_Birth(String date_Of_Birth) {
        this.date_Of_Birth = date_Of_Birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
