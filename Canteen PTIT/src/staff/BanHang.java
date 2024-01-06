/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package staff;

import admin.HoaDon;
import common.ToanCuc;
import dao.NhanVienDao;
import dao.categoryDao;
import dao.orderDao;
import dao.orderItemsDao;
import dao.productDao;
import dao.tableCanteenDao;
import dao.userDao;
import entity.CartItemsEntity;
import entity.CategoryEntity;
import entity.NhanVienEntity;
import entity.OrderEntity;
import entity.OrderItemsEntity;
import entity.ProductEntity;
import entity.TableCanteenEntity;
import entity.infoCartItem;
import entity.userEntity;
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
public class BanHang extends javax.swing.JFrame {

    private ToanCuc t = new ToanCuc();
    private String staff_username = t.getUsername().trim();
    private int table_id = t.getTable_id();
    private int categoryIdSelected = 1;

    private tableCanteenDao tableDAO = new tableCanteenDao();
    private userDao userDAO = new userDao();
    private orderDao orderDAO = new orderDao();
    private orderItemsDao orderItemsDAO = new orderItemsDao();
    private categoryDao categoryDAO = new categoryDao();
    private productDao proDAO = new productDao();
    private NhanVienDao nvDAO = new NhanVienDao();

    //private userEntity myUser = userDAO.selectUserByUsername(username);
    private NhanVienEntity nv = nvDAO.selectNhanVienByUsername(staff_username);
    private ArrayList<TableCanteenEntity> listTables = tableDAO.selectTable();
    private ArrayList<CategoryEntity> listCategory = categoryDAO.selectCategories();
    private ArrayList<ProductEntity> listProducts = proDAO.selectProductsByCategoryId(categoryIdSelected);

    // Lay don hang dang hoat dong
    private OrderEntity order = null;
    private int order_id;

    //lay danh sach san pham trong don hang
    private ArrayList<infoCartItem> listItems = null;
    
    Locale locale = new Locale("vi", "VN");
    NumberFormat format = NumberFormat.getInstance(locale);

    public BanHang() {
        initComponents();
        init();

    }

    // Load ten ban vào cbx
    private void loadTablesToCbx() {
        for (int i = 0; i < listTables.size(); i++) {
            cbxTables.addItem(listTables.get(i).getName());
        }
    }

    // Load hinh thuc su dung(tai ban, mang di)
    private void loadTypeOrderToCbx() {
        cbxTypeOrder.addItem("Tại quán");
        cbxTypeOrder.addItem("Mang về");
    }

    // Them lua chon hinh thuc thanh toan cho cbx
    private void loadPaymentsToCbx() {
        cbxPayments.addItem("Thanh toán khi nhận hàng");
        cbxPayments.addItem("Chuyển khoản ngân hàng");
        cbxPayments.addItem("Thẻ Tín dụng/Ghi nợ");
        cbxPayments.addItem("Thẻ nội địa NAPAS");
    }

    // Load info order items vào table
    public void loadOrderItemsToTable(JTable tblCartItem, ArrayList<infoCartItem> listItems) {
        DefaultTableModel model = (DefaultTableModel) tblCartItem.getModel();
        model.setRowCount(0);
        for (infoCartItem item : listItems) {
            float totalPriceItem = item.getPrice() * item.getQuantity();
            model.addRow(new Object[]{item.getName(), item.getQuantity(), format.format(totalPriceItem)});
        }
    }

    // Load san pham vào table
    public void loadProductsToTable(JTable tblCartItem, ArrayList<ProductEntity> listProducts) {
        DefaultTableModel model = (DefaultTableModel) tblCartItem.getModel();
        model.setRowCount(0);
        for (ProductEntity p : listProducts) {
            model.addRow(new Object[]{p.getId(), p.getName(), p.getQuantity(), format.format(p.getPrince())});
        }
    }

    // dua category name vao combobox 
    private void loadCategoriesToCbx() {
        for (int i = 0; i < listCategory.size(); i++) {
            cbxCategories.addItem(listCategory.get(i).getName());
        }
    }

    // Load tong tien vao lbl
    private void loadTotalPrice() {
        float totalPrice = 0;
        for (infoCartItem i : listItems) {
            totalPrice += (i.getPrice() * i.getQuantity());
        }
        lblTotalPrice.setText(format.format(totalPrice) + "");
    }

    //Tinh tong tien
    private float tinhTongTien() {
        float totalPrice = 0;
        for (infoCartItem i : listItems) {
            totalPrice += (i.getPrice() * i.getQuantity());
        }
        return totalPrice;
    }

    // Ham khoi tao
    private void init() {
        if (table_id != 0) {          // Neu là ban tai quan
            order = orderDAO.selectOrderByTableId(table_id);
            order_id = order.getId();
        } else {                      // Neu la ban mang ve
            order = orderDAO.selectOrderMangVe();
            order_id = order.getId();
        }
        listItems = orderItemsDAO.selectInfoCartItemByOrderId(order_id);
        loadTablesToCbx();
        loadTypeOrderToCbx();
        loadPaymentsToCbx();
        loadOrderItemsToTable(tblOrderItems, listItems);
        loadCategoriesToCbx();
        loadProductsToTable(tblProducts, listProducts);

        lblStaffName.setText(nv.getFullname());
        lblOrderId.setText(order_id + "");
        cbxTypeOrder.setSelectedIndex(order.getType());
        for (int i = 0; i < listTables.size(); i++) {
            if (listTables.get(i).getId() == table_id) {
                cbxTables.setSelectedIndex(i);
                break;
            }
        }
        lblStatus.setText("Chưa thanh toán");

        loadTotalPrice();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxTypeOrder = new javax.swing.JComboBox<>();
        cbxTables = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbxPayments = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lblOrderId = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblStaffName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTienNhan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        btnHuyDon = new javax.swing.JButton();
        btnInHoaDon = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbxCategories = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        btnThemVao = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblOrderItems = new javax.swing.JTable();
        btnUpdateQuantity = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtQuantity2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 204, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Loại hóa đơn :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        cbxTypeOrder.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbxTypeOrder.setEnabled(false);
        jPanel2.add(cbxTypeOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 206, -1));

        cbxTables.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbxTables.setEnabled(false);
        jPanel2.add(cbxTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 208, -1));

        jLabel2.setBackground(new java.awt.Color(51, 204, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bàn :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        cbxPayments.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(cbxPayments, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 208, -1));

        jLabel3.setBackground(new java.awt.Color(51, 204, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hình thức thanh toán :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        lblOrderId.setBackground(new java.awt.Color(51, 204, 255));
        lblOrderId.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblOrderId.setForeground(new java.awt.Color(255, 255, 255));
        lblOrderId.setText("0000000");
        jPanel2.add(lblOrderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 200, -1));

        jLabel6.setBackground(new java.awt.Color(51, 204, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nhân viên :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        lblStaffName.setBackground(new java.awt.Color(51, 204, 255));
        lblStaffName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblStaffName.setForeground(new java.awt.Color(255, 255, 255));
        lblStaffName.setText("Staff Name");
        jPanel2.add(lblStaffName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 200, -1));

        jLabel8.setBackground(new java.awt.Color(51, 204, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mã đơn hàng :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 320, 330));

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));

        jLabel4.setBackground(new java.awt.Color(51, 204, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Trạng thái :");

        jLabel9.setBackground(new java.awt.Color(51, 204, 255));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tổng :");

        lblStatus.setBackground(new java.awt.Color(51, 204, 255));
        lblStatus.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setText("Status");

        jLabel11.setBackground(new java.awt.Color(51, 204, 255));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tiền nhận khách :");

        lblTotalPrice.setBackground(new java.awt.Color(51, 204, 255));
        lblTotalPrice.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblTotalPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalPrice.setText("0.0");

        lblTienThua.setBackground(new java.awt.Color(51, 204, 255));
        lblTienThua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblTienThua.setForeground(new java.awt.Color(255, 255, 255));
        lblTienThua.setText("0.0");

        jLabel14.setBackground(new java.awt.Color(51, 204, 255));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("VND");

        jLabel15.setBackground(new java.awt.Color(51, 204, 255));
        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("%");

        txtTienNhan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtTienNhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienNhanKeyReleased(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(51, 204, 255));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tiền thừa :");

        jLabel22.setBackground(new java.awt.Color(51, 204, 255));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("VND");

        jLabel10.setBackground(new java.awt.Color(51, 204, 255));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Giảm giá :");

        txtGiamGia.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiamGiaActionPerformed(evt);
            }
        });
        txtGiamGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiamGiaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTienNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(txtGiamGia))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(lblTienThua))
                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 320, 280));

        btnThanhToan.setBackground(new java.awt.Color(204, 204, 255));
        btnThanhToan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuyDon.setBackground(new java.awt.Color(204, 204, 255));
        btnHuyDon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnHuyDon.setText("Hủy đơn");
        btnHuyDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDonActionPerformed(evt);
            }
        });

        btnInHoaDon.setBackground(new java.awt.Color(204, 204, 255));
        btnInHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(204, 204, 255));
        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(btnHuyDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnInHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThanhToan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(btnHuyDon)
                .addGap(18, 18, 18)
                .addComponent(btnThoat)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addComponent(btnInHoaDon)
                    .addContainerGap(102, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 320, 190));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setBackground(new java.awt.Color(51, 204, 255));
        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel16.setText("Loại :");

        jLabel17.setBackground(new java.awt.Color(51, 204, 255));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel17.setText("Search :");

        cbxCategories.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cbxCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriesActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        tblProducts.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng tồn ", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducts.setGridColor(new java.awt.Color(255, 255, 255));
        tblProducts.setRowHeight(35);
        tblProducts.setRowMargin(10);
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProducts);

        btnThemVao.setBackground(new java.awt.Color(204, 204, 255));
        btnThemVao.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThemVao.setText("Thêm vào");
        btnThemVao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVaoActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(51, 204, 255));
        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel18.setText("Số lượng :");

        jLabel19.setBackground(new java.awt.Color(51, 204, 255));
        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel19.setText("Tên sản phẩm :");

        txtProductName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txtQuantity.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(26, 26, 26)
                        .addComponent(cbxCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnThemVao, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18))
                .addGap(59, 59, 59)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(cbxCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btnThemVao)
                .addGap(39, 39, 39))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 600, 810));

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

        jLabel20.setBackground(new java.awt.Color(51, 204, 255));
        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Danh sách món đã đặt");

        tblOrderItems.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tblOrderItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "Số lượng đặt", "Tổng tiền"
            }
        ));
        tblOrderItems.setRowHeight(35);
        tblOrderItems.setRowMargin(10);
        tblOrderItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderItemsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblOrderItems);

        btnUpdateQuantity.setBackground(new java.awt.Color(204, 204, 255));
        btnUpdateQuantity.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnUpdateQuantity.setText("Cập nhật");
        btnUpdateQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateQuantityActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 204, 255));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(51, 204, 255));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel21.setText("Số lượng :");

        txtQuantity2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(65, 65, 65)
                .addComponent(txtQuantity2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantity2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnUpdateQuantity)
                .addGap(20, 20, 20)
                .addComponent(btnDelete)
                .addGap(36, 36, 36))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, 480, 810));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1481, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriesActionPerformed
        int cbxSelectedIndex = cbxCategories.getSelectedIndex();
        categoryIdSelected = listCategory.get(cbxSelectedIndex).getId();
        listProducts = proDAO.selectProductsByCategoryId(categoryIdSelected);
        loadProductsToTable(tblProducts, listProducts);
    }//GEN-LAST:event_cbxCategoriesActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        listProducts = proDAO.searchProducts(txtSearch, categoryIdSelected);
        proDAO.loadProductToTable(tblProducts, listProducts);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked
        int i = tblProducts.getSelectedRow();
        txtProductName.setText(listProducts.get(i).getName());
        txtQuantity.setText("1");
    }//GEN-LAST:event_tblProductsMouseClicked

    private void tblOrderItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderItemsMouseClicked
        int i = tblOrderItems.getSelectedRow();
        txtQuantity2.setText((String) tblOrderItems.getValueAt(tblOrderItems.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tblOrderItemsMouseClicked

    private void btnThemVaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoActionPerformed
        boolean a = checkIsEmpty();
        if (a == true) {
            int b = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm sản phẩm này vào đơn hàng ?", "Notice", JOptionPane.YES_NO_OPTION);

            if (b == 0) {
                int productId = Integer.parseInt((String) tblProducts.getValueAt(tblProducts.getSelectedRow(), 0).toString());
                int quantity = Integer.parseInt(txtQuantity.getText());

                //kiem tra Trong gio hang neu co san pham do roi thi chi them so luong
                OrderItemsEntity items = orderItemsDAO.selectOrderItem(order_id, productId);

                if (items == null) { // Neu chua co san pham nay trong gio hang
                    //Them san pham vao gio hang
                    orderItemsDAO.insertOrderItems(order_id, productId, quantity);
                    JOptionPane.showMessageDialog(this, "Sản phẩm đã được thêm vào giỏ hàng của bạn !", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else // San pham da ton tai nen tang so luong len va cap nhat
                {
                    int quantityNew = quantity + items.getQuantity();
                    orderItemsDAO.updateQuantity(order_id, productId, quantityNew);
                    JOptionPane.showMessageDialog(this, "Cập nhật số lượng sản phẩm trong đơn hàng thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

                //Cap nhat lai so luong san pham trong kho
                ProductEntity product = proDAO.selectProductsById(productId);
                int quantityUpdate = product.getQuantity() - quantity;
                proDAO.updateQuantityProduct(productId, quantityUpdate);

                //Load lai table order Items
                listItems = orderItemsDAO.selectInfoCartItemByOrderId(order_id);
                loadOrderItemsToTable(tblOrderItems, listItems);

                listProducts = proDAO.selectProductsByCategoryId(categoryIdSelected);
                loadProductsToTable(tblProducts, listProducts);
                //Cap nhat tong tien
                loadTotalPrice();
            }
        }
    }//GEN-LAST:event_btnThemVaoActionPerformed

    private void btnUpdateQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateQuantityActionPerformed
        int i = tblOrderItems.getSelectedRow();
        //check txt rong
        if (i < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //check so luong chua ki tu khac so
        if (txtQuantity2.getText().chars().allMatch(Character::isDigit) == false) {
            JOptionPane.showMessageDialog(this, "Chỉ được nhập số !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //check so luong luon > 0
        if(Integer.parseInt(txtQuantity2.getText()) <= 0){
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0 !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //check chon san pham
        if (tblOrderItems.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //kiem tra so luong khong vuot qua so luong ton
        int quantity = proDAO.selectQuantityByProductId(listItems.get(i).getProduct_id());
        int quantityNew = Integer.parseInt(txtQuantity2.getText());
        int quantityOld = listItems.get(tblOrderItems.getSelectedRow()).getQuantity();
        if (quantityNew > quantity + quantityOld) {
            JOptionPane.showMessageDialog(this, "Vượt quá số lượng tồn !!", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //tien hanh cap nhat so luong
        quantityNew = Integer.parseInt(txtQuantity2.getText());
        int productId = listItems.get(tblOrderItems.getSelectedRow()).getProduct_id();
        orderItemsDAO.updateQuantity(order_id, productId, quantityNew);

        //Cap nhat lai so luong san pham trong kho
        ProductEntity product = proDAO.selectProductsById(productId);
        quantityOld = listItems.get(tblOrderItems.getSelectedRow()).getQuantity();
        int quantityUpdate = product.getQuantity() + (quantityOld - quantityNew);
        proDAO.updateQuantityProduct(productId, quantityUpdate);

        JOptionPane.showMessageDialog(this, "Cập nhật số lượng sản phẩm trong đơn hàng thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

        //Load lai table order Items
        listItems = orderItemsDAO.selectInfoCartItemByOrderId(order_id);
        loadOrderItemsToTable(tblOrderItems, listItems);

        listProducts = proDAO.selectProductsByCategoryId(categoryIdSelected);
        loadProductsToTable(tblProducts, listProducts);
        //Cap nhat lbl tong tien
        loadTotalPrice();
    }//GEN-LAST:event_btnUpdateQuantityActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //check txt rong
        if (tblOrderItems.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm này khỏi đơn hàng ?", "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {
            int product_id = listItems.get(tblOrderItems.getSelectedRow()).getProduct_id();
            orderItemsDAO.deleteOrderItems(order_id, product_id);

            //Cap nhat lai so luong san pham trong kho
            ProductEntity product = proDAO.selectProductsById(product_id);
            int quantityUpdate = product.getQuantity() + Integer.parseInt(txtQuantity2.getText());
            proDAO.updateQuantityProduct(product_id, quantityUpdate);

            JOptionPane.showMessageDialog(this, "Sản phẩm đã được xóa khỏi giỏ hàng !", "Success", JOptionPane.INFORMATION_MESSAGE);

            //Load lai table order Items
            listItems = orderItemsDAO.selectInfoCartItemByOrderId(order_id);
            loadOrderItemsToTable(tblOrderItems, listItems);

            listProducts = proDAO.selectProductsByCategoryId(categoryIdSelected);
            loadProductsToTable(tblProducts, listProducts);

            //Cap nhat lbl tong tien
            loadTotalPrice();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnHuyDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDonActionPerformed
        int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn hủy đơn hàng này ?", "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {
            orderItemsDAO.deleteAllOrderItems(order_id);

            //Cap nhat lai so luong san pham trong kho
            for (infoCartItem i : listItems) {
                ProductEntity product = proDAO.selectProductsById(i.getProduct_id());
                int quantityUpdate = product.getQuantity() + i.getQuantity();
                proDAO.updateQuantityProduct(i.getProduct_id(), quantityUpdate);
            }

            JOptionPane.showMessageDialog(this, "Hủy đơn hàng thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

            //Load lai table order Items
            listItems = orderItemsDAO.selectInfoCartItemByOrderId(order_id);
            loadOrderItemsToTable(tblOrderItems, listItems);

            listProducts = proDAO.selectProductsByCategoryId(categoryIdSelected);
            loadProductsToTable(tblProducts, listProducts);
            //Cap nhat lbl tong tien
            loadTotalPrice();
        }
    }//GEN-LAST:event_btnHuyDonActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int b = JOptionPane.showConfirmDialog(this, "Bạn có muốn thanh toán đơn hàng này ?", "Notice", JOptionPane.YES_NO_OPTION);
        if (b == 0) {

            //Thanh toan don hang
            int payments = cbxPayments.getSelectedIndex();
            float tongTien = Float.parseFloat(lblTotalPrice.getText());
            orderDAO.thanhToanOrder(payments, order_id, tongTien);

            //Cap nhat ban Canteen ve trang thai trong
            tableDAO.updateStatusTable(table_id, 0);

            JOptionPane.showMessageDialog(this, "Thanh toán đơn hàng thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);

            //Enable mot so thu
            tblProducts.setEnabled(false);
            tblOrderItems.setEnabled(false);

            btnDelete.setEnabled(false);
            btnHuyDon.setEnabled(false);
            btnThemVao.setEnabled(false);
            btnUpdateQuantity.setEnabled(false);
            btnThanhToan.setEnabled(false);

            cbxPayments.setEnabled(false);
            txtTienNhan.setEnabled(false);
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienNhanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienNhanKeyReleased
        //check so luong chua ki tu khac so
        if (txtTienNhan.getText().chars().allMatch(Character::isDigit) == false) {
            JOptionPane.showMessageDialog(this, "Chỉ được nhập số !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            txtTienNhan.setText(txtTienNhan.getText().substring(0, txtTienNhan.getText().length() - 1));
        }

        float tongTien = Float.parseFloat(lblTotalPrice.getText());
        float tienNhan = 0;

        if (txtTienNhan.getText().isEmpty()) {
            tienNhan = 0;
        } else {
            tienNhan = Float.parseFloat(txtTienNhan.getText());
        }

        float tienThua = tienNhan - (tongTien);
        lblTienThua.setText(format.format(tienThua) + "");
    }//GEN-LAST:event_txtTienNhanKeyReleased

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        if (table_id != 0) { //Don hang tai quan
            int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                order = orderDAO.selectOrderById(order_id);   // Load lai don hang
                listItems = orderItemsDAO.selectInfoCartItemByOrderId(order_id);
                if (listItems.size() <= 0) { // Khong có san pham trong don hang
                    // Xoa don hang do
                    orderDAO.deleteOrder(order_id);
                    //Cap nhat lai trang thai ban la Trong
                    tableDAO.updateStatusTable(table_id, 0);
                }
                if (order.getStatus() == 0) {  // Da thanh toan don hang
                    //Cap nhat lai trang thai ban la Trong
                    tableDAO.updateStatusTable(table_id, 0);
                }
                JOptionPane.showMessageDialog(this, "Thoát thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        } else {    // Don hang mang ve
            int b = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát ?", "Notice", JOptionPane.YES_NO_OPTION);
            if (b == 0) {
                order = orderDAO.selectOrderMangVe();    // Load lai don hang
                listItems = orderItemsDAO.selectInfoCartItemByOrderId(order_id);
                if (listItems.size() <= 0) { // Khong có san pham trong don hang
                    // Xoa don hang do
                    orderDAO.deleteOrder(order_id);

                    JOptionPane.showMessageDialog(this, "Thoát thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else if (order.getStatus() == 0) {  //Da thanh toan xong

                    JOptionPane.showMessageDialog(this, "Thoát thành công !", "Success", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {  // Co san pham nhung chua thanh toan
                    JOptionPane.showMessageDialog(this, "Đơn hàng mang về.\n Cần thanh toán hoặc hủy đơn trước khi thoát !", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtGiamGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiamGiaKeyReleased
        //check so luong chua ki tu khac so
        if (txtGiamGia.getText().chars().allMatch(Character::isDigit) == false) {
            JOptionPane.showMessageDialog(this, "Chỉ được nhập số !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            txtGiamGia.setText(txtGiamGia.getText().substring(0, txtGiamGia.getText().length() - 1));
        }

        float tongTien = tinhTongTien();
        float tienNhan = 0;
        float giamGia = 0;

        if (txtTienNhan.getText().isEmpty()) {
            tienNhan = 0;
        } else {
            tienNhan = Float.parseFloat(txtTienNhan.getText());
        }

        if (txtGiamGia.getText().isEmpty()) {
            giamGia = 0;
        } else {
            giamGia = Float.parseFloat(txtGiamGia.getText());
        }

        float tienGiam = tongTien * (giamGia / 100);
        System.out.println(tienGiam);
        float tienThua = tienNhan - (tongTien - tienGiam);
        lblTienThua.setText(format.format(tienThua) + "");
        lblTotalPrice.setText(format.format(tongTien - tienGiam) + "");
    }//GEN-LAST:event_txtGiamGiaKeyReleased

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        ToanCuc t = new ToanCuc();
        t.setOrder_id(order_id);
        
        new HoaDon().setVisible(true);
    }//GEN-LAST:event_btnInHoaDonActionPerformed

    private void txtGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiamGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiamGiaActionPerformed

    private boolean checkIsEmpty() {
        // check txt rong
        if (tblProducts.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        //check txt rong
        if (txtQuantity.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        //check so luong chua ki tu khac so
        if (txtQuantity.getText().chars().allMatch(Character::isDigit) == false) {
            JOptionPane.showMessageDialog(this, "Chỉ được nhập số !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        //check so luong luon > 0
        if(Integer.parseInt(txtQuantity.getText()) <= 0){
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0 !", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // Lay so luong ton tren bang
        int productQuantity = Integer.parseInt((String) tblProducts.getValueAt(tblProducts.getSelectedRow(), 2).toString());
        //check so luong nhieu hon so luong ton
        if (Integer.parseInt(txtQuantity.getText().trim()) > productQuantity) {
            JOptionPane.showMessageDialog(this, "Vượt quá số lượng tồn !!", "Thông báo lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

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
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHuyDon;
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemVao;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnUpdateQuantity;
    private javax.swing.JComboBox<String> cbxCategories;
    private javax.swing.JComboBox<String> cbxPayments;
    private javax.swing.JComboBox<String> cbxTables;
    private javax.swing.JComboBox<String> cbxTypeOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblOrderId;
    private javax.swing.JLabel lblStaffName;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JTable tblOrderItems;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtQuantity2;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTienNhan;
    // End of variables declaration//GEN-END:variables
}
