/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package user;

import static admin.QuanLyKhachhang.VALID_EMAIL_ADDRESS_REGEX;
import common.ToanCuc;
import dao.NhanVienDao;
import dao.userDao;
import entity.NhanVienEntity;
import entity.userEntity;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Pham Van Thanh
 */
public class UserAccount extends javax.swing.JPanel {

    private String username = new ToanCuc().getUsername();
    private userDao userDAO = new userDao();
    
    private userEntity user = userDAO.selectUserByUsername(username);
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    public UserAccount() {
        initComponents();
        loadUser();
    }
    
    private void loadUser(){
        txtUsername.setText(user.getUser());
        txtHoTen.setText(user.getFullname());
        txtNgaySinh.setDate(user.getBirth());
        txtDiaChi.setText(user.getAddress());
        txtSDT.setText(user.getPhonenumber());
        txtEmail.setText(user.getEmail());
    }
    
    private boolean checkEmpty() {
        if (txtUsername.getText().trim().equals("") || txtHoTen.getText().trim().equals("") || txtEmail.getText().trim().equals("")
                || txtDiaChi.getText().trim().equals("") || txtSDT.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        
        if (txtNgaySinh.getDate() == null){    
        JOptionPane.showMessageDialog(this, "Ngày sinh chưa hợp lệ !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        
        if (txtNgaySinh.getDate().compareTo(new Date(01, 01, 1700)) < 0){    
        JOptionPane.showMessageDialog(this, "Ngày sinh quá nhỏ !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
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
        if (!m.find()){
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnThayDoi = new javax.swing.JButton();
        lbl_hide = new javax.swing.JLabel();
        lbl_visible = new javax.swing.JLabel();
        lbl_hide1 = new javax.swing.JLabel();
        lbl_visible1 = new javax.swing.JLabel();
        lbl_hide2 = new javax.swing.JLabel();
        lbl_visible2 = new javax.swing.JLabel();
        txtXacNhan = new javax.swing.JPasswordField();
        txtMatKhauCu = new javax.swing.JPasswordField();
        txtMatKhauMoi = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thay đổi mật khẩu");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 470, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel13.setText("Nhập mật khẩu cũ :");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 140, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel14.setText("Nhập mật khẩu mới :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel15.setText("Xác nhận lại mật khẩu :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 140, -1));

        btnThayDoi.setBackground(new java.awt.Color(153, 204, 255));
        btnThayDoi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnThayDoi.setText("Thay đổi");
        btnThayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThayDoiActionPerformed(evt);
            }
        });
        jPanel3.add(btnThayDoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 400, -1));

        lbl_hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
        lbl_hide.setText("jLabel8");
        lbl_hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_hideMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 30, 30));

        lbl_visible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/visible.png"))); // NOI18N
        lbl_visible.setText("jLabel8");
        lbl_visible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_visibleMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_visible, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 30, 30));

        lbl_hide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
        lbl_hide1.setText("jLabel8");
        lbl_hide1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_hide1MouseClicked(evt);
            }
        });
        jPanel3.add(lbl_hide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 30, 30));

        lbl_visible1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/visible.png"))); // NOI18N
        lbl_visible1.setText("jLabel8");
        lbl_visible1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_visible1MouseClicked(evt);
            }
        });
        jPanel3.add(lbl_visible1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 30, 30));

        lbl_hide2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
        lbl_hide2.setText("jLabel8");
        lbl_hide2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_hide2MouseClicked(evt);
            }
        });
        jPanel3.add(lbl_hide2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 30, 30));

        lbl_visible2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/visible.png"))); // NOI18N
        lbl_visible2.setText("jLabel8");
        lbl_visible2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_visible2MouseClicked(evt);
            }
        });
        jPanel3.add(lbl_visible2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 30, 30));

        txtXacNhan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel3.add(txtXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 300, -1));

        txtMatKhauCu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel3.add(txtMatKhauCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 300, -1));

        txtMatKhauMoi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel3.add(txtMatKhauMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 300, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 480, 680));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 280, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thông tin khách hàng");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 6, 380, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Tên tài khoản :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 140, -1));

        txtHoTen.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 280, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Email :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 140, -1));
        jPanel2.add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 300, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Địa chỉ :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 120, -1));

        txtSDT.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 290, -1));

        btnSua.setBackground(new java.awt.Color(153, 204, 255));
        btnSua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnSua.setText("Cập nhật");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 360, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setText("Số điện thoại :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 140, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setText("Họ và tên :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 140, -1));

        txtDiaChi.setColumns(20);
        txtDiaChi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtDiaChi.setRows(5);
        jScrollPane2.setViewportView(txtDiaChi);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 290, 90));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setText("Ngày sinh :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 140, -1));

        txtEmail.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 280, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 460, 680));

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

    private void btnThayDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThayDoiActionPerformed
        String matKhauCu = String.valueOf(txtMatKhauCu.getPassword()).trim();
        String matKhauMoi = String.valueOf(txtMatKhauMoi.getPassword()).trim();
        String xacNhan = String.valueOf(txtXacNhan.getPassword()).trim();

        if(matKhauCu.equals("") || matKhauMoi.equals("") || xacNhan.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!matKhauCu.equals(user.getPasswork().trim())){
            JOptionPane.showMessageDialog(this, "Mật khẩu không chính xác !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!matKhauMoi.equals(xacNhan)){
            JOptionPane.showMessageDialog(this, "Xác nhận mật khẩu không chính xác !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (matKhauMoi.trim().length() > 10 || matKhauMoi.trim().length() < 8) {
            JOptionPane.showMessageDialog(this, "Mật khẩu từ 8 tới 10 kí tự !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thay đổi mật khẩu  ?", "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {
            userDAO.updatePasswordUser(user.getUser(), xacNhan);

            JOptionPane.showMessageDialog(this, "Thay đổi mật khẩu thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
            user = userDAO.selectUserByUsername(username);
        }

    }//GEN-LAST:event_btnThayDoiActionPerformed

    private void lbl_hideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_hideMouseClicked
        txtMatKhauCu.setEchoChar((char) 0);

        lbl_visible.setVisible(true);
        lbl_hide.setVisible(false);
    }//GEN-LAST:event_lbl_hideMouseClicked

    private void lbl_visibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_visibleMouseClicked
        txtMatKhauCu.setEchoChar('*');

        lbl_visible.setVisible(false);
        lbl_hide.setVisible(true);
    }//GEN-LAST:event_lbl_visibleMouseClicked

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

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (!checkEmpty()) {
            // kiem tra username co ton tai chua
            String usernameOld = user.getUser().trim();
            if (!txtUsername.getText().trim().equals(usernameOld.trim())) {
                userEntity user_temp = userDAO.selectUserByUsername(usernameOld);
                if (user_temp != null) {
                    JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thay đổi thông tin  ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                String usernameNew = txtUsername.getText().trim();
                String fullname = txtHoTen.getText().trim();
                java.util.Date utilDate1 = txtNgaySinh.getDate();
                java.sql.Date ngaySinh = new java.sql.Date(utilDate1.getTime());
                String diaChi = txtDiaChi.getText().trim();
                String phone = txtSDT.getText().trim();
                String email = txtEmail.getText().trim();
                String password = user.getPasswork().trim();

                userDAO.updateUser(usernameNew, password, fullname, ngaySinh, email, phone, diaChi, usernameOld);

                JOptionPane.showMessageDialog(this, "Cập nhật thông tin khách hàng thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
                user = userDAO.selectUserByUsername(username);
                loadUser();
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThayDoi;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_hide;
    private javax.swing.JLabel lbl_hide1;
    private javax.swing.JLabel lbl_hide2;
    private javax.swing.JLabel lbl_visible;
    private javax.swing.JLabel lbl_visible1;
    private javax.swing.JLabel lbl_visible2;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JPasswordField txtMatKhauCu;
    private javax.swing.JPasswordField txtMatKhauMoi;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtXacNhan;
    // End of variables declaration//GEN-END:variables
}
