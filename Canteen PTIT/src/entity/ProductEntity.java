/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Pham Van Thanh
 */
public class ProductEntity {
    private int id;
    private String name;
    private String description;
    private int category_id;
    private float prince;
    private int quantity;
    private String image_url;
    private boolean status;

    public ProductEntity(int id, String name, String description, int category_id, float prince, int quantity, String image_url, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category_id = category_id;
        this.prince = prince;
        this.quantity = quantity;
        this.image_url = image_url;
        this.status = status;
    }

    public ProductEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public float getPrince() {
        return prince;
    }

    public void setPrince(float prince) {
        this.prince = prince;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductEntity{" + "id=" + id + ", name=" + name + ", description=" + description + ", category_id=" + category_id + ", prince=" + prince + ", quantity=" + quantity + ", image_url=" + image_url + '}';
    }
    
    
}
