/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MyConnection;
import entity.OrderEntity;
import java.sql.Connection;
import java.sql.Date;
//import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pham Van Thanh
 */
public class ThongKeDao {
    //Lay tong don hang
    public ArrayList<OrderEntity> selectAllOrdersByDate(Date orderDate1, Date orderDate2) {
        ArrayList<OrderEntity> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ORDERS WHERE order_date BETWEEN ? AND ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, orderDate1);
            ps.setDate(2, orderDate2);
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
    
    //Don hang tai quan
    public ArrayList<OrderEntity> selectOrdersInTable(Date orderDate1, Date orderDate2) {
        ArrayList<OrderEntity> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ORDERS WHERE order_date BETWEEN ? AND ? AND order_type = 0";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, orderDate1);
            ps.setDate(2, orderDate2);
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
    
    //Don hang mang ve
    public ArrayList<OrderEntity> selectOrdersMangVe(Date orderDate1, Date orderDate2) {
        ArrayList<OrderEntity> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ORDERS WHERE order_date BETWEEN ? AND ? AND order_type = 1";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, orderDate1);
            ps.setDate(2, orderDate2);
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
    
    //Lay ra tat ca don hang online
    public ArrayList<OrderEntity> selectOrdersOnline(Date orderDate1, Date orderDate2) {
        ArrayList<OrderEntity> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ORDERS WHERE order_date BETWEEN ? AND ? AND order_type = 2";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, orderDate1);
            ps.setDate(2, orderDate2);
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
    
    //Tong loai san pham
    public int selectTotalCategory() {
        int n = 0;
        try {
            String sql = "SELECT COUNT(*) FROM CATEGORY";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return n;
    }
    
    //Tong san pham
    public int selectTotalProducts() {
        int n = 0;
        try {
            String sql = "SELECT COUNT(*) FROM PRODUCT";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return n;
    }
    
    //Tong so ban
    public int selectTotalTable() {
        int n = 0;
        try {
            String sql = "SELECT COUNT(*) FROM TABLECANTEEN";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return n;
    }
    
    // tong nhan vien
    public int selectTotalStaff() {
        int n = 0;
        try {
            String sql = "SELECT COUNT(*) FROM NHANVIEN";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return n;
    }
    
    // tong khach hang
    public int selectTotalUser() {
        int n = 0;
        try {
            String sql = "SELECT COUNT(*) FROM [USER]";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return n;
    }
}
