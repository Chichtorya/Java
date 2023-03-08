/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author dell
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServlet {

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
            out.println("<title>Servlet ProfileServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfileServlet at " + request.getContextPath() + "</h1>");
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
        UserDAO dao = new UserDAO();
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        User acc = (User) session.getAttribute("account");
        if (action == null) {
            action = "";
        }
        RequestDispatcher dispatcher;
        switch (action) {
            case "view":
                String id = request.getParameter("id");
                try {
                    int id1 = Integer.parseInt(id);
                    User u = dao.getUserById(id1);
                    request.setAttribute("u", u);
                    dispatcher = request.getRequestDispatcher("Profile.jsp");
                    dispatcher.forward(request, response);
                } catch (NumberFormatException e) {
                    response.sendRedirect("/login");
                    System.out.println(e);
                }
                break;
            case "edit":
                if (acc != null) {
                    String id2 = request.getParameter("id");
                    try {
                        int id1 = Integer.parseInt(id2);
                        if (acc.getId() == id1) {
                            User u = dao.getUserById(id1);
                            request.setAttribute("u", u);
                            dispatcher = request.getRequestDispatcher("EditUser.jsp");
                            dispatcher.forward(request, response);
                        } else {
                            response.sendRedirect("/home");
                        }
                    } catch (NumberFormatException e) {
                        response.sendRedirect("/login");
                        System.out.println(e);
                    }
                } else {
                    response.sendRedirect("/login");

                }
                break;
                
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
