/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MyConnection;
import entity.NhanVienEntity;
import entity.OrderEntity;
import entity.RolesEntity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pham Van Thanh
 */
public class NhanVienDao {
    //Lay du lieu tat ca nhan vien
    public ArrayList<NhanVienEntity> selectNhanVien() {
        ArrayList<NhanVienEntity> listNV = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NhanVien";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listNV.add(new NhanVienEntity(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), 
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getBoolean(11)));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return listNV;
    }
    
    //Lay chuc vu
    public ArrayList<RolesEntity> selectRoles() {
        ArrayList<RolesEntity> roles = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ROLES";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                roles.add(new RolesEntity(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return roles;
    }
    
    //Them nhan vien moi
    public void insertNhanVien(String staff_username, String fullname, boolean gioiTinh, Date ngaySinh, String diaChi, String phone, String cmnd, String soTaiKhoan, int role_id, String password, boolean status){
        try {
            String sql = "INSERT INTO NhanVien VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, staff_username);
            ps.setString(2, fullname);
            ps.setBoolean(3, gioiTinh);
            ps.setDate(4, ngaySinh);
            ps.setString(5, diaChi);
            ps.setString(6, phone);
            ps.setString(7, cmnd);
            ps.setString(8, soTaiKhoan);
            ps.setInt(9, role_id);
            ps.setString(10, password);
            ps.setBoolean(11, status);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //Cap nhat thong tin nhan vien
    public void updateNhanVien(String staff_username, String fullname, boolean gioiTinh, Date ngaySinh, String diaChi, String phone,
            String cmnd, String soTaiKhoan, int role_id, String img_url, boolean status, String username_old){
        try {
            String sql = "UPDATE NhanVien SET staff_username = ?, fullname = ?, gioiTinh = ?, ngaySinh = ?,\n" +
                            "diaChi = ?, phone = ?, CMND = ?,soTaiKhoan= ?,role_id = ?, password = ?, [status] = ?   WHERE staff_username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, staff_username);
            ps.setString(2, fullname);
            ps.setBoolean(3, gioiTinh);
            ps.setDate(4, ngaySinh);
            ps.setString(5, diaChi);
            ps.setString(6, phone);
            ps.setString(7, cmnd);
            ps.setString(8, soTaiKhoan);
            ps.setInt(9, role_id);
            ps.setString(10, img_url);
            ps.setBoolean(11, status);
            ps.setString(12, username_old);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //Cap nhat trang thai nhan vien
    public void updateStatusNhanVien(String username, int status){
        try {
            String sql = "UPDATE NhanVien SET [status] = ? WHERE staff_username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, status);
            ps.setString(2, username);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //Kiem tra nhan vien co nam trong don hang
    public boolean checkNhanVienInOrder(String username){
        int id = 0;
        try {
            String sql = "SELECT id FROM ORDERS WHERE staff_username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            if(id == 0)  return false;
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return true;
    }
    
    //Xoa nhan vien
    public void deleteNhanVien(String username){
        try {
            String sql = "DELETE NhanVien WHERE staff_username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, username);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //Lay du lieu 1 nhan vien bang username
    public NhanVienEntity selectNhanVienByUsername(String username) {
        NhanVienEntity nv = null;
        try {
            String sql = "SELECT * FROM NhanVien WHERE staff_username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv = new NhanVienEntity(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), 
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getBoolean(11));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return nv;
    }
    
    //Lay du lieu 1 nhan vien bang username va password (De dang nhap)
    public NhanVienEntity selectNhanVienDangNhap(String username, String password, int role_id) {
        NhanVienEntity nv = null;
        try {
            String sql = "SELECT * FROM NhanVien WHERE staff_username = ? AND [password] = ? AND role_id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, role_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv = new NhanVienEntity(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), 
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getBoolean(11));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return nv;
    }
    
    //Thay doi mat khau nhan vien
    public void updatePasswordNhanVien(String username, String password){
        try {
            String sql = "UPDATE NhanVien SET [password] = ? WHERE staff_username = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, password);
            ps.setString(2, username);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
