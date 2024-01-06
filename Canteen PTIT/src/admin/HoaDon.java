/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import common.ToanCuc;
import dao.orderDao;
import dao.orderItemsDao;
import entity.OrderEntity;
import entity.infoCartItem;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pham Van Thanh
 */
public class HoaDon extends javax.swing.JFrame {

    ToanCuc t = new ToanCuc();
    int order_id = t.getOrder_id();

    private orderDao orderDAO = new orderDao();
    private orderItemsDao orderItemsDAO = new orderItemsDao();

    private ArrayList<infoCartItem> listItems = orderItemsDAO.selectInfoCartItemByOrderId(order_id);
    private OrderEntity order = orderDAO.selectOrderById(order_id);
    
    public HoaDon() {
        initComponents();
        String tennv = order.getStaff_username();
        String strHD = "\n\n-------------------------  CĂN TIN HỌC VIỆN  -------------------------" +
                            "\n97, Man Thiện, p.Hiệp Phú, tp Thủ Đức"+
                            "\nSĐT: 0987654889\n" +
                            "Thời gian: " + order.getOrder_date()+
                            "\nSố hóa đơn: " + order.getId()+
                            "\nTên nhân viên: " + tennv +
                             "\n------------------------------------------------------------------------------\n" +
                            "Sản phẩm" + "\t\tSố lượng" + "\tGiá\t" + "Thành tiền\n";
        String a = "";
      
        for (int i = 0; i < listItems.size(); i++) {
            String tenSP = listItems.get(i).getName();
            String soLuong = listItems.get(i).getQuantity() + "";
            String donGia = listItems.get(i).getPrice()+"";
            String thanhTien = (listItems.get(i).getQuantity()*listItems.get(i).getPrice()) + "";
            if(tenSP.length() < 10)
                a += (i+1) + ". "+ tenSP + "\t\t" +soLuong+"\t" +donGia+"\t"+thanhTien+"\n";
            else
                a += (i+1) + ". "+ tenSP + "\t" +soLuong+"\t" + donGia+"\t"+thanhTien+"\n";
        }
        strHD += a;
        String b = "\n\n------------------------------------------------------------------------------\n" + 
                        "Tổng Tiền: " + "\t\t\t\t" + this.tinhTongTien() +
                        "\n\n\n\t------------ Cảm ơn và hẹn gặp lại ! ---------------";
        strHD += b;
        txtHoaDon.setText(strHD);
        Font  f1  = new Font(Font.SERIF, Font.PLAIN,  20);
        txtHoaDon.setFont(f1);
        
        try {
            txtHoaDon.print();
        } catch (PrinterException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    //Tinh tong tien
    private float tinhTongTien() {
        float totalPrice = 0;
        for (infoCartItem i : listItems) {
            totalPrice += (i.getPrice() * i.getQuantity());
        }
        return totalPrice;
    }

    //Tinh tong san Pham
    private int tinhTongSanPham() {
        int count = 0;
        for (infoCartItem i : listItems) {
            count += i.getQuantity();
        }
        return count;
    }

    //tinh giam gia
    private float tinhGiamGia() {
        if (order.getStatus() == 0) { //Neu da thanh toan thi moi co giam gia
            float tienGiam = tinhTongTien() - order.getTotalPrice();
            float giamGia = (tienGiam / tinhTongTien()) * 100;
            return giamGia;
        }
        return 0;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbThoat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHoaDon = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbThoat.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lbThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbThoat.setText("X");
        lbThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbThoatMouseClicked(evt);
            }
        });
        getContentPane().add(lbThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 50, 40));

        txtHoaDon.setColumns(20);
        txtHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        txtHoaDon.setRows(5);
        txtHoaDon.setText("                                                         CĂN TIN HỌC VIỆN");
        jScrollPane1.setViewportView(txtHoaDon);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 581, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbThoatMouseClicked
        this.dispose();
    }//GEN-LAST:event_lbThoatMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbThoat;
    private javax.swing.JTextArea txtHoaDon;
    // End of variables declaration//GEN-END:variables
}
