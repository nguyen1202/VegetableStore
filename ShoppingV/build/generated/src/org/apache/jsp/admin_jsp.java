package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sample.vegetable.VegetableDTO;
import java.util.List;
import sample.user.UserDTO;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Page</title>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        body{\n");
      out.write("            background-image: url('');\n");
      out.write("            background-size: cover;\n");
      out.write("            color: black;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        ");

            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !loginUser.getRoleID().equals("AD")) {
                response.sendRedirect("login.jsp");
                return;
            }
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        
      out.write("\n");
      out.write("        <h1 style=\"text-align:center;\">Welcome Admin: </h1>\n");
      out.write("        <h2 style=\"text-align:center; font-size: 300%\" >");
      out.print( loginUser.getFullName());
      out.write("</h2>\n");
      out.write("        <form action=\"MainController\" method=\"POST\">           \n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Logout\"/>\n");
      out.write("        </form>\n");
      out.write("        <form action=\"MainController\">\n");
      out.write("            Search <input type=\"text\" name=\"search\" required=\"\" value=\"");
      out.print( search);
      out.write("\"/>\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Search2\" />\n");
      out.write("        </form>\n");
      out.write("        <!-- Insert -->\n");
      out.write("        <form action=\"MainController\">        \n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Insert\"/>\n");
      out.write("        </form>\n");
      out.write("        ");

            List<VegetableDTO> listV = (List<VegetableDTO>) request.getAttribute("LIST_V");
            if (listV != null) {
                if (listV.size() > 0) {
        
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th >No</th>\n");
      out.write("                    <th>Product ID</th>\n");
      out.write("                    <th>Product Name</th>\n");
      out.write("                    <th>Image</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Category ID</th>\n");
      out.write("                    <th>Import Date</th>\n");
      out.write("                    <th>Using Date</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    int count = 1;
                    for (VegetableDTO V : listV) {
                
      out.write("\n");
      out.write("            <form action=\"MainController\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <td>");
      out.print( count++);
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"productID\" value=\"");
      out.print( V.getProductID());
      out.write("\" required=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"productName\" value=\"");
      out.print( V.getProductName());
      out.write("\" required=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <img src=\"");
      out.print( V.getImage());
      out.write("\" hspace=\"10\" style=“width:30px;height:30px;\" readonly=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"number\" name=\"price\" value=\"");
      out.print( V.getPrice());
      out.write("\" required=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"number\" name=\"quantity\" value=\"");
      out.print( V.getQuantity());
      out.write("\" required=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"categoryID\" value=\"");
      out.print( V.getCategoryID());
      out.write("\" required=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"date\" name=\"importDate\" value=\"");
      out.print( V.getImportDate());
      out.write("\" required=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"date\" name=\"usingDate\" value=\"");
      out.print( V.getUsingDate());
      out.write("\" required=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                    <!-- Delete -->\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"submit\" name=\"action\" value=\"Delete\"/>\n");
      out.write("                        <input type=\"hidden\" name=\"search\" value=\"");
      out.print( search);
      out.write("\"\n");
      out.write("\n");
      out.write("                    </td> \n");
      out.write("\n");
      out.write("                    <!-- Update -->\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"submit\" name=\"action\" value=\"Update\"/>\n");
      out.write("                        <input type=\"hidden\" name=\"search\" value=\"");
      out.print( search);
      out.write("\"\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("            </form>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("\n");
      out.write("    ");

        String error = (String) request.getAttribute("ERROR");
        if (error == null) {
            error = "";
        }

    
      out.write("\n");
      out.write("    <h1>");
      out.print( error);
      out.write(" </h1> \n");
      out.write("    ");

            }
        }
    
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
