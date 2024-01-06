/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package admin;

import dao.tableCanteenDao;
import entity.TableCanteenEntity;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pham Van Thanh
 */
public class QuanLyBan extends javax.swing.JPanel {

    private tableCanteenDao tableDAO = new tableCanteenDao();

    private ArrayList<TableCanteenEntity> listTables = tableDAO.selectTable();

    public QuanLyBan() {
        initComponents();
        tableDAO.loadTablesToTable(tblTables, listTables);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTables = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenBan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTables.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tblTables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã bàn", "Tên bàn", "Trạng thái", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTables.setRowHeight(35);
        tblTables.setRowMargin(5);
        tblTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTables);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 560, 530));

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 250, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setText("Search :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 90, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin chi tiết bàn");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Tên bàn :");

        txtTenBan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Ghi chú :");

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtGhiChu);

        btnThem.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        btnThem.setText("Thêm bàn");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        btnXoa.setText("Xóa bàn");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        btnSua.setText("Sửa bàn");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(txtTenBan, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel4))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtTenBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

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

    private void tblTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablesMouseClicked
        int id = tblTables.getSelectedRow();
        TableCanteenEntity tb = listTables.get(id);
        txtTenBan.setText(tb.getName());
        txtGhiChu.setText(tb.getDescription());
    }//GEN-LAST:event_tblTablesMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String tenBan = txtTenBan.getText().trim();
        if (tenBan.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên bàn !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        for (TableCanteenEntity tb : listTables) {
            if (tb.getName().trim().equals(tenBan)) {
                JOptionPane.showMessageDialog(this, "Tên bàn đã tồn tại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        int b = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm bàn này ?", "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {
            int status = 0; // Trang thai ban trong
            tableDAO.insertTable(tenBan,status, txtGhiChu.getText().trim());
            JOptionPane.showMessageDialog(this, "Thêm bàn thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

            listTables = tableDAO.selectTable();
            tableDAO.loadTablesToTable(tblTables, listTables);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (tblTables.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn cần sửa !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(listTables.get(tblTables.getSelectedRow()).getStatus() == 1){ // Ban dang hoat dong
            JOptionPane.showMessageDialog(this, "Bàn này đang hoạt động.\n Không thể sửa !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String tenBan = txtTenBan.getText().trim();
        if (tenBan.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên bàn !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!listTables.get(tblTables.getSelectedRow()).getName().trim().equals(tenBan)) {
            for (TableCanteenEntity tb : listTables) {
                if (tb.getName().trim().equals(tenBan)) {
                    JOptionPane.showMessageDialog(this, "Tên bàn đã tồn tại !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
        int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa bàn này ?", "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {
            int id = listTables.get(tblTables.getSelectedRow()).getId();
            tableDAO.updateTable(tenBan, txtGhiChu.getText().trim(), id);
            JOptionPane.showMessageDialog(this, "Sửa bàn thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

            listTables = tableDAO.selectTable();
            tableDAO.loadTablesToTable(tblTables, listTables);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tblTables.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn cần xóa !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(listTables.get(tblTables.getSelectedRow()).getStatus() == 1){ // Ban dang hoat dong
            JOptionPane.showMessageDialog(this, "Bàn này đang hoạt động.\n Không thể xóa !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = listTables.get(tblTables.getSelectedRow()).getId();
        if(tableDAO.checkTableInOrder(id)){
            JOptionPane.showMessageDialog(this, "Bàn này đang nằm trong hóa đơn.\n Không thể xóa !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa bàn này ?", "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {
            tableDAO.deleteTable(id);
            JOptionPane.showMessageDialog(this, "Xóa bàn thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

            listTables = tableDAO.selectTable();
            tableDAO.loadTablesToTable(tblTables, listTables);
            
            txtTenBan.setText("");
            txtGhiChu.setText("");
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
    private javax.swing.JTable tblTables;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtTenBan;
    // End of variables declaration//GEN-END:variables
}
