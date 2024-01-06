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
import java.awt.Image;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Pham Van Thanh
 */
public class Purchase extends javax.swing.JPanel {

    private int categoryIdSelected = 1;
    private String username = new ToanCuc().getUsername();

    private categoryDao categoryDAO = new categoryDao();
    private productDao proDAO = new productDao();
    private cartDao cartDAO = new cartDao();
    private cartItemsDao cartItemsDAO = new cartItemsDao();

    private ArrayList<CategoryEntity> listCategory = categoryDAO.selectCategories();
    private ArrayList<ProductEntity> listProducts = proDAO.selectProductsByCategoryId(categoryIdSelected);
    private CartEntity myCart = new CartEntity();

    Locale locale = new Locale("vi", "VN");
    NumberFormat format = NumberFormat.getInstance(locale);

    public Purchase() {
        initComponents();
        loadSortByToCbx();
        loadCategoriesToCbx();
        loadData();
    }

    public ImageIcon ResizeImage(String ImagePath, JLabel lbanh) { // chinh kich thuoc anh cho phu hop voi label
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lbanh.getWidth(), lbanh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void loadData() {
        //for (int i = 0; i < 3; i++) {

        ProductEntity p0 = null;
        ProductEntity p1 = null;
        ProductEntity p2 = null;
        ProductEntity p3 = null;
        ProductEntity p4 = null;
        ProductEntity p5 = null;

        if (listProducts.size() >= 6) {

        } else if (listProducts.size() == 6) {
            p0 = listProducts.get(0);
            p1 = listProducts.get(1);
            p2 = listProducts.get(2);
            p3 = listProducts.get(3);
            p4 = listProducts.get(4);
            p5 = listProducts.get(5);
        } else if (listProducts.size() == 5) {
            p0 = listProducts.get(0);
            p1 = listProducts.get(1);
            p2 = listProducts.get(2);
            p3 = listProducts.get(3);
            p4 = listProducts.get(4);
        } else if (listProducts.size() == 4) {
            p0 = listProducts.get(0);
            p1 = listProducts.get(1);
            p2 = listProducts.get(2);
            p3 = listProducts.get(3);
        } else if (listProducts.size() == 3) {
            p0 = listProducts.get(0);
            p1 = listProducts.get(1);
            p2 = listProducts.get(2);
        } else if (listProducts.size() == 2) {
            p0 = listProducts.get(0);
            p1 = listProducts.get(1);
        } else if (listProducts.size() == 1) {
            p0 = listProducts.get(0);
        }

        if (p0 != null) {
            lblAnh0.setSize(170, 170);
            lblAnh0.setIcon(ResizeImage(p0.getImage_url(), lblAnh0));
            if(p0.getImage_url() == null){
                //lblAnh0.setIcon(ResizeImage("C:\\imagesSanPham\\new_product.png", lblAnh0));
                lblAnh0.setIcon(ResizeImage("C:\\imagesSanPham\\new_product.png", lblAnh0));
                
            }
            lblTen0.setText(p0.getName().trim());
            lblGia0.setText(format.format(p0.getPrince()));
            lbl_id0.setText(p0.getId() + "");
        } else {
            lblAnh0.setIcon(new ImageIcon());
            lblTen0.setText("");
            lblGia0.setText("");
            lbl_id0.setText("");
        }
        if (p1 != null) {
            lblAnh1.setSize(170, 170);
            lblAnh1.setIcon(ResizeImage(p1.getImage_url(), lblAnh1));
            if(p1.getImage_url() == null){
                lblAnh1.setIcon(ResizeImage("C:\\imagesSanPham\\new_product.png", lblAnh1));
            }
            lblTen1.setText(p1.getName().trim());
            lblGia1.setText(format.format(p1.getPrince()));
            lbl_id1.setText(p1.getId() + "");
        } else {
            lblAnh1.setIcon(new ImageIcon());
            lblTen1.setText("");
            lblGia1.setText("");
            lbl_id1.setText("");
        }
        if (p2 != null) {
            lblAnh2.setSize(170, 170);
            lblAnh2.setIcon(ResizeImage(p2.getImage_url(), lblAnh2));
            if(p2.getImage_url() == null){
                lblAnh2.setIcon(ResizeImage("C:\\imagesSanPham\\new_product.png", lblAnh2));
            }
            lblTen2.setText(p2.getName().trim());
            lblGia2.setText(format.format(p2.getPrince()));
            lbl_id2.setText(p2.getId() + "");
        } else {
            lblAnh2.setIcon(new ImageIcon());
            lblTen2.setText("");
            lblGia2.setText("");
            lbl_id2.setText("");
        }
        if (p3 != null) {
            lblAnh3.setSize(170, 170);
            lblAnh3.setIcon(ResizeImage(p3.getImage_url(), lblAnh3));
            if(p3.getImage_url() == null){
                lblAnh3.setIcon(ResizeImage("C:\\imagesSanPham\\new_product.png", lblAnh3));
            }
            lblTen3.setText(p3.getName().trim());
            lblGia3.setText(format.format(p3.getPrince()));
            lbl_id3.setText(p3.getId() + "");
        } else {
            lblAnh3.setIcon(new ImageIcon());
            lblTen3.setText("");
            lblGia3.setText("");
            lbl_id3.setText("");
        }
        if (p4 != null) {
            lblAnh4.setSize(170, 170);
            lblAnh4.setIcon(ResizeImage(p4.getImage_url(), lblAnh4));
            if(p4.getImage_url() == null){
                lblAnh4.setIcon(ResizeImage("C:\\imagesSanPham\\new_product.png", lblAnh4));
            }
            lblTen4.setText(p4.getName().trim());
            lblGia4.setText(format.format(p4.getPrince()));
            lbl_id4.setText(p4.getId() + "");
        } else {
            lblAnh4.setIcon(new ImageIcon());
            lblTen4.setText("");
            lblGia4.setText("");
            lbl_id4.setText("");
        }
        if (p5 != null) {
            lblAnh5.setSize(170, 170);
            lblAnh5.setIcon(ResizeImage(p5.getImage_url(), lblAnh5));
            if(p5.getImage_url() == null){
                lblAnh5.setIcon(ResizeImage("C:\\imagesSanPham\\new_product.png", lblAnh5));
            }
            lblTen5.setText(p5.getName().trim());
            lblGia5.setText(format.format(p5.getPrince()));
            lbl_id5.setText(p5.getId() + "");
        } else {
            lblAnh5.setIcon(new ImageIcon());
            lblTen5.setText("");
            lblGia5.setText("");
            lbl_id5.setText("");
        }
    }

    // dua category name vao combobox 
    private void loadCategoriesToCbx() {
        for (int i = 0; i < listCategory.size(); i++) {
            cbxCategories.addItem(listCategory.get(i).getName());
        }
    }

    // Them lua chon cho cbx
    private void loadSortByToCbx() {
        cbxSortBy.addItem("Giá thấp đến cao");
        cbxSortBy.addItem("Giá cao đến thấp");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTen0 = new javax.swing.JLabel();
        lblGia0 = new javax.swing.JLabel();
        lblAnh0 = new javax.swing.JLabel();
        lbl_id0 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblTen1 = new javax.swing.JLabel();
        lblGia1 = new javax.swing.JLabel();
        lblAnh1 = new javax.swing.JLabel();
        lbl_id1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblTen2 = new javax.swing.JLabel();
        lblGia2 = new javax.swing.JLabel();
        lblAnh2 = new javax.swing.JLabel();
        lbl_id2 = new javax.swing.JLabel();
        cbxCategories = new javax.swing.JComboBox<>();
        lblCate = new javax.swing.JLabel();
        cbxSortBy = new javax.swing.JComboBox<>();
        lblSX = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblTen3 = new javax.swing.JLabel();
        lblGia3 = new javax.swing.JLabel();
        lblAnh3 = new javax.swing.JLabel();
        lbl_id3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblTen4 = new javax.swing.JLabel();
        lblGia4 = new javax.swing.JLabel();
        lblAnh4 = new javax.swing.JLabel();
        lbl_id4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblTen5 = new javax.swing.JLabel();
        lblGia5 = new javax.swing.JLabel();
        lblAnh5 = new javax.swing.JLabel();
        lbl_id5 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        lblCate1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        lblTen0.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        lblTen0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblGia0.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblGia0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblAnh0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGia0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAnh0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 130, Short.MAX_VALUE)
                        .addComponent(lbl_id0, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTen0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh0, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTen0, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGia0, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lbl_id0, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 190, 250));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        lblTen1.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        lblTen1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblGia1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblGia1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblAnh1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblGia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGia1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_id1)
                .addGap(12, 12, 12))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 190, 250));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        lblTen2.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        lblTen2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblGia2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblGia2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblAnh2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTen2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblGia2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(153, 153, 153)
                    .addComponent(lbl_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTen2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGia2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(244, Short.MAX_VALUE)
                    .addComponent(lbl_id2)
                    .addContainerGap()))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 190, 250));

        cbxCategories.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbxCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriesActionPerformed(evt);
            }
        });
        jPanel1.add(cbxCategories, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 260, -1));

        lblCate.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        lblCate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCate.setText("Tìm kiếm :");
        jPanel1.add(lblCate, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 90, 50));

        cbxSortBy.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbxSortBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSortByActionPerformed(evt);
            }
        });
        jPanel1.add(cbxSortBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 200, -1));

        lblSX.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        lblSX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSX.setText("Loại :");
        jPanel1.add(lblSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        btnLamMoi.setText("refesh");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel1.add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, 100, 30));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        lblTen3.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        lblTen3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblGia3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblGia3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblAnh3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGia3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTen3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAnh3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 130, Short.MAX_VALUE)
                        .addComponent(lbl_id3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTen3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGia3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_id3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, 250));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        lblTen4.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        lblTen4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblGia4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblGia4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblAnh4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGia4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTen4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAnh4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 130, Short.MAX_VALUE)
                        .addComponent(lbl_id4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTen4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGia4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_id4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 190, 250));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        lblTen5.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        lblTen5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblGia5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblGia5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblAnh5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGia5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTen5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAnh5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 130, Short.MAX_VALUE)
                        .addComponent(lbl_id5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTen5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGia5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_id5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 190, 250));

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 210, -1));

        lblCate1.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        lblCate1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCate1.setText("Sắp xếp :");
        jPanel1.add(lblCate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 70, 50));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel1.setText("Lưu ý : Double click để thêm sản phẩm vào giỏ hàng");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 680, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriesActionPerformed
        int cbxSelectedIndex = cbxCategories.getSelectedIndex();
        categoryIdSelected = listCategory.get(cbxSelectedIndex).getId();
        listProducts = proDAO.selectProductsByCategoryId(categoryIdSelected);
        //Xu ly cbx SortBy
        if (cbxSortBy.getSelectedIndex() == 0) {
            proDAO.sortProductsByPriceAscending(listProducts);
        } else if (cbxSortBy.getSelectedIndex() == 1) {
            proDAO.sortProductsByPriceDecrease(listProducts);
        }
        loadData();
    }//GEN-LAST:event_cbxCategoriesActionPerformed

    private void cbxSortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSortByActionPerformed
        int cbxSelectedIndex = cbxSortBy.getSelectedIndex();
        if (cbxSelectedIndex == 0) {
            proDAO.sortProductsByPriceAscending(listProducts);
        } else if (cbxSelectedIndex == 1) {
            proDAO.sortProductsByPriceDecrease(listProducts);
        }
        loadData();
    }//GEN-LAST:event_cbxSortByActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        jPanel2.setVisible(false);
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
        jPanel3.setVisible(true);
        jPanel4.setVisible(false);
        jPanel4.setVisible(true);
        jPanel5.setVisible(false);
        jPanel5.setVisible(true);
        jPanel6.setVisible(false);
        jPanel6.setVisible(true);
        jPanel7.setVisible(false);
        jPanel7.setVisible(true);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        listProducts = proDAO.searchProducts(txtSearch, categoryIdSelected);
        loadData();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        if(!lbl_id0.getText().trim().equals("")){
        // Lay gio hang cua username
        myCart = cartDAO.selectCartByUsername(username);
        if (myCart == null) {         // Neu gio hang chua co
            cartDAO.insertCart(username);  // them gio hang
            myCart = cartDAO.selectCartByUsername(username);
        }

        int b = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm "+lblTen0.getText().trim()+" vào giỏ hàng ?", "Notice", JOptionPane.YES_NO_OPTION);

        if (b == 0) {
            int cartId = myCart.getId();
            int productId = Integer.parseInt(lbl_id0.getText());
            int quantity = 1;  // mac dinh bang 1

            //kiem tra Trong gio hang neu co san pham do roi thi chi them so luong
            CartItemsEntity items = cartItemsDAO.selectCartItem(cartId, productId);

            if (items == null) { // Neu chua co san pham nay trong gio hang
                //Them san pham vao gio hang
                cartItemsDAO.insertCartItems(cartId, productId, quantity);
                JOptionPane.showMessageDialog(this, "Sản phẩm đã được thêm vào giỏ hàng của bạn !", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else // San pham da ton tai nen tang so luong len va cap nhat
            {
                int quantityNew = quantity + items.getQuantity();
                cartItemsDAO.updateQuantityToCartItem(cartId, productId, quantityNew);
                JOptionPane.showMessageDialog(this, "Tăng số lượng sản phẩm trong giỏ hàng !", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        }
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        if(!lbl_id1.getText().trim().equals("")){
        // Lay gio hang cua username
        myCart = cartDAO.selectCartByUsername(username);
        if (myCart == null) {         // Neu gio hang chua co
            cartDAO.insertCart(username);  // them gio hang
            myCart = cartDAO.selectCartByUsername(username);
        }

        int b = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm "+lblTen1.getText().trim()+" vào giỏ hàng ?", "Notice", JOptionPane.YES_NO_OPTION);

        if (b == 0) {
            int cartId = myCart.getId();
            int productId = Integer.parseInt(lbl_id1.getText());
            int quantity = 1;  // mac dinh bang 1

            //kiem tra Trong gio hang neu co san pham do roi thi chi them so luong
            CartItemsEntity items = cartItemsDAO.selectCartItem(cartId, productId);

            if (items == null) { // Neu chua co san pham nay trong gio hang
                //Them san pham vao gio hang
                cartItemsDAO.insertCartItems(cartId, productId, quantity);
                JOptionPane.showMessageDialog(this, "Sản phẩm đã được thêm vào giỏ hàng của bạn !", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else // San pham da ton tai nen tang so luong len va cap nhat
            {
                int quantityNew = quantity + items.getQuantity();
                cartItemsDAO.updateQuantityToCartItem(cartId, productId, quantityNew);
                JOptionPane.showMessageDialog(this, "Tăng số lượng sản phẩm trong giỏ hàng !", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        }
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        if(!lbl_id2.getText().trim().equals("")){
        // Lay gio hang cua username
        myCart = cartDAO.selectCartByUsername(username);
        if (myCart == null) {         // Neu gio hang chua co
            cartDAO.insertCart(username);  // them gio hang
            myCart = cartDAO.selectCartByUsername(username);
        }

        int b = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm "+lblTen2.getText().trim()+" vào giỏ hàng ?", "Notice", JOptionPane.YES_NO_OPTION);

        if (b == 0) {
            int cartId = myCart.getId();
            int productId = Integer.parseInt(lbl_id2.getText());
            int quantity = 1;  // mac dinh bang 1

            //kiem tra Trong gio hang neu co san pham do roi thi chi them so luong
            CartItemsEntity items = cartItemsDAO.selectCartItem(cartId, productId);

            if (items == null) { // Neu chua co san pham nay trong gio hang
                //Them san pham vao gio hang
                cartItemsDAO.insertCartItems(cartId, productId, quantity);
                JOptionPane.showMessageDialog(this, "Sản phẩm đã được thêm vào giỏ hàng của bạn !", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else // San pham da ton tai nen tang so luong len va cap nhat
            {
                int quantityNew = quantity + items.getQuantity();
                cartItemsDAO.updateQuantityToCartItem(cartId, productId, quantityNew);
                JOptionPane.showMessageDialog(this, "Tăng số lượng sản phẩm trong giỏ hàng !", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        }
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        if(!lbl_id3.getText().trim().equals("")){
        // Lay gio hang cua username
        myCart = cartDAO.selectCartByUsername(username);
        if (myCart == null) {         // Neu gio hang chua co
            cartDAO.insertCart(username);  // them gio hang
            myCart = cartDAO.selectCartByUsername(username);
        }

        int b = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm "+lblTen3.getText().trim()+" vào giỏ hàng ?", "Notice", JOptionPane.YES_NO_OPTION);

        if (b == 0) {
            int cartId = myCart.getId();
            int productId = Integer.parseInt(lbl_id3.getText());
            int quantity = 1;  // mac dinh bang 1

            //kiem tra Trong gio hang neu co san pham do roi thi chi them so luong
            CartItemsEntity items = cartItemsDAO.selectCartItem(cartId, productId);

            if (items == null) { // Neu chua co san pham nay trong gio hang
                //Them san pham vao gio hang
                cartItemsDAO.insertCartItems(cartId, productId, quantity);
                JOptionPane.showMessageDialog(this, "Sản phẩm đã được thêm vào giỏ hàng của bạn !", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else // San pham da ton tai nen tang so luong len va cap nhat
            {
                int quantityNew = quantity + items.getQuantity();
                cartItemsDAO.updateQuantityToCartItem(cartId, productId, quantityNew);
                JOptionPane.showMessageDialog(this, "Tăng số lượng sản phẩm trong giỏ hàng !", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        }
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        if(!lbl_id4.getText().trim().equals("")){
        // Lay gio hang cua username
        myCart = cartDAO.selectCartByUsername(username);
        if (myCart == null) {         // Neu gio hang chua co
            cartDAO.insertCart(username);  // them gio hang
            myCart = cartDAO.selectCartByUsername(username);
        }

        int b = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm "+lblTen4.getText().trim()+" vào giỏ hàng ?", "Notice", JOptionPane.YES_NO_OPTION);

        if (b == 0) {
            int cartId = myCart.getId();
            int productId = Integer.parseInt(lbl_id4.getText());
            int quantity = 1;  // mac dinh bang 1

            //kiem tra Trong gio hang neu co san pham do roi thi chi them so luong
            CartItemsEntity items = cartItemsDAO.selectCartItem(cartId, productId);

            if (items == null) { // Neu chua co san pham nay trong gio hang
                //Them san pham vao gio hang
                cartItemsDAO.insertCartItems(cartId, productId, quantity);
                JOptionPane.showMessageDialog(this, "Sản phẩm đã được thêm vào giỏ hàng của bạn !", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else // San pham da ton tai nen tang so luong len va cap nhat
            {
                int quantityNew = quantity + items.getQuantity();
                cartItemsDAO.updateQuantityToCartItem(cartId, productId, quantityNew);
                JOptionPane.showMessageDialog(this, "Tăng số lượng sản phẩm trong giỏ hàng !", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        }
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        if(!lbl_id5.getText().trim().equals("")){
        // Lay gio hang cua username
        myCart = cartDAO.selectCartByUsername(username);
        if (myCart == null) {         // Neu gio hang chua co
            cartDAO.insertCart(username);  // them gio hang
            myCart = cartDAO.selectCartByUsername(username);
        }

        int b = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm "+lblTen5.getText().trim()+" vào giỏ hàng ?", "Notice", JOptionPane.YES_NO_OPTION);

        if (b == 0) {
            int cartId = myCart.getId();
            int productId = Integer.parseInt(lbl_id5.getText());
            int quantity = 1;  // mac dinh bang 1

            //kiem tra Trong gio hang neu co san pham do roi thi chi them so luong
            CartItemsEntity items = cartItemsDAO.selectCartItem(cartId, productId);

            if (items == null) { // Neu chua co san pham nay trong gio hang
                //Them san pham vao gio hang
                cartItemsDAO.insertCartItems(cartId, productId, quantity);
                JOptionPane.showMessageDialog(this, "Sản phẩm đã được thêm vào giỏ hàng của bạn !", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else // San pham da ton tai nen tang so luong len va cap nhat
            {
                int quantityNew = quantity + items.getQuantity();
                cartItemsDAO.updateQuantityToCartItem(cartId, productId, quantityNew);
                JOptionPane.showMessageDialog(this, "Tăng số lượng sản phẩm trong giỏ hàng !", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        }
    }//GEN-LAST:event_jPanel7MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JComboBox<String> cbxCategories;
    private javax.swing.JComboBox<String> cbxSortBy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblAnh0;
    private javax.swing.JLabel lblAnh1;
    private javax.swing.JLabel lblAnh2;
    private javax.swing.JLabel lblAnh3;
    private javax.swing.JLabel lblAnh4;
    private javax.swing.JLabel lblAnh5;
    private javax.swing.JLabel lblCate;
    private javax.swing.JLabel lblCate1;
    private javax.swing.JLabel lblGia0;
    private javax.swing.JLabel lblGia1;
    private javax.swing.JLabel lblGia2;
    private javax.swing.JLabel lblGia3;
    private javax.swing.JLabel lblGia4;
    private javax.swing.JLabel lblGia5;
    private javax.swing.JLabel lblSX;
    private javax.swing.JLabel lblTen0;
    private javax.swing.JLabel lblTen1;
    private javax.swing.JLabel lblTen2;
    private javax.swing.JLabel lblTen3;
    private javax.swing.JLabel lblTen4;
    private javax.swing.JLabel lblTen5;
    private javax.swing.JLabel lbl_id0;
    private javax.swing.JLabel lbl_id1;
    private javax.swing.JLabel lbl_id2;
    private javax.swing.JLabel lbl_id3;
    private javax.swing.JLabel lbl_id4;
    private javax.swing.JLabel lbl_id5;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
