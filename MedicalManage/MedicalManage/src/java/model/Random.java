/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dell
 */
public class Random {
     public  String getRandomString(int loai, int dodai) {
        ////////Code ho tro lay chu ngau nhien, phat trien boi Congdongjava - Tran Huy
        //Loai : kieu ran dom
        //0 : ngau nhien chi cac chu cai thuong
        //1 : ngau nhien chi cac chu cai hoa
        //2 : ngau nhien ca chu hoa va thuong
        //3 : ngau nhien chu va so
        String ketqua = "";
        String hoa = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String thuong = hoa.toLowerCase();
        String so = "1234567890";
        String randomchuoi = "";
        if (loai > 3 || loai < 0) {
            ketqua = "Loai khong hop le, cho phep tu 0 - 3";
        } else if (loai == 0) {
            randomchuoi = thuong;
        } else if (loai == 1) {
            randomchuoi = hoa;
        } else if (loai == 2) {
            randomchuoi = hoa + thuong;
        } else if (loai == 3) {
            randomchuoi = thuong + so;
        }
        for (int i = 0; i < dodai; i++) {
            int temp = (int) Math.round(Math.random() * randomchuoi.length());
            ketqua += randomchuoi.charAt(temp);
        }
        return ketqua;
    }
     public static void main(String[] args) {
//         String s =getRandomString(3, 6);
//         System.out.println(s);
    }
}
