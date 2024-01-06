/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Pham Van Thanh
 */
public class OrderEntity {
    private int id;
    private String username;
    private Date order_date;
    private Date shipper_date;
    private String adress;
    private int status;
    private String phonenumber;
    private int payments;
    private int table_id;
    private int type;
    private float totalPrice;
    private String staff_username;

    public OrderEntity() {
    }

    public OrderEntity(int id, String username, Date order_date, Date shipper_date, String adress, int status, String phonenumber, int payments, int table_id, int type, float totalPrice, String staff_username) {
        this.id = id;
        this.username = username;
        this.order_date = order_date;
        this.shipper_date = shipper_date;
        this.adress = adress;
        this.status = status;
        this.phonenumber = phonenumber;
        this.payments = payments;
        this.table_id = table_id;
        this.type = type;
        this.totalPrice = totalPrice;
        this.staff_username = staff_username;
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

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getShipper_date() {
        return shipper_date;
    }

    public void setShipper_date(Date shipper_date) {
        this.shipper_date = shipper_date;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getPayments() {
        return payments;
    }

    public void setPayments(int payments) {
        this.payments = payments;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public String getStaff_username() {
        return staff_username;
    }

    public void setStaff_username(String staff_username) {
        this.staff_username = staff_username;
    }

    

    @Override
    public String toString() {
        return "OrderEntity{" + "id=" + id + ", username=" + username + ", order_date=" + order_date + ", shipper_date=" + shipper_date + ", adress=" + adress +  ", status=" + status + ", phonenumber=" + phonenumber + ", payments=" + payments + '}';
    }
    
    
}
