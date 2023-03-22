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
import jakarta.servlet.annotation.MultipartConfig;
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
@MultipartConfig
@WebServlet(name = "EditUserServlet", urlPatterns = {"/editUser"})
public class EditUserServlet extends HttpServlet {

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
            out.println("<title>Servlet EditUserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditUserServlet at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");
                    HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        if (user!=null) {
        if (action.equals("editUser")) {
            try {
                int id1 = Integer.parseInt(id);
                User u = dao.getUserById(id1);
                request.setAttribute("u", u);
                request.getRequestDispatcher("EditUser.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                response.sendRedirect("/home");
            }
        }
    }else{
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
        String action = request.getParameter("action");
        RequestDispatcher dispatcher;
        if (action == null) {
            action = "";
        }
        if (action.equals("editUser")) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("account");
            if (user != null) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                String date = request.getParameter("date");
                String gender = request.getParameter("gender");
                String citizen = request.getParameter("citizen");
                String health = request.getParameter("health");
                String address = request.getParameter("address");
                String gmail = request.getParameter("gmail");
                if (name.length() > 35 || address.length() > 50) {
                    if (name.length() > 35) {
                        String msName = "* Name to long (5-34) words";
                        request.setAttribute("msName", msName);
                    }
                    if (address.length() > 50) {
                        String msAddress = "* Address to long (5-50) words.";
                        request.setAttribute("msAdsress", msAddress);
                    }
                  request.setAttribute("u", user);
                  request.getRequestDispatcher("EditUser.jsp").forward(request, response);
                } else {
                    try {
                        int id1 = Integer.parseInt(id);
                        int gender1 = Integer.parseInt(gender);
                        User u = new User(name, phone, date, gender1, citizen, health, address, gmail);
                        dao.editUserByCustomer(u, id1);
                        session.setAttribute("account", dao.getUserById(user.getId()));
                        response.sendRedirect("/profile?action=view&id="+id1);
                    } catch (NumberFormatException e) {
                        response.sendRedirect("/home");
                    }
                }
            } else {
                response.sendRedirect("/login");
            }
        } else {
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
