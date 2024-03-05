/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DomainModel.ChiTietSP;
import DomainModel.HDChiTiet;
import DomainModel.HoaDon;
import Service.AllService;
import Service.InterfaceChiTietSPService;
import ViewModels.CTSPViewModel;
import ViewModels.GioHang_QLHoaDon;
import ViewModels.HoaDon_QLHoaDon;
import Responsitory.InterfaceHDChiTietResponsitory;
import Service.InterfaceHDChiTietService;
import Service.InterfaceHoaDonService;

/**
 *
 * @author baphuoc
 */
public class ViewMain extends javax.swing.JFrame {

    InterfaceChiTietSPService CTSP_Service = AllService.getChiTietSPService();
    InterfaceHoaDonService HD_SV = AllService.getHoaDonService();
    InterfaceHDChiTietService DHCT_SV = AllService.getHDChiTietService();
//    ArrayList<ChiTietSP_Model> listSP = new ArrayList<>();
    ArrayList<HDChiTiet> listGH = new ArrayList<>();
    ArrayList<GioHang_QLHoaDon> listGHView = new ArrayList<>();
    ArrayList<CTSPViewModel> listSPCT = new ArrayList<>();
    ArrayList<HoaDon_QLHoaDon> listViewHoaDon = new ArrayList<>();
    DefaultTableModel mol;
    DecimalFormat fm = new DecimalFormat("#");
    Locale loc = new Locale("vi", "VN");
    NumberFormat numberFM = NumberFormat.getCurrencyInstance(loc);

    /**
     * Creates new form HoaDon_View
     */
    public ViewMain() {
        initComponents();
        filltblSP();
        fillHD();
        txtMaHD.setEnabled(false);
        txtNgayTao.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TrangThai = new javax.swing.ButtonGroup();
        btnTaoHD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtTKSP = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTienKhach = new javax.swing.JTextField();
        txtMaHD = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        rdoCho = new javax.swing.JRadioButton();
        rdoAll = new javax.swing.JRadioButton();
        rdoHuy = new javax.swing.JRadioButton();
        rdoDaTT = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTaoHD.setText("Tạo Hóa Đơn");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HD", "Ngày Tạo", "Tên NV", "Tình Trạng"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ Hàng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Màu", "Số Lượng", "Đơn Giá", "Thành TIền"
            }
        ));
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản Phẩm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Màu", "Năm BH", "Mô Tả", "SL SP", "Giá Nhập", "Giá Bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPham);

        txtTKSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTKSPKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTKSP, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(txtTKSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        jLabel1.setText("Mã HD");

        jLabel2.setText("Ngày Tạo");

        jLabel3.setText("Tên NV");

        jLabel4.setText("Tổng Tiền");

        jLabel5.setText("Tiền Khách Đưa");

        jLabel6.setText("Tiền Thừa");

        txtTienKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachActionPerformed(evt);
            }
        });
        txtTienKhach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachKeyReleased(evt);
            }
        });

        txtTongTien.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtTongTienInputMethodTextChanged(evt);
            }
        });

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTienKhach))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(63, 63, 63)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(46, 46, 46)
                        .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(60, 60, 60)
                        .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(42, 42, 42)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnThanhToan)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTienKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        TrangThai.add(rdoCho);
        rdoCho.setText("Chờ thanh toán");
        rdoCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChoMouseClicked(evt);
            }
        });

        TrangThai.add(rdoAll);
        rdoAll.setSelected(true);
        rdoAll.setText("Tất cả");
        rdoAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoAllMouseClicked(evt);
            }
        });

        TrangThai.add(rdoHuy);
        rdoHuy.setText("Đã hủy");

        TrangThai.add(rdoDaTT);
        rdoDaTT.setText("Đã thanh toán");
        rdoDaTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDaTTMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTaoHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoCho)
                                .addGap(18, 18, 18)
                                .addComponent(rdoAll)
                                .addGap(18, 18, 18)
                                .addComponent(rdoHuy)
                                .addGap(18, 18, 18)
                                .addComponent(rdoDaTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoCho)
                            .addComponent(rdoAll)
                            .addComponent(rdoHuy)
                            .addComponent(rdoDaTT))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTaoHD)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        try {
            int index = tblSanPham.getSelectedRow();
            ChiTietSP SP = CTSP_Service.getCTSPByid(listSPCT.get(index).getId());
            if (SP.getSlTon() <= 0) {
                JOptionPane.showMessageDialog(this, "Sản Phẩm Đã Hết", "Lỗi!!!", JOptionPane.ERROR_MESSAGE);
            } else {
                UpdateSL(SP, 1);
                //Tinh tien Thua

                addGH(index);
                float khach = Float.parseFloat(txtTienKhach.getText());
                float tienThua = khach - getThanhTien();
                txtTienThua.setText(numberFM.format(tienThua));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        // TODO add your handling code here:
        //set default SL sản phẩm  
//        for (HDChiTiet_Model h : listGH) {
//            UpdateSL(h.getChiTietSP(), -h.getSL());
//        }
        // set Row tblGH =0
        mol = (DefaultTableModel) tblGioHang.getModel();
        mol.setRowCount(0);
        //Add hóa đơn && fill tbl hoadon
        HoaDon h = getHoaDon();
        
        HD_SV.add(h);
        fillHD();
        tblSanPham.setEnabled(true);
        tblGioHang.setEnabled(true);
        btnThanhToan.setEnabled(true);
        HoaDon hD = HD_SV.getHDByMa(listViewHoaDon.get(0).getMa().toString());
        showHD(hD);


    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:

        try {
            int index = tblGioHang.getSelectedRow();
            HDChiTiet h = listGH.get(index);
            ChiTietSP sp = h.getChiTietSP();
            UpdateSL(sp, -1);
            if (h.getSL() == 1) {
                DHCT_SV.delete(h);
            } else {
                int SL = h.getSL() - 1;
                h.setSL(SL);
                h.setDonGia(SL * listGHView.get(index).getDonGia());
                DHCT_SV.updateSL(h);
            }
            filltblGH();
            txtTongTien.setText(getThanhTien() + "");
            //Tinh tien Thua
            float khach = Float.parseFloat(txtTienKhach.getText());
            float tienThua = khach - getThanhTien();
            txtTienThua.setText(numberFM.format(tienThua));
        } catch (Exception e) {
        }

    }//GEN-LAST:event_tblGioHangMouseClicked

    private void txtTienKhachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachKeyReleased
        // TODO add your handling code here:
        try {
            float khach = Float.parseFloat(txtTienKhach.getText());
//            txtTienKhach.setText(numberFM.format(khach));
            float tienThua = khach - getThanhTien();
            txtTienThua.setText(numberFM.format(tienThua));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtTienKhachKeyReleased

    private void txtTongTienInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtTongTienInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTongTienInputMethodTextChanged

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int index = tblHoaDon.getSelectedRow();
        HoaDon h = HD_SV.getHDByMa(tblHoaDon.getValueAt(index, 1).toString());
        showHD(h);
        listGH = (ArrayList<HDChiTiet>) DHCT_SV.getHDCTByMaHD(txtMaHD.getText().toString());

        txtTongTien.setText(numberFM.format(getThanhTien()));
        if (h.getTrangThai() == 1) {
            tblSanPham.setEnabled(false);
            filltblSP();
            tblGioHang.setEnabled(false);
            btnThanhToan.setEnabled(false);
        } else {
            tblSanPham.setEnabled(true);
            tblGioHang.setEnabled(true);
            btnThanhToan.setEnabled(true);
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
//        for (ChiTietSP_Model c : listSP) {
//            CTSP_Service.update(c, c.getSlTon());
//        }
        thanhtoan();
        fillHD();
        tblSanPham.setEnabled(false);
        filltblSP();
        tblGioHang.setEnabled(false);
        btnThanhToan.setEnabled(false);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void rdoAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoAllMouseClicked
        // TODO add your handling code here:
        if (rdoAll.isSelected() == true) {
            fillHD();
        }
    }//GEN-LAST:event_rdoAllMouseClicked

    private void rdoChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChoMouseClicked
        // TODO add your handling code here:
        fillHDByTT();
    }//GEN-LAST:event_rdoChoMouseClicked

    private void rdoDaTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDaTTMouseClicked
        // TODO add your handling code here:
        fillHDByTT();
    }//GEN-LAST:event_rdoDaTTMouseClicked

    private void txtTKSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTKSPKeyReleased
        // TODO add your handling code here:
        search(txtTKSP.getText().trim());
    }//GEN-LAST:event_txtTKSPKeyReleased

    private void txtTienKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup TrangThai;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdoAll;
    private javax.swing.JRadioButton rdoCho;
    private javax.swing.JRadioButton rdoDaTT;
    private javax.swing.JRadioButton rdoHuy;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTKSP;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTienKhach;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
    public void filltblSP() {
        listSPCT = (ArrayList<CTSPViewModel>) CTSP_Service.layDanhSachNhanVien();
        mol = (DefaultTableModel) tblSanPham.getModel();
        mol.setRowCount(0);
        for (CTSPViewModel c : listSPCT) {
            mol.addRow(new Object[]{c.getStt(), c.getMasanPham(), c.getTensanPham(), c.getMauSac(), c.getNamBH(), c.getMoTa(), c.getSlTon(), c.getGiaNhap(), c.getGiaBan()});
        }
    }

    public void UpdateSL(ChiTietSP SP, int SL) {
        CTSP_Service.update(SP, SL);
        for (int i = 0; i < listSPCT.size() - 1; i++) {
            if (listSPCT.get(i).getId().endsWith(SP.getId())) {
                tblSanPham.setValueAt(SP.getSlTon() - SL, i, 6);
            }
        }
    }

    public void fillHD() {
        listViewHoaDon = (ArrayList<HoaDon_QLHoaDon>) HD_SV.getViewHoaDon();
        mol = (DefaultTableModel) tblHoaDon.getModel();
        mol.setRowCount(0);
        String TrangThai = "";
        for (HoaDon_QLHoaDon h : listViewHoaDon) {
            if (h.getTinhTrang() == 0) {
                TrangThai = "Chưa Thanh Toán";
            } else {
                TrangThai = "Đã Thanh Toán";
            }
            mol.addRow(new Object[]{h.getsTT(), h.getMa(), h.getNgayTao(), null, TrangThai});
        }
    }

    public void fillHDByTT() {
        int TT = 0;
        if (rdoCho.isSelected() == true) {
            TT = 0;
        } else if (rdoDaTT.isSelected() == true) {
            TT = 1;
        }
        listViewHoaDon = (ArrayList<HoaDon_QLHoaDon>) HD_SV.getViewHoaDonByTT(TT);
        mol = (DefaultTableModel) tblHoaDon.getModel();
        mol.setRowCount(0);
        String TrangThai = "";
        for (HoaDon_QLHoaDon h : listViewHoaDon) {
            if (h.getTinhTrang() == 0) {
                TrangThai = "Chưa Thanh Toán";
            } else {
                TrangThai = "Đã Thanh Toán";
            }
            mol.addRow(new Object[]{h.getsTT(), h.getMa(), h.getNgayTao(), null, TrangThai});
        }
    }

    public void filltblGH() {
        listGH = (ArrayList<HDChiTiet>) DHCT_SV.getHDCTByMaHD(txtMaHD.getText());
        listGHView = (ArrayList<GioHang_QLHoaDon>) DHCT_SV.getHDCTView(txtMaHD.getText());
        mol = (DefaultTableModel) tblGioHang.getModel();
        mol.setRowCount(0);
        for (GioHang_QLHoaDon h : listGHView) {
            mol.addRow(new Object[]{h.getSTT(), h.getMaSP(), h.getMau(), h.getSL(), h.getDonGia(), h.getThanhTien()});
        }
    }

    public void showHD(HoaDon h) {

        txtMaHD.setText(h.getMa());
        txtNgayTao.setText(h.getNgayTao() + "");
        txtTienThua.setText(getThanhTien() + "");
        txtTienKhach.setText("");
        txtTienThua.setText("");

        filltblGH();
    }

    public void clear() {
        listGH.removeAll(listGH);
        mol = (DefaultTableModel) tblGioHang.getModel();
        mol.setRowCount(0);
        txtNgayTao.setText("");
        txtTKSP.setText("");
        txtTenNV.setText("");
        txtTienKhach.setText("");
        txtTienThua.setText("");
        txtTongTien.setText("");
        btnThanhToan.setEnabled(false);

    }

    public HoaDon getHoaDon() {
        int count = Integer.parseInt(listViewHoaDon.get(0).getMa().substring(2, listViewHoaDon.get(0).getMa().length())) + 1;
        String ma = "HD" + count;
        return new HoaDon(ma, getDate(), 1);
    }

    public Date getDate() {
        SimpleDateFormat DateFM = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String d = DateFM.format(date);
        try {
            return DateFM.parse(d);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void addGH(int index) {
        boolean chk = true;
        //check xem gio hang co SP chua
        String id = listSPCT.get(index).getId();
        listGH = (ArrayList<HDChiTiet>) DHCT_SV.getHDCTByMaHD(txtMaHD.getText().toString());
        for (HDChiTiet h : listGH) {
            if (h.getChiTietSP().getId().equalsIgnoreCase(id)) {
                int SL = h.getSL() + 1;
                h.setSL(SL);
                h.setDonGia(SL * h.getChiTietSP().getGiaBan());
                float dg = SL * h.getChiTietSP().getGiaBan();
                DHCT_SV.updateSL(h);
                chk = false;
            }
        }
        if (chk == true) {
            HDChiTiet h = new HDChiTiet(HD_SV.getHDByMa(txtMaHD.getText()), CTSP_Service.getCTSPByid(id), 1, listSPCT.get(index).getGiaBan());
//            listGH.add(h);
            DHCT_SV.addSP(h);
        }
        //add row tblGioHang
        filltblGH();
        //Tinh Tien
        txtTongTien.setText(numberFM.format(getThanhTien()));
    }

    public float getThanhTien() {
        float money = 0;
        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            money += Float.parseFloat(tblGioHang.getValueAt(i, 5) + "");
        }
        return money;
    }

    public void thanhtoan() {
//        for (HDChiTiet_Model h : listGH) {
//            DHCT_SV.addSP(h);
//        }
        HoaDon h = HD_SV.getHDByMa(txtMaHD.getText());
        HD_SV.ThanhToan(h);
    }

    public void search(String keyWord) {
        listSPCT = (ArrayList<CTSPViewModel>) CTSP_Service.search(keyWord);
        mol = (DefaultTableModel) tblSanPham.getModel();
        mol.setRowCount(0);
        int i = 1;
        for (CTSPViewModel c : listSPCT) {
            mol.addRow(new Object[]{c.getStt(), c.getMasanPham(), c.getTensanPham(), c.getMauSac(), c.getNamBH(), c.getMoTa(), c.getSlTon(), c.getGiaNhap(), c.getGiaBan()});
        }
    }

}