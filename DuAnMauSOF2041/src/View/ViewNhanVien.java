/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DomainModel.ChucVu;
import DomainModel.CuaHang;
import DomainModel.NhanVien;
import Service.AllService;
import Service.InterfaceChucVuService;
import Service.InterfaceCuaHangService;
import Service.NhanVienService;
import Service.InterfaceNhanVienService;
import Utilities.Chk;
import ViewModels.ChucVuViewModel;
import ViewModels.CuaHangViewModel;
import ViewModels.NhanVienViewModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ViewNhanVien extends javax.swing.JFrame {
    
    private final InterfaceNhanVienService NVservice = AllService.getNhanVienService();
    InterfaceChucVuService CVservice = AllService.getChucVuService();
    InterfaceCuaHangService CHservice = AllService.getCuaHangService();
    ArrayList<NhanVienViewModel> dsNhanVien = new ArrayList<>();
    ArrayList<ChucVuViewModel> dsChucVu = new ArrayList<>();
    ArrayList<CuaHangViewModel> dsCuaHang = new ArrayList<>();

    /**
     * Creates new form ViewNhanVien
     */
    public ViewNhanVien() {
        initComponents();
        setLocationRelativeTo(null);
        loadTable();
    }
    
    
    private void loadTable() {
        fillcboCV();
        fillcboCH();
        dsNhanVien = NVservice.layDanhSachNhanVien();
        DefaultTableModel tableModel = (DefaultTableModel) tblNhanVien.getModel();
        tableModel.setColumnCount(0);
        tableModel.addColumn("ID");
        tableModel.addColumn("Mã");
        tableModel.addColumn("Tên");
        tableModel.addColumn("Giới tính");
        tableModel.addColumn("Ngày sinh");
        tableModel.addColumn("Chức vụ");
        tableModel.addColumn("Cửa hàng");
        tableModel.addColumn("Trạng thái");
        tableModel.setRowCount(0);
        String trangThai = "";
        for(NhanVienViewModel nv : dsNhanVien){
            if (nv.getTrangThai() == 0) {
                    trangThai = "Đi làm";
                } else {
                    trangThai = "Ở Nhà";
                }
            Object[] row = new Object[]{
                nv.getId(),
                nv.getMa(),
                nv.getTen(),
                nv.getGioiTinh(),
                nv.getNgaySinh(),
                nv.getChucVu(),
                nv.getCuaHang(),
                trangThai
            };
            tableModel.addRow(row);
        }
        
    }
    
    
    public void showDetail(int index) {
        NhanVien nv = NVservice.getNVByMa(dsNhanVien.get(index).getMa());
        txtMaNV.setText(nv.getMa());
        txtNameNV.setText(nv.getTen());
        txtPassNV.setText(nv.getMatKhau());
        txtNgaySinhNV.setText(nv.getNgaySinh() + "");
        txtSDTNV.setText(nv.getSdt());
        txtDiaChiNV.setText(nv.getDiaChi());
        cboChucVu.setSelectedItem(nv.getChucVu().toString());
        cboCuaHang.setSelectedItem(nv.getCuaHang().toString());
        if (nv.getGioiTinh().equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        if (nv.getTrangThai() == 0) {
            rdoDiLam.setSelected(true);
        } else {
            rdoONhan.setSelected(true);
        }
    }
    
    
    public boolean chk(){
        if (Chk.chknull("Vui lòng nhập mã NV", txtMaNV)) {
            return false;
        } else if (Chk.chknull("Vui lòng nhập mật khẩu", txtPassNV)) {
            return false;
        } else if (Chk.chknull("Vui lòng nhập họ tên", txtNameNV)) {
            return false;
        } else if (Chk.chknull("Vui lòng nhập ngày sinh", txtNgaySinhNV)) {
            return false;
        } else if (txtNameNV.getText().split(" ").length < 3) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ họ tên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (Chk.chknull("Vui lòng nhập số điện thoại", txtSDTNV)) {
            return false;
        } else if (Chk.chknull("Vui lòng nhập địa chỉ", txtDiaChiNV)) {
            return false;
        } else {
            return true;
        }
    }
    
    
    public NhanVien getNhanVien(){
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String maCH = cboCuaHang.getSelectedItem().toString().split(" ")[0];
        CuaHang ch = CHservice.getCuaHangByMa(maCH);
        String maCV = cboChucVu.getSelectedItem().toString().split(" ")[0];
        ChucVu cv = CVservice.getChucVuByMa(maCV);
        String gioitinh = "";
        if (rdoNam.isSelected() == true) {
            gioitinh = "Nam";
        } else {
            gioitinh = "Nữ";
        }
        int tt = 0;
        if (rdoONhan.isSelected() == true) {
            tt = 1;
        }
        NhanVien nv;
        try {
            nv = new NhanVien(
                    txtMaNV.getText(), 
                    txtNameNV.getText(), 
                    gioitinh, 
                    fm.parse(txtNgaySinhNV.getText()), 
                    txtDiaChiNV.getText(), 
                    txtSDTNV.getText(), 
                    txtPassNV.getText(), 
                    ch, 
                    cv, 
                    tt);
            return nv;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngay Sinh không đúng định dạng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
    
    public void fillcboCV() {
        dsChucVu = CVservice.layDanhSachChucVu();
        cboChucVu.removeAllItems();
        for (ChucVuViewModel chucVu_View : dsChucVu) {
            cboChucVu.addItem(chucVu_View.toString());
        }
    }

    public void fillcboCH() {
        dsCuaHang = CHservice.layDanhSachCuaHang();
        cboCuaHang.removeAllItems();
        for (CuaHangViewModel chucVu_View : dsCuaHang) {
            cboCuaHang.addItem(chucVu_View.toString());
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel12 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPassNV = new javax.swing.JPasswordField();
        chkShowPassNV = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        txtNameNV = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        txtNgaySinhNV = new javax.swing.JTextField();
        txtSDTNV = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDiaChiNV = new javax.swing.JTextField();
        cboCuaHang = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cboChucVu = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        rdoDiLam = new javax.swing.JRadioButton();
        rdoONhan = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnForm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel12.setText("Mã");

        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });

        jLabel13.setText("Pass");

        txtPassNV.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPassNV.setToolTipText("");

        chkShowPassNV.setText("Hiển Thị Mật Khẩu");
        chkShowPassNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowPassNVActionPerformed(evt);
            }
        });

        jLabel14.setText("Họ Tên");

        jLabel21.setText("Giới Tính");

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });

        jLabel15.setText("Ngày Sinh");

        jLabel19.setText("SDT");

        jLabel16.setText("Địa Chỉ");

        cboCuaHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel17.setText("Cửa Hàng");

        jLabel18.setText("Chức Vụ");

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel28.setText("Trạng Thái");

        buttonGroup2.add(rdoDiLam);
        rdoDiLam.setSelected(true);
        rdoDiLam.setText("Đi Làm");

        buttonGroup2.add(rdoONhan);
        rdoONhan.setText("Ở Nhà");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("QUẢN LÝ NHÂN VIÊN");

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnForm.setText("Form");
        btnForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnForm)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoDiLam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdoONhan))
                            .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameNV, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(chkShowPassNV)
                                .addGap(2, 2, 2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdoNu))
                            .addComponent(txtNgaySinhNV)
                            .addComponent(txtSDTNV)
                            .addComponent(txtDiaChiNV)
                            .addComponent(cboCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPassNV, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua)
                            .addComponent(btnThem)
                            .addComponent(btnXoa))))
                .addGap(25, 33, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboChucVu, cboCuaHang, txtDiaChiNV, txtNameNV, txtNgaySinhNV, txtSDTNV});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSua, btnThem, btnXoa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnForm))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPassNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(chkShowPassNV)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNameNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaySinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnXoa)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(rdoDiLam))
                    .addComponent(rdoONhan))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSua, btnThem, btnXoa});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void chkShowPassNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowPassNVActionPerformed
        // TODO add your handling code here:
        if (chkShowPassNV.isSelected() == false) {
            txtPassNV.setEchoChar('*');
        } else {
            txtPassNV.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_chkShowPassNVActionPerformed

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamActionPerformed

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNuActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int index = tblNhanVien.getSelectedRow();
        showDetail(index);
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (chk()) {
            if (NVservice.getNVByMa(txtMaNV.getText()) == null) {
                NVservice.add(getNhanVien());
                loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Đã có mã này trong database", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (chk()) {
            if (NVservice.getNVByMa(txtMaNV.getText()) != null) {
                NVservice.update(getNhanVien());
                loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Nhân Viên không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String str = JOptionPane.showInputDialog(this, "Vui lòng nhập mã:", "Xoá", JOptionPane.QUESTION_MESSAGE);
        try {
            if (str.isBlank()) {
                return;
            }
            if (NVservice.getNVByMa(str) != null) {
                int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá không ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    NVservice.delete(str);
                    loadTable();
                }
            }else {
                JOptionPane.showMessageDialog(this, "Không tồn tại mã này trong database", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormActionPerformed
        new FormNhanVien().setVisible(true);
    }//GEN-LAST:event_btnFormActionPerformed

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
            java.util.logging.Logger.getLogger(ViewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnForm;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JComboBox<String> cboCuaHang;
    private javax.swing.JCheckBox chkShowPassNV;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoDiLam;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoONhan;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNameNV;
    private javax.swing.JTextField txtNgaySinhNV;
    private javax.swing.JPasswordField txtPassNV;
    private javax.swing.JTextField txtSDTNV;
    // End of variables declaration//GEN-END:variables
}
