/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import DomainModel.HoaDon;
import Responsitory.HoaDonResponsitory;
import ViewModels.HoaDon_QLHoaDon;

/**
 *
 * @author baphuoc
 */
public class HoaDonService implements InterfaceHoaDonService {
    HoaDonResponsitory HoaDon = new HoaDonResponsitory();
   
    
    public HoaDon getHDByMa(String ma) {
        return HoaDon.getHDByMa(ma);
    }

    
    public int add(HoaDon h) {
        return HoaDon.add(h);
    }

    
    public int ThanhToan(HoaDon h) {
        return HoaDon.ThanhToan(h);
    }

   
    public List<HoaDon_QLHoaDon> getViewHoaDon() {
        List<HoaDon_QLHoaDon> listViewHD = new ArrayList<>();
        List<HoaDon> listHD = HoaDon.getAllHD();
        int i = 1;
        for (HoaDon h : listHD) {
            listViewHD.add(new HoaDon_QLHoaDon(i,h.getMa(),h.getNgayTao(),"",h.getTrangThai()));
            i++;
        }
        return listViewHD;
    }

    
    public List<HoaDon_QLHoaDon> getViewHoaDonByTT(Integer TinhTrang) {
        List<HoaDon_QLHoaDon> listViewHD = new ArrayList<>();
        List<HoaDon> listHD = HoaDon.getHDByTT(TinhTrang);
        int i = 1;
        for (HoaDon h : listHD) {
            listViewHD.add(new HoaDon_QLHoaDon(i,h.getMa(),h.getNgayTao(),"",h.getTrangThai()));
            i++;
        }
        return listViewHD;
    }
}
