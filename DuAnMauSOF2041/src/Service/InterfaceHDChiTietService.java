/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.List;
import DomainModel.HDChiTiet;
import ViewModels.GioHang_QLHoaDon;

/**
 *
 * @author baphuoc
 */
public interface InterfaceHDChiTietService {
    List<HDChiTiet> getHDCTByMaHD(String ma);
    int addSP(HDChiTiet h);
    List<GioHang_QLHoaDon> getHDCTView(String ma);
    int updateSL(HDChiTiet h);
    int delete(HDChiTiet h);
}
