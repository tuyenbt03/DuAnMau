/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.List;
import DomainModel.HoaDon;
import ViewModels.HoaDon_QLHoaDon;

/**
 *
 * @author baphuoc
 */
public interface InterfaceHoaDonService {
    HoaDon getHDByMa(String ma);
    int add(HoaDon h);
    int ThanhToan(HoaDon h);
    List<HoaDon_QLHoaDon> getViewHoaDon();
    List<HoaDon_QLHoaDon> getViewHoaDonByTT(Integer TinhTrang);
}
