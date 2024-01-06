/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package staff;

import dao.orderDao;
import dao.orderItemsDao;
import dao.userDao;
import entity.OrderEntity;
import entity.infoCartItem;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Van Thanh
 */
public class DonDatHang extends javax.swing.JPanel {

    private orderDao orderDAO = new orderDao() ;
    private userDao userDAO = new userDao();
    private orderItemsDao itemsDAO = new orderItemsDao();
    
    private ArrayList<OrderEntity> listOrders = orderDAO.selectOrdersOnline();
    
    public DonDatHang() {
        initComponents();
        loadOrdersToTable();
        loadStatusToCbx();
    }
    
    private void loadStatusToCbx(){
        cbxStatus.addItem("Hoàn thành");
        cbxStatus.addItem("Chờ xác nhận");
        cbxStatus.addItem("Chờ lấy hàng");
        cbxStatus.addItem("Ðang giao");
        cbxStatus.addItem("Ðã hủy");
    }
    
    private void loadOrdersToTable(){
        DefaultTableModel model = (DefaultTableModel) tblOrder.getModel();
        model.setRowCount(0);
        for (OrderEntity o : listOrders) {
            String status = "";
            if(o.getStatus() == 0) status = "Hoàn thành";
            else if(o.getStatus() == 1) status = "Chờ xác nhận";
            else if(o.getStatus() == 2) status = "Chờ lấy hàng";
            else if(o.getStatus() == 3) status = "Ðang giao";
            else if(o.getStatus() == 4) status = "Ðã hủy";
            String fullName = userDAO.selectFullNameUser(o.getUsername());
            model.addRow(new Object[]{o.getId(), fullName, o.getAdress(), o.getPhonenumber(), status, o.getOrder_date(), o.getShipper_date()});
        }
    }
    
    private float tinhTongTien(int order_id){
        ArrayList<infoCartItem> listInfoItems = itemsDAO.selectInfoCartItemByOrderId(order_id);
        float totalPrice = 0;
        for (infoCartItem i : listInfoItems) {
            totalPrice += (i.getQuantity() * i.getPrice());
        }
        return totalPrice;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblOrderId = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnUpdateStatus = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOrderId.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblOrderId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrderId.setText("00000");

        cbxStatus.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Trạng thái đơn hàng :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Mã đơn hàng :");

        btnUpdateStatus.setBackground(new java.awt.Color(0, 153, 204));
        btnUpdateStatus.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnUpdateStatus.setText("Cập nhật trạng thái");
        btnUpdateStatus.setEnabled(false);
        btnUpdateStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnUpdateStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnUpdateStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 990, 150));

        tblOrder.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đơn hàng", "Tên khách hàng", "Địa chỉ giao", "Số điện thoại", "Trạng thái", "Ngày đặt", "Ngày giao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrder.setRowHeight(35);
        tblOrder.setRowMargin(5);
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrder);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Đơn đặt hàng online");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 990, 490));

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

    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
        int id = tblOrder.getSelectedRow();
        lblOrderId.setText(tblOrder.getValueAt(id, 0).toString());
        cbxStatus.setSelectedItem(tblOrder.getValueAt(id, 4).toString());
        btnUpdateStatus.setEnabled(true);

        //Don hang da huy hoac hoan thanh thi khong the thay doi trang thai
        if(cbxStatus.getSelectedIndex() == 0 || cbxStatus.getSelectedIndex() == 4){
            btnUpdateStatus.setEnabled(false);
        }
    }//GEN-LAST:event_tblOrderMouseClicked

    private void btnUpdateStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStatusActionPerformed
        if(tblOrder.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đơn hàng !", "Success", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn đổi trạng thái đơn hàng thành " + cbxStatus.getSelectedItem(), "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {
            int id = tblOrder.getSelectedRow();
            int order_id = Integer.parseInt((String)tblOrder.getValueAt(id, 0).toString());
            orderDAO.updateStatus(order_id, cbxStatus.getSelectedIndex());

            //Neu chon trang thai la hoan thanh thi cap nhat ngay hoan thanh don
            if(cbxStatus.getSelectedIndex() == 0){
                long millis = System.currentTimeMillis();
                Date shipper_date = new Date(millis);
                orderDAO.updateShipperDate(order_id, shipper_date);
            }
            
            if(cbxStatus.getSelectedIndex() != 4){
                //Cap nhat tong tien don hang
                float totalPrice = tinhTongTien(order_id);
                orderDAO.updateTotalPrice(order_id, totalPrice);
            }
            
            JOptionPane.showMessageDialog(this, "Cập nhật trạng thái đơn hàng thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
            //Cap nhat lai table
            listOrders = orderDAO.selectOrdersOnline();
            loadOrdersToTable();
            lblOrderId.setText("");
        }

    }//GEN-LAST:event_btnUpdateStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateStatus;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrderId;
    private javax.swing.JTable tblOrder;
    // End of variables declaration//GEN-END:variables
}
