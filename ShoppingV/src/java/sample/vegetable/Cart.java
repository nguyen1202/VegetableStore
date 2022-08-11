package sample.vegetable;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String, VegetableDTO> cart;

    public Cart() {
    }

    public Cart(Map<String, VegetableDTO> cart) {
        this.cart = cart;
    }

    public Map<String, VegetableDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, VegetableDTO> cart) {
        this.cart = cart;
    }

    public boolean add(VegetableDTO V) {
        boolean check = false;
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(V.getProductID())) {
            int currentQuantity = this.cart.get(V.getProductID()).getQuantity();
            V.setQuantity(currentQuantity + V.getQuantity());
        }
        this.cart.put(V.getProductID(), V);
        check = true;
        return check;
    }
    public void update(String id, VegetableDTO V){
        if(this.cart == null){
            return;
        }
        if(this.cart.containsKey(id)){
            this.cart.replace(id, V);
        }
    }

    public boolean remove(String productID) {
        boolean check = false;
        if (this.cart != null) {
            if (this.cart.containsKey(productID)) {
                this.cart.remove(productID);
                check = true;
            }
        }
        return check;
    }
    public boolean edit(String productID, VegetableDTO V) {
        boolean check = false;
        if (this.cart != null) {
            if (this.cart.containsKey(productID)) {
                this.cart.replace(productID, V);
                check = true;
            }
        }
        return check;
    }
}
