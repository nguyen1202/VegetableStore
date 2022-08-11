<%-- 
    Document   : admin
    Created on : Mar 7, 2022, 8:01:31 PM
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
        <title>Admin Page</title>
    </head>
    <style>
        body{
            background-image: url('');
            background-size: cover;
            color: black;
        }
    </style>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !loginUser.getRoleID().equals("AD")) {
                response.sendRedirect("login.jsp");
                return;
            }
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <h1 style="text-align:center;">Welcome Admin: </h1>
        <h2 style="text-align:center; font-size: 300%" ><%= loginUser.getFullName()%></h2>
        <form action="MainController" method="POST">           
            <input type="submit" name="action" value="Logout"/>
        </form>
        <form action="MainController">
            Search <input type="text" name="search" required="" value="<%= search%>"/>
            <input type="submit" name="action" value="Search2" />
        </form>
        <!-- Insert -->
        <form action="MainController">        
            <input type="submit" name="action" value="Insert"/>
        </form>
        <%
            List<VegetableDTO> listV = (List<VegetableDTO>) request.getAttribute("LIST_V");
            if (listV != null) {
                if (listV.size() > 0) {
        %>
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
                        <input type="text" name="productID" value="<%= V.getProductID()%>" required=""/>
                    </td>
                    <td>
                        <input type="text" name="productName" value="<%= V.getProductName()%>" required=""/>
                    </td>
                    <td>
                        <img src="<%= V.getImage()%>" hspace="10" style=“width:30px;height:30px;" readonly=""/>
                    </td>
                    <td>
                        <input type="number" name="price" value="<%= V.getPrice()%>" required=""/>
                    </td>
                    <td>
                        <input type="number" name="quantity" value="<%= V.getQuantity()%>" required=""/>
                    </td>
                    <td>
                        <input type="text" name="categoryID" value="<%= V.getCategoryID()%>" required=""/>
                    </td>
                    <td>
                        <input type="date" name="importDate" value="<%= V.getImportDate()%>" required=""/>
                    </td>
                    <td>
                        <input type="date" name="usingDate" value="<%= V.getUsingDate()%>" required=""/>
                    </td>

                    <!-- Delete -->
                    <td>
                        <input type="submit" name="action" value="Delete"/>
                        <input type="hidden" name="search" value="<%= search%>"

                    </td> 

                    <!-- Update -->
                    <td>
                        <input type="submit" name="action" value="Update"/>
                        <input type="hidden" name="search" value="<%= search%>"

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
