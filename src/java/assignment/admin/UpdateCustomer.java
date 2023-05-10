/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment.admin;

import entity.Customer;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author LocalMachine
 */
public class UpdateCustomer extends HttpServlet {

    @PersistenceContext
    private EntityManager manager;
    @Resource
    UserTransaction tx;

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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Customer updatedCustomer;
        try {
            tx.begin();
        } catch (Exception e) {
            session.setAttribute("error", e);
            response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
        }

        try {
            updatedCustomer = manager.find(Customer.class, Integer.valueOf(request.getParameter("customer-id")));
        } catch (Exception e) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Oops, something went wrong!");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-customer.jsp");
            return;
        }

        if (request.getParameter("customer-name").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Customer name can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-customer.jsp");
            return;
        } else {
            updatedCustomer.setCustomerName(request.getParameter("customer-name"));
        }

        if (request.getParameter("customer-email").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Customer email can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-customer.jsp");
            return;
        } else {
            updatedCustomer.setEmail(request.getParameter("customer-email"));
        }

        if (request.getParameter("customer-contact").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("error_msg", "Customer contact number can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-customer.jsp");
            return;
        } else {
            updatedCustomer.setCustomerContact(request.getParameter("customer-contact"));
        }
        
        try {
            tx.commit();
            session.setAttribute("error", 0);
            response.sendRedirect("/AMIT3094_Assignment/admin/GetCustomerDetails?customerId=" + request.getParameter("customer-id"));
            return;
        } catch (Exception e) {
            session.setAttribute("error", e);
            response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
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
