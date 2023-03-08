/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class BillOrder {
    private int id ;
    private Bill id_bill;
    private TypeTest id_test ;
    private float priceUnit;

    public BillOrder() {
    }

    public BillOrder(int id, Bill id_bill, TypeTest id_test, float priceUnit) {
        this.id = id;
        this.id_bill = id_bill;
        this.id_test = id_test;
        this.priceUnit = priceUnit;
    }
    public BillOrder( Bill id_bill, TypeTest id_test, float priceUnit) {
        this.id = id;
        this.id_bill = id_bill;
        this.id_test = id_test;
        this.priceUnit = priceUnit;
    }

    @Override
    public String toString() {
        return "BillOrder{" + "id=" + id + ", id_bill=" + id_bill + ", id_test=" + id_test + ", priceUnit=" + priceUnit + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bill getId_bill() {
        return id_bill;
    }

    public void setId_bill(Bill id_bill) {
        this.id_bill = id_bill;
    }

    public TypeTest getId_test() {
        return id_test;
    }

    public void setId_test(TypeTest id_test) {
        this.id_test = id_test;
    }

    public float getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(float priceUnit) {
        this.priceUnit = priceUnit;
    }
    
}
