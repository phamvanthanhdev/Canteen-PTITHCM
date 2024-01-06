/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Pham Van Thanh
 */
public class NhanVienEntity {
    private String staff_username;
    private String fullname;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String phone;
    private String cmnd;
    private String soTaiKhoan;
    private int role_id;
    private String password;
    private boolean status;

    public NhanVienEntity() {
    }

    public NhanVienEntity(String staff_username, String fullname, boolean gioiTinh, Date ngaySinh, String diaChi, String phone, String cmnd, String soTaiKhoan, int role_id, String password, boolean status) {
        this.staff_username = staff_username;
        this.fullname = fullname;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.phone = phone;
        this.cmnd = cmnd;
        this.soTaiKhoan = soTaiKhoan;
        this.role_id = role_id;
        this.password = password;
        this.status = status;
    }


    public String getStaff_username() {
        return staff_username;
    }

    public void setStaff_username(String staff_username) {
        this.staff_username = staff_username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   

    

    @Override
    public String toString() {
        return "NhanVienEntity{" + "staff_username=" + staff_username + ", fullname=" + fullname + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", phone=" + phone + ", cmnd=" + cmnd + ", soTaiKhoan=" + soTaiKhoan + ", role_id=" + role_id + '}';
    }
    
}
