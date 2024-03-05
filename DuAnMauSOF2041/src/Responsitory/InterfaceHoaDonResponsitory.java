/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory;

import service.*;
import java.util.List;
import DomainModel.HoaDon;

/**
 *
 * @author baphuoc
 */
public interface InterfaceHoaDonResponsitory {
    List<HoaDon> getAllHD();
    List<HoaDon> getHDByTT(Integer TinhTrang);
    HoaDon getHDByMa(String ma);
    int add(HoaDon h);
    int ThanhToan(HoaDon h);
}
