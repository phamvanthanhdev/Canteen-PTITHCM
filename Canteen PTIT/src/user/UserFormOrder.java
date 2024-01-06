/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package user;

import common.ToanCuc;
import dao.cartDao;
import dao.cartItemsDao;
import dao.orderDao;
import dao.orderItemsDao;
import dao.productDao;
import entity.CartItemsEntity;
import entity.ProductEntity;
import entity.infoCartItem;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Pham Van Thanh
 */
public class UserFormOrder extends javax.swing.JFrame {

    private String username = new ToanCuc().getUsername();

    private cartDao cartDAO = new cartDao();
    private cartItemsDao cartItemsDAO = new cartItemsDao();
    private orderDao orderDAO = new orderDao();
    private orderItemsDao orderItemsDAO = new orderItemsDao();
    private productDao productDAO = new productDao();

    //Lay cartId cua gio hang
    private int cartId = cartDAO.selectCartByUsername(username).getId();
    //danh sach info Item cua gio hang
    private ArrayList<infoCartItem> listInfoItems = cartItemsDAO.selectInfoCartItem(cartId);
    
    Locale locale = new Locale("vi", "VN");
    NumberFormat format = NumberFormat.getInstance(locale);

    public UserFormOrder() {
        initComponents();
        loadPaymentsToCbx();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_totalPrice = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_totalQuantity = new javax.swing.JLabel();
        btnDatHang = new javax.swing.JButton();
        txtPhoneNumber = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbxPayments = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNote = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(25, 118, 211));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tổng tiền :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 100, -1));

        lbl_totalPrice.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_totalPrice.setForeground(new java.awt.Color(255, 255, 255));
        lbl_totalPrice.setText("0.0");
        jPanel1.add(lbl_totalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 280, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hình thức thanh toán :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 230, 30));

        lbl_totalQuantity.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_totalQuantity.setForeground(new java.awt.Color(255, 255, 255));
        lbl_totalQuantity.setText("0");
        jPanel1.add(lbl_totalQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 280, -1));

        btnDatHang.setBackground(new java.awt.Color(204, 204, 255));
        btnDatHang.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnDatHang.setForeground(new java.awt.Color(25, 118, 221));
        btnDatHang.setText("Hoàn tất đặt hàng");
        btnDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHangActionPerformed(evt);
            }
        });
        jPanel1.add(btnDatHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 890, 40));

        txtPhoneNumber.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 320, -1));

        txtAddress.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 320, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tổng sản phẩm :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        cbxPayments.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbxPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPaymentsActionPerformed(evt);
            }
        });
        jPanel1.add(cbxPayments, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 320, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Địa chỉ nhận :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 130, 30));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("XÁC NHẬN ĐẶT HÀNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 60));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Số điện thoại :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 130, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 61, 60, 50));

        lblNote.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        lblNote.setForeground(new java.awt.Color(255, 255, 255));
        lblNote.setText("Lưu ý : Vui lòng chuyển tiền tới số tài khoản 361920546303 để nhân viên tiến hành xác nhận đơn của bạn.");
        jPanel1.add(lblNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 800, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHangActionPerformed
        boolean a = checkIsEmpty();
        if (a == true) {
            long millis = System.currentTimeMillis();
            Date order_date = new Date(millis);

            String adress = txtAddress.getText();
            int status = 1; // Trang thai don hang online mac dinh la 1(Cho xac nhan)
            String phonenumber = txtPhoneNumber.getText();
            int payments = cbxPayments.getSelectedIndex();
            int type = 2; // Hang dat online se có loai la 2
            
            float totalPrice = 0;
                
            int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn hoàn tất đặt hàng cho đơn hàng này ?", "Notice", JOptionPane.YES_NO_OPTION);

            if (b == 0) {
                //Them don hang moi vao csdl
                orderDAO.insertOrder(username, order_date, adress, status, phonenumber, payments, type, totalPrice);

                //Lay ra ma don hang vua dat
                int orderID = orderDAO.selectOrderIdByUsername(username);

                //Them tung mat hang vao chi tiet don hang
                for (infoCartItem i : listInfoItems) {
                    orderItemsDAO.insertOrderItems(orderID, i.getProduct_id(), i.getQuantity());
                    
                    // Cap nhat lai so luong tung san pham
                    ProductEntity product = productDAO.selectProductsById(i.getProduct_id());
                    int productNew = product.getQuantity() - i.getQuantity();
                    productDAO.updateQuantityProduct(product.getId(), productNew);
                }
                
                //Xoa tat ca don hang trong gio hang
                cartItemsDAO.deleteAllCartItems(cartId);

                JOptionPane.showMessageDialog(this, "Đặt hàng thành công.\n Sản phẩm của bạn sẽ được giao đến trong thời gian ngắn nhất !", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnDatHangActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void cbxPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPaymentsActionPerformed
        int payment = cbxPayments.getSelectedIndex();
        if(payment == 0){
            lblNote.setVisible(false);
        }else{
            lblNote.setVisible(true);
        }
    }//GEN-LAST:event_cbxPaymentsActionPerformed

    private boolean checkIsEmpty() {
        // check txt rong
        if (txtAddress.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhận hàng !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        //check txt rong
        if (txtPhoneNumber.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        //check so luong chua ki tu khac so
        if (txtPhoneNumber.getText().chars().allMatch(Character::isDigit) == false) {
            JOptionPane.showMessageDialog(this, "Chỉ được nhập số !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        //check so dien thoai bat dau bang so 0
        if (txtPhoneNumber.getText().toString().charAt(0) != '0') {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải bắt đầu bằng số 0 !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    // Them lua chon hinh thuc thanh toan cho cbx
    private void loadPaymentsToCbx() {
        cbxPayments.addItem("Thanh toán khi nhận hàng (COD)");
        cbxPayments.addItem("Chuyển khoản ngân hàng");
        cbxPayments.addItem("Thẻ Tín dụng/Ghi nợ");
        cbxPayments.addItem("Thẻ nội địa NAPAS");
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
            java.util.logging.Logger.getLogger(UserFormOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFormOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFormOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFormOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFormOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatHang;
    private javax.swing.JComboBox<String> cbxPayments;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lbl_totalPrice;
    private javax.swing.JLabel lbl_totalQuantity;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
