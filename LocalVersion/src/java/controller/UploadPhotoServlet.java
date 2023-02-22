/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import model.User;
/**
 *
 * @author dell
 */
@MultipartConfig
@WebServlet(name = "UploadPhotoServlet", urlPatterns = {"/upload"})
public class UploadPhotoServlet extends HttpServlet {

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
      
            UserDAO dao = new UserDAO();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("account");
            if (user != null) {
                Part part = request.getPart("photo");
                String fileName = part.getSubmittedFileName();
                String uploadPath = "C:\\Users\\dell\\Documents\\NetBeansProjects\\G6\\g6\\MedicalManage\\web\\images\\" + fileName;
                dao.updatePhoto(fileName, user.getId());
                try {
                    FileOutputStream fos = new FileOutputStream(uploadPath);
                    InputStream is = part.getInputStream();
                    byte[] data = new byte[is.available()];
                    is.read(data);
                    fos.write(data);
                    fos.close();   
//                    String ms = "Update photo success ";
//                    request.setAttribute("ms1", ms);
                    response.sendRedirect("/home");
                } catch (Exception e) {
                    System.out.println(e);
                     response.sendRedirect("/home");
                }
            } else {
                response.sendRedirect("/login");
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
        request.getRequestDispatcher("Home.jsp").forward(request, response);
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
        processRequest(request, response);
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
