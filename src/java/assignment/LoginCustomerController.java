/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment;

import entity.Customer;
import entity.CustomerService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class LoginCustomerController extends HttpServlet {

    @PersistenceContext
    EntityManager manager;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //String email = request.getParameter("email");
        //String password = request.getParameter("password");
        HttpSession session = request.getSession();
        //CustomerService customerService = new CustomerService(manager);
        /*
        if (!customerService.checkIfEmailExists(email)) {
            session.setAttribute("status", "invalidEmail");
            System.out.print(email);
            response.sendRedirect("login.jsp");
            return;
        }*/
        
        if (request.getParameter("email").isEmpty()) {
            session.setAttribute("status", "EmptyEmail");
            response.sendRedirect("login.jsp");
            return;
        }
        if (request.getParameter("password").isEmpty()) {
            session.setAttribute("status", "EmptyPass");
            response.sendRedirect("login.jsp");
            return;
        }
        
        try {
            Query query = manager.createNamedQuery("Customer.findByEmailAndPassword");
            query.setParameter("email", request.getParameter("email"));
            query.setParameter("password", request.getParameter("password"));

            try {
                Customer customer = (Customer) query.getSingleResult();
                session.setAttribute("customer", customer);
                response.sendRedirect("index.jsp");
            } catch (NoResultException e) {
                session.setAttribute("status", "loginError");
                
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            // Something went wrong page here
            e.printStackTrace();
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
