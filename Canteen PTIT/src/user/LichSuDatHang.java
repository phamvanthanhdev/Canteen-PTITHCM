/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package user;

import admin.ChiTietDonHang;
import common.ToanCuc;
import dao.orderDao;
import entity.NhanVienEntity;
import entity.OrderEntity;
import entity.RolesEntity;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Van Thanh
 */
public class LichSuDatHang extends javax.swing.JPanel {

    private String username = new ToanCuc().getUsername();
    private orderDao orderDAO = new orderDao();

    private ArrayList<OrderEntity> listOrders = orderDAO.selectOrdersOnlineByUser(username.trim());

    Locale locale = new Locale("vi", "VN");
    NumberFormat format = NumberFormat.getInstance(locale);

    public LichSuDatHang() {
        initComponents();
        loadOrderToTable();
    }

    private void loadOrderToTable() {
        DefaultTableModel model = (DefaultTableModel) tblOrders.getModel();
        model.setRowCount(0);
        for (OrderEntity o : listOrders) {
            String status = "";
            if (o.getStatus() == 0) {
                status = "Hoàn thành";
            } else if (o.getStatus() == 1) {
                status = "Chờ xác nhận";
            } else if (o.getStatus() == 2) {
                status = "Chờ lấy hàng";
            } else if (o.getStatus() == 3) {
                status = "Ðang giao";
            } else if (o.getStatus() == 4) {
                status = "Ðã hủy";
            }
            model.addRow(new Object[]{o.getId(), o.getOrder_date(), o.getShipper_date(), status});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblMaDon = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNgayDat = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblPayments = new javax.swing.JLabel();
        btnChiTiet = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btnInHoaDon = new javax.swing.JButton();
        btnHuyDon = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblOrders.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã đơn hàng", "Ngày đặt", "Ngày giao", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrders.setRowHeight(35);
        tblOrders.setRowMargin(5);
        tblOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrders);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel1.setText("Tìm kiếm :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 630, 660));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin đơn hàng");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 348, 39));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel3.setText("Mã đơn hàng :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        lblMaDon.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        lblMaDon.setText("0000");
        jPanel3.add(lblMaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 130, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel7.setText("Tổng tiền :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        lblTongTien.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        lblTongTien.setText("000.00");
        jPanel3.add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 160, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel9.setText("Ngày đặt hàng :");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        lblNgayDat.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        lblNgayDat.setText("00 - 00 - 0000");
        jPanel3.add(lblNgayDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 180, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel11.setText("Trạng thái đơn hàng :");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        lblTrangThai.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        lblTrangThai.setText("Status");
        jPanel3.add(lblTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 370, 250, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel13.setText("Hình thức thanh toán :");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        lblPayments.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        lblPayments.setText("PaymentMeThod");
        jPanel3.add(lblPayments, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 440, 240, -1));

        btnChiTiet.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnChiTiet.setText("Xem chi tiết");
        btnChiTiet.setEnabled(false);
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });
        jPanel3.add(btnChiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 300, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel15.setText("VNÐ");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 60, -1));

        btnInHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.setEnabled(false);
        jPanel3.add(btnInHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 300, -1));

        btnHuyDon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnHuyDon.setText("Hủy đơn");
        btnHuyDon.setEnabled(false);
        btnHuyDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDonActionPerformed(evt);
            }
        });
        jPanel3.add(btnHuyDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 300, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 360, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdersMouseClicked
        int i = tblOrders.getSelectedRow();
        OrderEntity order = listOrders.get(i);
        lblMaDon.setText(order.getId() + "");
        lblNgayDat.setText(order.getOrder_date() + "");
        String payment = "";
        if (order.getPayments() == 0) {
            payment = "Thanh toán khi nhận hàng";
        } else if (order.getPayments() == 1) {
            payment = "Chuyển khoản ngân hàng";
        } else if (order.getPayments() == 2) {
            payment = "Thẻ Tín dụng/Ghi nợ";
        } else if (order.getPayments() == 3) {
            payment = "Thẻ nội địa NAPAS";
        }
        
        lblPayments.setText(payment);
        lblTongTien.setText(format.format(order.getTotalPrice()) + "");
        lblTrangThai.setText(tblOrders.getValueAt(i, 3) + "");

        btnChiTiet.setEnabled(true);
        btnInHoaDon.setEnabled(true);
        btnHuyDon.setEnabled(true);
    }//GEN-LAST:event_tblOrdersMouseClicked

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        int i = tblOrders.getSelectedRow();
        int order_Id = listOrders.get(i).getId();
        new ToanCuc().setOrder_id(order_Id);
        new ChiTietDonHang().setVisible(true);
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void btnHuyDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDonActionPerformed
        int i = tblOrders.getSelectedRow();
        OrderEntity order = listOrders.get(i);
        if(order.getStatus() == 0){
            JOptionPane.showMessageDialog(this, "Đơn hàng đã hoàn thành.\n Không thể hủy !", "Success", JOptionPane.INFORMATION_MESSAGE);
        }else if(order.getStatus() == 4){
            JOptionPane.showMessageDialog(this, "Đơn hàng đã được hủy trước đó.\n Không thể hủy !", "Success", JOptionPane.INFORMATION_MESSAGE);
        }else if(order.getStatus() == 2 || order.getStatus() == 3){
            JOptionPane.showMessageDialog(this, "Đơn hàng đã được nhân viên xác nhận.\n Không thể hủy !", "Success", JOptionPane.INFORMATION_MESSAGE);
        }else if(order.getStatus() == 1){
            int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn hủy đơn hàng này không ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                orderDAO.updateStatus(order.getId(), 4);
                
                listOrders = orderDAO.selectOrdersOnlineByUser(username.trim());
                loadOrderToTable();
                JOptionPane.showMessageDialog(this, "Hủy đơn hàng thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnHuyDonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnHuyDon;
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblMaDon;
    private javax.swing.JLabel lblNgayDat;
    private javax.swing.JLabel lblPayments;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JTable tblOrders;
    // End of variables declaration//GEN-END:variables
}
