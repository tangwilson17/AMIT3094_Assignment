/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment;

import entity.Category;
import entity.CategoryModel;
import entity.Product;
import entity.BrowseCategoryModel;
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
public class BrowseCategory extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int categoryID = Integer.parseInt(request.getParameter("categoryID"));
            session.setAttribute("categoryID",categoryID);
            
            String categoryName = request.getParameter("categoryName");
            session.setAttribute("categoryName",categoryName);

            BrowseCategoryModel browse = new BrowseCategoryModel(em);
            List<Product> prodList = browse.BrowseCategory(categoryID);
            session.setAttribute("prodList", prodList);

            CategoryModel cat = new CategoryModel(em);
            List<Category> catList = cat.findAll();
            session.setAttribute("catList", catList);

            response.sendRedirect("BrowseCategory.jsp");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
