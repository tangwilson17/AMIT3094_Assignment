/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment;

import entity.BrowseCategoryModel;
import entity.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mayte
 */
public class FilterRangeOnCategory extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    Query query;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();

            int categoryID = Integer.parseInt(request.getParameter("categoryID"));
            session.setAttribute("categoryID", categoryID);

            double minNum = Double.parseDouble(request.getParameter("minNum"));
            double maxNum = Double.parseDouble(request.getParameter("maxNum"));
            session.setAttribute("minNum", minNum);
            session.setAttribute("maxNum", maxNum);

            int filterOption = Integer.parseInt(request.getParameter("filter"));
            
            BrowseCategoryModel browseModel = new BrowseCategoryModel(em);
            List<Product>prodList = browseModel.FilterBasedOnCategory(categoryID, filterOption);
            
             List<Product> filteredProdList = new ArrayList<>();
            for (Product p : prodList) {
                if (p.getPrice() >= minNum && p.getPrice() <= maxNum) {
                    filteredProdList.add(p);
                }
            }
            session.setAttribute("prodList", filteredProdList);
            response.sendRedirect("RangeResultOnCategory.jsp");
    
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
