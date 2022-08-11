package sample.order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sample.utils.DBUtils;
import sample.vegetable.VegetableDTO;

public class OrderDAO {

//    private static final String COUNT_DETAIL = "SELECT COUNT(detailID) as count FROM tblOrderDetail";
//    private static final String ORDER_DETAIL = "INSERT INTO tblOrderDetail(detailID, price, quantity, orderID, productID) VALUES(?,?,?,?,?)";
//    private static final String ORDER = "INSERT INTO tblOrder(orderID, orderDate, total, userID) VALUES(?,?,?,?)";
//    private static final String COUNT = "SELECT COUNT(orderID) as count FROM tblOrder";
    private static final String GET_VEGETABLE = "SELECT productName, image, price, quantity, categoryID, importDate, usingDate FROM tblProduct WHERE productID=?";
    private static final String CHECK_QUANTITY = "SELECT quantity FROM tblProduct WHERE productID=?";
//    private static final String UPDATE_QUANTITY = "UPDATE tblProduct SET quantity=? WHERE productID=?";

    public VegetableDTO getProductByID(String id, int amount) throws SQLException {
        VegetableDTO V = new VegetableDTO();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = GET_VEGETABLE;
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    float price = rs.getFloat("price");
                    String categoryID = rs.getString("categoryID");
                    Date importDate = rs.getDate("importDate");
                    Date usingDate = rs.getDate("usingDate");
                    V = new VegetableDTO(id, productName, image, categoryID, amount, price, importDate, usingDate);
                }
            }
        } catch (Exception e) {
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
        return V;
    }

    public int getQuantity(String productID) throws SQLException {
        int quantity = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = CHECK_QUANTITY;
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, productID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    quantity = rs.getInt("quantity");
                }
            }
        } catch (Exception e) {
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
        return quantity;
    }
//
//    public void updateQuantity(String id, int xxx) throws SQLException {
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                String sql = UPDATE_QUANTITY;
//                ptm = conn.prepareStatement(sql);
//                ptm.setInt(1, xxx);
//                ptm.setString(2, id);
//                ptm.executeUpdate();
//            }
//        } catch (Exception e) {
//        } finally {
//
//            if (ptm != null) {
//                ptm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//    }
//
//    public int getCount() throws SQLException {
//        int count = 0;
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                String sql = COUNT;
//                ptm = conn.prepareStatement(sql);
//                rs = ptm.executeQuery();
//                if (rs.next()) {
//                    count = rs.getInt("count");
//                }
//            }
//
//        } catch (Exception e) {
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (ptm != null) {
//                ptm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return (count + 1);
//    }
//
//    public String insertOrder(String userID, double total) throws SQLException {
//
//        String orderID = "";
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                String sql = ORDER;
//                ptm = conn.prepareStatement(sql);
//                orderID = String.valueOf(getCount());
//                long millis = System.currentTimeMillis();
//                Date date = new java.sql.Date(millis);
//                Order order = new Order(orderID, date, total, userID);
//                ptm.setString(1, order.getOrderID());
//                ptm.setDate(2, order.getOrderDate());
//                ptm.setDouble(3, order.getTotal());
//                ptm.setString(4, order.getUserID());
//                ptm.executeUpdate();
//            }
//        } catch (Exception e) {
//        } finally {
//            if (ptm != null) {
//                ptm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return orderID;
//    }
//
//    public int getCountDetail() throws SQLException {
//        int count = 0;
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                String sql = COUNT_DETAIL;
//                ptm = conn.prepareStatement(sql);
//                rs = ptm.executeQuery();
//                if (rs.next()) {
//                    count = rs.getInt("count");
//                }
//            }
//
//        } catch (Exception e) {
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (ptm != null) {
//                ptm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return (count + 1);
//    }
//
//    public boolean insertOrderDetail(VegetableDTO V, String orderID) throws SQLException {
//        boolean count = false;
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                String sql = ORDER_DETAIL;
//                ptm = conn.prepareStatement(sql);
//                String id = String.valueOf(getCountDetail());
//                ptm.setString(1, id);
//                ptm.setFloat(2, V.getPrice());
//                ptm.setInt(3, V.getQuantity());
//                ptm.setString(4, orderID);
//                ptm.setString(5, V.getProductID());
//                count = ptm.executeUpdate() > 0;
//            }
//        } catch (Exception e) {
//        } finally {
//            if (ptm != null) {
//                ptm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return count;
//
//    }
}
