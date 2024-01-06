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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Van Thanh
 */
public class ChiTietDonHang extends javax.swing.JFrame {

    ToanCuc t = new ToanCuc();
    int order_id = t.getOrder_id();

    private orderDao orderDAO = new orderDao();
    private orderItemsDao orderItemsDAO = new orderItemsDao();

    private ArrayList<infoCartItem> listItems = orderItemsDAO.selectInfoCartItemByOrderId(order_id);
    private OrderEntity order = orderDAO.selectOrderById(order_id);
    
    Locale locale = new Locale("vi", "VN");
    NumberFormat format = NumberFormat.getInstance(locale);

    public ChiTietDonHang() {
        initComponents();
        loadOrderItemsToTable();
        lblTongTien.setText(format.format(tinhTongTien()) + "");
        lblTongSp.setText(tinhTongSanPham() + "");
        lblDaTra.setText(format.format(order.getTotalPrice()) + "");
        lblGiamGia.setText(tinhGiamGia() + "");
        lblTrangThai.setText(trangThai());
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

    //Tinh trang thai
    private String trangThai() {
        int status = order.getStatus();
        if (status == 0) {
            return "Ðã hoàn tất";
        } else if (status == 4) {
            return "Ðã hủy";
        } else {
            return "Ðang giao dịch";
        }
    }

    // Load info order items vào table
    public void loadOrderItemsToTable() {
        DefaultTableModel model = (DefaultTableModel) tblOrderItem.getModel();
        model.setRowCount(0);
        for (infoCartItem item : listItems) {
            float totalPriceItem = item.getPrice() * item.getQuantity();
            model.addRow(new Object[]{item.getProduct_id(),item.getName(), item.getQuantity(), format.format(totalPriceItem)});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrderItem = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTongSp = new javax.swing.JLabel();
        lblDaTra = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        lblMaDon = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnInHoaDon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblOrderItem.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tblOrderItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng đặt", "Tổng tiền"
            }
        ));
        tblOrderItem.setRowHeight(35);
        tblOrderItem.setRowMargin(5);
        jScrollPane1.setViewportView(tblOrderItem);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 460, 510));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chi tiết đơn hàng");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 370, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTongSp.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        lblTongSp.setText("000");
        jPanel2.add(lblTongSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 150, -1));

        lblDaTra.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        lblDaTra.setText("000.00");
        jPanel2.add(lblDaTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 120, -1));

        lblGiamGia.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        lblGiamGia.setText("00");
        jPanel2.add(lblGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 120, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel7.setText("Tổng tiền :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 110, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel9.setText("Giảm giá :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel4.setText("Ðã trả :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, -1));

        lblTrangThai.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        lblTrangThai.setText("Status");
        jPanel2.add(lblTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 200, -1));

        lblMaDon.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        lblMaDon.setText("0000");
        jPanel2.add(lblMaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 110, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel10.setText("Mã đơn hàng :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, -1));

        lblTongTien.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        lblTongTien.setText("000");
        jPanel2.add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 130, -1));

        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jPanel2.add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 270, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("VNÐ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("VNÐ");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("%");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel15.setText("Tổng sản phẩm :");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 150, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel16.setText("Trạng thái :");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 130, -1));

        btnInHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });
        jPanel2.add(btnInHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 270, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 380, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        new HoaDon().setVisible(true);
    }//GEN-LAST:event_btnInHoaDonActionPerformed

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
            java.util.logging.Logger.getLogger(ChiTietDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietDonHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDaTra;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblMaDon;
    private javax.swing.JLabel lblTongSp;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JTable tblOrderItem;
    // End of variables declaration//GEN-END:variables
}
