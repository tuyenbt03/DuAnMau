/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.NhanVien;
import ViewModels.NhanVienViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceNhanVienService {
    ArrayList<NhanVienViewModel> layDanhSachNhanVien();
    NhanVien getNVByMa(String ma);
    ArrayList<NhanVienViewModel> findNV(String ketWord);
    int add(NhanVien nv);
    int update(NhanVien nv);
    int delete(String Ma);
}
