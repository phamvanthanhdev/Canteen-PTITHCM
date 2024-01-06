/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package user;

import common.ToanCuc;
import dao.cartDao;
import dao.cartItemsDao;
import dao.categoryDao;
import dao.productDao;
import entity.CartEntity;
import entity.CartItemsEntity;
import entity.CategoryEntity;
import entity.ProductEntity;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pham Van Thanh
 */
public class MuaHang extends javax.swing.JPanel {

    private int categoryIdSelected = 1;
    private String username = new ToanCuc().getUsername();
    
    private categoryDao categoryDAO = new categoryDao();
    private productDao proDAO = new productDao();
    private cartDao cartDAO = new cartDao();
    private cartItemsDao cartItemsDAO = new cartItemsDao();
    
    private ArrayList<CategoryEntity> listCategory = categoryDAO.selectCategories();
    private ArrayList<ProductEntity> listProducts = proDAO.selectProductsByCategoryId(categoryIdSelected);
    private CartEntity myCart = new CartEntity();
    
    public MuaHang() {
        initComponents();
        loadCategoriesToCbx();
        loadSortByToCbx();
        proDAO.loadProductToTable(tbl_Products, listProducts);
    }

    // dua category name vao combobox 
    private void loadCategoriesToCbx(){
        for (int i = 0; i < listCategory.size(); i++) {
            cbxCategories.addItem(listCategory.get(i).getName());
        }
    }
    
    // Them lua chon cho cbx
    private void loadSortByToCbx(){
        cbxSortBy.addItem("Giá thấp đến cao");
        cbxSortBy.addItem("Giá cao đến thấp");
    }
    
    private boolean checkIsEmpty(){
        // check txt rong
        if(txtProductName.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        //check txt rong
        if(txtQuantity.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        //check so luong chua ki tu khac so
        if(txtQuantity.getText().chars().allMatch(Character::isDigit) == false){
            JOptionPane.showMessageDialog(this, "Chỉ được nhập số !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        //check so luong luon > 0
        if(Integer.parseInt(txtQuantity.getText()) <= 0){
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0 !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // Lay so luong ton tren bang
        int productQuantity = Integer.parseInt((String)tbl_Products.getValueAt(tbl_Products.getSelectedRow(), 3).toString()); 
        //check so luong nhieu hon so luong ton
        if(Integer.parseInt(txtQuantity.getText().trim()) > productQuantity){
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
        tbl_Products = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbxCategories = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAddToCart = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbxSortBy = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(25, 118, 211));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Products.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        tbl_Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng tồn", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Products.setRowHeight(35);
        tbl_Products.setRowMargin(10);
        tbl_Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Products);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 970, 370));

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 290, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sắp xếp theo :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        cbxCategories.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbxCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriesActionPerformed(evt);
            }
        });
        jPanel1.add(cbxCategories, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 260, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Số lượng :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, -1, -1));

        txtProductName.setEditable(false);
        txtProductName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 290, -1));

        txtQuantity.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 550, 170, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên sản phẩm :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, -1, -1));

        btnAddToCart.setBackground(new java.awt.Color(204, 204, 255));
        btnAddToCart.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnAddToCart.setForeground(new java.awt.Color(25, 118, 221));
        btnAddToCart.setText("Thêm vào giỏ hàng");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 530, 260, 60));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Loại :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        cbxSortBy.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbxSortBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSortByActionPerformed(evt);
            }
        });
        jPanel1.add(cbxSortBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 200, -1));

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

    private void tbl_ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ProductsMouseClicked
        int i = tbl_Products.getSelectedRow();
        txtProductName.setText(listProducts.get(i).getName());
        txtQuantity.setText("1");
    }//GEN-LAST:event_tbl_ProductsMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        listProducts = proDAO.searchProducts(txtSearch, categoryIdSelected);
        proDAO.loadProductToTable(tbl_Products, listProducts);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cbxCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriesActionPerformed
        int cbxSelectedIndex = cbxCategories.getSelectedIndex();
        categoryIdSelected = listCategory.get(cbxSelectedIndex).getId();
        listProducts = proDAO.selectProductsByCategoryId(categoryIdSelected);
        //Xu ly cbx SortBy
        if(cbxSortBy.getSelectedIndex() == 0){
            proDAO.sortProductsByPriceAscending(listProducts);
        }else if(cbxSortBy.getSelectedIndex() == 1){
            proDAO.sortProductsByPriceDecrease(listProducts);
        }
        proDAO.loadProductToTable(tbl_Products, listProducts);
    }//GEN-LAST:event_cbxCategoriesActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        boolean a = checkIsEmpty();
        if(a == true){
            // Lay gio hang cua username
            myCart = cartDAO.selectCartByUsername(username);
            if(myCart == null){         // Neu gio hang chua co
                cartDAO.insertCart(username);  // them gio hang
                myCart = cartDAO.selectCartByUsername(username);
            }

            int b = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm sản phẩm này vào giỏ hàng ?", "Notice", JOptionPane.YES_NO_OPTION);

            if(b == 0){
                int cartId = myCart.getId();
                int productId = Integer.parseInt((String)tbl_Products.getValueAt(tbl_Products.getSelectedRow(), 0).toString());
                int quantity = Integer.parseInt(txtQuantity.getText());

                //kiem tra Trong gio hang neu co san pham do roi thi chi them so luong
                CartItemsEntity items = cartItemsDAO.selectCartItem(cartId, productId);

                if(items == null){ // Neu chua co san pham nay trong gio hang
                    //Them san pham vao gio hang
                    cartItemsDAO.insertCartItems(cartId, productId, quantity);
                    JOptionPane.showMessageDialog(this, "Sản phẩm đã được thêm vào giỏ hàng của bạn !", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else        // San pham da ton tai nen tang so luong len va cap nhat
                {
                    int quantityNew = quantity + items.getQuantity();
                    cartItemsDAO.updateQuantityToCartItem(cartId, productId, quantityNew);
                    JOptionPane.showMessageDialog(this, "Sản phẩm đã tồn tại trong giỏ hàng. \nCập nhật số lượng sản phẩm trong giỏ thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void cbxSortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSortByActionPerformed
        int cbxSelectedIndex = cbxSortBy.getSelectedIndex();
        if(cbxSelectedIndex == 0){
            proDAO.sortProductsByPriceAscending(listProducts);
        }else if(cbxSelectedIndex == 1){
            proDAO.sortProductsByPriceDecrease(listProducts);
        }
        proDAO.loadProductToTable(tbl_Products, listProducts);
    }//GEN-LAST:event_cbxSortByActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JComboBox<String> cbxCategories;
    private javax.swing.JComboBox<String> cbxSortBy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Products;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
