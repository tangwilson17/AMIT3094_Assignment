/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment.admin;

import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author LocalMachine
 */
@WebServlet(name = "AddCustomer", urlPatterns = {"/admin/AddCustomer"})
public class AddCustomer extends HttpServlet {

    @PersistenceContext
    private EntityManager manager;
    @Resource
    UserTransaction tx;

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
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Customer newCustomer = new Customer();

        try {
            tx.begin();
        } catch (Exception e) {
            session.setAttribute("error", e);
            response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
        }

        if (request.getParameter("customer-name").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("nameError", "Customer name can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/customer-list.jsp");
            return;
        } else {
            newCustomer.setCustomerName(request.getParameter("customer-name"));
        }

        if (request.getParameter("customer-email").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("emailError", "Email can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/customer-list.jsp");
            return;
        } else {
            
            try {
                Query query = manager.createNamedQuery("Customer.findByEmail");
                query.setParameter("email", request.getParameter("customer-email"));
                Customer existEmail = (Customer) query.getSingleResult();

                session.setAttribute("error", 1);
                session.setAttribute("emailError", "Email already exist");
                response.sendRedirect("/AMIT3094_Assignment/admin/customer-list.jsp");
                return;
            } catch (NoResultException e) {
                newCustomer.setEmail(request.getParameter("customer-email"));
            } catch (Exception e) {
                session.setAttribute("error", e);
                response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
            }
            
        }

        if (request.getParameter("customer-password").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("passwordError", "Password can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/customer-list.jsp");
            return;
        }

        if (request.getParameter("customer-confirm-password").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("confirmPasswordError", "Confirm password can't be empty");
            response.sendRedirect("/AMIT3094_Assignment/admin/customer-list.jsp");
            return;
        }

        if (!request.getParameter("customer-password").equals(request.getParameter("customer-confirm-password"))) {
            session.setAttribute("error", 1);
            session.setAttribute("passwordError", "Password and confirm password does not match");
            session.setAttribute("confirmPasswordError", "Password and confirm password does not match");
            response.sendRedirect("/AMIT3094_Assignment/admin/customer-list.jsp");
            return;
        } else {
            newCustomer.setPassword(request.getParameter("customer-password"));
        }

        if (request.getParameter("customer-contact").isEmpty()) {
            session.setAttribute("error", 1);
            session.setAttribute("contactError", "Password and confirm password does not match");
            response.sendRedirect("/AMIT3094_Assignment/admin/edit-customer.jsp");
            return;
        } else {
            newCustomer.setCustomerContact(request.getParameter("customer-contact"));
        }

        try {
            manager.persist(newCustomer);
            tx.commit();
            response.sendRedirect("/AMIT3094_Assignment/admin/customer-list.jsp");
            return;
        } catch (Exception e) {
            session.setAttribute("error", e);
            response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
            return;
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
