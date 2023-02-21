/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import model.Major;
import model.Schedule;
import model.User;

/**
 *
 * @author Admin
 */
public class ScheduleDAO extends DbContext {

    UserDAO dao = new UserDAO();
    LocalDate curDate = java.time.LocalDate.now();
    String date = curDate.toString();
    LocalTime curtime = java.time.LocalTime.now();
    String time = curtime.toString();

    public ArrayList<Schedule> getAllScheduleByStatus(int status) {
        ArrayList<Schedule> list = new ArrayList<>();
        String sql = "select * from Schedule where status = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int major = rs.getInt("id_majors");
                Major ma = dao.getMajorById(major);
                int id_u = rs.getInt("id_user");
                User u = dao.getUserById(id_u);
                list.add(new Schedule(rs.getInt("Id"),
                        ma,
                        u,
                        rs.getString("descrip"),
                        rs.getString("day"),
                        rs.getString("time"),
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
        public ArrayList<Schedule> getAllScheduleByNameAndStatusAndMajor(String name, int status,int major) {
        ArrayList<Schedule> list = new ArrayList<>();
        String sql = "select * from Schedule s inner  join Users u on \n"
                + "s.id_user = u.id where name like '%"+name+"%' and status ="+status+" and s.id_majors = "+major;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Major ma = dao.getMajorById(major);
                int id_u = rs.getInt("id_user");
                User u = dao.getUserById(id_u);
                list.add(new Schedule(rs.getInt("Id"),
                        ma,
                        u,
                        rs.getString("descrip"),
                        rs.getString("day"),
                        rs.getString("time"),
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Schedule> getAllScheduleByNameAndStatus(String name, int status) {
        ArrayList<Schedule> list = new ArrayList<>();
        String sql = "select * from Schedule s inner  join Users u on \n"
                + "s.id_user = u.id where name like '%"+name+"%' and status ="+status;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int major = rs.getInt("id_majors");
                Major ma = dao.getMajorById(major);
                int id_u = rs.getInt("id_user");
                User u = dao.getUserById(id_u);
                list.add(new Schedule(rs.getInt("Id"),
                        ma,
                        u,
                        rs.getString("descrip"),
                        rs.getString("day"),
                        rs.getString("time"),
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Schedule> getAllScheduleByUser(int user, int status) {
        ArrayList<Schedule> list = new ArrayList<>();
        String sql = "select * from Schedule where id_user = ? and status = ?\n"
                + "order by time  asc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, user);
            ps.setInt(2, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int major = rs.getInt("id_majors");
                Major ma = dao.getMajorById(major);
                int id_u = rs.getInt("id_user");
                User u = dao.getUserById(id_u);
                list.add(new Schedule(rs.getInt("Id"),
                        ma,
                        u,
                        rs.getString("descrip"),
                        rs.getString("day"),
                        rs.getString("time"),
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Schedule> getAllScheduleByMajor(int major, int status) {
        ArrayList<Schedule> list = new ArrayList<>();
        String sql = "select * from Schedule where id_majors = ? and status = ?  \n"
                + "order by time  asc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, major);
            ps.setInt(2, status);
//            ps.setString(3, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Major ma = dao.getMajorById(major);
                int id_u = rs.getInt("id_user");
                User u = dao.getUserById(id_u);
                list.add(new Schedule(rs.getInt("Id"),
                        ma,
                        u,
                        rs.getString("descrip"),
                        rs.getString("day"),
                        rs.getString("time"),
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void addSchedule(Schedule schedule) {
        String sql = "INSERT INTO Schedule (id_majors,id_user,descrip,day,time,status) values (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, schedule.getMajor().getId());
            st.setInt(2, schedule.getUser().getId());
            st.setString(3, schedule.getDescrip());
            st.setString(4, schedule.getDate());
            st.setString(5, schedule.getTime());
            st.setInt(6,schedule.getStatus() );
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // delete a row in Schedule table 
    public int deleteSchedule(int id) {
        String sql = "delete from Schedule where  id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // update a row in Schedule table 
    public void UpdateSchedule(Schedule s, int id) {
        String sql = "update Schedule set id_majors = ?, id_user = ?,descrip = ? , day= ?,time = ? where id = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, s.getMajor().getId());
            st.setInt(2, s.getUser().getId());
            st.setString(3, s.getDescrip());
            st.setString(4, s.getDate());
            st.setString(5, s.getTime());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void UpdateStatus(int status, int id) {
        String sql = "update Schedule set status= ? where id = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, status);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ScheduleDAO dao = new ScheduleDAO();
        UserDAO dao1 = new UserDAO();
        Major j = dao1.getMajorById(1);
        User u = dao1.getUserById(1);
        String des = "dau hng";
        Schedule s = new Schedule(j, u, des, dao.date, dao.time, 0);
        dao.addSchedule(s);
        ArrayList<Schedule> list = dao.getAllScheduleByUser(5,0);
        for (Schedule x: list) {
            System.out.println(x);
        }
        System.out.println("date "+ dao.date +" time : "+dao.time);
    }
}
