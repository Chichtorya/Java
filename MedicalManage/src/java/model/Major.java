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
    private String name ;
    private String room ;

    public Major() {
    }

    public Major(int id, String name, String room) {
        this.id = id;
        this.name = name;
        this.room = room;
    }
    
    public Major( String name, String room) {
        this.name = name;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Major{" + "id=" + id + ", name=" + name + ", room=" + room + '}';
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    
            
}
