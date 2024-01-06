/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MyConnection;
import entity.CartEntity;
import entity.CartItemsEntity;
import entity.ProductEntity;
import entity.infoCartItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Van Thanh
 */
public class cartItemsDao {

    //Lay danh sach item trong gio hang
    public ArrayList<CartItemsEntity> selectCartItemsByCartId(int cartId) {
        ArrayList<CartItemsEntity> cartItems = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CartItems WHERE cart_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cartId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cartItems.add(new CartItemsEntity(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return cartItems;
    }

    // Them 1 san pham vao gio hang
    public void insertCartItems(int cartId, int productId, int quantity) {
        try {
            String sql = "insert into CartItems values(?,?,?)";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cartId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    // Select items trong gio hang theo CartId va Product Id
    public CartItemsEntity selectCartItem(int cartId, int productId) {
        CartItemsEntity cartItem = null;
        try {
            String sql = "SELECT * FROM CartItems WHERE cart_id = ? AND product_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cartId);
            ps.setInt(2, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cartItem = new CartItemsEntity(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return cartItem;
    }

    // Cap nhat so luong items trong gio hang
    public void updateQuantityToCartItem(int cartId, int productId, int quantity) {
        try {
            String sql = "UPDATE CartItems SET quantity = ? WHERE cart_id = ? AND product_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, cartId);
            ps.setInt(3, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }

    //Lay danh sach ve thong tin san pham trong gio hang
    public ArrayList<infoCartItem> selectInfoCartItem(int cartId) {
        ArrayList<infoCartItem> cartItems = new ArrayList<>();
        try {
            String sql = "SELECT product_id, name, CartItems.quantity, price \n"
                    + "FROM CartItems INNER JOIN PRODUCT ON CartItems.product_id = PRODUCT.id AND CartItems.cart_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cartId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cartItems.add(new infoCartItem(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4)));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return cartItems;
    }

    // Load info cart items vào table
    public void loadCartItemsToTable(JTable tbl_CartItem, ArrayList<infoCartItem> listItems) {
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getInstance(locale);
        DefaultTableModel model = (DefaultTableModel) tbl_CartItem.getModel();
        model.setRowCount(0);
        for (infoCartItem item : listItems) {
            float totalPriceItem = item.getPrice() * item.getQuantity();
            model.addRow(new Object[]{item.getProduct_id(), item.getName(), item.getQuantity(), format.format(item.getPrice()), format.format(totalPriceItem)});
        }
    }


    // Xoa items khoi gio hang
    public void deleteCartItems(int cartId, int productId) {
        try {
            String sql = "DELETE FROM CartItems WHERE cart_id = ? AND product_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cartId);
            ps.setInt(2, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }

    //Xoa tat ca don hang khoi gio hang
    public void deleteAllCartItems(int cartId) {
        try {
            String sql = "DELETE FROM CartItems WHERE cart_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cartId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
}
