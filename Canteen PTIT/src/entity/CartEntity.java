/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Pham Van Thanh
 */
public class CartEntity {
    private int id;
    private String username;

    public CartEntity() {
    }

    public CartEntity(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    

    @Override
    public String toString() {
        return "CartEntity{" + "id=" + id + ", username=" + username + '}';
    }
    
    
}
