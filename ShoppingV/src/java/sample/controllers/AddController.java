package sample.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.vegetable.Cart;
import sample.vegetable.VegetableDTO;

@WebServlet(name = "AddController", urlPatterns = {"/AddController"})
public class AddController extends HttpServlet {

    private static final String ERROR = "MainController?action=Search&search=";
    private static final String SUCCESS = "MainController?action=Search&search=";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        
        try {
            String productID = request.getParameter("productID");
            String productName = request.getParameter("productName");
            String image = request.getParameter("image");
            float price = Float.parseFloat(request.getParameter("price"));
            int quantity_add = Integer.parseInt(request.getParameter("quantity_add"));            
            String categoryID = request.getParameter("categoryID");
//            Date importDate = Date.valueOf(getInitParameter("importDate"));
//            Date usingDate = Date.valueOf(getInitParameter("usingDate"));
            
            VegetableDTO V = new VegetableDTO(productID, productName, image, price, quantity_add, categoryID);
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            
            if(cart == null){
                cart = new Cart();
            }
            if(quantity_add > Integer.parseInt(request.getParameter("quantity"))){
                String message = "This product only has  "+ Integer.parseInt(request.getParameter("quantity") +" pieces left");
                request.setAttribute("MESSAGE", message);
                url= SUCCESS;
            }else{
                cart.add(V);
                session.setAttribute("CART", cart);
                request.setAttribute("MESSAGE","You added " + quantity_add +" "+ productName +" into ur cart!!!");
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at AddController: "+ e.toString());
        }finally{
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
