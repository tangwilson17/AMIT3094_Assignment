/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment;

import entity.Customer;
import entity.CustomerService;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
public class RegistrationCustomerController extends HttpServlet {

    @PersistenceContext
    EntityManager manager;
    @Resource
    UserTransaction utx;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneNo = request.getParameter("phoneNo");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        HttpSession session = request.getSession();
        CustomerService customerService = new CustomerService(manager);
        
        if (name == null || name.equals("")) {
            session.setAttribute("status", "EmptyName");
            response.sendRedirect("customer/registration.jsp");
            return;
        }
        
        if (email == null || email.equals("")) {
            session.setAttribute("status", "EmptyEmail");
            response.sendRedirect("customer/register.jsp");
            return;
        }
        if (phoneNo == null || phoneNo.equals("")) {
            session.setAttribute("status", "EmptyPhoneNo");
            response.sendRedirect("customer/register.jsp");
            return;
        }
        if (password == null || password.equals("")) {
            session.setAttribute("status", "EmptyPass");
            response.sendRedirect("customer/register.jsp");
            return;
        }
        if (cpassword == null || cpassword.equals("")) {
            session.setAttribute("status", "EmptyConfirmPass");
            response.sendRedirect("customer/register.jsp");
            return;
        }
        
        if (customerService.checkIfEmailExists(email)) {
            session.setAttribute("status", "invalidEmail");
            System.out.print(email);
            response.sendRedirect("customer/register.jsp");
            return;
        }
        
        if (!password.equals(cpassword)){
            session.setAttribute("status", "invalidConfirmPassword");
            response.sendRedirect("customer/register.jsp");
            return;
        }
        
        try {
                       
            Customer customer = new Customer(name, email, phoneNo, password);
            
            
            utx.begin();
            boolean success = customerService.addCustomer(customer);
            utx.commit();
            
                            
            if (success) {
                session.setAttribute("status", "success");
            } else {
                session.setAttribute("status", "failure");
            }
            response.sendRedirect("customer/login.jsp");
            
            
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
