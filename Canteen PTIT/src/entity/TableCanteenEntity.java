/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Pham Van Thanh
 */
public class TableCanteenEntity {
    private int id;
    private String name;
    private int status;
    private String description;

    public TableCanteenEntity() {
    }

    public TableCanteenEntity(int id, String name, int status, String description) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.description = description;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TableCanteenEntity{" + "id=" + id + ", name=" + name + ", status=" + status + ", description=" + description + '}';
    }
    
    
}
