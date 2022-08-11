package sample.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.vegetable.Cart;
import sample.order.OrderDAO;
import sample.vegetable.VegetableDTO;
import sample.user.UserDTO;

@WebServlet(name = "CheckOutController", urlPatterns = {"/CheckOutController"})
public class CheckOutController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "viewCart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        int count = 0;
        int countRemove = 0;
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                Cart cart = (Cart) session.getAttribute("CART");
                if (cart != null) {
                    for (VegetableDTO dto : cart.getCart().values()) {
                        OrderDAO dao = new OrderDAO();
                        if (dao.getQuantity(dto.getProductID()) >= dto.getQuantity()) {
                            url = SUCCESS;
                            request.setAttribute("CHECK_MESSAGE", "DONE <3");
                            countRemove = 1;
                        } else {
                            url = SUCCESS;
                            count = 1;
                            request.setAttribute("CHECK_MESSAGE", "Only" + dao.getQuantity(dto.getProductID()) + dto.getProductName() + " left in the store :v");
                            break;
                        }
                        if (countRemove != 1) {
                                session.removeAttribute("CART");
                            }    
                    }

//                    if (count != 1) {
//                        OrderDAO o = new OrderDAO();
//                        double total = Double.parseDouble(request.getParameter("total"));
//                        UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
//                        String userID = user.getUserID();
//                        String orderID = o.insertOrder(userID, total);
//                        if (!orderID.isEmpty()) {
//                            int countRemove = 0;
//                            for (VegetableDTO dto : cart.getCart().values()) {
//                                boolean checkDetail = o.insertOrderDetail(dto, orderID);
//                                if (checkDetail) {
//                                    url = SUCCESS;
//                                    o.updateQuantity(dto.getProductID(), o.getQuantity(dto.getProductID()) - dto.getQuantity());
//
//                                } else {
//                                    countRemove = 1;
//                                    url = ERROR;
//                                    session.setAttribute("ERROR_MESSAGE", "DETAIL is not available to insert");
//                                }
//                            }
//                            if (countRemove != 1) {
//                                session.removeAttribute("CART");
//                            }
//                        } else {
//                            url = ERROR;
//                            session.setAttribute("ERROR_MESSAGE", "DETAIL is not available");
//                        }
//                    }
                } else {
                    url = ERROR;
                    session.setAttribute("ERROR_MESSAGE", "YOUR CART IS EMPTY FOR NOW!!!");
                }
            } else {
                url = ERROR;
                session.setAttribute("ERROR_MESSAGE", "YOUR CART IS EMPTY FOR NOW!!!");
            }
        } catch (Exception e) {
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

