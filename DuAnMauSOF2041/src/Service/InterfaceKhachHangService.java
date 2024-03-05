/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.KhachHang;
import ViewModels.KhachHangViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceKhachHangService {
    ArrayList<KhachHangViewModel> layDanhSachKhachHang();
    KhachHang getKHByMa(String ma);
    ArrayList<KhachHangViewModel> findKH(String keyWord);
    int add(KhachHang kh);
    int update(KhachHang kh);
    int delete(String Ma);
}
