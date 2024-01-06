/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package admin;

import dao.NhanVienDao;
import entity.NhanVienEntity;
import entity.OrderEntity;
import entity.RolesEntity;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Van Thanh
 */
public class NhanVien extends javax.swing.JPanel {

    private NhanVienDao nhanVienDAO = new NhanVienDao();

    private ArrayList<NhanVienEntity> listNV = nhanVienDAO.selectNhanVien();
    private ArrayList<RolesEntity> listRoles = nhanVienDAO.selectRoles();

    public NhanVien() {
        initComponents();
        loadNhanVienToTable();
        loadRolesToCbx();

        long millis = System.currentTimeMillis();
        Date currentDate = new Date(millis);
        txtNgaySinh.setDate(currentDate);
    }

    private void loadNhanVienToTable() {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        for (NhanVienEntity nv : listNV) {
            String role = "";
            for (RolesEntity r : listRoles) {
                if (r.getRole_id() == nv.getRole_id()) {
                    role = r.getRole_name();
                }
            }
            String gioiTinh = "Nam";
            if (!nv.isGioiTinh()) {
                gioiTinh = "Nữ";
            }
            String status = "Hoạt động";
            if (!nv.isStatus()) {
                status = "Ðã nghỉ";
            }
            model.addRow(new Object[]{nv.getStaff_username(), nv.getFullname(), gioiTinh, nv.getNgaySinh(), nv.getDiaChi(),
                nv.getPhone(), nv.getCmnd(), nv.getSoTaiKhoan(), role, status});
        }
    }

    private void loadRolesToCbx() {
        for (int i = 0; i < listRoles.size(); i++) {
            cbxChucVu.addItem(listRoles.get(i).getRole_name());
        }
    }

    private boolean checkEmpty() {
        if (txtUsername.getText().trim().equals("") || txtHoTen.getText().trim().equals("") || txtCMND.getText().trim().equals("")
                || txtDiaChi.getText().trim().equals("") || txtSDT.getText().trim().equals("")
                || txtSTK.getText().trim().equals("") || txtMatKhau.getText().trim().equals("")) {
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
        if (txtCMND.getText().trim().chars().allMatch(Character::isDigit) == false) {
            JOptionPane.showMessageDialog(this, "Số CMND không thể nhập chữ !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        if (txtSTK.getText().trim().chars().allMatch(Character::isDigit) == false) {
            JOptionPane.showMessageDialog(this, "Số tài khoản ngân hàng không thể nhập chữ !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSTK = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNam = new javax.swing.JRadioButton();
        txtNu = new javax.swing.JRadioButton();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbxChucVu = new javax.swing.JComboBox<>();
        lbl = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnStatus = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 230, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin nhân viên");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 335, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Tên tài khoản :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 38, 95, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Mật khẩu :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 95, -1));

        txtHoTen.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 230, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setText("Ngày sinh :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 95, -1));

        txtSTK.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtSTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 240, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Giới tính :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 95, -1));

        buttonGroup1.add(txtNam);
        txtNam.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtNam.setSelected(true);
        txtNam.setText("Nam");
        jPanel2.add(txtNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 81, -1));

        buttonGroup1.add(txtNu);
        txtNu.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtNu.setText("Nữ");
        jPanel2.add(txtNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 93, -1));
        jPanel2.add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 250, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setText("Chức vụ :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 95, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Địa chỉ :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 70, -1));

        txtDiaChi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 240, -1));

        txtSDT.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 240, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setText("CMND/CCCD :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 110, -1));

        cbxChucVu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(cbxChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 240, -1));

        lbl.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbl.setText("Số tài khoản ngân hàng :");
        jPanel2.add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 180, -1));

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
        btnStatus.setText("Nghỉ làm");
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
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 95, -1));

        txtCMND.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 240, -1));

        txtMatKhau.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 230, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setText("Họ và tên :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 95, -1));

        tblNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên đăng nhập", "Họ tên", "Giới tính", "Ngày sinh", "Địa chỉ", "Số điện thoại", "CMND/CCCD", "Số tài khoản", "Chức vụ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.setGridColor(new java.awt.Color(153, 255, 153));
        tblNhanVien.setRowHeight(35);
        tblNhanVien.setRowMargin(5);
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

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
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 800));
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        NhanVienEntity nv = listNV.get(tblNhanVien.getSelectedRow());
        txtUsername.setText(nv.getStaff_username());
        txtMatKhau.setText(nv.getPassword());
        txtHoTen.setText(nv.getFullname());
        if (nv.isGioiTinh()) {
            txtNam.setSelected(true);
        } else {
            txtNu.setSelected(true);
        }

        txtNgaySinh.setDate(nv.getNgaySinh());

        txtDiaChi.setText(nv.getDiaChi());
        txtSDT.setText(nv.getPhone());
        txtCMND.setText(nv.getCmnd());
        txtSTK.setText(nv.getSoTaiKhoan());
        String roleName = tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 8).toString();
        cbxChucVu.setSelectedItem(roleName);

        if (nv.isStatus())
            btnStatus.setText("Nghỉ làm");
        else
            btnStatus.setText("Làm lại");
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (!checkEmpty()) {
            // kiem tra staff_name co ton tai chua
            int dem = 0;
            for (NhanVienEntity nv : listNV) {
                if (nv.getStaff_username().trim().equals(txtUsername.getText().trim())) {
                    dem++;
                }
            }
            if (dem > 0) {
                JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int b = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm nhân viên này ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                String staff_username = txtUsername.getText().trim();
                String password = txtMatKhau.getText().trim();
                String fullname = txtHoTen.getText().trim();
                boolean gioiTinh = txtNam.isSelected();
                java.util.Date utilDate1 = txtNgaySinh.getDate();
                java.sql.Date ngaySinh = new java.sql.Date(utilDate1.getTime());
                String diaChi = txtDiaChi.getText().trim();
                String phone = txtSDT.getText().trim();
                String cmnd = txtCMND.getText().trim();
                String soTaiKhoan = txtSTK.getText().trim();
                int role_id = listRoles.get(cbxChucVu.getSelectedIndex()).getRole_id();
                boolean status = true;
                nhanVienDAO.insertNhanVien(staff_username, fullname, gioiTinh, ngaySinh, diaChi, phone, cmnd, soTaiKhoan, role_id, password, status);

                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
                listNV = nhanVienDAO.selectNhanVien();
                loadNhanVienToTable();
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (tblNhanVien.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!checkEmpty()) {
            // kiem tra staff_name co ton tai chua
            String username = listNV.get(tblNhanVien.getSelectedRow()).getStaff_username();
            if (!txtUsername.getText().trim().equals(username.trim())) {
                int dem = 0;
                for (NhanVienEntity nv : listNV) {
                    if (nv.getStaff_username().trim().equals(txtUsername.getText().trim())) {
                        dem++;
                    }
                }
                if (dem > 0) {
                    JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn lưu thay đổi  ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                String staff_username = txtUsername.getText().trim();
                String password = txtMatKhau.getText().trim();
                String fullname = txtHoTen.getText().trim();
                boolean gioiTinh = txtNam.isSelected();
                java.util.Date utilDate1 = txtNgaySinh.getDate();
                java.sql.Date ngaySinh = new java.sql.Date(utilDate1.getTime());
                String diaChi = txtDiaChi.getText().trim();
                String phone = txtSDT.getText().trim();
                String cmnd = txtCMND.getText().trim();
                String soTaiKhoan = txtSTK.getText().trim();
                int role_id = listRoles.get(cbxChucVu.getSelectedIndex()).getRole_id();
                boolean status = listNV.get(tblNhanVien.getSelectedRow()).isStatus();
                String username_old = listNV.get(tblNhanVien.getSelectedRow()).getStaff_username();
                nhanVienDAO.updateNhanVien(staff_username, fullname, gioiTinh, ngaySinh, diaChi, phone, cmnd, soTaiKhoan, role_id, password, status, username_old);

                JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhân viên thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
                listNV = nhanVienDAO.selectNhanVien();
                loadNhanVienToTable();
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusActionPerformed
        if (tblNhanVien.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        NhanVienEntity nv = listNV.get(tblNhanVien.getSelectedRow());
        if (nv.isStatus()) {
            int b = JOptionPane.showConfirmDialog(this, "Bạn có cho nhân viên này nghỉ làm  ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                nhanVienDAO.updateStatusNhanVien(nv.getStaff_username(), 0);
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhân viên thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

                listNV = nhanVienDAO.selectNhanVien();
                loadNhanVienToTable();
            }
        } else {
            int b = JOptionPane.showConfirmDialog(this, "Bạn có cho nhân viên này làm lại ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                nhanVienDAO.updateStatusNhanVien(nv.getStaff_username(), 1);
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhân viên thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

                listNV = nhanVienDAO.selectNhanVien();
                loadNhanVienToTable();
            }
        }
    }//GEN-LAST:event_btnStatusActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tblNhanVien.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String staff_userName = listNV.get(tblNhanVien.getSelectedRow()).getStaff_username();
        if (nhanVienDAO.checkNhanVienInOrder(staff_userName)) {
            JOptionPane.showMessageDialog(this, "Nhân viên đã lập hóa đơn.\n Không thể xóa !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn XÓA nhân viên này ?", "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {
            nhanVienDAO.deleteNhanVien(staff_userName);
            JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

            listNV = nhanVienDAO.selectNhanVien();
            loadNhanVienToTable();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtUsername.setText("");
        txtHoTen.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtCMND.setText("");
        txtSTK.setText("");
        txtMatKhau.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnStatus;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxChucVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JRadioButton txtNam;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JRadioButton txtNu;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSTK;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
