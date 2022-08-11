package sample.order;
public class OrderDetail {
    private String detaiID;
    private float price;
    private int quantity;
    private String orderID, productID;

    public OrderDetail() {
    }

    public OrderDetail(String detaiID, float price, int quantity, String orderID, String productID) {
        this.detaiID = detaiID;
        this.price = price;
        this.quantity = quantity;
        this.orderID = orderID;
        this.productID = productID;
    }

    public String getDetaiID() {
        return detaiID;
    }

    public void setDetaiID(String detaiID) {
        this.detaiID = detaiID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
    
    
    
    
}
