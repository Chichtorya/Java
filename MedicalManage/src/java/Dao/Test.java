/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        AccountDAO dao = new AccountDAO();
        System.out.println(dao.getAccount("khanh","12345678"));
    }
}
