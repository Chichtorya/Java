/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dell
 */
public class TypeTest {
    private int id ;
    private String name ;
    private Float price;

    public TypeTest() {
    }

    public TypeTest(int id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public TypeTest(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "TypeTest{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
}
