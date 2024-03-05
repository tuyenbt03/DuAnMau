/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.ChiTietSP;
import Responsitory.SPChiTietResponsitory;
import Responsitory.InterfaceChiTietSPResponsitory;
import ViewModels.CTSPViewModel;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class ChiTietSPService implements InterfaceChiTietSPService{
    private InterfaceChiTietSPResponsitory responsitory = new SPChiTietResponsitory();
    
    public ArrayList<CTSPViewModel> layDanhSachNhanVien(){
        ArrayList<CTSPViewModel> dsCTSPViewModel = new ArrayList<>();
        
        ArrayList<ChiTietSP> dsChiTietSP = responsitory.read();
        int i = 1;
        for(ChiTietSP S : dsChiTietSP){
            dsCTSPViewModel.add(new CTSPViewModel(i,S.getId(), S.getSanPham().getMa(), S.getSanPham().getTen(), S.getMauSac().getTen(), S.getNamBH(), S.getMoTa(),S.getSlTon(), S.getGiaNhap(), S.getGiaBan()));
            i++;
        }
        return dsCTSPViewModel;
    }
    
    @Override
    public ArrayList<CTSPViewModel> getCTSPByMaSPView(String MaSP){
        ArrayList<CTSPViewModel> dsCTSPViewModel = new ArrayList<>();
        
        ArrayList<ChiTietSP> dsChiTietSP = responsitory.getCTSPByMaSP(MaSP);
        int i = 1;
        for(ChiTietSP S : dsChiTietSP){
            dsCTSPViewModel.add(new CTSPViewModel(i,S.getId(), S.getSanPham().getMa(), S.getSanPham().getTen(), S.getMauSac().getTen(), S.getNamBH(), S.getMoTa(),S.getSlTon(), S.getGiaNhap(), S.getGiaBan()));
            i++;
        }
        return dsCTSPViewModel;
    } 
    
    @Override
    public  int add(ChiTietSP sp){
        return responsitory.add(sp);
    }
    
    @Override
    public  int deleteBySP(String idSP){
        return responsitory.deleteBySP(idSP);
    }
    
    @Override
    public  int deleteByColor(String id){
        return responsitory.deleteByColor(id);
    }
    
    @Override
    public  int deleteByNSX(String id){
        return responsitory.deleteByNSX(id);
    }
    
    @Override
    public  int deleteByDongSP(String id){
        return responsitory.deleteByDongSP(id);
    }
    
    @Override
    public  int delete(String id){
        return responsitory.delete(id);
    }
    
    @Override
    public  int update(ChiTietSP sp){
        return responsitory.update(sp);
    }
    
    @Override
    public  int update(ChiTietSP sp, int SL){
        return responsitory.update(sp, SL);
    }
    
    @Override
    public ArrayList<CTSPViewModel> search(String keyWord){
        ArrayList<CTSPViewModel> dsCTSPViewModel = new ArrayList<>();
        
        ArrayList<ChiTietSP> dsChiTietSP = responsitory.search(keyWord);
        int i = 1;
        for(ChiTietSP S : dsChiTietSP){
            dsCTSPViewModel.add(new CTSPViewModel(i,S.getId(), S.getSanPham().getMa(), S.getSanPham().getTen(), S.getMauSac().getTen(), S.getNamBH(), S.getMoTa(),S.getSlTon(), S.getGiaNhap(), S.getGiaBan()));
            i++;
        }
        return dsCTSPViewModel;
    }
    
    @Override
    public ChiTietSP getCTSP(String MaSP,String maMau){
        return responsitory.getCTSP(MaSP, maMau);
    }
    
    @Override
    public ChiTietSP getCTSPByid(String idctSP){
        return responsitory.getCTSPByid(idctSP);
    }
}
