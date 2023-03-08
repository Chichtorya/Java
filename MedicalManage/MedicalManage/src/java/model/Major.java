/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dell
 */
public class Major {
    private int id ;
    private String room ;

    public Major() {
    }

    public Major(int id, String room) {
        this.id = id;
        this.room = room;
    }
    
    public Major(  String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Major{" + "id=" + id + ", room=" + room + '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    
            
}
