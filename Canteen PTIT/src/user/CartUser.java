/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package user;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import common.ToanCuc;
import dao.cartDao;
import dao.cartItemsDao;
import dao.productDao;
import entity.CartEntity;
import entity.infoCartItem;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Pham Van Thanh
 */
public class CartUser extends javax.swing.JPanel {
    
    // Tên người dùng và Nguyễn Thái Trưởng
    private String username = new ToanCuc().getUsername();

    private cartItemsDao cartItemsDAO = new cartItemsDao();
    private cartDao cartDAO = new cartDao();
    private productDao proDAO = new productDao();

    //Lay cartId cua gio hang
    private CartEntity cart = cartDAO.selectCartByUsername(username);
    private int cartId;
    //danh sach info Item cua gio hang
    private ArrayList<infoCartItem> listInfoItems = new ArrayList<>();
    
    Locale locale = new Locale("vi", "VN");
    NumberFormat format = NumberFormat.getInstance(locale);
    
    public CartUser() {
        initComponents();
        if(cart == null){
            cartDAO.insertCart(username);
            cartId = cartDAO.selectCartByUsername(username).getId();
        }else{
            cartId = cartDAO.selectCartByUsername(username).getId();
        }
        listInfoItems = cartItemsDAO.selectInfoCartItem(cartId);
        cartItemsDAO.loadCartItemsToTable(tbl_CartItems, listInfoItems);
        init();
    }

    private void init() {
        int totalQuantity = 0;
        float totalPrice = 0;
        for (infoCartItem i : listInfoItems) {
            totalQuantity += i.getQuantity();
            totalPrice += (i.getQuantity() * i.getPrice());
        }
        lbl_totalQuantity.setText(totalQuantity + "");
        lbl_totalPrice.setText(format.format(totalPrice) + "");
    }
    
    private boolean checkIsEmpty() {
        // check txt rong
        if (tbl_CartItems.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        //check txt rong
        if (txtQuantity.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        //check so luong chua ki tu khac so
        if (txtQuantity.getText().chars().allMatch(Character::isDigit) == false) {
            JOptionPane.showMessageDialog(this, "Chỉ được nhập số !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        //check so luong luon > 0
        if(Integer.parseInt(txtQuantity.getText()) <= 0){
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0 !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // Lay so luong ton cua san pham dang chon
        int product_id = Integer.parseInt((String) tbl_CartItems.getValueAt(tbl_CartItems.getSelectedRow(), 0).toString());
        int productQuantity = proDAO.selectQuantityByProductId(product_id);
        //kiem tra so luong nhieu hon so luong ton
        if (Integer.parseInt(txtQuantity.getText().trim()) > productQuantity) {
            JOptionPane.showMessageDialog(this, "Vượt quá số lượng tồn !!", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_CartItems = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lbl_totalPrice = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_totalQuantity = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        txtProductName = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(25, 118, 211));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_CartItems.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        tbl_CartItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_CartItems.setRowHeight(35);
        tbl_CartItems.setRowMargin(10);
        tbl_CartItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CartItemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_CartItems);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 970, 410));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tổng tiền :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 100, -1));

        lbl_totalPrice.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_totalPrice.setForeground(new java.awt.Color(255, 255, 255));
        lbl_totalPrice.setText("0.0");
        jPanel1.add(lbl_totalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, 180, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Số lượng :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 520, 130, 30));

        lbl_totalQuantity.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_totalQuantity.setForeground(new java.awt.Color(255, 255, 255));
        lbl_totalQuantity.setText("0");
        jPanel1.add(lbl_totalQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 70, -1));

        btnDelete.setBackground(new java.awt.Color(204, 204, 255));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(25, 118, 221));
        btnDelete.setText("Xóa sản phẩm");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 580, 260, 40));

        btnThanhToan.setBackground(new java.awt.Color(204, 204, 255));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(25, 118, 221));
        btnThanhToan.setText("Đặt hàng");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        jPanel1.add(btnThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 580, 260, 40));

        btnUpdate.setBackground(new java.awt.Color(204, 204, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(25, 118, 221));
        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 260, 40));

        txtProductName.setEditable(false);
        txtProductName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 290, -1));

        txtQuantity.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 520, 180, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tổng sản phẩm :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tên sản phẩm :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 522, 160, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_CartItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CartItemsMouseClicked
        int i = tbl_CartItems.getSelectedRow();
        txtProductName.setText((String) tbl_CartItems.getValueAt(tbl_CartItems.getSelectedRow(), 1).toString());
        txtQuantity.setText((String) tbl_CartItems.getValueAt(tbl_CartItems.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tbl_CartItemsMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tbl_CartItems.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
        }else{
            int b = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sản phẩm này khỏi giỏ hàng ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                int product_id = Integer.parseInt((String) tbl_CartItems.getValueAt(tbl_CartItems.getSelectedRow(), 0).toString());
                cartItemsDAO.deleteCartItems(cartId, product_id);
                JOptionPane.showMessageDialog(this, "Sản phẩm đã được xóa khỏi giỏ hàng !", "Success", JOptionPane.INFORMATION_MESSAGE);

                //Cap nhat lai toan bo table
                listInfoItems = cartItemsDAO.selectInfoCartItem(cartId);
                cartItemsDAO.loadCartItemsToTable(tbl_CartItems, listInfoItems);
                init();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if(listInfoItems.size() <= 0){ // khong co san pham trong gio
            JOptionPane.showMessageDialog(this, "Bạn chưa có hàng trong giỏ !", "Success", JOptionPane.INFORMATION_MESSAGE);
        }else{
            UserFormOrder formOrder = new UserFormOrder();
            formOrder.setVisible(true);
            formOrder.setLocation(565, 210);
            formOrder.setSize(1040, 660);
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (checkIsEmpty()) {
            int product_id = Integer.parseInt((String) tbl_CartItems.getValueAt(tbl_CartItems.getSelectedRow(), 0).toString());
            int quantityNew = Integer.parseInt(txtQuantity.getText());
            cartItemsDAO.updateQuantityToCartItem(cartId, product_id, quantityNew);
            JOptionPane.showMessageDialog(this, "Cập nhật số lượng sản phẩm thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

            //Cap nhat lai toan bo table
            listInfoItems = cartItemsDAO.selectInfoCartItem(cartId);
            cartItemsDAO.loadCartItemsToTable(tbl_CartItems, listInfoItems);
            init();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_totalPrice;
    private javax.swing.JLabel lbl_totalQuantity;
    private javax.swing.JTable tbl_CartItems;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
