/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.FeedBack;
import model.User;

/**
 *
 * @author dell
 */
public class FeedBackDAO extends DbContext{
    UserDAO dao = new UserDAO();
     LocalDate curDate = java.time.LocalDate.now();
    String date = curDate.toString();
    
       public ArrayList<FeedBack> getAllFeedBack() {
        ArrayList<FeedBack> list = new ArrayList<>();
        String sql = "select * from FeedBack order by date desc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_user = rs.getInt("Id_user");
                User user = dao.getUserById(id_user);
                list.add(new FeedBack(rs.getInt("Id"),
                        user,
                        rs.getString("feedback"),
                rs.getString("date")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
         public ArrayList<FeedBack> getListByPage(ArrayList<FeedBack> list1, int start, int end) {
        ArrayList<FeedBack> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list1.get(i));
        }
        return arr;
    }
       public void CreateFeedBack(FeedBack p) {
        String sql = "insert into FeedBack (id_user ,feedback,date ) values (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, p.getUser().getId());
            ps.setString(2, p.getFeedback());
            ps.setString(3, date);
            ps.executeUpdate();
                       
        } catch (SQLException e) {
            System.out.println(e);
        }
  
    }      
    public void deleteFeedBackById(int id) {
        try {
            String sql = "delete from FeedBack where Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        FeedBackDAO dao = new FeedBackDAO();
        UserDAO dao1 = new UserDAO();
        User u = dao1.getUserById(3);
        FeedBack f = new FeedBack(u, "abc");
        dao.CreateFeedBack(f);
        ArrayList<FeedBack> list = dao.getAllFeedBack();
        for(FeedBack a : list ){
            System.out.println(a);
        }
    }
}
