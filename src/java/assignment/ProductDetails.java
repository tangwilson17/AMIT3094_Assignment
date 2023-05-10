/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment;

import entity.Category;
import entity.Product;
import entity.CategoryModel;
import java.io.IOException;
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
public class ProductDetails extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // initiate Session
            HttpSession session = request.getSession();

            int ID = Integer.parseInt(request.getParameter("prodID"));
            Product prod = em.find(Product.class, ID);
            session.setAttribute("prod", prod);

            int categoryID = Integer.parseInt(request.getParameter("catID"));

            CategoryModel catModel = new CategoryModel(em);
            Category category = catModel.getCategoryByID(categoryID);
            session.setAttribute("category", category);

            response.sendRedirect("ShowProdDetails.jsp");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
