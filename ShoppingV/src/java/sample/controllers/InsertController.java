package sample.controllers;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.vegetable.VegetableDAO;
import sample.vegetable.VegetableDTO;
import sample.vegetable.VegetableError;

@WebServlet(name = "InsertController", urlPatterns = {"/InsertController"})
public class InsertController extends HttpServlet {

    private static final String ERROR = "insert.jsp";
    private static final String SUCCESS = "insert.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        VegetableError VE = new VegetableError();
        try {
            String productID = request.getParameter("productID");
            String productName = request.getParameter("productName");
            String image = request.getParameter("image");
            Float price = Float.parseFloat(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String categoryID = request.getParameter("categoryID");
            Date importDate = Date.valueOf(request.getParameter("importDate"));
            Date usingDate = Date.valueOf(request.getParameter("usingDate"));
            VegetableDAO dao = new VegetableDAO();
            
            boolean checkValidation = true;
            if (productID.length() < 2 || productID.length() > 10) {
                checkValidation = false;
                VE.setProductIDError("ProductID must be in [2,10]");
            }
            
            if (productName.length() < 3 || productName.length() > 20) {
                checkValidation = false;
                VE.setProductNameError("ProductName must be in [3,20]");
            }
            
            if (price < 0) {
                checkValidation = false;
                VE.setProductNameError("Price must be >= 1");
            }
            
            if (quantity < 1) {
                checkValidation = false;
                VE.setProductNameError("Quantity must be >= 1");
            }
            
            if (categoryID.length() < 2 || categoryID.length() > 20) {
                checkValidation = false;
                VE.setProductNameError("CategoryID must be in [2,20]");
            }
            
            if (checkValidation) {
                VegetableDTO vegetable = new VegetableDTO(productID, productName, image, price, quantity, categoryID, importDate, usingDate);
                boolean checkInsert = dao.insert(vegetable);
                if (checkInsert) {
                    request.setAttribute("MESSAGE", "insert successfully");
                    
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("VEGETABLE_ERROR", VE);
            }
            
        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                VE.setProductIDError("Duplicate productID !!!");
                request.setAttribute("VEGETABLE_ERROR", VE);
            }
            log("Error at CreateController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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

