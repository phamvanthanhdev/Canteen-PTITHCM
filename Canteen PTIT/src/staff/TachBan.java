/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package staff;

import dao.orderDao;
import dao.orderItemsDao;
import dao.tableCanteenDao;
import entity.OrderEntity;
import entity.TableCanteenEntity;
import entity.infoCartItem;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Van Thanh
 */
public class TachBan extends javax.swing.JFrame {

    private tableCanteenDao tableDAO = new tableCanteenDao();
    private orderDao orderDAO = new orderDao();
    private orderItemsDao orderItemsDAO = new orderItemsDao();

    private ArrayList<TableCanteenEntity> listTables = tableDAO.selectTable();

    //phan Can Tach
    int table_id1;
    OrderEntity order1;
    int order_id1;
    ArrayList<infoCartItem> listItems1;

    //Phan Tach toi
    int table_id2;
    OrderEntity order2;
    int order_id2;
    ArrayList<infoCartItem> listItems2;

    public TachBan() {
        initComponents();
        loadTablesToCbx();
        loadTablesToCbx1();
    }

    // Load ten ban vào cbx
    private void loadTablesToCbx() {
        for (int i = 0; i < listTables.size(); i++) {
            cbxBanTach.addItem(listTables.get(i).getName());
        }
    }

    // Load ten ban vào cbx
    private void loadTablesToCbx1() {
        for (int i = 0; i < listTables.size(); i++) {
            cbxBanToi.addItem(listTables.get(i).getName());
        }
    }

    // Load info order items vào table
    public void loadOrderItemsToTable(JTable tblCartItem, ArrayList<infoCartItem> listItems) {
        DefaultTableModel model = (DefaultTableModel) tblCartItem.getModel();
        model.setRowCount(0);
        for (infoCartItem item : listItems) {
            float totalPriceItem = item.getPrice() * item.getQuantity();
            model.addRow(new Object[]{item.getName(), item.getQuantity(), totalPriceItem});
        }
    }

    //Kiem tra san pham co o ban ben kia chua
    private infoCartItem checkOrderItemExist(int productId, ArrayList<infoCartItem> listItems) {
        for (infoCartItem p : listItems) {
            if (p.getProduct_id() == productId) {
                return p;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxBanTach = new javax.swing.JComboBox<>();
        txtQuantity = new javax.swing.JTextField();
        btnTach = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblOrderItems1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbxBanToi = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblOrderItems2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Bàn :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 6, 74, 29));

        cbxBanTach.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        cbxBanTach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBanTachActionPerformed(evt);
            }
        });
        jPanel2.add(cbxBanTach, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 6, 203, -1));
        jPanel2.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 52, 203, -1));

        btnTach.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnTach.setText("Tách");
        btnTach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTachActionPerformed(evt);
            }
        });
        jPanel2.add(btnTach, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 6, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Số lượng :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 56, 90, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Bàn cần tách");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 220, 50));

        tblOrderItems1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tblOrderItems1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "Số lượng đặt", "Tổng tiền"
            }
        ));
        tblOrderItems1.setRowHeight(35);
        tblOrderItems1.setRowMargin(10);
        tblOrderItems1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderItems1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblOrderItems1);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 790, 240));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 820, 360));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Bàn :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 70, 30));

        cbxBanToi.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        cbxBanToi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBanToiActionPerformed(evt);
            }
        });
        jPanel3.add(cbxBanToi, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 291, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Tách tới bàn");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 220, 50));

        tblOrderItems2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tblOrderItems2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "Số lượng đặt", "Tổng tiền"
            }
        ));
        tblOrderItems2.setRowHeight(35);
        tblOrderItems2.setRowMargin(10);
        tblOrderItems2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderItems2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblOrderItems2);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 780, 260));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 374, 820, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblOrderItems1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderItems1MouseClicked
        int i = tblOrderItems1.getSelectedRow();
        txtQuantity.setText((String) tblOrderItems1.getValueAt(tblOrderItems1.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tblOrderItems1MouseClicked

    private void tblOrderItems2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderItems2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblOrderItems2MouseClicked

    private void cbxBanTachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBanTachActionPerformed
        table_id1 = listTables.get(cbxBanTach.getSelectedIndex()).getId();
        order1 = orderDAO.selectOrderByTableId(table_id1);
        if (order1 != null) {
            order_id1 = order1.getId();
            listItems1 = orderItemsDAO.selectInfoCartItemByOrderId(order_id1);
            loadOrderItemsToTable(tblOrderItems1, listItems1);
        } else {
            listItems1 = new ArrayList<>();
            loadOrderItemsToTable(tblOrderItems1, listItems1);
        }
    }//GEN-LAST:event_cbxBanTachActionPerformed

    private void cbxBanToiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBanToiActionPerformed
        table_id2 = listTables.get(cbxBanToi.getSelectedIndex()).getId();
        OrderEntity order = orderDAO.selectOrderByTableId(table_id2);
        if (order != null) {
            order_id2 = order.getId();
            listItems2 = orderItemsDAO.selectInfoCartItemByOrderId(order_id2);
            loadOrderItemsToTable(tblOrderItems2, listItems2);
        } else {
            ArrayList<infoCartItem> listItems = new ArrayList<>();
            loadOrderItemsToTable(tblOrderItems2, listItems);
        }
    }//GEN-LAST:event_cbxBanToiActionPerformed

    private void btnTachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTachActionPerformed
        int quantity = Integer.parseInt(txtQuantity.getText());
        int quantityItem = Integer.parseInt(tblOrderItems1.getValueAt(tblOrderItems1.getSelectedRow(), 1).toString());
        // Neu tach toàn bo so luong cua san pham do (Doi order_id trong orderItems)
        if (quantity == quantityItem) {
            // kiem tra neu san pham nay da co o ban ben kia (Chi Cap nhat so luong, Xoa luon san pham do o ban ben nay)
            int product_id1 = listItems1.get(tblOrderItems1.getSelectedRow()).getProduct_id();
            infoCartItem item = checkOrderItemExist(product_id1, listItems2);
            if (item != null) {
                //Cap nhat so luong 
                int quantityNew = quantity + item.getQuantity();
                orderItemsDAO.updateQuantity(order_id2, item.getProduct_id(), quantityNew);
                // Xoa orderItem
                orderItemsDAO.deleteOrderItems(order_id1, product_id1);
            } else {
                //Them 1 don hang moi
                // Doi order_id
            }
        }
        //Neu chi tach 1 phan so luong cua san pham (Them orderItems moi vao Order, Giam so luong san pham)
        // kiem tra neu san pham nay da co o ban ben kia (Chi cap nhat so luong, khong them moi)
        
        table_id1 = listTables.get(cbxBanTach.getSelectedIndex()).getId();
        order1 = orderDAO.selectOrderByTableId(table_id1);
        if (order1 != null) {
            order_id1 = order1.getId();
            listItems1 = orderItemsDAO.selectInfoCartItemByOrderId(order_id1);
            loadOrderItemsToTable(tblOrderItems1, listItems1);
        } else {
            listItems1 = new ArrayList<>();
            loadOrderItemsToTable(tblOrderItems1, listItems1);
        }
        
        table_id2 = listTables.get(cbxBanToi.getSelectedIndex()).getId();
        OrderEntity order = orderDAO.selectOrderByTableId(table_id2);
        order_id2 = order.getId();
        listItems2 = orderItemsDAO.selectInfoCartItemByOrderId(order_id2);
        loadOrderItemsToTable(tblOrderItems2, listItems2);
        
        
    }//GEN-LAST:event_btnTachActionPerformed

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
            java.util.logging.Logger.getLogger(TachBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TachBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TachBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TachBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TachBan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTach;
    private javax.swing.JComboBox<String> cbxBanTach;
    private javax.swing.JComboBox<String> cbxBanToi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblOrderItems1;
    private javax.swing.JTable tblOrderItems2;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
