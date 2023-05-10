/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package assignment;

import entity.Category;
import entity.CategoryModel;
import entity.Product;
import entity.ProductSearchModel;
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
public class FilterOnSearch extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();

            String searchProd = request.getParameter("searchProd");
            session.setAttribute("searchProd", searchProd);

            //for browse category
            CategoryModel cat = new CategoryModel(em);
            List<Category> catList = cat.findAll();
            session.setAttribute("catList", catList);

            int filterOption = Integer.parseInt(request.getParameter("filter")); 

            ProductSearchModel searchModel = new ProductSearchModel(em);
            List<Product> prodList = searchModel.FilterOnSearch(searchProd,filterOption);
   
            session.setAttribute("prodList", prodList);
              if (prodList.isEmpty()) {
                response.sendRedirect("ProductNotFound.jsp");
            } else {
                response.sendRedirect("searchResult.jsp");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
