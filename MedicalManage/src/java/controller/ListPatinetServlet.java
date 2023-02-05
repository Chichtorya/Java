/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.PatientDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Patien_Info;

/**
 *
 * @author dell
 */
@WebServlet(name="ListPatinetServlet", urlPatterns={"/patient"})
public class ListPatinetServlet extends HttpServlet {
   
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
            out.println("<title>Servlet NewServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath () + "</h1>");
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
    PatientDAO dao = new PatientDAO();
    String action = request.getParameter("action");
    RequestDispatcher dispatcher;
    if(action == null){
        action = "";
    }
    switch(action){
        case "create":
            dispatcher= request.getRequestDispatcher("CreatePatient.jsp");
                dispatcher.forward(request, response);
            break;        
        case "update":
            String id = request.getParameter("id");
            try{
                int id1 = Integer.parseInt(id);
                Patien_Info pa = dao.getPatientById(id1);
                request.setAttribute("pa", pa);
                dispatcher= request.getRequestDispatcher("EditPatient.jsp");
                dispatcher.forward(request, response);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
            break;
        case "delete":
            String id2 = request.getParameter("id");
            try{
                int id1 = Integer.parseInt(id2);
                dao.deletePatientById(id1);
               response.sendRedirect("/patient");               
            }catch(NumberFormatException e){
                e.printStackTrace();
            } 
            break;
        case "findName":
             String name = request.getParameter("findName");
                ArrayList<Patien_Info> list = dao.getAllPatientByName(name);
                request.setAttribute("ListPatient", list);
                dispatcher= request.getRequestDispatcher("ListPatient.jsp");
                dispatcher.forward(request, response);
                break;
        default: 
             ArrayList<Patien_Info> list1 = dao.getAllPatient();
                request.setAttribute("ListPatient", list1);
                dispatcher = request.getRequestDispatcher("ListPatient.jsp");
                dispatcher.forward(request, response);         
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
        PatientDAO dao = new PatientDAO();
         String action = request.getParameter("action");
        RequestDispatcher dispatcher;
        switch(action){
            case "create":
                String name = request.getParameter("name");
                request.setAttribute("name1", name);
                String citizenId = request.getParameter("citizenId");
                request.setAttribute("citizenId1", citizenId);
                String healthId= request.getParameter("healthId");
                request.setAttribute("healthId1", healthId);
                String phone = request.getParameter("phone");                
                request.setAttribute("phone1", phone);
                String date = request.getParameter("dateOfBirth");
                request.setAttribute("dateOfBirth1", date);
                String gender =request.getParameter("gender");
                request.setAttribute("gender1", gender);
                String address = request.getParameter("address");
                request.setAttribute("address1", address);
                if(!dao.checkPhone(phone) || !dao.checkCitizenId(citizenId)){
                    if(!dao.checkPhone(phone)){
                        String ms = "* Phone Exist";
                    request.setAttribute("ms", ms);
                    }
                    if(!dao.checkCitizenId(citizenId)){
                        String ms1 = "* Citizen Id Exist";
                    request.setAttribute("ms1", ms1);
                    }
                    dispatcher = request.getRequestDispatcher("CreatePatient.jsp");
                    dispatcher.forward(request, response);
                }else{
                Patien_Info pa = new Patien_Info(name, citizenId, healthId, phone, date, gender, address);
                dao.createPatient(pa);
                response.sendRedirect("/patient");
                }
                break;
            case "update":
                String id =request.getParameter("id");      
                String name1 = request.getParameter("name");
                String citizenId1 = request.getParameter("citizenId");
                String healthId1 = request.getParameter("healthId");
                String phone1 = request.getParameter("phone");                
                String date1 = request.getParameter("date");
                String gender1 =request.getParameter("gender");
                String address1 = request.getParameter("address");
                Patien_Info pa = new Patien_Info(name1, citizenId1, healthId1, phone1, date1, gender1, address1);
                try{
                    int id1 =Integer.parseInt(id);
                    dao.editPatient(pa,id1);
                    response.sendRedirect("/patient");
                }catch(NumberFormatException e){
                    System.out.println(e);
                    response.sendRedirect("/patient");
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
