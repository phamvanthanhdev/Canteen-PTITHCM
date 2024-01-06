/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package admin;

import dao.categoryDao;
import entity.CategoryEntity;
import entity.TableCanteenEntity;
import entity.infoCartItem;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Van Thanh
 */
public class QuanLyLoai extends javax.swing.JPanel {

    private categoryDao categoryDAO = new categoryDao();

    private ArrayList<CategoryEntity> listCategory = categoryDAO.selectCategories();

    public QuanLyLoai() {
        initComponents();
        loadCategoriesToTable();
    }

    // Load info order items vào table
    public void loadCategoriesToTable() {
        DefaultTableModel model = (DefaultTableModel) tblCategories.getModel();
        model.setRowCount(0);
        for (CategoryEntity c : listCategory) {
            model.addRow(new Object[]{c.getId(), c.getName(), c.getDescription()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategories = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenLoai = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCategories.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tblCategories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã loại sản phẩm", "Tên loại sản phẩm", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCategories.setRowHeight(35);
        tblCategories.setRowMargin(5);
        tblCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategories);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 54, 581, 576));

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 250, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setText("Tìm kiếm :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 650));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin loại sản phẩm");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Tên loại sản phẩm :");

        txtTenLoai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtGhiChu);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Ghi chú :");

        btnThem.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnThem.setText("Thêm loại");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnXoa.setText("Xóa loại");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnSua.setText("Sửa loại");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(btnThem)
                .addGap(31, 31, 31)
                .addComponent(btnXoa)
                .addGap(35, 35, 35)
                .addComponent(btnSua)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 400, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriesMouseClicked
        int i = tblCategories.getSelectedRow();
        txtTenLoai.setText(listCategory.get(i).getName());
        txtGhiChu.setText(listCategory.get(i).getDescription());
    }//GEN-LAST:event_tblCategoriesMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtTenLoai.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên loại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String tenLoai = txtTenLoai.getText().trim();
        for (CategoryEntity c : listCategory) {
            if (c.getName().trim().equals(tenLoai)) {
                JOptionPane.showMessageDialog(this, "Tên loại đã tồn tại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thêm loại này ?", "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {
            categoryDAO.insertCategory(txtTenLoai.getText().trim(), txtGhiChu.getText().trim());
            JOptionPane.showMessageDialog(this, "Thêm loại thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

            listCategory = categoryDAO.selectCategories();
            loadCategoriesToTable();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (txtTenLoai.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên loại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tblCategories.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String tenLoai = txtTenLoai.getText().trim();
        if (!listCategory.get(tblCategories.getSelectedRow()).getName().trim().equals(tenLoai)) {
            for (CategoryEntity c : listCategory) {
                if (c.getName().trim().equals(tenLoai)) {
                    JOptionPane.showMessageDialog(this, "Tên loại đã tồn tại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
        int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa loại này ?", "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {
            int id = listCategory.get(tblCategories.getSelectedRow()).getId();
            categoryDAO.updateCategory(tenLoai, txtGhiChu.getText().trim(), id);

            JOptionPane.showMessageDialog(this, "Cập nhật loại thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

            listCategory = categoryDAO.selectCategories();
            loadCategoriesToTable();
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tblCategories.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại cần xóa !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = listCategory.get(tblCategories.getSelectedRow()).getId();
        if (categoryDAO.checkCategoryInProduct(id)) {
            JOptionPane.showMessageDialog(this, "Loại này đã chứa sản phẩm.\n Không thể xóa !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn XÓA loại này ?", "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {
            categoryDAO.deleteCategory(id);
            JOptionPane.showMessageDialog(this, "Xóa loại thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

            listCategory = categoryDAO.selectCategories();
            loadCategoriesToTable();
        }
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblCategories;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtTenLoai;
    // End of variables declaration//GEN-END:variables
}
