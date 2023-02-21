/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author dell
 */
@WebServlet(name="AccountMServlet", urlPatterns={"/account"})
public class AccountMServlet extends HttpServlet {
   
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
            out.println("<title>Servlet AccountMServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccountMServlet at " + request.getContextPath () + "</h1>");
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
        UserDAO dao = new UserDAO();
        String action = request.getParameter("action");
       if(action.equals("view")){
            String id = request.getParameter("id");
            try{
                int id1 = Integer.parseInt(id);
                User u = dao.getUserById(id1);
                request.setAttribute("u",u);
                request.getRequestDispatcher("userProfile.jsp").forward(request, response);
            }catch(Exception e){
                System.out.println(e);
            }
       }
       if(action.equals("editRole")){
            String id = request.getParameter("id");
            try{
                int id1 = Integer.parseInt(id);
                User u = dao.getUserById(id1);
                request.setAttribute("u",u);
                request.getRequestDispatcher("EditU.jsp").forward(request, response);
            }catch(Exception e){
                System.out.println(e);
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
         UserDAO dao = new UserDAO();
        String action = request.getParameter("action");
        if(action.equals("editRole")){
            String id = request.getParameter("id");
            String role = request.getParameter("role");
            String major =request.getParameter("major");
            try{
                int role1 = Integer.parseInt(role);
                int major1 = Integer.parseInt(major);
                if(role1 == 2){
                int id1 = Integer.parseInt(id);
                dao.ChangeRole(role1,major1, id1);
                User u = dao.getUserById(id1);
                request.setAttribute("u",u);
                request.getRequestDispatcher("userProfile.jsp").forward(request, response); 
                }else {
                int id1 = Integer.parseInt(id);
                dao.ChangeRole1(role1, id1);
                User u = dao.getUserById(id1);
                request.setAttribute("u",u);
                request.getRequestDispatcher("userProfile.jsp").forward(request, response);   
                }
            }catch(Exception e){
                System.out.println(e);
            }
       }
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
