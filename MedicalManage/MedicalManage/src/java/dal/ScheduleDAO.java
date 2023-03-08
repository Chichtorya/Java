/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.Major;
import model.Schedule;
import model.TypeTest;
import model.User;

/**
 *
 * @author Admin
 */
public class ScheduleDAO extends DbContext {

    LocalDateTime curDate = java.time.LocalDateTime.now();
    String date = curDate.toString();

    public ArrayList<TypeTest> getAllTypeTest() {
        ArrayList<TypeTest> list = new ArrayList<>();
        String sql = "select * from Type";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TypeTest(rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getFloat("price")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void updatePrice(int id, float price) {
        String sql = "update Type set price = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setFloat(1, price);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TypeTest getTypeTestById(int id) {
        String sql = "select * from Type where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new TypeTest(rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getFloat("price")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Schedule> getAllScheduleByStatus(int status) {
        ExamDAO Edao = new ExamDAO();
        UserDAO dao = new UserDAO();
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
                        Edao.getExamById(rs.getInt("id_exam")),
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Schedule getScheduleByID(int id) {
        ExamDAO Edao = new ExamDAO();
        UserDAO dao = new UserDAO();
        String sql = "select * from Schedule where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Schedule(rs.getInt("Id"),
                        dao.getMajorById(rs.getInt("id_majors")),
                        dao.getUserById(rs.getInt("id_user")),
                        rs.getString("descrip"),
                        rs.getString("day"),
                        Edao.getExamById(rs.getInt("id_exam")),
                        getTypeTestById(rs.getInt("id_type")),
                        rs.getInt("status"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Schedule> getAllScheduleByNameAndStatusAndMajor(String name, int status, int major) {
        UserDAO dao = new UserDAO();
        ArrayList<Schedule> list = new ArrayList<>();
        String sql = "select * from Schedule s inner  join Users u on \n"
                + "s.id_user = u.id where name like '%" + name + "%' and status =" + status + " and s.id_majors = " + major;
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
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Schedule> getAllScheduleByNameAndStatus(String name, int status) {
        UserDAO dao = new UserDAO();
        ArrayList<Schedule> list = new ArrayList<>();
        String sql = "select * from Schedule s inner  join Users u on \n"
                + "s.id_user = u.id where name like '%" + name + "%' and status =" + status;
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
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Schedule> getAllScheduleByUser(int user, int status) {
        UserDAO dao = new UserDAO();
        ArrayList<Schedule> list = new ArrayList<>();
        String sql = "select * from Schedule where id_user = ? and status = ?\n"
                + "order by day  asc";
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
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Schedule> getAllScheduleByMajor(int major, int status) {
        UserDAO dao = new UserDAO();
        ArrayList<Schedule> list = new ArrayList<>();
        String sql = "select * from Schedule where id_majors = ? and status = ?  \n"
                + "order by day  asc";
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
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Schedule> getAllScheduleDoing(int id_doctor) {
        UserDAO dao = new UserDAO();
        ArrayList<Schedule> list = new ArrayList<>();
        String sql = "select * from schedule s \n"
                + "inner join Examination e on  s.id_exam = e.id\n"
                + "where e.Doctor_In_Charge = ? and s.status = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_doctor);
//            ps.setString(3, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Schedule(rs.getInt("Id"),
                        dao.getMajorById(rs.getInt("id_majors")),
                        dao.getUserById(rs.getInt("id_user")),
                        rs.getString("descrip"),
                        rs.getString("day"),
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void addSchedule(Schedule schedule) {
        String sql = "INSERT INTO Schedule (id_majors,id_user,descrip,day,status) values (?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, schedule.getMajor().getId());
            st.setInt(2, schedule.getUser().getId());
            st.setString(3, schedule.getDescrip());
            st.setString(4, schedule.getDatetime());
            st.setInt(5, schedule.getStatus());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addScheduleByExam(Schedule schedule) {
        String sql = "INSERT INTO Schedule (id_majors,id_user,descrip,day,id_exam,id_type,status) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, schedule.getMajor().getId());
            st.setInt(2, schedule.getUser().getId());
            st.setString(3, schedule.getDescrip());
            st.setString(4, schedule.getDatetime());
            st.setInt(5, schedule.getExam().getId());
            st.setInt(6, schedule.getType().getId());
            st.setInt(7, schedule.getStatus());
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
    public void UpdateStatusByExamId(int status, int id_exam) {
        String sql = "update Schedule set status = ? where id_exam = ? and id_majors != 4;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, status);
            st.setInt(2, id_exam);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void UpdateStatusByExamId1(int status, int id_exam) {
        String sql = "update Schedule set status = ? where id_exam = ? and id_majors = 4;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, status);
            st.setInt(2, id_exam);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void UpdateExamID(int exam, int id) {
        String sql = "update Schedule set id_exam = ? where id = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, exam);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ScheduleDAO dao = new ScheduleDAO();
                //        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                //        Date date = new Date();
                //        String s = dateFormat.format(date);
                //        System.out.println(s);
                //        Calendar cal = Calendar.getInstance();
                //        System.out.println(dateFormat.format(cal.getTime()));
                //        UserDAO dao1 = new UserDAO();
                //        Major j = dao1.getMajorById(1);
                //        User u = dao1.getUserById(1);        Schedule s = dao.getScheduleByID(1);
                //        String des = "dau hng";
//                Schedule s = dao.getScheduleByID(20);
//        System.out.println(s);
//        System.out.println(s);
//                new Schedule(j, u, des, dao.date, 0);
//        dao.addSchedule(s);
//        ArrayList<Schedule> list = dao.getAllScheduleDoing(1);
//        for (Schedule x: list) {
//            System.out.println(x);
//        }
//        System.out.println("date "+ dao.date +" time : "+dao.time);
    }
}
