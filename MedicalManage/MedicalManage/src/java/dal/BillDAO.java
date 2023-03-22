/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Bill;
import model.BillOrder;
import model.User;

/**
 *
 * @author PC
 */
public class BillDAO extends DbContext {
      public ArrayList<Bill> getListByPage(ArrayList<Bill> list1, int start, int end) {
        ArrayList<Bill> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list1.get(i));
        }
        return arr;
    }

    public ArrayList<Bill> getAllBillByStatus(int status ) {
        UserDAO dao = new UserDAO();
        ExamDAO edao = new ExamDAO();
        ArrayList<Bill> list = new ArrayList<>();
        String sql = "select * from Bill where status = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt("Id"),
                        dao.getUserById(rs.getInt("id_user")),
                        edao.getExamById(rs.getInt("id_exam")),
                        rs.getFloat("totalPrice"),
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Bill> getAllBillByStatus(int id_user, int status) {
        UserDAO dao = new UserDAO();
        ExamDAO edao = new ExamDAO();
        ArrayList<Bill> list = new ArrayList<>();
        String sql = "select * from Bill where id_user= ? and status = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_user);
            ps.setInt(2, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt("Id"),
                        dao.getUserById(rs.getInt("id_user")),
                        edao.getExamById(rs.getInt("id_exam")),
                        rs.getFloat("totalPrice"),
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<BillOrder> getAllBillOrdersById(int id_bill) {
        ScheduleDAO dao = new ScheduleDAO();
        ArrayList<BillOrder> list = new ArrayList<>();
        String sql = "select * from Bill_Order where id_bill = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_bill);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BillOrder(rs.getInt("Id"),
                        getBillById(rs.getInt("id_bill")),
                        dao.getTypeTestById(rs.getInt("id_type")),
                        rs.getFloat("price")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public float getTotalPriceByBill(int id_bill) {
        String sql = "select sum(price) as 'totalPrice' from Bill_Order where id_bill = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_bill);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getFloat("totalPrice");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public int createBill(Bill b) {
        String sql = "INSERT INTO `g62`.`Bill` (`id_user`, `id_exam`, "
                + " `status`) VALUES (?, ?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, b.getId_user().getId());
            ps.setInt(2, b.getId_exam().getId());
            ps.setInt(3, 0);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    public void updateStatusBill(int status, int id) {
        String sql = "update Bill set status = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTotalPrice(float total, int id) {
        String sql = "update Bill set totalPrice = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setFloat(1, total);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Bill getBillById(int id) {
        UserDAO dao = new UserDAO();
        ExamDAO edao = new ExamDAO();
        String sql = "select * from Bill where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Bill(rs.getInt("Id"),
                        dao.getUserById(rs.getInt("id_user")),
                        edao.getExamById(rs.getInt("id_exam")),
                        rs.getFloat("totalPrice"),
                        rs.getInt("status")
                );

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int createBillOrder(BillOrder b) {
        ScheduleDAO dao = new ScheduleDAO();
        String sql = "INSERT INTO `g62`.`Bill_Order` (`id_bill`, `id_type`, `price`) VALUES (?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, b.getId_bill().getId());
            ps.setInt(2, b.getId_test().getId());
            ps.setFloat(3, b.getPriceUnit());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    public static void main(String[] args) {
        BillDAO dao = new BillDAO();
        UserDAO udao = new UserDAO();
        ExamDAO edao = new ExamDAO();
//        float b = dao.getTotalPriceByBill(4);
//        System.out.println(b);
//        ArrayList<BillOrder> list = dao.getAllBillOrdersById(4);

//        Bill b = new Bill(udao.getUserById(1), edao.getExamById(1), 0, 0);
//        int a = dao.createBill(b);
//        System.out.println(a);
        ArrayList<Bill> list = dao.getAllBillByStatus(1);
        for (Bill b : list) {
            System.out.println(b);
        }
    }
}
