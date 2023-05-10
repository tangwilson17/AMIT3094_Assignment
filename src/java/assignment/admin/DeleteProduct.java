/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment.admin;

import entity.Category;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
import javax.transaction.RollbackException;
import javax.transaction.UserTransaction;

/**
 *
 * @author LocalMachine
 */
@WebServlet(name = "DeleteProduct", urlPatterns = {"/admin/DeleteProduct"})
public class DeleteProduct extends HttpServlet {


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

        HttpSession session = request.getSession();
        String getString = request.getQueryString();
        if (getString != null) {
            String productId = getString.split("=")[1];

            try {
                tx.begin();
                Product product = manager.find(Product.class, Integer.valueOf(productId));
                if (product != null) {
                    manager.remove(product);
                    tx.commit();
                    response.sendRedirect("/AMIT3094_Assignment/admin/product-list");
                    return;
                }
                response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
            }catch(RollbackException e){
                session.setAttribute("error", 1);
                session.setAttribute("error_msg", "Unable to delete product, please ensure all orders with this product has been removed");
                response.sendRedirect("/AMIT3094_Assignment/admin/edit-product.jsp");
                return;
            } catch (Exception e) {
                // Something went wrong page here
                session.setAttribute("error", e);
                response.sendRedirect("/AMIT3094_Assignment/admin/error.jsp");
            }
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
