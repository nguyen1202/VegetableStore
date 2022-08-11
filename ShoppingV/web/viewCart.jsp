<%-- 
    Document   : viewCart
    Created on : Feb 27, 2022, 1:10:15 PM
    Author     : Admin
--%>

<%@page import="sample.vegetable.VegetableDTO"%>
<%@page import="sample.vegetable.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAYMENT PAGE</title>
    </head>
    <body>
        <h1>Your cart:</h1>

        <%
            Cart cart = (Cart) session.getAttribute("CART");
            double total = 0;
            if (cart == null) {
        %>
        <h1>Your cart is empty!!</h1>
        <%
        } else {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Category ID</th>
                    <th>Total</th>
                    <th>Remove</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (VegetableDTO V : cart.getCart().values()) {
                        total += V.getPrice() * V.getQuantity();
                %>
            <form action="MainController">

                <tr>
                    <td><%= count++%></td>
                    <td>
                        <%= V.getProductID()%>
                        <input type="hidden" name="productID" value="<%= V.getProductID()%>"/>
                    </td>
                    <td><%= V.getProductName()%></td>
                    <td><%= V.getPrice()%></td>
                    <td>
                        <input type="number" name="quantity" value="<%= V.getQuantity()%>" min="1" required=""/>
                    </td>
                    <td><%= V.getCategoryID()%></td>
                    <td><%= V.getPrice() * V.getQuantity()%></td> 
                    <td>
                        <input type="submit" name="action" value="Remove"/>
                    </td>                   
                    <td>
                        <input type="submit" name="action" value="Edit"/>
                    </td>                   
                </tr>
            </form>
            <%
                }
            %>

        </tbody>
    </table>
    <h1>Total: <%= total%></h1>
    <%
        }
    %>
    <form action="MainController">
        <input type="submit" name="action" value="Add"/>
    </form>
    <form action="MainController">
        
        <input type="hidden" name="total" value="<%= total%>"/>
        <input type="submit" name="action" value="Check"/>      
    </form>

    <%
        String message = (String) request.getAttribute("CHECK_MESSAGE");
        if (message == null) {
            message = "";
        }
    %>

    <h2><%= message%></h2>
</body>
</html>
