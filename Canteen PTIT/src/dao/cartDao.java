/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MyConnection;
import entity.CartEntity;
import entity.ProductEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pham Van Thanh
 */
public class cartDao {
    // Lay gio hang cua 1 tai khoan
    public CartEntity selectCartByUsername(String username) {
        CartEntity cart = null;
        try {
            String sql = "SELECT * FROM CART WHERE username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cart = new CartEntity(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return cart;
    }
    
    //Tao moi 1 gio hang
    public void insertCart(String username) {
        try {
            String sql = "insert into CART values(?)";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
