/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MyConnection;
import entity.ProductEntity;
import entity.TableCanteenEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Van Thanh
 */
public class tableCanteenDao {
    //Lay cac ban trong csdl
    public ArrayList<TableCanteenEntity> selectTable() {
        ArrayList<TableCanteenEntity> listTables = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TableCanteen";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listTables.add(new TableCanteenEntity(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
        return listTables;
    }
    
    //Load Tables vao table
    public void loadTablesToTable(JTable tblTables, ArrayList<TableCanteenEntity> listTables) {
        DefaultTableModel model = (DefaultTableModel) tblTables.getModel();
        model.setRowCount(0);
        for (TableCanteenEntity t : listTables) {
            String status = "";
            if (t.getStatus() == 0) status = "Trống";
            if (t.getStatus() == 1) status = "Đang hoạt động";
            model.addRow(new Object[]{t.getId(), t.getName(),status, t.getDescription()});
        }
    }
    
    // Cap nhat trang thai cua ban
    public void updateStatusTable(int tableId, int status) {
        try {
            String sql = "UPDATE TableCanteen SET [status] = ? WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, tableId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
    
    // Them ban
    public void insertTable(String name,int status, String description){
        try {
            String sql = "INSERT INTO TableCanteen VALUES(?,?,?)";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, status);
            ps.setString(3, description);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
    
    //Sua ban
    public void updateTable(String nameNew, String description, int id){
        try {
            String sql = "UPDATE TableCanteen SET name = ?, description = ? WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nameNew);
            ps.setString(2, description);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
    
    //Kiem Tra xem ban da duoc lap hoa don 
    public boolean checkTableInOrder(int id){
        int count = 0;
        try {
            String sql = "select count(*) from ORDERS WHERE table_id = ?";
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
    
    //Xoa ban
    public void deleteTable(int id){
        try {
            String sql = "DELETE TableCanteen WHERE id = ?";
            Connection con = new MyConnection().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erorr : " + e);
        }
    }
}
