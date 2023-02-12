/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;


import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import model.Schedule;

/**
 *
 * @author Admin
 */
public class ScheduleDAO extends DbContext implements Serializable {

    public void addSchedule(Schedule schedule) {
        String sql = "INSERT INTO Schedule values(?,?,?,?,?) ;;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, schedule.getId());
            st.setInt(2, schedule.getUser_Id());
            st.setDate(3, schedule.getDay());
            st.setTime(4, schedule.getTime());
            st.setInt(5, schedule.getPatien_Id());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    // delete a row in Schedule table 
    public int deleteSchedule(Schedule schedule) {
        String sql = "delete from Schedule where User_Id= ? and Id = ? ;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, schedule.getUser_Id());
            st.setInt(2, schedule.getId());
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // update a row in Schedule table 
    public void UpdateSchedule(Schedule schedule, LocalTime localTime) {
        String sql = "UPDATE Schedule SET Day = ?, Time = ?,Patien_Id= ? WHERE User_Id = ? and Id = ? and Time > ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(5, schedule.getId());
            st.setInt(4, schedule.getUser_Id());
            st.setDate(1, schedule.getDay());
            st.setTime(3, schedule.getTime());
            st.setInt(2, schedule.getPatien_Id());
            st.setTime(6, Time.valueOf(localTime.toString()));

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int DeletePassSchedule(LocalTime localTime) {
        Time time = Time.valueOf(localTime.toString());
        String mySQL = "delete from Schedule where Time < ?;";
        try {
            PreparedStatement st = connection.prepareStatement(mySQL);
            st.setTime(1,time);
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public static void main(String[] args) {
        
    }
}
