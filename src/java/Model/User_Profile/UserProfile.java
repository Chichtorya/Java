/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.User_Profile;
import Enum_Type.Gender;
import Enum_Type.Role;
import java.io.Serializable;
/**
 *
 * @author Admin
 */
public class UserProfile implements Serializable{
    private int Id;
    private String Name;
    private String Phone_Number;
    private String Date_Of_Birth;
    private Gender Gender;
    private Role Role;
    private String Address;
    private String Gmail;
    private String Password;

    public UserProfile(int Id, String Name, String Phone_Number, String Date_Of_Birth, Gender Gender, Role Role, String Address, String Gmail, String Password) {
        this.Id = Id;
        this.Name = Name;
        this.Phone_Number = Phone_Number;
        this.Date_Of_Birth = Date_Of_Birth;
        this.Gender = Gender;
        this.Role = Role;
        this.Address = Address;
        this.Gmail = Gmail;
        this.Password = Password;
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

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String Phone_Number) {
        this.Phone_Number = Phone_Number;
    }

    public String getDate_Of_Birth() {
        return Date_Of_Birth;
    }

    public void setDate_Of_Birth(String Date_Of_Birth) {
        this.Date_Of_Birth = Date_Of_Birth;
    }

    public Gender getGender() {
        return Gender;
    }

    public void setGender(Gender Gender) {
        this.Gender = Gender;
    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role Role) {
        this.Role = Role;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
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

    @Override
    public String toString() {
        return "UserProfile{" + "Id=" + Id + ", Name=" + Name + ", Phone_Number=" + Phone_Number + ", Date_Of_Birth=" + Date_Of_Birth + ", Gender=" + Gender + ", Role=" + Role + ", Address=" + Address + ", Gmail=" + Gmail + ", Password=" + Password + '}';
    }
    
    
}