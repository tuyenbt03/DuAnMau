/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.KhachHang;
import Responsitory.KhachHangResponsitory;
import Responsitory.InterfaceKhachHangResponsitory;
import ViewModels.KhachHangViewModel;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class KhachHangService implements InterfaceKhachHangService{
    private InterfaceKhachHangResponsitory responsitory = new KhachHangResponsitory();
    
    public ArrayList<KhachHangViewModel> layDanhSachKhachHang(){
        ArrayList<KhachHangViewModel> dsKhachHangViewModel = new ArrayList<>();
        
        ArrayList<KhachHang> dsKhachHang = responsitory.read();
        for(KhachHang kh : dsKhachHang){
            KhachHangViewModel khachHangViewModel = new KhachHangViewModel();
            khachHangViewModel.setId(kh.getId().toUpperCase());
            khachHangViewModel.setMa(kh.getMa());
            khachHangViewModel.setHoTen(kh.getHoTen());
            khachHangViewModel.setNgaySinh(kh.getNgaySinh());
            khachHangViewModel.setSdt(kh.getSdt());
            khachHangViewModel.setDiaChi(kh.getDiaChi());
            khachHangViewModel.setThanhPho(kh.getThanhPho());
            khachHangViewModel.setQuocGia(kh.getQuocGia());
            dsKhachHangViewModel.add(khachHangViewModel);
        }
        return dsKhachHangViewModel;
    }
    
    public KhachHang getKHByMa(String ma){
        return responsitory.getKHByMa(ma);
    }
    
    public ArrayList<KhachHangViewModel> findKH(String keyWord){
        ArrayList<KhachHangViewModel> dsKhachHangViewModel = new ArrayList<>();
        
        ArrayList<KhachHang> dsKhachHang = responsitory.findKH(keyWord);
        for(KhachHang kh : dsKhachHang){
            KhachHangViewModel khachHangViewModel = new KhachHangViewModel();
            khachHangViewModel.setId(kh.getId().toUpperCase());
            khachHangViewModel.setMa(kh.getMa());
            khachHangViewModel.setHoTen(kh.getHoTen());
            khachHangViewModel.setNgaySinh(kh.getNgaySinh());
            khachHangViewModel.setSdt(kh.getSdt());
            khachHangViewModel.setDiaChi(kh.getDiaChi());
            khachHangViewModel.setThanhPho(kh.getThanhPho());
            khachHangViewModel.setQuocGia(kh.getQuocGia());
            dsKhachHangViewModel.add(khachHangViewModel);
        }
        return dsKhachHangViewModel;
    }
    
    public int add(KhachHang kh){
        return responsitory.add(kh);
    }
    
    public int update(KhachHang kh){
        return responsitory.update(kh);
    }
    
    public int delete(String Ma){
        return responsitory.delete(Ma);
    }
}
