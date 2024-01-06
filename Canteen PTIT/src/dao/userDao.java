/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MyConnection;
import entity.userEntity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pham Van Thanh
 */
public class userDao {
    
    // Lay tai khoan mat khau dang nhap
    public userEntity selectUserLogin(String username, String password) {
        userEntity myuser = null;
        try {
            String sql = "select * from [User]\n" +
                            "where username = ? and password = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                myuser = new userEntity(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getBoolean(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myuser;
    }
    // Lay tai khoan mat khau dang nhap
    public userEntity selectUserByUsername(String username) {
        userEntity myuser = null;
        try {
            String sql = "select * from [User]\n" +
                            "where username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                myuser = new userEntity(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getBoolean(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myuser;
    }
    
    // Lay ho ten cua tai khoan khach hang tu username
    public String selectFullNameUser(String username){
        String fullName = null;
        try {
            String sql = "SELECT fullname FROM [User] WHERE username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fullName = rs.getString(1);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fullName;
    }
    
    // Lay tat ca khach hang
    public ArrayList<userEntity> selectUsers() {
        ArrayList<userEntity> listUsers = new ArrayList<>();
        try {
            String sql = "select * from [User]";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listUsers.add(new userEntity(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getBoolean(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUsers;
    }
    
    //Them khach hang
    public void insertUser(String username,String password, String fullname, Date ngaySinh,String email, String phone, String diaChi, boolean status){
        try {
            String sql = "INSERT INTO [User] VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setDate(4, ngaySinh);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setString(7, diaChi);
            ps.setBoolean(8, status);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //Them khach hang
    public void updateUser(String usernameNew,String password, String fullname, Date ngaySinh,String email, String phone, String diaChi, String username){
        try {
                String sql = "UPDATE [User] SET username = ?, [password] = ?, fullname = ?, birth = ?, email = ?, phonenumber = ?, [address] = ?\n" +
                             "WHERE username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usernameNew);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setDate(4, ngaySinh);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setString(7, diaChi);
            ps.setString(8, username);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //Them khach hang
    public void updateStatusUser(String username, boolean status){
        try {
                String sql = "UPDATE [User] SET [status] = ?\n" +
                             "WHERE username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, status);
            ps.setString(2, username);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //Kiem tra nhan vien co nam trong don hang
    public boolean checkUserInOrder(String username){
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM ORDERS WHERE username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if(count > 0)  return true;
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return false;
    }
    
    //Kiem tra khach hang co nam gio hang
    public boolean checkUserInCart(String username){
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM CART WHERE username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if(count > 0)  return true;
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return false;
    }
    
    //Xoa khach hang
    public void deleteUser(String username){
        try {
            String sql = "DELETE [User] WHERE username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
    
    //Thay doi mat khau khach hang
    public void updatePasswordUser(String username, String password){
        try {
            String sql = "UPDATE [User] SET [password] = ? WHERE username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, password);
            ps.setString(2, username);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
