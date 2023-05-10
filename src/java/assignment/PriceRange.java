/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment;

import entity.Category;
import entity.CategoryModel;
import entity.Product;
import entity.PriceRangeModel;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mayte
 */
public class PriceRange extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();

            //for browse category
            CategoryModel cat = new CategoryModel(em);
            List<Category> catList = cat.findAll();
            session.setAttribute("catList", catList);

            double minNum = Double.parseDouble(request.getParameter("minNum"));
            double maxNum = Double.parseDouble(request.getParameter("maxNum"));
            session.setAttribute("minPrice", minNum);
            session.setAttribute("maxPrice", maxNum);

            PriceRangeModel rangeModel = new PriceRangeModel(em);
            List<Product> prodList = rangeModel.PriceRange(minNum, maxNum);
            session.setAttribute("prodList", prodList);

            if (prodList.isEmpty()) {
                response.sendRedirect("ProductNotFound.jsp");
            } else {
                response.sendRedirect("PriceRangeResult.jsp");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
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
