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
public class userEntity {
    private String user;
    private String passwork;
    private String fullname;
    private Date birth;
    private String email;
    private String phonenumber;
    private String address;
    private boolean status;

    public userEntity() {
    }

    public userEntity(String user, String passwork, String fullname, Date birth, String email, String phonenumber, String address, boolean status) {
        this.user = user;
        this.passwork = passwork;
        this.fullname = fullname;
        this.birth = birth;
        this.email = email;
        this.phonenumber = phonenumber;
        this.address = address;
        this.status = status;
    }

    

    

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    

    @Override
    public String toString() {
        return "user{" + "user=" + user + ", passwork=" + passwork + ", fullname=" + fullname + ", email=" + email + ", phonenumber=" + phonenumber + ", address=" + address  + '}';
    }
    
}
