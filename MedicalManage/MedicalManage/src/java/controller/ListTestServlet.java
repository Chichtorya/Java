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
import java.util.ArrayList;
import model.TypeTest;

/**
 *
 * @author PC
 */
@WebServlet(name = "ListTestServlet", urlPatterns = {"/listTest"})
public class ListTestServlet extends HttpServlet {

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
            out.println("<title>Servlet ListTestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListTestServlet at " + request.getContextPath() + "</h1>");
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
        ScheduleDAO dao = new ScheduleDAO();
        String action = request.getParameter("action");
        ArrayList<TypeTest> list = dao.getAllTypeTest();
        if (action == null) {
            action = "";
        }
        if (action.equals("")) {
            request.setAttribute("ListTest", list);
            request.getRequestDispatcher("UpdateTest.jsp").forward(request, response);
        }
        if (action.equals("update")) {
            String id = request.getParameter("id");
            try {
                int id1 = Integer.parseInt(id);
                TypeTest t = dao.getTypeTestById(id1);
                request.setAttribute("t", t);
                request.getRequestDispatcher("EditPriceTest.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                response.sendRedirect("/home");
            }
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
        ScheduleDAO dao = new ScheduleDAO();
        String action = request.getParameter("action");
        if (action.equals("update")) {
            String id = request.getParameter("id");
            String pri = request.getParameter("price");
            try {
                int id1 = Integer.parseInt(id);
                float price = Float.parseFloat(pri);
                dao.updatePrice(id1, price);
                  ArrayList<TypeTest> list = dao.getAllTypeTest();
                request.setAttribute("ListTest", list);
                request.getRequestDispatcher("UpdateTest.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                response.sendRedirect("/home");
            }
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
