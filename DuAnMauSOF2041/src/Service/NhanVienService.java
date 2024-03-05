/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.NhanVien;
import Responsitory.NhanVienResponsitory;
import Responsitory.InterfaceNhanVienResponsitory;
import ViewModels.NhanVienViewModel;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class NhanVienService implements InterfaceNhanVienService{
    private InterfaceNhanVienResponsitory responsitory = new NhanVienResponsitory();
    
    @Override
    public ArrayList<NhanVienViewModel> layDanhSachNhanVien(){
        ArrayList<NhanVienViewModel> dsNhanVienViewModel = new ArrayList<>();
        
        ArrayList<NhanVien> dsNhanVien = responsitory.read();
        for(NhanVien nv : dsNhanVien){
            NhanVienViewModel nhanVienViewModel = new NhanVienViewModel();
            nhanVienViewModel.setId(nv.getId().toUpperCase());
            nhanVienViewModel.setMa(nv.getMa());
            nhanVienViewModel.setTen(nv.getTen());
            nhanVienViewModel.setGioiTinh(nv.getGioiTinh());
            nhanVienViewModel.setNgaySinh(nv.getNgaySinh());
            nhanVienViewModel.setChucVu(nv.getChucVu().getTen());
            nhanVienViewModel.setCuaHang(nv.getCuaHang().getTen());
            nhanVienViewModel.setTrangThai(nv.getTrangThai());
            dsNhanVienViewModel.add(nhanVienViewModel);
        }
        return dsNhanVienViewModel;
    }
    
    public NhanVien getNVByMa(String ma){
        return responsitory.getNVByMa(ma);
    }
    
    public ArrayList<NhanVienViewModel> findNV(String ketWord){
        ArrayList<NhanVienViewModel> dsNhanVienViewModel = new ArrayList<>();
        
        ArrayList<NhanVien> dsNhanVien = responsitory.read();
        for(NhanVien nv : dsNhanVien){
            NhanVienViewModel nhanVienViewModel = new NhanVienViewModel();
            nhanVienViewModel.setId(nv.getId().toUpperCase());
            nhanVienViewModel.setMa(nv.getMa());
            nhanVienViewModel.setTen(nv.getTen());
            nhanVienViewModel.setGioiTinh(nv.getGioiTinh());
            nhanVienViewModel.setNgaySinh(nv.getNgaySinh());
            nhanVienViewModel.setChucVu(nv.getChucVu().getTen());
            nhanVienViewModel.setCuaHang(nv.getCuaHang().getTen());
            nhanVienViewModel.setTrangThai(nv.getTrangThai());
            dsNhanVienViewModel.add(nhanVienViewModel);
        }
        return dsNhanVienViewModel;
    }
    
    public int add(NhanVien nv){
        return responsitory.add(nv);
    }
    
    public int update(NhanVien nv){
        return responsitory.update(nv);
    }
    
    public int delete(String Ma){
        return responsitory.delete(Ma);
    }
}
