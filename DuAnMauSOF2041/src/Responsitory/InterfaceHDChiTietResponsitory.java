/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory;

import service.*;
import java.util.List;
import DomainModel.HDChiTiet;

/**
 *
 * @author baphuoc
 */
public interface InterfaceHDChiTietResponsitory {
    List<HDChiTiet> getHDCTByMaHD(String ma);
    int addSP(HDChiTiet h);
    int updateSL(HDChiTiet h);
    int delete(HDChiTiet h);
}
