/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package admin;

import dao.NhanVienDao;
import dao.userDao;
import entity.NhanVienEntity;
import entity.RolesEntity;
import entity.userEntity;
import java.sql.Date;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Van Thanh
 */
public class QuanLyKhachhang extends javax.swing.JPanel {
    
    
    private userDao userDAO = new userDao();

    private ArrayList<userEntity> listUser = userDAO.selectUsers();
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    
    public QuanLyKhachhang() {
        initComponents();
        loadUserToTable();
        long millis = System.currentTimeMillis();
        Date currentDate = new Date(millis);
        txtNgaySinh.setDate(currentDate);
    }

    private void loadUserToTable() {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);
        for (userEntity user : listUser) {
            String status = "Hoạt động";
            if (!user.isStatus()) {
                status = "Đã khóa";
            }
            model.addRow(new Object[]{user.getUser(), user.getFullname(), user.getEmail(), user.getBirth(), user.getPhonenumber(), user.getAddress(),status});
        }
    }
    
    private boolean checkEmpty() {
        if (txtUsername.getText().trim().equals("") || txtHoTen.getText().trim().equals("") || txtEmail.getText().trim().equals("")
                || txtDiaChi.getText().trim().equals("") || txtSDT.getText().trim().equals("")
                || txtMatKhau.getText().trim().equals("")) {
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
        
        if (txtMatKhau.getText().trim().length() > 10 || txtMatKhau.getText().trim().length() < 8) {
            JOptionPane.showMessageDialog(this, "Mật khẩu từ 8 tới 10 kí tự !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
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
        jPanel2 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnStatus = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 230, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin khách hàng");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 335, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Tên tài khoản :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 95, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Mật khẩu :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 95, -1));

        txtHoTen.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 230, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setText("Email :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 95, -1));
        jPanel2.add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 250, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Địa chỉ :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 70, -1));

        txtSDT.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 240, -1));

        btnThem.setBackground(new java.awt.Color(153, 204, 255));
        btnThem.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 140, -1));

        btnStatus.setBackground(new java.awt.Color(153, 204, 255));
        btnStatus.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnStatus.setText("Khóa tài khoản");
        btnStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusActionPerformed(evt);
            }
        });
        jPanel2.add(btnStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 230, -1));

        btnSua.setBackground(new java.awt.Color(153, 204, 255));
        btnSua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 140, -1));

        btnXoa.setBackground(new java.awt.Color(153, 204, 255));
        btnXoa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 150, -1));

        btnLamMoi.setBackground(new java.awt.Color(153, 204, 255));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel2.add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 660, 140, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setText("Số điện thoại :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 95, -1));

        txtMatKhau.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 230, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setText("Họ và tên :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 95, -1));

        txtDiaChi.setColumns(20);
        txtDiaChi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtDiaChi.setRows(5);
        jScrollPane2.setViewportView(txtDiaChi);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 240, 90));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Ngày sinh :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 95, -1));

        txtEmail.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 230, -1));

        tblKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên đăng nhập", "Họ tên", "Email", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.setGridColor(new java.awt.Color(153, 255, 153));
        tblKhachHang.setRowHeight(35);
        tblKhachHang.setRowMargin(5);
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setText("Search :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (!checkEmpty()) {
            // kiem tra staff_name co ton tai chua
            for (userEntity nv : listUser) {
                if (nv.getUser().trim().equals(txtUsername.getText().trim())) {
                    JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            int b = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm khách hàng này ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                String username = txtUsername.getText().trim();
                String password = txtMatKhau.getText().trim();
                String fullname = txtHoTen.getText().trim();
                java.util.Date utilDate1 = txtNgaySinh.getDate();
                java.sql.Date ngaySinh = new java.sql.Date(utilDate1.getTime());
                String diaChi = txtDiaChi.getText().trim();
                String phone = txtSDT.getText().trim();
                String email = txtEmail.getText().trim();
                boolean status = true;
                
                userDAO.insertUser(username, password, fullname, ngaySinh, email, phone, diaChi, status);

                JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
                listUser = userDAO.selectUsers();
                loadUserToTable();
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusActionPerformed
        if (tblKhachHang.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        userEntity user = listUser.get(tblKhachHang.getSelectedRow());
        if (user.isStatus()) {
            int b = JOptionPane.showConfirmDialog(this, "Bạn có cho khóa tài khoản này  ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                userDAO.updateStatusUser(user.getUser(), false);
                JOptionPane.showMessageDialog(this, "Khóa tài khoản thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

                listUser = userDAO.selectUsers();
                loadUserToTable();
            }
        } else {
            int b = JOptionPane.showConfirmDialog(this, "Bạn có mở khóa tài khoản này ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                userDAO.updateStatusUser(user.getUser(), true);
                JOptionPane.showMessageDialog(this, "Mở khóa tài khoản thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

                listUser = userDAO.selectUsers();
                loadUserToTable();
            }
        }
    }//GEN-LAST:event_btnStatusActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (tblKhachHang.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!checkEmpty()) {
            // kiem tra staff_name co ton tai chua
            String username = listUser.get(tblKhachHang.getSelectedRow()).getUser();
            if (!txtUsername.getText().trim().equals(username.trim())) {
                for (userEntity nv : listUser) {
                    if (nv.getUser().trim().equals(txtUsername.getText().trim())) {
                        JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
            }
            int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn lưu thay đổi  ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                String usernameNew = txtUsername.getText().trim();
                String password = txtMatKhau.getText().trim();
                String fullname = txtHoTen.getText().trim();
                java.util.Date utilDate1 = txtNgaySinh.getDate();
                java.sql.Date ngaySinh = new java.sql.Date(utilDate1.getTime());
                String diaChi = txtDiaChi.getText().trim();
                String phone = txtSDT.getText().trim();
                String email = txtEmail.getText().trim();
                
                String username_old = listUser.get(tblKhachHang.getSelectedRow()).getUser().trim();
                
                userDAO.updateUser(usernameNew, password, fullname, ngaySinh, email, phone, diaChi, username_old);

                JOptionPane.showMessageDialog(this, "Cập nhật thông tin khách hàng thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
                listUser = userDAO.selectUsers();
                loadUserToTable();
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tblKhachHang.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String usernameDelete = listUser.get(tblKhachHang.getSelectedRow()).getUser();
        if (userDAO.checkUserInOrder(usernameDelete)) {
            JOptionPane.showMessageDialog(this, "Khách hàng đã có hóa đơn.\n Không thể xóa !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (userDAO.checkUserInCart(usernameDelete)) {
            JOptionPane.showMessageDialog(this, "Khách hàng đã có giỏ hàng.\n Không thể xóa !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn XÓA nhân viên này ?", "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {
            userDAO.deleteUser(usernameDelete);
            JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

            listUser = userDAO.selectUsers();
            loadUserToTable();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtUsername.setText("");
        txtHoTen.setText("");
        txtMatKhau.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        userEntity user = listUser.get(tblKhachHang.getSelectedRow());
        txtUsername.setText(user.getUser());
        txtMatKhau.setText(user.getPasswork());
        txtHoTen.setText(user.getFullname());
        txtNgaySinh.setDate(user.getBirth());
        txtDiaChi.setText(user.getAddress());
        txtSDT.setText(user.getPhonenumber());
        txtEmail.setText(user.getEmail());

        if (user.isStatus())
            btnStatus.setText("Khóa tài khoản");
        else
            btnStatus.setText("Mở khóa");
    }//GEN-LAST:event_tblKhachHangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnStatus;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMatKhau;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
