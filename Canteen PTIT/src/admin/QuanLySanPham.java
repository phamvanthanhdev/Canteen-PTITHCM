/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package admin;

import dao.categoryDao;
import dao.productDao;
import entity.CategoryEntity;
import entity.ProductEntity;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Van Thanh
 */
public class QuanLySanPham extends javax.swing.JPanel {

    private productDao proDAO = new productDao();
    private categoryDao categoryDAO = new categoryDao();

    private ArrayList<ProductEntity> listProducts = proDAO.selectAllProducts();
    private ArrayList<CategoryEntity> listCategory = categoryDAO.selectCategories();
    
    public QuanLySanPham() {
        initComponents();
        init();
    }

    // Load san pham vào table
    public void loadProductsToTable(JTable tblCartItem, ArrayList<ProductEntity> listProducts) {
        DefaultTableModel model = (DefaultTableModel) tblCartItem.getModel();
        model.setRowCount(0);
        for (ProductEntity p : listProducts) {
            String status = "Hoạt động";
            if (!p.isStatus()) {
                status = "Ngưng bán";
            }
            model.addRow(new Object[]{p.getId(), p.getName(), p.getQuantity(), p.getPrince(), status});
        }
    }

    // dua category name vao combobox 
    private void loadCategoriesToCbx() {
        for (int i = 0; i < listCategory.size(); i++) {
            cbxCategory.addItem(listCategory.get(i).getName());
        }
    }
    
    private void init() {
        loadProductsToTable(tblProducts, listProducts);
        loadCategoriesToCbx();
    }
    
    //Kiem tra nhap du lieu
    private boolean checkEmpty(){
        if(txtName.getText().trim().equals("") || txtPrice.getText().trim().equals("") || txtQuantity.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        //check so luong luon > 0
        if(Integer.parseInt(txtQuantity.getText()) <= 0){
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0 !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxCategory = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDecriptions = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        btnNgungBan = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblAnh = new javax.swing.JLabel();
        btnChon = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý sản phẩm");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 408, -1));

        btnThem.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 123, -1));

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 529, 139, -1));

        btnDelete.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 529, 110, -1));

        txtName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 260, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Số lượng tồn :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 108, 30));

        txtQuantity.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityKeyReleased(evt);
            }
        });
        jPanel1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 260, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Giá bán :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 199, 108, 30));

        txtPrice.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPriceKeyReleased(evt);
            }
        });
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 260, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Loại sản phẩm :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 108, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hình ảnh :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 108, -1));

        cbxCategory.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(cbxCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 260, -1));

        txtDecriptions.setColumns(20);
        txtDecriptions.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtDecriptions.setRows(5);
        jScrollPane2.setViewportView(txtDecriptions);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 260, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tên sản phẩm :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 79, 108, 30));

        btnNgungBan.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        btnNgungBan.setText("Ngưng bán");
        btnNgungBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgungBanActionPerformed(evt);
            }
        });
        jPanel1.add(btnNgungBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 575, 127, -1));

        btnClear.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        btnClear.setText("Làm mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 575, 126, -1));

        lblAnh.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        lblAnh.setText("Chưa chọn file nào");
        jPanel1.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 280, 20));

        btnChon.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        btnChon.setText("chọn");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });
        jPanel1.add(btnChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 80, 20));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mô tả :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 108, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 15, 420, 630));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        tblProducts.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducts.setRowHeight(35);
        tblProducts.setRowMargin(5);
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducts);

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tìm kiếm :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 16, -1, 630));
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(!checkEmpty()){
            int b = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm sản phẩm này ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                String name = txtName.getText();
                String description = txtDecriptions.getText();
                int cateId = listCategory.get(cbxCategory.getSelectedIndex()).getId();
                float price = Float.parseFloat(txtPrice.getText());
                int quantity = Integer.parseInt(txtQuantity.getText());
                
                String img = lblAnh.getText();
                
                int status = 1;
                proDAO.insertProduct(name, description, cateId, price, quantity, img, status);
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

                listProducts = proDAO.selectAllProducts();
                loadProductsToTable(tblProducts, listProducts);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(!checkEmpty()){
            int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn lưu thay đổi  ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                String name = txtName.getText();
                String description = txtDecriptions.getText();
                int cateId = listCategory.get(cbxCategory.getSelectedIndex()).getId();
                float price = Float.parseFloat(txtPrice.getText());
                int quantity = Integer.parseInt(txtQuantity.getText());
                String img = lblAnh.getText();
                
                int id = listProducts.get(tblProducts.getSelectedRow()).getId();

                proDAO.updateProduct(id, name, description, cateId, price, quantity, img);
                JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

                listProducts = proDAO.selectAllProducts();
                loadProductsToTable(tblProducts, listProducts);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm ?", "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {
            int id = listProducts.get(tblProducts.getSelectedRow()).getId();

            if (proDAO.checkCartItemsExist(id)) {
                JOptionPane.showMessageDialog(this, "Sản phẩm đang nằm trong đặt hàng hàng Online\nKhông thể xóa sản phẩm !", "Success", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (proDAO.checkOrderItemsExist(id)) {
                JOptionPane.showMessageDialog(this, "Sản phẩm đang nằm trong đơn hàng\nKhông thể xóa sản phẩm !", "Success", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            proDAO.deleteProduct(id);
            JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

            listProducts = proDAO.selectAllProducts();
            loadProductsToTable(tblProducts, listProducts);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased
        //check so luong chua ki tu khac so
        if (txtQuantity.getText().chars().allMatch(Character::isDigit) == false) {
            JOptionPane.showMessageDialog(this, "Chỉ được nhập số !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            txtQuantity.setText(txtQuantity.getText().substring(0, txtQuantity.getText().length() - 1));
        }
    }//GEN-LAST:event_txtQuantityKeyReleased

    private void txtPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyReleased
        //check so luong chua ki tu khac so
        if (txtPrice.getText().chars().allMatch(Character::isDigit) == false) {
            JOptionPane.showMessageDialog(this, "Chỉ được nhập số !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            txtPrice.setText(txtPrice.getText().substring(0, txtPrice.getText().length() - 1));
        }
    }//GEN-LAST:event_txtPriceKeyReleased

    private void btnNgungBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgungBanActionPerformed
        boolean status = listProducts.get(tblProducts.getSelectedRow()).isStatus();
        if (status) {
            int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn dừng bán sản phẩm này ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                int id = listProducts.get(tblProducts.getSelectedRow()).getId();
                proDAO.updateStatusProduct(id, 0);

                JOptionPane.showMessageDialog(this, "Ngưng bán sản phẩm thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
                listProducts = proDAO.selectAllProducts();
                loadProductsToTable(tblProducts, listProducts);
            }
        }else{
            int b = JOptionPane.showConfirmDialog(this, "Hoạt động lại sản phẩm này ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                int id = listProducts.get(tblProducts.getSelectedRow()).getId();
                proDAO.updateStatusProduct(id, 1);

                JOptionPane.showMessageDialog(this, "Sản phẩm hoạt động thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
                listProducts = proDAO.selectAllProducts();
                loadProductsToTable(tblProducts, listProducts);
            }
        }
    }//GEN-LAST:event_btnNgungBanActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtName.setText("");
        txtPrice.setText("");
        txtDecriptions.setText("");
        txtQuantity.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked
        int i = tblProducts.getSelectedRow();
        ProductEntity prod = listProducts.get(i);
        txtName.setText(prod.getName());
        txtQuantity.setText(prod.getQuantity() + "");
        txtPrice.setText(prod.getPrince() + "");
        txtDecriptions.setText(prod.getDescription());
        lblAnh.setText(prod.getImage_url());

        for (CategoryEntity c : listCategory) {
            if (c.getId() == prod.getCategory_id()) {
                cbxCategory.setSelectedItem(c.getName());
            }
        }
        boolean status = listProducts.get(i).isStatus();
        if(status) btnNgungBan.setText("Ngưng bán");
        else btnNgungBan.setText("Hoạt động");
    }//GEN-LAST:event_tblProductsMouseClicked

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        listProducts = proDAO.searchAllProducts(txtSearch);
        loadProductsToTable(tblProducts, listProducts);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
       JFileChooser fileChooser = new JFileChooser("C:\\imagesSanPham");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//chi hien thi 1 file
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // duong dan file
            String pathFile = file.getAbsolutePath();
            //String pathFile1 = file.getAbsolutePath().replace("//", "--");
            BufferedImage b;
            try {
                b = ImageIO.read(file);
                lblAnh.setText(pathFile);
                //img_url = pathFile;
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnChonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNgungBan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextArea txtDecriptions;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
