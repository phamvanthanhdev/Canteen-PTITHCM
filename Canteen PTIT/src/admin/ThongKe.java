/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package admin;

import common.ToanCuc;
import dao.ThongKeDao;
import dao.userDao;
import entity.OrderEntity;
import entity.ProductEntity;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pham Van Thanh
 */
public class ThongKe extends javax.swing.JPanel {

    private ThongKeDao thongKeDAO = new ThongKeDao();
    private userDao userDAO = new userDao();

    private ArrayList<OrderEntity> listAllOrder = new ArrayList<>();
    private ArrayList<OrderEntity> listOrdersTaiQuan = new ArrayList<>();
    private ArrayList<OrderEntity> listOrderMangVe = new ArrayList<>();
    private ArrayList<OrderEntity> listOrdersOnline = new ArrayList<>();
    ArrayList<String> payments = new ArrayList<>();
    ArrayList<String> types = new ArrayList<>();
    
    private int activity = 1; // 1 la toan bo don hang, 2 : don tai quan, 3: don mang di 4: don Online

    Locale locale = new Locale("vi", "VN");
    NumberFormat format = NumberFormat.getInstance(locale);
    
    public ThongKe() {
        initComponents();
        init();
    }

    private void loadOrderToTable(ArrayList<OrderEntity> orders) {
        DefaultTableModel model = (DefaultTableModel) tblOrders.getModel();
        model.setRowCount(0);
        for (OrderEntity o : orders) {
            String fullName = userDAO.selectFullNameUser(o.getUsername());
            String payment = payments.get(o.getPayments());
            String type = types.get(o.getType());
            model.addRow(new Object[]{o.getId(), fullName, o.getOrder_date(), payment, o.getTotalPrice(), type});
        }
    }
    
    private void addDataToArrayList(){
        payments.add("Thanh toán khi nhận hàng");
        payments.add("Chuyển khoản ngân hàng");
        payments.add("Thẻ Tín dụng/Ghi nợ");
        payments.add("Thẻ nội địa NAPAS");
        
        types.add("Tại quán");
        types.add("Mang về");
        types.add("Online");
    }
    
    // Tinh toan cac don hang de ghi len cac label
    private void loadAllLabel(){
        //tat ca don
        lblTongDon.setText(listAllOrder.size() + "");
        float totalOrderPrice = 0;
        for (OrderEntity o : listAllOrder) {
            totalOrderPrice += o.getTotalPrice();
        }
        lblTongDoanhThu.setText(format.format(totalOrderPrice));
        
        //Don tai quan
        lblDonTaiQuan.setText(listOrdersTaiQuan.size() + "");
        float totalOrderPriceTaiQuan = 0;
        for (OrderEntity o : listOrdersTaiQuan) {
            totalOrderPriceTaiQuan += o.getTotalPrice();
        }
        lblDoanhThuTaiQuan.setText(format.format(totalOrderPriceTaiQuan));
        
        //Don mang ve
        lblDonMangVe.setText(listOrderMangVe.size() + "");
        float totalOrderPriceMangVe = 0;
        for (OrderEntity o : listOrderMangVe) {
            totalOrderPriceMangVe += o.getTotalPrice();
        }
        lblDoanhThuMangVe.setText(format.format(totalOrderPriceMangVe));
        
        //Don online
        lblDonOnline.setText(listOrdersOnline.size() + "");
        float totalOrderPriceOnline = 0;
        for (OrderEntity o : listOrdersOnline) {
            totalOrderPriceOnline += o.getTotalPrice();
        }
        lblDoanhThuOnline.setText(format.format(totalOrderPriceOnline));
    }

    private void init() {
        addDataToArrayList();
        
        long millis = System.currentTimeMillis();
        Date currentDate = new Date(millis);
        txtDate1.setDate(currentDate);
        txtDate2.setDate(currentDate);
        
        java.util.Date utilDate1 = txtDate1.getDate();
        java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
        
        java.util.Date utilDate2 = txtDate2.getDate();
        java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
        
        listAllOrder = thongKeDAO.selectAllOrdersByDate(sqlDate1, sqlDate2);
        
        listOrdersTaiQuan = thongKeDAO.selectOrdersInTable(sqlDate1, sqlDate2);
        listOrderMangVe = thongKeDAO.selectOrdersMangVe(sqlDate1, sqlDate2);
        listOrdersOnline = thongKeDAO.selectOrdersOnline(sqlDate1, sqlDate2);
        
        loadOrderToTable(listAllOrder);
        loadAllLabel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnTongDon = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTongDon = new javax.swing.JLabel();
        lblTongDoanhThu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDate1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtDate2 = new com.toedter.calendar.JDateChooser();
        pnTaiQuan = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblDonTaiQuan = new javax.swing.JLabel();
        lblDoanhThuTaiQuan = new javax.swing.JLabel();
        pnMangVe = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblDonMangVe = new javax.swing.JLabel();
        lblDoanhThuMangVe = new javax.swing.JLabel();
        pnOnline = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblDonOnline = new javax.swing.JLabel();
        lblDoanhThuOnline = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnTongDon.setBackground(new java.awt.Color(204, 255, 255));
        pnTongDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnTongDonMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tổng đơn hàng");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tổng danh thu");

        lblTongDon.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        lblTongDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongDon.setText("000");

        lblTongDoanhThu.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        lblTongDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongDoanhThu.setText("000.000");

        javax.swing.GroupLayout pnTongDonLayout = new javax.swing.GroupLayout(pnTongDon);
        pnTongDon.setLayout(pnTongDonLayout);
        pnTongDonLayout.setHorizontalGroup(
            pnTongDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnTongDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTongDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addGroup(pnTongDonLayout.createSequentialGroup()
                        .addGroup(pnTongDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTongDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTongDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnTongDonLayout.setVerticalGroup(
            pnTongDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTongDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblTongDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTongDoanhThu)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel1.add(pnTongDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Ngày bắt đầu :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 13, 120, 40));
        jPanel1.add(txtDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 160, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Ngày kết thúc :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 120, 30));
        jPanel1.add(txtDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 170, -1));

        pnTaiQuan.setBackground(new java.awt.Color(255, 204, 204));
        pnTaiQuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnTaiQuanMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ðơn hàng tại quán");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Doanh thu");

        lblDonTaiQuan.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        lblDonTaiQuan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDonTaiQuan.setText("000");

        lblDoanhThuTaiQuan.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        lblDoanhThuTaiQuan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThuTaiQuan.setText("000.00");

        javax.swing.GroupLayout pnTaiQuanLayout = new javax.swing.GroupLayout(pnTaiQuan);
        pnTaiQuan.setLayout(pnTaiQuanLayout);
        pnTaiQuanLayout.setHorizontalGroup(
            pnTaiQuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnTaiQuanLayout.createSequentialGroup()
                .addGroup(pnTaiQuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTaiQuanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                    .addGroup(pnTaiQuanLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblDonTaiQuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnTaiQuanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDoanhThuTaiQuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnTaiQuanLayout.setVerticalGroup(
            pnTaiQuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTaiQuanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDonTaiQuan)
                .addGap(10, 10, 10)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDoanhThuTaiQuan)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel1.add(pnTaiQuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 190, 197));

        pnMangVe.setBackground(new java.awt.Color(255, 255, 204));
        pnMangVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnMangVeMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ðơn hàng mang về");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Doanh thu");

        lblDonMangVe.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        lblDonMangVe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDonMangVe.setText("000");

        lblDoanhThuMangVe.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        lblDoanhThuMangVe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThuMangVe.setText("000.00");

        javax.swing.GroupLayout pnMangVeLayout = new javax.swing.GroupLayout(pnMangVe);
        pnMangVe.setLayout(pnMangVeLayout);
        pnMangVeLayout.setHorizontalGroup(
            pnMangVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addGroup(pnMangVeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnMangVeLayout.createSequentialGroup()
                .addGroup(pnMangVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMangVeLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblDonMangVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnMangVeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDoanhThuMangVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnMangVeLayout.setVerticalGroup(
            pnMangVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMangVeLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDonMangVe)
                .addGap(7, 7, 7)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDoanhThuMangVe)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        jPanel1.add(pnMangVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 210, 197));

        pnOnline.setBackground(new java.awt.Color(204, 255, 204));
        pnOnline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnOnlineMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ðơn hàng online");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Doanh thu");

        lblDonOnline.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        lblDonOnline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDonOnline.setText("00");

        lblDoanhThuOnline.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        lblDoanhThuOnline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThuOnline.setText("000.00");

        javax.swing.GroupLayout pnOnlineLayout = new javax.swing.GroupLayout(pnOnline);
        pnOnline.setLayout(pnOnlineLayout);
        pnOnlineLayout.setHorizontalGroup(
            pnOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnOnlineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(lblDonOnline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDoanhThuOnline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnOnlineLayout.setVerticalGroup(
            pnOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOnlineLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lblDonOnline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDoanhThuOnline)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        jPanel1.add(pnOnline, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, 190, 200));

        tblOrders.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã đơn hàng", "Tên khách hàng", "Ngày lập", "Hình thức thanh toán", "Tổng tiền", "Loại đơn hàng"
            }
        ));
        tblOrders.setRowHeight(35);
        tblOrders.setRowMargin(5);
        tblOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrders);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1008, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 1040, 350));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Xem thống kê");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, -1, -1));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        java.util.Date utilDate1 = txtDate1.getDate();
        java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
        
        java.util.Date utilDate2 = txtDate2.getDate();
        java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
        
        if (sqlDate1.compareTo(sqlDate2) > 0) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc thống kê phải lớn hơn ngày bắt đầu !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        listAllOrder = thongKeDAO.selectAllOrdersByDate(sqlDate1, sqlDate2);
        listOrdersTaiQuan = thongKeDAO.selectOrdersInTable(sqlDate1, sqlDate2);
        listOrderMangVe = thongKeDAO.selectOrdersMangVe(sqlDate1, sqlDate2);
        listOrdersOnline = thongKeDAO.selectOrdersOnline(sqlDate1, sqlDate2);
        
        loadOrderToTable(listAllOrder);
        
        loadAllLabel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pnTongDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTongDonMouseClicked
        loadOrderToTable(listAllOrder);
        activity = 1;
    }//GEN-LAST:event_pnTongDonMouseClicked

    private void pnTaiQuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTaiQuanMouseClicked
        loadOrderToTable(listOrdersTaiQuan);
        activity = 2;
    }//GEN-LAST:event_pnTaiQuanMouseClicked

    private void pnMangVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMangVeMouseClicked
        loadOrderToTable(listOrderMangVe);
        activity = 3;
    }//GEN-LAST:event_pnMangVeMouseClicked

    private void pnOnlineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnOnlineMouseClicked
        loadOrderToTable(listOrdersOnline);
        activity = 4;
    }//GEN-LAST:event_pnOnlineMouseClicked

    private void tblOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdersMouseClicked
        ToanCuc t = new ToanCuc();
        if(activity == 1) t.setOrder_id(listAllOrder.get(tblOrders.getSelectedRow()).getId());
        if(activity == 2) t.setOrder_id(listOrdersTaiQuan.get(tblOrders.getSelectedRow()).getId());
        if(activity == 3) t.setOrder_id(listOrderMangVe.get(tblOrders.getSelectedRow()).getId());
        if(activity == 4) t.setOrder_id(listOrdersOnline.get(tblOrders.getSelectedRow()).getId());
        
        new ChiTietDonHang().setVisible(true);
    }//GEN-LAST:event_tblOrdersMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDoanhThuMangVe;
    private javax.swing.JLabel lblDoanhThuOnline;
    private javax.swing.JLabel lblDoanhThuTaiQuan;
    private javax.swing.JLabel lblDonMangVe;
    private javax.swing.JLabel lblDonOnline;
    private javax.swing.JLabel lblDonTaiQuan;
    private javax.swing.JLabel lblTongDoanhThu;
    private javax.swing.JLabel lblTongDon;
    private javax.swing.JPanel pnMangVe;
    private javax.swing.JPanel pnOnline;
    private javax.swing.JPanel pnTaiQuan;
    private javax.swing.JPanel pnTongDon;
    private javax.swing.JTable tblOrders;
    private com.toedter.calendar.JDateChooser txtDate1;
    private com.toedter.calendar.JDateChooser txtDate2;
    // End of variables declaration//GEN-END:variables
}
