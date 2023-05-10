/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment;

import entity.Customer;
import entity.CustomerService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author User
 */
public class ForgotPasswordCustomerController extends HttpServlet {

    @PersistenceContext
    EntityManager manager;
    @Resource
    UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        CustomerService customerService = new CustomerService(manager);
        HttpSession session = request.getSession();
        
        if (email == null || email.equals("")) {
            session.setAttribute("status", "EmptyEmail");
            response.sendRedirect("ForgotPassword.jsp");
            return;
        }        
        if (password == null || password.equals("")) {
            session.setAttribute("status", "EmptyPass");
            response.sendRedirect("ForgotPassword.jsp");
            return;
        }
        if (cpassword == null || cpassword.equals("")) {
            session.setAttribute("status", "EmptyConfirmPass");
            response.sendRedirect("ForgotPassword.jsp");
            return;
        }
        
        if (!password.equals(cpassword)){
            session.setAttribute("status", "invalidConfirmPassword");
            response.sendRedirect("ForgotPassword.jsp");
            return;
        }
        
        try {
            
            Customer customer = new Customer(email, password);
             
            utx.begin();
            boolean success = customerService.updateCustomer(customer);
            utx.commit();
            
                            
            if (success) {
                session.setAttribute("status", "success");
            } else {
                session.setAttribute("status", "failure");
            }
            
            response.sendRedirect("login.jsp");
             
        }catch(Exception ex){
             Logger.getLogger(RegistrationCustomerController.class.getName()).log(Level.SEVERE, null, ex);
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
