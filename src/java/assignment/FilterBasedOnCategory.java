/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment;

import entity.BrowseCategoryModel;
import entity.Category;
import entity.CategoryModel;
import entity.Product;
import java.io.IOException;
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
public class FilterBasedOnCategory extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    Query query;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();

            int categoryID = Integer.parseInt(request.getParameter("categoryID"));
            session.setAttribute("categoryID", categoryID);

            //for browse category
            CategoryModel cat = new CategoryModel(em);
            List<Category> catList = cat.findAll();
            session.setAttribute("catList", catList);

            int filterOption = Integer.parseInt(request.getParameter("filter")); 

            BrowseCategoryModel browseModel = new BrowseCategoryModel(em);
            List<Product> prodList = browseModel.FilterBasedOnCategory(categoryID, filterOption);
            
            if (prodList.isEmpty()) {
                response.sendRedirect("ProductNotFound.jsp");
            } else {
                session.setAttribute("prodList", prodList);
                response.sendRedirect("BrowseCategory.jsp");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
