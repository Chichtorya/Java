/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.ScheduleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Schedule;
import model.User;

/**
 *
 * @author dell
 */
@WebServlet(name="SearchMajor2Servlet", urlPatterns={"/searchMajor2"})
public class SearchMajor2Servlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchMajor2Servlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchMajor2Servlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
          ScheduleDAO dao = new ScheduleDAO();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        String name = request.getParameter("name");
        if (name == null) {
            name = "";
        }
        if (user.getRole().getId()==2){
             try {
            request.setAttribute("name1", name);
             ArrayList<Schedule> list = new ArrayList<>();
              list = dao.getAllScheduleByNameAndStatusAndMajor(name, 1, user.getMajor().getId());
            request.setAttribute("ListSchedule", list);
            request.getRequestDispatcher("ScheduleDoing.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/login");
        }
        }else{
        String major = request.getParameter("major");
        try {
            int major1 = Integer.parseInt(major);
            request.setAttribute("major1", major1);
            request.setAttribute("name1", name);
             ArrayList<Schedule> list = new ArrayList<>();
            if(major1 == 0){
             list = dao.getAllScheduleByNameAndStatus(name,1);
            }else{
              list = dao.getAllScheduleByNameAndStatusAndMajor(name, 1, major1);
            }
            request.setAttribute("ListSchedule", list);
            request.getRequestDispatcher("ScheduleDoing.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/login");
        }
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}