/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MyConnection;
import entity.CartItemsEntity;
import entity.OrderItemsEntity;
import entity.infoCartItem;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pham Van Thanh
 */
public class orderItemsDao {
    public void insertOrderItems(int order_id, int product_id, int quantity) {
        try {
            String sql = "insert into OrderItem values(?,?,?)";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            ps.setInt(2, product_id);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //Lay danh sach ve thong tin san pham trong danh sach san pham trong orderItems
    public ArrayList<infoCartItem> selectInfoCartItemByOrderId(int order_id) {
        ArrayList<infoCartItem> cartItems = new ArrayList<>();
        try {
            String sql = "SELECT product_id, name, OrderItem.quantity, price " +
                            "FROM OrderItem INNER JOIN PRODUCT ON OrderItem.product_id = PRODUCT.id AND OrderItem.order_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cartItems.add(new infoCartItem(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4)));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return cartItems;
    }
    
    // Select items trong don hang theo CartId va Product Id
    public OrderItemsEntity selectOrderItem(int orderId, int productId) {
        OrderItemsEntity orderItem = null;
        try {
            String sql = "SELECT * FROM OrderItem WHERE order_id = ? AND product_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.setInt(2, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orderItem = new OrderItemsEntity(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return orderItem;
    }
    
    // Cap nhat so luong san pham trong don hang
    public void updateQuantity(int orderId, int productId, int quantity) {
        try {
            String sql = "UPDATE OrderItem SET quantity = ? WHERE order_id = ? AND product_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, orderId);
            ps.setInt(3, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
    
    // Xoa san pham khoi gio hang
    public void deleteOrderItems(int orderId, int productId) {
        try {
            String sql = "DELETE FROM OrderItem WHERE order_id = ? AND product_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.setInt(2, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
    
    // Xoa tat ca san pham cua 1 gio hang
    public void deleteAllOrderItems(int orderId) {
        try {
            String sql = "DELETE FROM OrderItem WHERE order_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
    
    //Chuyen tat ca san pham trong don hang nay qua don hang khac(Cap nhat lai orderId)
    public void updateOrderId(int orderId_old, int orderId_new) {
        try {
            String sql = "UPDATE OrderItem SET order_id = ? where order_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderId_new);
            ps.setInt(2, orderId_old);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
}
