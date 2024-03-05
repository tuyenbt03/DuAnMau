/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.ChiTietSP;
import ViewModels.CTSPViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceChiTietSPService {
    ArrayList<CTSPViewModel> layDanhSachNhanVien();
    ArrayList<CTSPViewModel> getCTSPByMaSPView(String MaSP);
    int add(ChiTietSP sp);
    int deleteBySP(String idSP);
    int deleteByColor(String id);
    int deleteByNSX(String id);
    int deleteByDongSP(String id);
    int delete(String id);
    int update(ChiTietSP sp);
    int update(ChiTietSP sp, int SL);
    ArrayList<CTSPViewModel> search(String keyWord);
    ChiTietSP getCTSP(String MaSP,String maMau);
    ChiTietSP getCTSPByid(String idctSP);
}
