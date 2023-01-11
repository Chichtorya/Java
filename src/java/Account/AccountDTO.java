/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class AccountDTO implements Serializable{
    String Id;
    String Gmail;
    String Password;

    public AccountDTO() {
    }
    
    

    public AccountDTO(String Id, String Gmail, String Password) {
        this.Id = Id;
        this.Gmail = Gmail;
        this.Password = Password;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
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
        return "AccountDTO{" + "Id=" + Id + ", Gmail=" + Gmail + ", Password=" + Password + '}';
    }
    
    
    
}
