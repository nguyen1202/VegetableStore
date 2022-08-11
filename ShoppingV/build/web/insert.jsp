<%-- 
    Document   : insert
    Created on : Mar 10, 2022, 8:50:34 PM
    Author     : Admin
--%>

<%@page import="sample.vegetable.VegetableError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>*CREATE A NEW PRODUCT*</title>
    </head>
    <body>
        <h1>*CREATE A NEW PRODUCT*</h1>
        <%
            VegetableError VE = (VegetableError) request.getAttribute("VEGETABLE_ERROR");
            if (VE == null) {
                VE = new VegetableError();
            }
        %>

        <form action="MainController" method="POST">
            Product ID: <input type="text" name="productID" required="" />
            <%= VE.getProductIDError()%> </br>

            Product Name: <input type="text" name="productName" required="" />
            <%= VE.getProductNameError()%></br>

            Image: <input type="text" name="image"/></br>

            Price: <input type="number" name="price" required="" min="0"/>
            </br>

            Quantity: <input type="number" name="quantity" required="" min="1"/>
            </br>

            CategoryID: <input type="text" name="categoryID" required="" />
            <%= VE.getCategoryIDError()%></br>

            Import Date: <input type="date" name="importDate" required="" /></br>


            Using Date: <input type="date" name="usingDate" required="" /></br>


            <input type="submit" name="action" value="Insert" />
            <input type="reset" value="Reset" />
        </form>
        <%
            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <h1><center><%= message%></center></h1>
        <a href="MainController?action=Search2&search=">Admin Page</a>
    </body>
</html>
