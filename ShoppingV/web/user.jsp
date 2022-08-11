<%-- 
    Document   : user
    Created on : Feb 16, 2022, 8:11:59 AM
    Author     : Admin
--%>

<%@page import="sample.vegetable.VegetableDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <style>
        body{
            background-color: black;
            
            color: white;
        }
    </style>
    <body>

        <h1>Your Information</h1>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !loginUser.getRoleID().equals("US")) {
                response.sendRedirect("login.jsp");
                return;

            }
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        User ID: <%= loginUser.getUserID()%></br>
        Full Name: <%= loginUser.getFullName()%></br>
        Password:  <%= "***"%></br>
        Role ID: <%= loginUser.getRoleID()%></br>
        Address: <%= loginUser.getAddress()%></br>
        Phone: <%= loginUser.getPhone()%></br>
        Birthday: <%= loginUser.getBirthday()%></br>



        Welcome: <h1><%= loginUser.getFullName()%></h1>
        <!--        <a href="MainController?action=Logout" >Logout</a> -->
        <form action="MainController" method="POST">           
            <input type="submit" name="action" value="Logout"/>
        </form>
        <form action="MainController">
            Search <input type="text" name="search" required="" value="<%= search%>"/>
            <input type="submit" name="action" value="Search" />       
        </form>
        <%
            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <h1><center><%= message%></center></h1>
        <%
            List<VegetableDTO> listV = (List<VegetableDTO>) request.getAttribute("LIST_V");
            if (listV != null) {
                if (listV.size() > 0) {
        %>
        <form action="MainController">
            <input type="submit" name="action" value="View"/>
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th >No</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Image</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Category ID</th>
                    <th>Import Date</th>
                    <th>Using Date</th>
                    <th>Add quantity</th>
                    <th>Add To Cart</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (VegetableDTO V : listV) {
                %>
            <form action="MainController">


                <tr>


                    <td><%= count++%></td>
                    <td>
                        <input type="text" name="productID" value="<%= V.getProductID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productName" value="<%= V.getProductName()%>" readonly=""/>
                    </td>
                    <td>
                        <img src="<%= V.getImage()%>" hspace="10" style=“width:30px;height:30px;" readonly=""/>
                    </td>
                    <td>
                        <input type="number" name="price" value="<%= V.getPrice()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="number" name="quantity" value="<%= V.getQuantity()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="categoryID" value="<%= V.getCategoryID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="date" name="importDate" value="<%= V.getImportDate()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="date" name="usingDate" value="<%= V.getUsingDate()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="number" name="quantity_add" value="1"/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="Add"/>
                    </td>
                </tr>
            </form>
            <%
                }
            %>

        </tbody>
    </table>

    <%
        String error = (String) request.getAttribute("ERROR");
        if (error == null) {
            error = "";
        }

    %>
    <h1><%= error%> </h1> 
    <%
            }
        }
    %>

</body>
</html>
