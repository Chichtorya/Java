/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;
/**
 *
 * @author Admin
 */
public class User implements Serializable{
    private int Id;
    private String Name;
    private String img;
    private String phone;
    private String Date_Of_Birth;
    private int Gender;
    private String Citizen_Id;
    private String Health_Id;
    private String Address;
    private Role role ;
    private Major major;
    private int isBlock;
    private String Gmail;
    private String Password;

    public User() {
    } 

    public User(int Id, String Name, String img, String phone, String Date_Of_Birth, int Gender, String Citizen_Id, String Health_Id, String Address, Role role, Major major, int isBlock, String Gmail, String Password) {
        this.Id = Id;
        this.Name = Name;
        this.img = img;
        this.phone = phone;
        this.Date_Of_Birth = Date_Of_Birth;
        this.Gender = Gender;
        this.Citizen_Id = Citizen_Id;
        this.Health_Id = Health_Id;
        this.Address = Address;
        this.role = role;
        this.major = major;
        this.isBlock = isBlock;
        this.Gmail = Gmail;
        this.Password = Password;
    }

    public User(String Name, String img, String phone, String Date_Of_Birth, int Gender, String Citizen_Id, String Health_Id, String Address, Role role, Major major, int isBlock, String Gmail, String Password) {
        this.Name = Name;
        this.img = img;
        this.phone = phone;
        this.Date_Of_Birth = Date_Of_Birth;
        this.Gender = Gender;
        this.Citizen_Id = Citizen_Id;
        this.Health_Id = Health_Id;
        this.Address = Address;
        this.role = role;
        this.major = major;
        this.isBlock = isBlock;
        this.Gmail = Gmail;
        this.Password = Password;
    }


    public User(String Name, String img, String phone, String Date_Of_Birth, int Gender, String Citizen_Id, String Health_Id, String Address, Role role, int isBlock, String Gmail, String Password) {
        this.Name = Name;
        this.img = img;
        this.phone = phone;
        this.Date_Of_Birth = Date_Of_Birth;
        this.Gender = Gender;
        this.Citizen_Id = Citizen_Id;
        this.Health_Id = Health_Id;
        this.Address = Address;
        this.role = role;
        this.isBlock = isBlock;
        this.Gmail = Gmail;
        this.Password = Password;
    }
    public User(String Name, String img, String phone, String Date_Of_Birth, int Gender, String Citizen_Id, String Health_Id, String Address, String Gmail) {
        this.Name = Name;
        this.img = img;
        this.phone = phone;
        this.Date_Of_Birth = Date_Of_Birth;
        this.Gender = Gender;
        this.Citizen_Id = Citizen_Id;
        this.Health_Id = Health_Id;
        this.Address = Address;
        this.Gmail = Gmail;    
    }

    @Override
    public String toString() {
        return "User{" + "Id=" + Id + ", Name=" + Name + ", img=" + img + ", phone=" + phone + ", Date_Of_Birth=" + Date_Of_Birth + ", Gender=" + Gender + ", Citizen_Id=" + Citizen_Id + ", Health_Id=" + Health_Id + ", Address=" + Address + ", role=" + role + ", major=" + major + ", isBlock=" + isBlock + ", Gmail=" + Gmail + ", Password=" + Password + '}';
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

  

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate_Of_Birth() {
        return Date_Of_Birth;
    }

    public void setDate_Of_Birth(String Date_Of_Birth) {
        this.Date_Of_Birth = Date_Of_Birth;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        this.Gender = Gender;
    }

    public String getCitizen_Id() {
        return Citizen_Id;
    }

    public void setCitizen_Id(String Citizen_Id) {
        this.Citizen_Id = Citizen_Id;
    }

    public String getHealth_Id() {
        return Health_Id;
    }

    public void setHealth_Id(String Health_Id) {
        this.Health_Id = Health_Id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getIsBlock() {
        return isBlock;
    }

    public void setIsBlock(int isBlock) {
        this.isBlock = isBlock;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    

}
