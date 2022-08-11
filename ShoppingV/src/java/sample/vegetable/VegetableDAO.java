package sample.vegetable;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

public class VegetableDAO {

    private static final String SEARCH = "SELECT productID, productName, image, price, quantity, categoryID, importDate, usingDate FROM tblProduct WHERE productName like ?";
    private static final String INSERT = "INSERT INTO tblProduct(productID, productName, image, price, quantity, categoryID, importDate, usingDate) VALUES(?,?,?,?,?,?,?,?)";
    private static final String ADD = "SELECT productID, productName, image, price, quantity, categoryID, importDate, usingDate FROM tblProduct ";
    private static final String CHECK_DUPLICATE = "SELECT productName FROM tblProduct WHERE productID = ? ";
    private static final String DELETE = "DELETE tblProduct WHERE productID=? ";
    private static final String UPDATE = "UPDATE tblProduct SET productName=?, price=?, quantity=?, categoryID=?, importDate=?, usingDate=? WHERE productID=?";
    
    

    public List<VegetableDTO> getListVegetable(String search) throws SQLException {
        List<VegetableDTO> listV = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    Date importDate = rs.getDate("importDate");
                    Date usingDate = rs.getDate("usingDate");

                    listV.add(new VegetableDTO(productID, productName, image, price, quantity, categoryID, importDate, usingDate));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listV;
    }

    public boolean insert(VegetableDTO V) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, V.getProductID());
                ptm.setString(2, V.getProductName());
                ptm.setString(3, V.getImage());
                ptm.setFloat(4, V.getPrice());
                ptm.setInt(5, V.getQuantity());
                ptm.setString(6, V.getCategoryID());
                ptm.setDate(7, V.getImportDate());
                ptm.setDate(8, V.getUsingDate());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public List<VegetableDTO> add() throws SQLException {
        List<VegetableDTO> listV = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    Date importDate = rs.getDate("importDate");
                    Date usingDate = rs.getDate("usingDate");

                    listV.add(new VegetableDTO(productID, productName, image, price, quantity, categoryID, importDate, usingDate));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listV;
    }

    public boolean checkDuplicate(String productID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, productID);

                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean delete(String productID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, productID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean update(VegetableDTO V) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, V.getProductName());
                ptm.setFloat(2, V.getPrice());
                ptm.setInt(3, V.getQuantity());
                ptm.setString(4, V.getCategoryID());
                ptm.setDate(5, V.getImportDate());
                ptm.setDate(6, V.getUsingDate());
                ptm.setString(7, V.getProductID());

                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    
}
