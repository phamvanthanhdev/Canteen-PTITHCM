/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Pham Van Thanh
 */
public class infoCartItem {
    private int product_id;
    private String name;
    private int quantity;
    private float price;

    public infoCartItem() {
    }

    public infoCartItem(int product_id, String name, int quantity, float price) {
        this.product_id = product_id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "infoCartItem{" + "product_id=" + product_id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + '}';
    }
    
    
}
