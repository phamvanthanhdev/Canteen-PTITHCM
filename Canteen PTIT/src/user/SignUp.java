/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package user;

import static admin.QuanLyKhachhang.VALID_EMAIL_ADDRESS_REGEX;
import common.Login;
import common.ToanCuc;
import dao.userDao;
import entity.userEntity;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Pham Van Thanh
 */
public class SignUp extends javax.swing.JFrame {

    private userDao userDAO = new userDao();

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public SignUp() {
        initComponents();
        long millis = System.currentTimeMillis();
        Date currentDate = new Date(millis);
        txtNgaySinh.setDate(currentDate);
    }

    private boolean checkEmpty() {
        if (txtUsername.getText().trim().equals("") || txtHoTen.getText().trim().equals("") || txtEmail.getText().trim().equals("")
                || txtDiaChi.getText().trim().equals("") || txtSDT.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        
         if (txtNgaySinh.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Ngày sinh chưa hợp lệ !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return true;
        }

        if (txtSDT.getText().trim().chars().allMatch(Character::isDigit) == false) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không thể nhập chữ !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        if (txtSDT.getText().trim().length() != 10) {
            JOptionPane.showMessageDialog(this, "Số điện thoại bắt buộc 10 chữ số !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        //check so dien thoai bat dau bang so 0
        if (txtSDT.getText().toString().charAt(0) != '0') {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải bắt đầu bằng số 0 !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return true;
        }

        Matcher m = VALID_EMAIL_ADDRESS_REGEX.matcher(txtEmail.getText().trim());
        if (!m.find()) {
            JOptionPane.showMessageDialog(this, "Email chưa chính xác !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return true;
        }

        long millis = System.currentTimeMillis();
        Date currentDate = new Date(millis);
        java.util.Date utilDate1 = txtNgaySinh.getDate();
        java.sql.Date ngaySinh = new java.sql.Date(utilDate1.getTime());
        if (ngaySinh.compareTo(currentDate) > 0) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không thể vượt quá ngày hiện tại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return true;
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnTaoTaiKhoan = new javax.swing.JButton();
        lbl_hide1 = new javax.swing.JLabel();
        lbl_visible1 = new javax.swing.JLabel();
        lbl_hide2 = new javax.swing.JLabel();
        lbl_visible2 = new javax.swing.JLabel();
        txtXacNhan = new javax.swing.JPasswordField();
        txtMatKhauMoi = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tài khoản đăng nhập");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 470, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel18.setText("Nhập mật khẩu mới :");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel19.setText("Xác nhận lại mật khẩu :");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 140, -1));

        btnTaoTaiKhoan.setBackground(new java.awt.Color(153, 204, 255));
        btnTaoTaiKhoan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnTaoTaiKhoan.setText("Tạo tài khoản");
        btnTaoTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoTaiKhoanActionPerformed(evt);
            }
        });
        jPanel6.add(btnTaoTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 400, -1));

        lbl_hide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
        lbl_hide1.setText("jLabel8");
        lbl_hide1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_hide1MouseClicked(evt);
            }
        });
        jPanel6.add(lbl_hide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 30, 30));

        lbl_visible1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/visible.png"))); // NOI18N
        lbl_visible1.setText("jLabel8");
        lbl_visible1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_visible1MouseClicked(evt);
            }
        });
        jPanel6.add(lbl_visible1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 30, 30));

        lbl_hide2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
        lbl_hide2.setText("jLabel8");
        lbl_hide2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_hide2MouseClicked(evt);
            }
        });
        jPanel6.add(lbl_hide2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 30, 30));

        lbl_visible2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/visible.png"))); // NOI18N
        lbl_visible2.setText("jLabel8");
        lbl_visible2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_visible2MouseClicked(evt);
            }
        });
        jPanel6.add(lbl_visible2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 30, 30));

        txtXacNhan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel6.add(txtXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 300, -1));

        txtMatKhauMoi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel6.add(txtMatKhauMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 300, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Tên tài khoản :");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, -1));

        txtUsername.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel6.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 300, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 480, 680));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Thông tin khách hàng");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 6, 380, -1));

        txtHoTen.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel7.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 280, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setText("Email :");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 140, -1));
        jPanel7.add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 300, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Địa chỉ :");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 120, -1));

        txtSDT.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel7.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 280, -1));

        btnLamMoi.setBackground(new java.awt.Color(153, 204, 255));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel7.add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 360, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setText("Số điện thoại :");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 140, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setText("Họ và tên :");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 140, -1));

        txtDiaChi.setColumns(20);
        txtDiaChi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtDiaChi.setRows(5);
        jScrollPane2.setViewportView(txtDiaChi);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 290, 90));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setText("Ngày sinh :");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 140, -1));

        txtEmail.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel7.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 280, -1));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 460, 680));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 20, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoTaiKhoanActionPerformed
        if (!checkEmpty()) {
            // kiem tra username co ton tai chua
            String username = txtUsername.getText().trim();
            userEntity user_temp = userDAO.selectUserByUsername(username);
            if (user_temp != null) {
                JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            

            String matKhauMoi = String.valueOf(txtMatKhauMoi.getPassword()).trim();
            String xacNhan = String.valueOf(txtXacNhan.getPassword()).trim();

            if (matKhauMoi.equals("") || xacNhan.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!matKhauMoi.equals(xacNhan)) {
                JOptionPane.showMessageDialog(this, "Xác nhận mật khẩu không chính xác !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (matKhauMoi.trim().length() > 10 || matKhauMoi.trim().length() < 8) {
                JOptionPane.showMessageDialog(this, "Mật khẩu từ 8 tới 10 kí tự !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn tạo tài khoản này  ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {

                String password = xacNhan;
                String fullname = txtHoTen.getText().trim();
                java.util.Date utilDate1 = txtNgaySinh.getDate();
                java.sql.Date ngaySinh = new java.sql.Date(utilDate1.getTime());
                String diaChi = txtDiaChi.getText().trim();
                String phone = txtSDT.getText().trim();
                String email = txtEmail.getText().trim();
                boolean status = true;

                userDAO.insertUser(username, password, fullname, ngaySinh, email, phone, diaChi, status);

                int c = JOptionPane.showConfirmDialog(this, "Tạo tài khoản thành công. \nBạn có muốn đăng nhập ngay vào hệ thống với tài khoản này ?  ?", "Notice", JOptionPane.YES_NO_OPTION);
                if (c == 0) {
                    new ToanCuc().setUsername(username);
                    
                    this.dispose();
                    new UserDashboard().setVisible(true);
                }else{
                    this.dispose();
                    new Login().setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_btnTaoTaiKhoanActionPerformed

    private void lbl_hide1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_hide1MouseClicked
        txtMatKhauMoi.setEchoChar((char) 0);

        lbl_visible1.setVisible(true);
        lbl_hide1.setVisible(false);
    }//GEN-LAST:event_lbl_hide1MouseClicked

    private void lbl_visible1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_visible1MouseClicked
        txtMatKhauMoi.setEchoChar('*');

        lbl_visible1.setVisible(false);
        lbl_hide1.setVisible(true);
    }//GEN-LAST:event_lbl_visible1MouseClicked

    private void lbl_hide2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_hide2MouseClicked
        txtXacNhan.setEchoChar((char) 0);

        lbl_visible2.setVisible(true);
        lbl_hide2.setVisible(false);
    }//GEN-LAST:event_lbl_hide2MouseClicked

    private void lbl_visible2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_visible2MouseClicked
        txtXacNhan.setEchoChar('*');

        lbl_visible2.setVisible(false);
        lbl_hide2.setVisible(true);
    }//GEN-LAST:event_lbl_visible2MouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn làm làm mới thông tin đã nhập  ?", "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {
            txtDiaChi.setText("");
            txtEmail.setText("");
            txtHoTen.setText("");
            txtSDT.setText("");
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTaoTaiKhoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_hide1;
    private javax.swing.JLabel lbl_hide2;
    private javax.swing.JLabel lbl_visible1;
    private javax.swing.JLabel lbl_visible2;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JPasswordField txtMatKhauMoi;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtXacNhan;
    // End of variables declaration//GEN-END:variables
}
