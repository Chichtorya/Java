
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
import java.util.ArrayList;
import model.UserProfile;
/**
 *
 * @author admin
 */
@WebServlet(name = "ListUserServlet", urlPatterns = {"/user"})
public class ListUserServlet extends HttpServlet {

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
            out.println("<title>Servlet ListUserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListUserServlet at " + request.getContextPath() + "</h1>");
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
    RequestDispatcher dispatcher;
    if(action == null){
        action = "";
    }
    switch(action){
        case "create":
            dispatcher= request.getRequestDispatcher("CreateUser.jsp");
                dispatcher.forward(request, response);
            break;        
        case "update":
            String id = request.getParameter("id");
            try{
                int id1 = Integer.parseInt(id);
                UserProfile us = dao.getUserById(id1);
                request.setAttribute("us", us);
                dispatcher= request.getRequestDispatcher("EditUser.jsp");
                dispatcher.forward(request, response);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
            break;
        case "delete":
            String id2 = request.getParameter("id");
            try{
                int id1 = Integer.parseInt(id2);
                dao.deleteUserById(id1);
               response.sendRedirect("/user");               
            }catch(NumberFormatException e){
                e.printStackTrace();
            } 
            break;
        case "findName":
             String name = request.getParameter("findName");
                ArrayList<UserProfile> list = dao.getAllUserByName(name);
                request.setAttribute("ListUser", list);
                dispatcher= request.getRequestDispatcher("ListUser.jsp");
                dispatcher.forward(request, response);
                break;
        default: 
             ArrayList<UserProfile> list1 = dao.getAllUser();
                request.setAttribute("ListUser", list1);
                dispatcher = request.getRequestDispatcher("ListUser.jsp");
                dispatcher.forward(request, response);         
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
        switch(action){
            case "create":
                String name = request.getParameter("name");
                request.setAttribute("name1", name);
                String phone = request.getParameter("phone");
                request.setAttribute("phone1", phone);
                String date = request.getParameter("dateOfBirth");
                request.setAttribute("dateOfBirth1", date);
                String gender =request.getParameter("gender");
                request.setAttribute("gender1", gender);
                String role =request.getParameter("role");
                request.setAttribute("role1", role);
                String address = request.getParameter("address");
                request.setAttribute("address1", address);
                if(!dao.checkPhone(phone)){
                    if(!dao.checkPhone(phone)){
                        String ms = "* Phone Exist";
                    request.setAttribute("ms", ms);
                    }
                    dispatcher = request.getRequestDispatcher("CreateUser.jsp");
                    dispatcher.forward(request, response);
                }else{
                UserProfile us = new UserProfile(name,phone, date, gender, role, address);
                dao.createUser(us);
                response.sendRedirect("/user");
                }
                break;
            case "update":
                String id =request.getParameter("id");      
                String name1 = request.getParameter("name");
                String phone1 = request.getParameter("phone");                
                String date1 = request.getParameter("date");
                String gender1 =request.getParameter("gender");
                String role1 =request.getParameter("role");
                String address1 = request.getParameter("address");i
                UserProfile us = new UserProfile(name1, phone1, date1, gender1, role1,address1);
                try{
                    int id1 =Integer.parseInt(id);
                    dao.editUser(us,id1);
                    response.sendRedirect("/user");
                }catch(NumberFormatException e){
                    System.out.println(e);
                    response.sendRedirect("/user");
                }
                break;
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

    