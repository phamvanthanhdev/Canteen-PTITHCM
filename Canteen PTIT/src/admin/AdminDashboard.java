/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import common.Login;
import common.ToanCuc;
import dao.NhanVienDao;
import dao.ThongKeDao;
import dao.userDao;
import staff.Tables;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Pham Van Thanh
 */
public class AdminDashboard extends javax.swing.JFrame {    
    
    Color selectionColor = new Color(34, 48, 62);
    Color sideColor = new Color(64, 194, 150);
    Color textSelectionColor = new Color(255, 255, 255);
    
    Color defaultSelectionColor = new Color(42,58,73);
    Color defaultTextColor = new Color(102,120,138);
    Color defaultSideColor = new Color(42,58,73);
    
    
    private String username = new ToanCuc().getUsername();
    private String fullName = new NhanVienDao().selectNhanVienByUsername(username).getFullname();
    private ThongKeDao thongKeDAO = new ThongKeDao();
    
    public AdminDashboard() {
        initComponents();
        lblHoTen.setText(fullName);
        init();
    }
    
    private void init(){
        lblTongLoai.setText(thongKeDAO.selectTotalCategory()+"");
        lblTongSP.setText(thongKeDAO.selectTotalProducts()+"");
        lblTongNV.setText(thongKeDAO.selectTotalStaff()+"");
        lblTongKH.setText(thongKeDAO.selectTotalUser()+"");
        lblTongBan.setText(thongKeDAO.selectTotalTable()+"");
    }

    private void PanelQuanLyBanSelectionColor(){
        pnQuanLyBan.setBackground(selectionColor);
        jPanel7.setBackground(sideColor);
        jLabel20.setForeground(textSelectionColor);
        
        pn_QuanLyLoai.setBackground(defaultSelectionColor);
        jPanel18.setBackground(defaultSideColor);
        jLabel32.setForeground(defaultTextColor);
        
        pn_Products.setBackground(defaultSelectionColor);
        jPanel14.setBackground(defaultSideColor);
        jLabel24.setForeground(defaultTextColor);
        
        pnQuanLyNhanVien.setBackground(defaultSelectionColor);
        jPanel16.setBackground(defaultSideColor);
        jLabel28.setForeground(defaultTextColor);
        
        pn_DoanhThu.setBackground(defaultSelectionColor);
        jPanel15.setBackground(defaultSideColor);
        jLabel26.setForeground(defaultTextColor);
        
        pn_QuanLyKhachHang.setBackground(defaultSelectionColor);
        jPanel19.setBackground(defaultSideColor);
        jLabel34.setForeground(defaultTextColor);
        
        pn_TaiKhoan.setBackground(defaultSelectionColor);
        jPanel17.setBackground(defaultSideColor);
        jLabel30.setForeground(defaultTextColor);
    }
    
    private void PanelQuanLyLoaiSelectionColor(){
        pnQuanLyBan.setBackground(defaultSelectionColor);
        jPanel7.setBackground(defaultSideColor);
        jLabel20.setForeground(defaultTextColor);
        
        pn_QuanLyLoai.setBackground(selectionColor);
        jPanel18.setBackground(sideColor);
        jLabel32.setForeground(textSelectionColor);
        
        pn_Products.setBackground(defaultSelectionColor);
        jPanel14.setBackground(defaultSideColor);
        jLabel24.setForeground(defaultTextColor);
        
        pnQuanLyNhanVien.setBackground(defaultSelectionColor);
        jPanel16.setBackground(defaultSideColor);
        jLabel28.setForeground(defaultTextColor);
        
        pn_DoanhThu.setBackground(defaultSelectionColor);
        jPanel15.setBackground(defaultSideColor);
        jLabel26.setForeground(defaultTextColor);
        
        pn_QuanLyKhachHang.setBackground(defaultSelectionColor);
        jPanel19.setBackground(defaultSideColor);
        jLabel34.setForeground(defaultTextColor);
        
        pn_TaiKhoan.setBackground(defaultSelectionColor);
        jPanel17.setBackground(defaultSideColor);
        jLabel30.setForeground(defaultTextColor);
    }
    
    private void PanelQuanLySPSelectionColor(){
        pnQuanLyBan.setBackground(defaultSelectionColor);
        jPanel7.setBackground(defaultSideColor);
        jLabel20.setForeground(defaultTextColor);
        
        pn_QuanLyLoai.setBackground(defaultSelectionColor);
        jPanel18.setBackground(defaultSideColor);
        jLabel32.setForeground(defaultTextColor);
        
        pn_Products.setBackground(selectionColor);
        jPanel14.setBackground(sideColor);
        jLabel24.setForeground(textSelectionColor);
        
        pnQuanLyNhanVien.setBackground(defaultSelectionColor);
        jPanel16.setBackground(defaultSideColor);
        jLabel28.setForeground(defaultTextColor);
        
        pn_DoanhThu.setBackground(defaultSelectionColor);
        jPanel15.setBackground(defaultSideColor);
        jLabel26.setForeground(defaultTextColor);
        
        pn_QuanLyKhachHang.setBackground(defaultSelectionColor);
        jPanel19.setBackground(defaultSideColor);
        jLabel34.setForeground(defaultTextColor);
        
        pn_TaiKhoan.setBackground(defaultSelectionColor);
        jPanel17.setBackground(defaultSideColor);
        jLabel30.setForeground(defaultTextColor);
    }
    
    private void PanelNhanVienSelectionColor(){
        pnQuanLyBan.setBackground(defaultSelectionColor);
        jPanel7.setBackground(defaultSideColor);
        jLabel20.setForeground(defaultTextColor);
        
        pn_QuanLyLoai.setBackground(defaultSelectionColor);
        jPanel18.setBackground(defaultSideColor);
        jLabel32.setForeground(defaultTextColor);
        
        pn_Products.setBackground(defaultSelectionColor);
        jPanel14.setBackground(defaultSideColor);
        jLabel24.setForeground(defaultTextColor);
        
        pnQuanLyNhanVien.setBackground(selectionColor);
        jPanel16.setBackground(sideColor);
        jLabel28.setForeground(textSelectionColor);
        
        pn_DoanhThu.setBackground(defaultSelectionColor);
        jPanel15.setBackground(defaultSideColor);
        jLabel26.setForeground(defaultTextColor);
        
        pn_QuanLyKhachHang.setBackground(defaultSelectionColor);
        jPanel19.setBackground(defaultSideColor);
        jLabel34.setForeground(defaultTextColor);
        
        pn_TaiKhoan.setBackground(defaultSelectionColor);
        jPanel17.setBackground(defaultSideColor);
        jLabel30.setForeground(defaultTextColor);
    }
    
    private void PanelDoanhThuSelectionColor(){
        pnQuanLyBan.setBackground(defaultSelectionColor);
        jPanel7.setBackground(defaultSideColor);
        jLabel20.setForeground(defaultTextColor);
        
        pn_QuanLyLoai.setBackground(defaultSelectionColor);
        jPanel18.setBackground(defaultSideColor);
        jLabel32.setForeground(defaultTextColor);
        
        pn_Products.setBackground(defaultSelectionColor);
        jPanel14.setBackground(defaultSideColor);
        jLabel24.setForeground(defaultTextColor);
        
        pnQuanLyNhanVien.setBackground(defaultSelectionColor);
        jPanel16.setBackground(defaultSideColor);
        jLabel28.setForeground(defaultTextColor);
        
        pn_DoanhThu.setBackground(selectionColor);
        jPanel15.setBackground(sideColor);
        jLabel26.setForeground(textSelectionColor);
        
        pn_QuanLyKhachHang.setBackground(defaultSelectionColor);
        jPanel19.setBackground(defaultSideColor);
        jLabel34.setForeground(defaultTextColor);
        
        pn_TaiKhoan.setBackground(defaultSelectionColor);
        jPanel17.setBackground(defaultSideColor);
        jLabel30.setForeground(defaultTextColor);
    }
    
    private void PanelKhachHangSelectionColor(){
        pnQuanLyBan.setBackground(defaultSelectionColor);
        jPanel7.setBackground(defaultSideColor);
        jLabel20.setForeground(defaultTextColor);
        
        pn_QuanLyLoai.setBackground(defaultSelectionColor);
        jPanel18.setBackground(defaultSideColor);
        jLabel32.setForeground(defaultTextColor);
        
        pn_Products.setBackground(defaultSelectionColor);
        jPanel14.setBackground(defaultSideColor);
        jLabel24.setForeground(defaultTextColor);
        
        pnQuanLyNhanVien.setBackground(defaultSelectionColor);
        jPanel16.setBackground(defaultSideColor);
        jLabel28.setForeground(defaultTextColor);
        
        pn_DoanhThu.setBackground(defaultSelectionColor);
        jPanel15.setBackground(defaultSideColor);
        jLabel26.setForeground(defaultTextColor);
        
        pn_QuanLyKhachHang.setBackground(selectionColor);
        jPanel19.setBackground(sideColor);
        jLabel34.setForeground(textSelectionColor);
        
        pn_TaiKhoan.setBackground(defaultSelectionColor);
        jPanel17.setBackground(defaultSideColor);
        jLabel30.setForeground(defaultTextColor);
    }
    
    private void PanelTaiKhoanSelectionColor(){
        pnQuanLyBan.setBackground(defaultSelectionColor);
        jPanel7.setBackground(defaultSideColor);
        jLabel20.setForeground(defaultTextColor);
        
        pn_QuanLyLoai.setBackground(defaultSelectionColor);
        jPanel18.setBackground(defaultSideColor);
        jLabel32.setForeground(defaultTextColor);
        
        pn_Products.setBackground(defaultSelectionColor);
        jPanel14.setBackground(defaultSideColor);
        jLabel24.setForeground(defaultTextColor);
        
        pnQuanLyNhanVien.setBackground(defaultSelectionColor);
        jPanel16.setBackground(defaultSideColor);
        jLabel28.setForeground(defaultTextColor);
        
        pn_DoanhThu.setBackground(defaultSelectionColor);
        jPanel15.setBackground(defaultSideColor);
        jLabel26.setForeground(defaultTextColor);
        
        pn_QuanLyKhachHang.setBackground(defaultSelectionColor);
        jPanel19.setBackground(defaultSideColor);
        jLabel34.setForeground(defaultTextColor);
        
        pn_TaiKhoan.setBackground(selectionColor);
        jPanel17.setBackground(sideColor);
        jLabel30.setForeground(textSelectionColor);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_logout = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnQuanLyBan = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pn_Products = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pn_DoanhThu = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        pnQuanLyNhanVien = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        pn_TaiKhoan = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        pn_QuanLyLoai = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        pn_QuanLyKhachHang = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        pn_Main = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTongLoai = new javax.swing.JLabel();
        lblTongSP = new javax.swing.JLabel();
        lblTongKH = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblTongBan = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblTongNV = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(64, 194, 150));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shopping.png"))); // NOI18N
        jLabel1.setText("CANTEEN PTITHCM");

        lbl_logout.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logout.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        lbl_logout.setText("Logout");
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
        });

        lblHoTen.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(255, 255, 255));
        lblHoTen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        lblHoTen.setText("myemail@gmail.com");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 615, Short.MAX_VALUE)
                .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lbl_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(lbl_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoTen))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 60));

        jPanel3.setBackground(new java.awt.Color(42, 58, 73));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 51, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashboard.png"))); // NOI18N
        jLabel2.setText("DASHBOARD");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 250, 50));

        pnQuanLyBan.setBackground(new java.awt.Color(42, 58, 73));
        pnQuanLyBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnQuanLyBanMouseClicked(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(42, 58, 73));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/purchase_dark.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 120, 138));
        jLabel20.setText("Quản lý bàn");

        javax.swing.GroupLayout pnQuanLyBanLayout = new javax.swing.GroupLayout(pnQuanLyBan);
        pnQuanLyBan.setLayout(pnQuanLyBanLayout);
        pnQuanLyBanLayout.setHorizontalGroup(
            pnQuanLyBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuanLyBanLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnQuanLyBanLayout.setVerticalGroup(
            pnQuanLyBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(pnQuanLyBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        pn_Products.setBackground(new java.awt.Color(42, 58, 73));
        pn_Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_ProductsMouseClicked(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(42, 58, 73));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/purchase_dark.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 120, 138));
        jLabel24.setText("Quản lý sản phẩm");

        javax.swing.GroupLayout pn_ProductsLayout = new javax.swing.GroupLayout(pn_Products);
        pn_Products.setLayout(pn_ProductsLayout);
        pn_ProductsLayout.setHorizontalGroup(
            pn_ProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ProductsLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_ProductsLayout.setVerticalGroup(
            pn_ProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(pn_Products, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, -1));

        pn_DoanhThu.setBackground(new java.awt.Color(42, 58, 73));
        pn_DoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_DoanhThuMouseClicked(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(42, 58, 73));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/purchase_dark.png"))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 120, 138));
        jLabel26.setText("Doanh thu");

        javax.swing.GroupLayout pn_DoanhThuLayout = new javax.swing.GroupLayout(pn_DoanhThu);
        pn_DoanhThu.setLayout(pn_DoanhThuLayout);
        pn_DoanhThuLayout.setHorizontalGroup(
            pn_DoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_DoanhThuLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_DoanhThuLayout.setVerticalGroup(
            pn_DoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(pn_DoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, -1));

        pnQuanLyNhanVien.setBackground(new java.awt.Color(42, 58, 73));
        pnQuanLyNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnQuanLyNhanVienMouseClicked(evt);
            }
        });

        jPanel16.setBackground(new java.awt.Color(42, 58, 73));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/purchase_dark.png"))); // NOI18N

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 120, 138));
        jLabel28.setText("Quản lý nhân viên");

        javax.swing.GroupLayout pnQuanLyNhanVienLayout = new javax.swing.GroupLayout(pnQuanLyNhanVien);
        pnQuanLyNhanVien.setLayout(pnQuanLyNhanVienLayout);
        pnQuanLyNhanVienLayout.setHorizontalGroup(
            pnQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuanLyNhanVienLayout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnQuanLyNhanVienLayout.setVerticalGroup(
            pnQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(pnQuanLyNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, -1, -1));

        pn_TaiKhoan.setBackground(new java.awt.Color(42, 58, 73));
        pn_TaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_TaiKhoanMouseClicked(evt);
            }
        });

        jPanel17.setBackground(new java.awt.Color(42, 58, 73));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/purchase_dark.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 120, 138));
        jLabel30.setText("Tài khoản");

        javax.swing.GroupLayout pn_TaiKhoanLayout = new javax.swing.GroupLayout(pn_TaiKhoan);
        pn_TaiKhoan.setLayout(pn_TaiKhoanLayout);
        pn_TaiKhoanLayout.setHorizontalGroup(
            pn_TaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TaiKhoanLayout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_TaiKhoanLayout.setVerticalGroup(
            pn_TaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(pn_TaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, -1, -1));

        pn_QuanLyLoai.setBackground(new java.awt.Color(42, 58, 73));
        pn_QuanLyLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_QuanLyLoaiMouseClicked(evt);
            }
        });

        jPanel18.setBackground(new java.awt.Color(42, 58, 73));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/purchase_dark.png"))); // NOI18N

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 120, 138));
        jLabel32.setText("Quản lý loại");

        javax.swing.GroupLayout pn_QuanLyLoaiLayout = new javax.swing.GroupLayout(pn_QuanLyLoai);
        pn_QuanLyLoai.setLayout(pn_QuanLyLoaiLayout);
        pn_QuanLyLoaiLayout.setHorizontalGroup(
            pn_QuanLyLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QuanLyLoaiLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_QuanLyLoaiLayout.setVerticalGroup(
            pn_QuanLyLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(pn_QuanLyLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        pn_QuanLyKhachHang.setBackground(new java.awt.Color(42, 58, 73));
        pn_QuanLyKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_QuanLyKhachHangMouseClicked(evt);
            }
        });

        jPanel19.setBackground(new java.awt.Color(42, 58, 73));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/purchase_dark.png"))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 120, 138));
        jLabel34.setText("Quản lý khách hàng");

        javax.swing.GroupLayout pn_QuanLyKhachHangLayout = new javax.swing.GroupLayout(pn_QuanLyKhachHang);
        pn_QuanLyKhachHang.setLayout(pn_QuanLyKhachHangLayout);
        pn_QuanLyKhachHangLayout.setHorizontalGroup(
            pn_QuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QuanLyKhachHangLayout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addContainerGap())
        );
        pn_QuanLyKhachHangLayout.setVerticalGroup(
            pn_QuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(pn_QuanLyKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 250, 720));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Thống kê ");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Tổng số loại sản phẩm :");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Tổng số sản phẩm :");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("Tổng số nhân viên :");

        lblTongLoai.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTongLoai.setText("0");

        lblTongSP.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTongSP.setText("0");

        lblTongKH.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTongKH.setText("0");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setText("Tổng số bàn :");

        lblTongBan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTongBan.setText("0");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setText("Tổng số khách hàng :");

        lblTongNV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTongNV.setText("0");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 55)); // NOI18N
        jLabel5.setText("ADMIN");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 55)); // NOI18N
        jLabel6.setText("HOME");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(lblTongLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(73, 73, 73)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(lblTongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTongKH, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTongNV, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 220, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel5)
                .addGap(93, 93, 93)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblTongLoai)
                    .addComponent(jLabel13)
                    .addComponent(lblTongNV))
                .addGap(46, 46, 46)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblTongSP)
                    .addComponent(jLabel21)
                    .addComponent(lblTongKH))
                .addGap(44, 44, 44)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblTongBan))
                .addGap(226, 226, 226))
        );

        javax.swing.GroupLayout pn_MainLayout = new javax.swing.GroupLayout(pn_Main);
        pn_Main.setLayout(pn_MainLayout);
        pn_MainLayout.setHorizontalGroup(
            pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_MainLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        pn_MainLayout.setVerticalGroup(
            pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        jPanel1.add(pn_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 1090, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        int a = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất tài khoản ?", "Logout", JOptionPane.YES_NO_OPTION);
        if(a == 0){
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void pnQuanLyBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnQuanLyBanMouseClicked
        PanelQuanLyBanSelectionColor();
        
        pn_Main.removeAll();
        pn_Main.setLayout(new BorderLayout());
        pn_Main.add(new QuanLyBan());
        pn_Main.validate();
        pn_Main.repaint();
    }//GEN-LAST:event_pnQuanLyBanMouseClicked

    private void pn_ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ProductsMouseClicked
        PanelQuanLySPSelectionColor();
        
        pn_Main.removeAll();
        pn_Main.setLayout(new BorderLayout());
        //pn_Main.add(new Products());
        pn_Main.add(new QuanLySanPham());
        pn_Main.validate();
        pn_Main.repaint();
    }//GEN-LAST:event_pn_ProductsMouseClicked

    private void pn_DoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_DoanhThuMouseClicked
        PanelDoanhThuSelectionColor();
        
        pn_Main.removeAll();
        pn_Main.setLayout(new BorderLayout());
        pn_Main.add(new ThongKe());
        pn_Main.validate();
        pn_Main.repaint();
    }//GEN-LAST:event_pn_DoanhThuMouseClicked

    private void pnQuanLyNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnQuanLyNhanVienMouseClicked
        PanelNhanVienSelectionColor();
        
        pn_Main.removeAll();
        pn_Main.setLayout(new BorderLayout());
        pn_Main.add(new NhanVien());
        pn_Main.validate();
        pn_Main.repaint();
    }//GEN-LAST:event_pnQuanLyNhanVienMouseClicked

    private void pn_TaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_TaiKhoanMouseClicked
        PanelTaiKhoanSelectionColor();
        
        pn_Main.removeAll();
        pn_Main.setLayout(new BorderLayout());
        pn_Main.add(new MyAccount());
        pn_Main.validate();
        pn_Main.repaint();
    }//GEN-LAST:event_pn_TaiKhoanMouseClicked

    private void pn_QuanLyLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_QuanLyLoaiMouseClicked
        PanelQuanLyLoaiSelectionColor();
        
        pn_Main.removeAll();
        pn_Main.setLayout(new BorderLayout());
        pn_Main.add(new QuanLyLoai());
        pn_Main.validate();
        pn_Main.repaint();
    }//GEN-LAST:event_pn_QuanLyLoaiMouseClicked

    private void pn_QuanLyKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_QuanLyKhachHangMouseClicked
        PanelKhachHangSelectionColor();
        
        pn_Main.removeAll();
        pn_Main.setLayout(new BorderLayout());
        pn_Main.add(new QuanLyKhachhang());
        pn_Main.validate();
        pn_Main.repaint();
    }//GEN-LAST:event_pn_QuanLyKhachHangMouseClicked

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblTongBan;
    private javax.swing.JLabel lblTongKH;
    private javax.swing.JLabel lblTongLoai;
    private javax.swing.JLabel lblTongNV;
    private javax.swing.JLabel lblTongSP;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JPanel pnQuanLyBan;
    private javax.swing.JPanel pnQuanLyNhanVien;
    private javax.swing.JPanel pn_DoanhThu;
    private javax.swing.JPanel pn_Main;
    private javax.swing.JPanel pn_Products;
    private javax.swing.JPanel pn_QuanLyKhachHang;
    private javax.swing.JPanel pn_QuanLyLoai;
    private javax.swing.JPanel pn_TaiKhoan;
    // End of variables declaration//GEN-END:variables
}
