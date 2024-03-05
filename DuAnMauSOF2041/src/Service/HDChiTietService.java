/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import DomainModel.HDChiTiet;
import Responsitory.HDChiTietResponsitory;
import ViewModels.GioHang_QLHoaDon;

/**
 *
 * @author baphuoc
 */
public class HDChiTietService implements InterfaceHDChiTietService {

    HDChiTietResponsitory HDCT = new HDChiTietResponsitory();

    
    public List<HDChiTiet> getHDCTByMaHD(String ma) {
        return HDCT.getHDCTByMaHD(ma);
    }

   
    
    public int addSP(HDChiTiet h) {
        return HDCT.addSP(h);
    }

    
    public List<GioHang_QLHoaDon> getHDCTView(String ma) {
        List<HDChiTiet> listHDCT = HDCT.getHDCTByMaHD(ma);
        List<GioHang_QLHoaDon> listGH = new ArrayList<>();
        int stt = 1;
        for (HDChiTiet h : listHDCT) {
            listGH.add(new GioHang_QLHoaDon(stt, h.getChiTietSP().getSanPham().getMa(), h.getChiTietSP().getMauSac().getTen(), h.getSL(), h.getChiTietSP().getGiaBan(), h.getDonGia()));
            stt++;
        }
        System.out.println("asd");
        return listGH;
    }

    
    public int updateSL(HDChiTiet h) {
        return HDCT.updateSL(h);
    }

    
    public int delete(HDChiTiet h) {
        return HDCT.delete(h);
    }
}
