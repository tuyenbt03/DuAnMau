/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DomainModel.ChiTietSP;
import DomainModel.SanPham;
import DomainModel.NSX;
import DomainModel.MauSac;
import DomainModel.DongSP;
import Service.AllService;
import Service.InterfaceChiTietSPService;
import Service.InterfaceSanPhamService;
import Service.InterfaceNSXService;
import Service.InterfaceMauSacService;
import Service.InterfaceDongSPService;
import Utilities.Chk;
import ViewModels.CTSPViewModel;
import ViewModels.SanPhamViewModel;
import ViewModels.NSXViewModel;
import ViewModels.MauSacViewModel;
import ViewModels.DongSPViewModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ViewChiTietSP extends javax.swing.JFrame {
    
    private final InterfaceChiTietSPService CTSP_Service = AllService.getChiTietSPService();
    InterfaceSanPhamService SanPham_SV = AllService.getSanPhamService();
    InterfaceNSXService NSX_SV = AllService.getNSXService();
    InterfaceMauSacService MauSac_SV = AllService.getMauSacService();
    InterfaceDongSPService DongSP_SV = AllService.getDongSPService();
    ArrayList<CTSPViewModel> listCTSP = new ArrayList<>();
    ArrayList<SanPhamViewModel> listSP = new ArrayList<>();
    ArrayList<NSXViewModel> listNSX = new ArrayList<>();
    ArrayList<MauSacViewModel> listMS = new ArrayList<>();
    ArrayList<DongSPViewModel> listDongSP = new ArrayList<>();
    DefaultTableModel mol;

    /**
     * Creates new form ViewChiTietSP
     */
    public ViewChiTietSP() {
        initComponents();
        fillTable();
        txtMa.setEnabled(false);
        txtIDSP.setEnabled(false);
        txtTen.setEnabled(false);
        cboALL.setEnabled(false);
        cboDongSP.setEnabled(false);
        cboMau.setEnabled(false);
        cboNSX.setEnabled(false);
        fillDongSP();
        fillMauSac();
        fillNSX();
        
    }
    
    
    public void fillTable(){
        cboALL.setEnabled(false);
        listSP = (ArrayList<SanPhamViewModel>) SanPham_SV.layDanhSachSanPham();
        mol = (DefaultTableModel) TblSanPham1.getModel();
        mol.setRowCount(0);
        int i = 1;
        for (SanPhamViewModel s : listSP) {
            mol.addRow(new Object[]{s.getId(), s.getMa(), s.getTen()});
        }

        //Fill Chi tiết Sản Phẩm 
        listCTSP = (ArrayList<CTSPViewModel>) CTSP_Service.layDanhSachNhanVien();
        mol = (DefaultTableModel) tblCTSP.getModel();
        mol.setRowCount(0);
        for (CTSPViewModel c : listCTSP) {
            mol.addRow(new Object[]{c.getStt(), c.getMasanPham(), c.getTensanPham(), c.getNamBH(), c.getMauSac(), c.getSlTon()});
        }
    }
    
    
    
    public void fillMauSac() {
        listMS = (ArrayList<MauSacViewModel>) MauSac_SV.layDanhSachMauSac();
        cboMau.removeAllItems();
        for (MauSacViewModel mau : listMS) {
            cboMau.addItem(mau.toString());
        }
    }

    public void fillDongSP() {
        listDongSP = (ArrayList<DongSPViewModel>) DongSP_SV.layDanhSachDongSP();
        cboDongSP.removeAllItems();
        for (DongSPViewModel d : listDongSP) {
            cboDongSP.addItem(d.toString());
        }
    }

    public void fillNSX() {
        listNSX = (ArrayList<NSXViewModel>) NSX_SV.layDanhSachNSX();
        cboNSX.removeAllItems();
        for (NSXViewModel n : listNSX) {
            cboNSX.addItem(n.toString());
        }
    }
    
    
    public void fillCTSPByMa(String ma) {
        listCTSP = (ArrayList<CTSPViewModel>) CTSP_Service.getCTSPByMaSPView(ma);
        mol = (DefaultTableModel) tblCTSP.getModel();
        mol.setRowCount(0);
        for (CTSPViewModel c : listCTSP) {
            mol.addRow(new Object[]{c.getStt(), c.getMasanPham(), c.getTensanPham(), c.getNamBH(), c.getMauSac(), c.getSlTon()});
        }
        cboALL.setSelected(false);
    }
    
    
    public void SearchSPByMa(String KeyWord) {
        //Fill Sản Phẩm 
        listSP = (ArrayList<SanPhamViewModel>) SanPham_SV.SearchSP(KeyWord);
        mol = (DefaultTableModel) TblSanPham1.getModel();
        mol.setRowCount(0);
        int i = 1;
        for (SanPhamViewModel s : listSP) {
            mol.addRow(new Object[]{s.getId(), s.getMa(), s.getTen()});
        }
    }
    
    
    public void show(int index){
        ChiTietSP CTSP = CTSP_Service.getCTSPByid(listCTSP.get(index).getId());
        SanPham sp = SanPham_SV.getSanPhamByMa(listCTSP.get(index).getMasanPham());
        txtIDSP.setText(sp.getId());
        txtMa.setText(sp.getMa());
        txtTen.setText(sp.getTen());
        cboNSX.setSelectedItem(CTSP.getNsx().toString());
        cboMau.setSelectedItem(CTSP.getMauSac().toString());
        cboDongSP.setSelectedItem(CTSP.getDongSP().toString());
        txtNamBH.setText(CTSP.getNamBH() + "");
        txtSL.setText(CTSP.getSlTon() + "");
        txtGiaNhap.setText(CTSP.getGiaNhap() + "");
        txtGiaBan.setText(CTSP.getGiaBan() + "");
        txtMota.setText(CTSP.getMoTa());
    }
    
    
    public boolean chkValidate() {
        if (Chk.chknull("Vui Lòng Chọn Sản Phẩm", txtIDSP)) {
            return false;
        } else if (Chk.chknull("Không Để Trống Năm Bảo Hành", txtNamBH)) {
            return false;
        } else if (Chk.chkFloat("Năm Bảo Hành Phải là Số", "Năm Bảo Hành Phải >=0", txtNamBH)) {
            return false;
        } else if (Chk.chknull("Không Để Trống Số Lượng", txtSL)) {
            return false;
        } else if (Chk.chkInt("Số Lượng Phải là Số", "Năm Bảo Hành Phải >0", txtSL)) {
            return false;
        } else if (Chk.chknull("Không Để Trống Giá Nhập", txtGiaNhap)) {
            return false;
        } else if (Chk.chkFloat("Giá Nhập Phải là Số", "Giá Nhập Phải >=0", txtGiaNhap)) {
            return false;
        } else if (Chk.chknull("Không Để Trống Giá Bán", txtGiaBan)) {
            return false;
        } else if (Chk.chkFloat("Giá Bán Phải là Số", "Giá Nhập Phải >=0", txtGiaBan)) {
            return false;
        } else {
            return true;
        }
    }
    
    
    public ChiTietSP getCTSP() {
        //id
        //get Mau 
        String maMau = cboMau.getSelectedItem().toString().split(" ")[0];
        MauSac s = MauSac_SV.getChucVuByMa(maMau);
        //get NSX
        String maNSX = cboNSX.getSelectedItem().toString().split(" ")[0];
        NSX nsx = NSX_SV.getNSXByMa(maNSX);
        //get DongSP 
        String madong = cboDongSP.getSelectedItem().toString().split(" ")[0];
        DongSP dongsp = DongSP_SV.getDongSPByMa(madong);
        SanPham sp = SanPham_SV.getSanPhamByMa(txtMa.getText());
        return new ChiTietSP(sp, nsx, s, dongsp, Integer.parseInt(txtNamBH.getText()), txtMota.getText(), Integer.parseInt(txtSL.getText()), Float.parseFloat(txtGiaNhap.getText()), Float.parseFloat(txtGiaBan.getText()));
    }

    public ChiTietSP getCTSP(String idCTSP) {
        //id
        String id = idCTSP;
        //get Mau 
        String maMau = cboMau.getSelectedItem().toString().split(" ")[0];
        MauSac s = MauSac_SV.getChucVuByMa(maMau);
        //get NSX
        String maNSX = cboNSX.getSelectedItem().toString().split(" ")[0];
        NSX nsx = NSX_SV.getNSXByMa(maNSX);
        //get DongSP 
        String madong = cboDongSP.getSelectedItem().toString().split(" ")[0];
        DongSP dongsp = DongSP_SV.getDongSPByMa(madong);
        SanPham sp = SanPham_SV.getSanPhamByMa(txtMa.getText());
        return new ChiTietSP(id, sp, nsx, s, dongsp, Integer.parseInt(txtNamBH.getText()), txtMota.getText(), Integer.parseInt(txtSL.getText()), Float.parseFloat(txtGiaNhap.getText()), Float.parseFloat(txtGiaBan.getText()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel19 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblCTSP = new javax.swing.JTable();
        cboALL = new javax.swing.JCheckBox();
        jPanel20 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboNSX = new javax.swing.JComboBox<>();
        cboMau = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboDongSP = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNamBH = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        txtIDSP = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TblSanPham1 = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnThemCTSP = new javax.swing.JButton();
        btnXoaCTSP = new javax.swing.JButton();
        btnSuaCTSP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Sản Phẩm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        tblCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Năm BH", "Màu Sắc", "SL SP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTSPMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblCTSP);

        cboALL.setText("Tất Cả");
        cboALL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboALLMouseClicked(evt);
            }
        });
        cboALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboALLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(cboALL)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addComponent(cboALL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("Mã");

        jLabel4.setText("Tên");

        jLabel5.setText("NSX");

        cboNSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMauActionPerformed(evt);
            }
        });

        jLabel6.setText("Màu");

        cboDongSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboDongSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDongSPActionPerformed(evt);
            }
        });

        jLabel7.setText("Dòng SP");

        jLabel8.setText("Năm BH");

        jLabel9.setText("SL");

        jLabel11.setText("Giá Nhập");

        jLabel12.setText("Giá Bán");

        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });

        txtMota.setColumns(20);
        txtMota.setLineWrap(true);
        txtMota.setRows(1);
        txtMota.setBorder(javax.swing.BorderFactory.createTitledBorder("Mô tả"));
        jScrollPane6.setViewportView(txtMota);

        jLabel13.setText("ID SP");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(33, 33, 33)
                                .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(0, 130, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(30, 30, 30)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cboNSX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboMau, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboDongSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(24, 24, 24)
                        .addComponent(txtIDSP)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtIDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Sản Phẩm"));

        jScrollPane5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane5MouseClicked(evt);
            }
        });

        TblSanPham1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Mã ", "Tên"
            }
        ));
        TblSanPham1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblSanPham1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TblSanPham1);

        txtSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSearchInputMethodTextChanged(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("CHI TIẾT SẢN PHẨM");

        btnThemCTSP.setText("Thêm");
        btnThemCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTSPActionPerformed(evt);
            }
        });

        btnXoaCTSP.setText("Xóa");
        btnXoaCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCTSPActionPerformed(evt);
            }
        });

        btnSuaCTSP.setText("Sửa");
        btnSuaCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCTSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1)
                .addContainerGap(398, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaCTSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuaCTSP)
                .addGap(64, 64, 64))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 397, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSuaCTSP)
                    .addComponent(btnXoaCTSP)
                    .addComponent(btnThemCTSP))
                .addGap(32, 32, 32))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(40, 40, 40)))
                    .addGap(36, 36, 36)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTSPMouseClicked
        // TODO add your handling code here:
        int index = tblCTSP.getSelectedRow();
        show(index);
    }//GEN-LAST:event_tblCTSPMouseClicked

    private void cboALLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboALLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboALLMouseClicked

    private void cboALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboALLActionPerformed
        // TODO add your handling code here:
        if (cboALL.isSelected() == true) {
            cboALL.setEnabled(false);
            //Fill Chi tiết Sản Phẩm
            listCTSP = (ArrayList<CTSPViewModel>) CTSP_Service.layDanhSachNhanVien();
            mol = (DefaultTableModel) tblCTSP.getModel();
            mol.setRowCount(0);
            int count = 1;
            for (CTSPViewModel c : listCTSP) {
                mol.addRow(new Object[]{c.getStt(), c.getMasanPham(), c.getTensanPham(), c.getNamBH(), c.getMauSac(), c.getSlTon()});
            }
            
        }
    }//GEN-LAST:event_cboALLActionPerformed

    private void cboMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMauActionPerformed

    private void cboDongSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDongSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDongSPActionPerformed

    private void TblSanPham1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblSanPham1MouseClicked
        // TODO add your handling code here:
        //Show Detail SP
        int index = TblSanPham1.getSelectedRow();
        String ma = listSP.get(index).getMa();
        SanPham sp = SanPham_SV.getSanPhamByMa(ma);
        txtIDSP.setText(sp.getId());
        txtMa.setText(sp.getMa());
        txtTen.setText(sp.getTen());
        //Fill Chi Tiet SP By Ma
        fillCTSPByMa(ma);
        cboALL.setEnabled(true);
        cboALL.setSelected(false);
    }//GEN-LAST:event_TblSanPham1MouseClicked

    private void jScrollPane5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane5MouseClicked

    private void txtSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSearchInputMethodTextChanged
        // TODO add your handling code here:
        SearchSPByMa(txtSearch.getText());
    }//GEN-LAST:event_txtSearchInputMethodTextChanged

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        SearchSPByMa(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        SearchSPByMa(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanActionPerformed

    private void btnThemCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCTSPActionPerformed
        // TODO add your handling code here:
        if (chkValidate()) {
            if (CTSP_Service.getCTSP(txtMa.getText(), cboMau.getSelectedItem().toString().split(" ")[0]) == null) {
                CTSP_Service.add(getCTSP());
                fillCTSPByMa(txtMa.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Chi Tiết Sản Phẩm Đã Tồn Tại", "Lỗi!!!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnThemCTSPActionPerformed

    private void btnXoaCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCTSPActionPerformed
        // TODO add your handling code here:
        try {
            ChiTietSP ctsp = CTSP_Service.getCTSPByid(listCTSP.get(tblCTSP.getSelectedRow()).getId());
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá không ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION){
                CTSP_Service.delete(ctsp.getId());
                fillTable();
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chi tiết SP trước khi xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaCTSPActionPerformed

    private void btnSuaCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCTSPActionPerformed
        // TODO add your handling code here:
        try {
            ChiTietSP ctsp = CTSP_Service.getCTSPByid(listCTSP.get(tblCTSP.getSelectedRow()).getId());
            if (chkValidate()) {
                CTSP_Service.update(getCTSP(ctsp.getId()));
                fillTable();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chi tiết SP trước khi sửa", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaCTSPActionPerformed

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
            java.util.logging.Logger.getLogger(ViewChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewChiTietSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblSanPham1;
    private javax.swing.JButton btnSuaCTSP;
    private javax.swing.JButton btnThemCTSP;
    private javax.swing.JButton btnXoaCTSP;
    private javax.swing.JCheckBox cboALL;
    private javax.swing.JComboBox<String> cboDongSP;
    private javax.swing.JComboBox<String> cboMau;
    private javax.swing.JComboBox<String> cboNSX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable tblCTSP;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtIDSP;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextArea txtMota;
    private javax.swing.JTextField txtNamBH;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
