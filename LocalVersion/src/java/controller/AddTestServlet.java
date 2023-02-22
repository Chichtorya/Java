 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.MedicalExamDao;
import dal.TestDao;
import model.PatientTest;
import model.BiochemistryTests;
import model.BloodTests;
import model.ImmunoassTest;
import model.Patien_Info;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *
 * @author chich
 */
@WebServlet(name = "AddTestServlet", urlPatterns = {"/AddTestServlet"})
public class AddTestServlet extends HttpServlet {

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
            out.println("<title>Servlet AddTestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddTestServlet at " + request.getContextPath() + "</h1>");
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

        processRequest(request, response);

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
        TestDao td = new TestDao();
        String totalTest = request.getParameter("price");
     
        String action = request.getParameter("test");
        String id = request.getParameter("id");
        String idtest = request.getParameter("idtest");
            MedicalExamDao md = new MedicalExamDao();
        int latestExamId = md.getLatestExaminationIdForUser(Integer.parseInt(request.getParameter("id")));
          int idOfTest =  td.getLatestTest(latestExamId).getPaID();
       
          int count_free;
         
        try {
             
             count_free = Integer.parseInt(totalTest);
        } catch (NumberFormatException e) {
         count_free =0;
        }
      
       

        if (null == action) {
            String decrip = request.getParameter("decrip");
            String doctor = request.getParameter("doctor");
            
            double moneyTest = 100 * count_free;
           PatientTest Pt = new PatientTest(idOfTest,1, decrip,"st", moneyTest);
            td.UpdateTest(Pt);
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        } else//
        {
          
            switch (action) {

                case "Blood":
                    float RedB = Float.parseFloat((String) request.getParameter("RedB"));
                    float WhiteB = Float.parseFloat((String) request.getParameter("WhiteB"));
                    float Platelets = Float.parseFloat((String) request.getParameter("Platelets"));
                    float Hemoglobin = Float.parseFloat((String) request.getParameter("Hemoglobin"));
                    float Hemattocrit = Float.parseFloat((String) request.getParameter("Hemattocrit"));
                    int MCV = Integer.parseInt((String) request.getParameter("MCV"));
                    BloodTests Blo = new BloodTests(Integer.parseInt(id),idOfTest, RedB, WhiteB, Platelets, Hemoglobin, Hemattocrit, MCV);

                    td.addBloodyTestdata(Blo);
                    float[] variables1 = {RedB, WhiteB, Platelets, Hemoglobin, Hemattocrit, MCV};
                    
                    for (int i = 0; i < variables1.length; i++) {
                        if (variables1[i] != 0) {
                            count_free++;
                        }
                    }
                    
                    totalTest = String.valueOf(count_free);//check
             
        
                    request.setAttribute("money", totalTest);
//                            request.setAttribute("im", immunoassTest);
//            request.setAttribute("bi", biochemistryTests);
//            request.setAttribute("bl", td.getTest("Blood_Test", pt.getId()));
//            request.setAttribute("patient", pt);
                    request.getRequestDispatcher("addTest.jsp").forward(request, response);
                    break;

                case "Bio":
                    float Fasting = Float.parseFloat((String) request.getParameter("Fasting"));
                    float PP = Float.parseFloat((String) request.getParameter("PP"));
                    float Urea = Float.parseFloat((String) request.getParameter("Urea"));
                    float S_Cr = Float.parseFloat((String) request.getParameter("S_Cr"));
                    float Sodium = Float.parseFloat((String) request.getParameter("Sodium"));
                    float Potassium = Float.parseFloat((String) request.getParameter("Potassium"));
                    float Choloride = Float.parseFloat((String) request.getParameter("Choloride"));
                    float TCalcium = Float.parseFloat((String) request.getParameter("TCalcium"));
                    float Scardium = Float.parseFloat((String) request.getParameter("Scardium"));
                    float UricAcid = Float.parseFloat((String) request.getParameter("UricAcid"));
                    float TBilirubin = Float.parseFloat((String) request.getParameter("TBilirubin"));
                    float AP = Float.parseFloat((String) request.getParameter("AP"));
                    float TProtein = Float.parseFloat((String) request.getParameter("TProtein"));
                    float Albumin = Float.parseFloat((String) request.getParameter("Albumin"));
                    float TCholesterol = Float.parseFloat((String) request.getParameter("TCholesterol"));
                    float Triglyceride = Float.parseFloat((String) request.getParameter("Triglyceride"));
                    float ADA = Float.parseFloat((String) request.getParameter("ADA"));
                    BiochemistryTests Bit = new BiochemistryTests(Integer.parseInt(id),idOfTest, Fasting, PP, Urea, S_Cr, Sodium, Potassium, Choloride, TCalcium, Scardium, UricAcid, TBilirubin, AP, TProtein, Albumin, TCholesterol, Triglyceride, ADA);

                    td.addBiochemistryTestdata(Bit);

                    float[] variables2 = {Fasting, PP, Urea, S_Cr, Sodium, Potassium, Choloride, TCalcium, UricAcid, TBilirubin, AP, TProtein, Albumin, TCholesterol, Triglyceride, ADA};
                    for (int i = 0; i < variables2.length; i++) {
                        if (variables2[i] != 0) {
                            count_free++;
                            // The i-th variable is equal to 0
                        }
                    }
                    totalTest = String.valueOf(count_free);
                    request.setAttribute("money", totalTest);
//                            request.setAttribute("im", immunoassTest);
//            request.setAttribute("bi", Bit);
//            request.setAttribute("bl",  td.getTest("Biochemistry_Test", pt.getId()));
//            request.setAttribute("patient", pt);

                    request.getRequestDispatcher("addTest.jsp").forward(request, response);
                    break;
                case "Imm":

                    float Digoxin = Float.parseFloat((String) request.getParameter("Digoxin"));
                    float Estradiol = Float.parseFloat((String) request.getParameter("Estradiol"));
                    float Ferritin = Float.parseFloat((String) request.getParameter("Ferritin"));
                    float FAcid = Float.parseFloat((String) request.getParameter("FAcid"));
                    float Progesterone = Float.parseFloat((String) request.getParameter("Progesterone"));
                    float Prolactin = Float.parseFloat((String) request.getParameter("Prolactin"));
                    float TroponinT = Float.parseFloat((String) request.getParameter("TroponinT"));
                    float Testosterone = Float.parseFloat((String) request.getParameter("Testosterone"));
                    float PSA = Float.parseFloat((String) request.getParameter("PSA"));
                    ImmunoassTest Imm = new ImmunoassTest(1,idOfTest, Digoxin, Estradiol, Ferritin, FAcid, Progesterone, Prolactin, TroponinT, Testosterone, PSA);
                    td.addImmunoassTestdata(Imm);
//                            request.setAttribute("im",  td.getTest("Immunoass_Test", pt.getId()));
//            request.setAttribute("bi", biochemistryTests);
//            request.setAttribute("bl", bloodTests);
//            request.setAttribute("patient", pt);
                    float[] variables3 = {Digoxin, Estradiol, Ferritin, FAcid, Progesterone, Prolactin, TroponinT, Testosterone, PSA};
                    for (int i = 0; i < variables3.length; i++) {
                        if (variables3[i] != 0) {
                            count_free++;
                        }
                    }
               totalTest = String.valueOf(count_free);
                    request.setAttribute("money", totalTest);
                    request.getRequestDispatcher("addTest.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
//        if (check != null) {
//            Pt.setPaID(Integer.parseInt(check));
//            td.UpdateTest(Pt);
//        }

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
