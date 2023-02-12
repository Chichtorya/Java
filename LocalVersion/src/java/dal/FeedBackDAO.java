/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.FeedBack;
import model.User;

/**
 *
 * @author dell
 */
public class FeedBackDAO extends DbContext{
    UserDAO dao = new UserDAO();
       public ArrayList<FeedBack> getAllFeedBack() {
        ArrayList<FeedBack> list = new ArrayList<>();
        String sql = "select * from FeedBack";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_user = rs.getInt("Id_user");
                User user = dao.getUserById(id_user);
                list.add(new FeedBack(rs.getInt("Id"),
                        user,
                        rs.getString("feedback")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
       public void CreateFeedBack(FeedBack p) {
        String sql = "insert into FeedBack (id_user ,feedback ) values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, p.getUser().getId());
            ps.setString(2, p.getFeedback());
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
        User u = dao1.getUserById(11);
        FeedBack f = new FeedBack(u, "abc");
        dao.CreateFeedBack(f);
        ArrayList<FeedBack> list = dao.getAllFeedBack();
        for(FeedBack a : list ){
            System.out.println(a);
        }
    }
}
