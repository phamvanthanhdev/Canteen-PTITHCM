/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MyConnection;
import entity.ProductEntity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Van Thanh
 */
public class productDao {
    // Lay danh sach san pham theo id loai
    public ArrayList<ProductEntity> selectProductsByCategoryId(int cateID) {
        ArrayList<ProductEntity> listProduct = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PRODUCT WHERE category_id = ? AND status = 1";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cateID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listProduct.add(new ProductEntity(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getFloat(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8)));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return listProduct;
    }
    
    public void loadProductToTable(JTable tblProduct, ArrayList<ProductEntity> listProducts) {
        DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();
        model.setRowCount(0);
        for (ProductEntity p : listProducts) {
            model.addRow(new Object[]{p.getId(), p.getName(), p.getPrince(), p.getQuantity(), p.getDescription(), p.getCategory_id()});
        }
    }
    
    // Sap xep danh sach Product tang dan theo gia
    public void sortProductsByPriceAscending(ArrayList<ProductEntity> listProducts){
        Collections.sort(listProducts, new Comparator<ProductEntity>() {
            @Override
            public int compare(ProductEntity o1, ProductEntity o2) {
                if(o1.getPrince() - o2.getPrince() > 0)
                    return 1;
                else return -1;
            }
        });
    }
    
    // Sap xep danh sach Product giam dan theo gia
    public void sortProductsByPriceDecrease(ArrayList<ProductEntity> listProducts){
        Collections.sort(listProducts, new Comparator<ProductEntity>() {
            @Override
            public int compare(ProductEntity o1, ProductEntity o2) {
                if(o1.getPrince() - o2.getPrince() < 0)
                    return 1;
                else return -1;
            }
        });
    }
    
    //Tim kiem theo loai
    public ArrayList<ProductEntity> searchProducts(JTextField txtSearch, int categoryID) {
        ArrayList<ProductEntity> listProduct = new ArrayList<>();
        float so = 0;
        try {
            if (txtSearch.getText().isEmpty()) {
                so = 0;
            } else if (txtSearch.getText().chars().allMatch(Character::isDigit)) {
                so = Float.parseFloat(txtSearch.getText());
            }
            String sql = "select * from PRODUCT where (id like N'%" + txtSearch.getText() + "%' or name like N'%" + txtSearch.getText() + "%'"
                    + "or quantity = " + so + " or price=" + so + ") AND category_id = ? AND status = 1";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoryID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listProduct.add(new ProductEntity(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getFloat(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProduct;
    }
    
    // Lay danh sach san pham theo id loai
    public ArrayList<ProductEntity> selectAllProducts() {
        ArrayList<ProductEntity> listProduct = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PRODUCT";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listProduct.add(new ProductEntity(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getFloat(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8)));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return listProduct;
    }
    
    //Tim kiem theo tat ca
    public ArrayList<ProductEntity> searchAllProducts(JTextField txtSearch) {
        ArrayList<ProductEntity> listProduct = new ArrayList<>();
        float so = 0;
        try {
            if (txtSearch.getText().isEmpty()) {
                so = 0;
            } else if (txtSearch.getText().chars().allMatch(Character::isDigit)) {
                so = Float.parseFloat(txtSearch.getText());
            }
            String sql = "select * from PRODUCT where (id like N'%" + txtSearch.getText() + "%' or name like N'%" + txtSearch.getText() + "%'"
                    + "or quantity = " + so + " or price=" + so + ")";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listProduct.add(new ProductEntity(rs.getInt(1), rs.getString(2), rs.getString(3), 
                        rs.getInt(4), rs.getFloat(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProduct;
    }
    
    //Them san pham moi
    public void insertProduct(String name, String description, int cateId, float price, int quantity,String img,  int status){
        try {
            String sql = "INSERT INTO PRODUCT VALUES(?, ?, ?, ?, ?, ?, ?)";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setInt(3, cateId);
            ps.setFloat(4, price);
            ps.setInt(5, quantity);
            ps.setString(6, img);
            ps.setInt(7, status);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    // Cap nhat san pham
    public void updateProduct(int id, String name, String description, int cateId, float price, int quantity,String img){
        try {
            String sql = "UPDATE PRODUCT SET name = ?, [description] = ?, category_id = ?, price = ?,\n" +
                            "image_url = ?, quantity = ? WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setInt(3, cateId);
            ps.setFloat(4, price);
            ps.setString(5, img);
            ps.setInt(6, quantity);
            ps.setInt(7, id);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    // Xoa san pham
    public void deleteProduct(int id){
        try {
            String sql = "DELETE PRODUCT WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
       
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    // Kiem tra san pham co nam trong don hang
    public boolean checkOrderItemsExist(int product_id){
        int id = 0;
        try {
            String sql = "select * from OrderItem WHERE product_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
       
            ps.setInt(1, product_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        if(id != 0) return true;
        return false;
    }
    
    // Kiem tra san pham co nam trong don dat hang
    public boolean checkCartItemsExist(int product_id){
        int id = 0;
        try {
            String sql = "select * from CartItems WHERE product_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
       
            ps.setInt(1, product_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        if(id != 0) return true;
        return false;
    }
    
    //Ngung ban san pham, Hoat dong lai san pham
    public void updateStatusProduct(int id, int status){
        try {
            String sql = "UPDATE PRODUCT SET [status] = ? WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, status);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //Ngung ban san pham, Hoat dong lai san pham
    public void updateQuantityProduct(int id, int quantity){
        try {
            String sql = "UPDATE PRODUCT SET [quantity] = ? WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, quantity);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    // Lay san pham theo id
    public ProductEntity selectProductsById(int id) {
        ProductEntity product = new ProductEntity();
        try {
            String sql = "SELECT * FROM PRODUCT WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product = new ProductEntity(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getFloat(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return product;
    }
    
    // Lay so luong mot san pham
    public int selectQuantityByProductId(int product_id) {
        int quantity = 0;
        try {
            String sql = "SELECT quantity FROM PRODUCT WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, product_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                quantity = rs.getInt(1);
                break;
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return quantity;
    }
}
