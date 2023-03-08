/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.ScheduleDAO;
import dal.TestDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BiochemistryTests;
import model.BloodTests;
import model.ImmunoassTest;
import model.Schedule;

/**
 *
 * @author PC
 */
@WebServlet(name="ViewTestServlet", urlPatterns={"/viewTest"})
public class ViewTestServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ViewTestServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewTestServlet at " + request.getContextPath () + "</h1>");
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
        TestDao tdao = new TestDao();
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        try {
            int id_exam = Integer.parseInt(id);
            int id_type = Integer.parseInt(type);
            
            if (id_type == 1) {
                BiochemistryTests t = tdao.getBioTestByExamId(id_exam);
                request.setAttribute("s", t);
                request.getRequestDispatcher("viewBio.jsp").forward(request, response);
            }
            if (id_type == 2) {
                BloodTests s = tdao.getBloodTestByExamId(id_exam);
                request.setAttribute("s", s);
                request.getRequestDispatcher("viewBlood.jsp").forward(request, response);
            }
            if (id_type== 3) {
                ImmunoassTest s = tdao.getImmuTestByExamId(id_exam);
                request.setAttribute("s", s);
                request.getRequestDispatcher("viewImmu.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("/login");
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
