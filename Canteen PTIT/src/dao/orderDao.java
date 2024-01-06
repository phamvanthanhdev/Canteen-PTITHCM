/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MyConnection;
import entity.CartItemsEntity;
import entity.OrderEntity;
import entity.infoCartItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pham Van Thanh
 */
public class orderDao {
    // Them 1 don hang vao csdl (danh cho mua online )
    public void insertOrder(String username, Date order_date, String adress, int status, String phonenumber, int payments, int type, float totalPrice) {
        try {
            String sql = "insert into ORDERS(username, order_date, adress, [status], phonenumber, payments, order_type, totalPrice)"
                    + " values(?,?,?,?,?,?,?, ?)";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setDate(2, order_date);
            ps.setString(3, adress);
            ps.setInt(4, status);
            ps.setString(5, phonenumber);
            ps.setInt(6, payments);
            ps.setInt(7, type);
            ps.setFloat(8, totalPrice);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //Lay ra ma don hang vua dat online (Thieu dieu kien orderType = 2)
    public int selectOrderIdByUsername(String userName) {
        int orderId = 0;
        try {
            String sql = "SELECT TOP 1 id FROM ORDERS WHERE username = ? ORDER BY id DESC";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orderId = rs.getInt(1);
                break;
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return orderId;
    }
    
    //Lay ra tat ca don hang online
    public ArrayList<OrderEntity> selectOrdersOnline() {
        ArrayList<OrderEntity> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ORDERS WHERE order_type = 2";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(new OrderEntity(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4), rs.getString(5),
                        rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getFloat(11), rs.getString(12)));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return orders;
    }
    
    //Lay ra tat ca don hang online cua 1 user
    public ArrayList<OrderEntity> selectOrdersOnlineByUser(String username) {
        ArrayList<OrderEntity> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ORDERS WHERE username = ? AND order_type = 2";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(new OrderEntity(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4), rs.getString(5),
                        rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getFloat(11), rs.getString(12)));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return orders;
    }
    
    //Thay doi trang thai don hang
    public void updateStatus(int orderId, int status){
        try {
            String sql = "UPDATE ORDERS SET [status] = ? WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
    
    //Cap nhat ngay giao hang
    public void updateShipperDate(int orderId, Date shipper_date){
        try {
            String sql = "UPDATE ORDERS SET shipped_date = ? WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, shipper_date);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
   
    
    // Them 1 don hang vao csdl (su dung tai ban)
    public void insertOrderOnTable(String username, Date order_date, int status, int payments,int table_id, int type, String staff_username) {
        try {
            String sql = "insert into ORDERS(username, order_date, [status], payments, table_id, order_type, staff_username)"
                    + " values(?,?,?,?,?,?,?)";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setDate(2, order_date);
            ps.setInt(3, status);
            ps.setInt(4, payments);
            ps.setInt(5, table_id);
            ps.setInt(6, type);
            ps.setString(7, staff_username);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    // Lay ra don hang cua ban dang hoat dong de cap nhat don hang
    public OrderEntity selectOrderByTableId(int table_id) {
        OrderEntity order = null;
        try {
            String sql = "SELECT * FROM ORDERS WHERE table_id = ? and status = 1 and order_type = 0"; // status = 1 : dang hoat dong, order_type = 0: su dung tai ban
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, table_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                order = new OrderEntity(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5),
                        rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getFloat(11), rs.getString(12));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return order;
    }
    
    //Thanh toan don hang
    public void thanhToanOrder(int payments, int orderId, float totalPrice) {
        try {
            String sql = "UPDATE ORDERS SET [status] = 0, payments = ?, totalPrice = ? WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, payments);
            ps.setFloat(2, totalPrice);
            ps.setInt(3, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
    
    // Xoa don hang khong chua san pham
    public void deleteOrder(int orderId){
        try {
            String sql = "DELETE FROM ORDERS WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
    
    // Them 1 don hang vao csdl (su dung mang ve)
    public void insertOrderMangVe(String username, Date order_date, int status, int payments, int type, String staff_username) {
        try {
            String sql = "insert into ORDERS(username, order_date, [status], payments, order_type, staff_username)"
                    + " values(?,?,?,?,?,?)";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setDate(2, order_date);
            ps.setInt(3, status);
            ps.setInt(4, payments);
            ps.setInt(5, type);
            ps.setString(6, staff_username);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    //Lay ra don hang mang ve gan nhat
    public OrderEntity selectOrderMangVe() {
        OrderEntity orders = null;
        try {
            String sql = "SELECT TOP 1 * FROM ORDERS WHERE order_type = 1 ORDER BY id DESC";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orders = new OrderEntity(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4), rs.getString(5),
                        rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getFloat(11), rs.getString(12));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return orders;
    }
    
    //Chuyen ban (Cap nhat lai id ban)
    public void updateTableId(int orderId, int table_id){
        try {
            String sql = "UPDATE ORDERS SET table_id = ? WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, table_id);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
   
    
    //Lay don hang bang id
    public OrderEntity selectOrderById(int id) {
        OrderEntity orders = null;
        try {
            String sql = "SELECT * FROM ORDERS WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orders = new OrderEntity(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4), rs.getString(5),
                        rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getFloat(11), rs.getString(12));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return orders;
    }
    
    //Luu tong tien cua don hang
    public void updateTotalPrice(int orderId, float totalPrice){
        try {
            String sql = "UPDATE ORDERS SET totalPrice = ? WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, totalPrice);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
}
