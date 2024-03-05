/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.SanPham;
import ViewModels.SanPhamViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceSanPhamService {
    ArrayList<SanPhamViewModel> layDanhSachSanPham();
    SanPham getSanPhamByMa(String Ma);
    int add(SanPham sp);
    int delete(String Ma);
    int update(SanPham sp);
    ArrayList<SanPhamViewModel> SearchSP(String KeyWord);
}
