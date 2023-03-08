/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ScheduleDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Major;
import model.Schedule;
import model.User;

/**
 *
 * @author dell
 */
@WebServlet(name = "CreateScheduleServlet", urlPatterns = {"/createSchedule"})
public class CreateScheduleServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateScheduleServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateScheduleServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        LocalDateTime curDate = java.time.LocalDateTime.now();
//        String s = curDate.toString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = new Date();
        String s = dateFormat.format(date);
        UserDAO dao = new UserDAO();
        String id = request.getParameter("id");
        try {
            int id1 = Integer.parseInt(id);
            User u = dao.getUserById(id1);
            request.setAttribute("u", u);
            request.setAttribute("minDate", s);
            request.getRequestDispatcher("CreateSchedule.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/home");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        ScheduleDAO dao1 = new ScheduleDAO();
        String id = request.getParameter("id");
        String major = request.getParameter("major");
        String descrip = request.getParameter("descrip");
        String date = request.getParameter("date1");
        try {
            int major1 = Integer.parseInt(major);
            Major m = dao.getMajorById(major1);
            int id1 = Integer.parseInt(id);
            User u = dao.getUserById(id1);
            Schedule sche = new Schedule(m, u, descrip, date, 0);
            dao1.addSchedule(sche);
            String ms = "create schedule success .";
            request.setAttribute("u", u);
            request.setAttribute("ms", ms);
            request.getRequestDispatcher("Profile.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/home");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
