/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MyConnection;
import entity.CategoryEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pham Van Thanh
 */
public class categoryDao {
    // Lay danh sach san pham theo id loai
    public ArrayList<CategoryEntity> selectCategories() {
        ArrayList<CategoryEntity> listCategory = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CATEGORY";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listCategory.add(new CategoryEntity(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return listCategory;
    }
    
    // Them Loai
    public void insertCategory(String name, String description){
        try {
            String sql = "INSERT INTO CATEGORY VALUES(?,?)";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
    
    // sua Loai
    public void updateCategory(String name, String description, int id){
        try {
            String sql = "UPDATE CATEGORY SET name = ?, description = ? WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
    
    //Kiem Tra xem san pham co thuoc loai
    public boolean checkCategoryInProduct(int id){
        int count = 0;
        try {
            String sql = "select count(*) from PRODUCT WHERE category_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if(count > 0) return true;
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return false;
    }
    
    // Xoa Loai
    public void deleteCategory(int id){
        try {
            String sql = "DELETE CATEGORY WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
}
