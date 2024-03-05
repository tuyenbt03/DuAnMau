/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.CuaHang;
import Responsitory.CuaHangResponsitory;
import Responsitory.InterfaceCuaHangResponsitory;
import ViewModels.CuaHangViewModel;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class CuaHangService implements InterfaceCuaHangService{
    private InterfaceCuaHangResponsitory responsitory = new CuaHangResponsitory();
    
    public ArrayList<CuaHangViewModel> layDanhSachCuaHang(){
        ArrayList<CuaHangViewModel> dsCuaHangViewModel = new ArrayList<>();
        
        ArrayList<CuaHang> dsCuaHang = responsitory.read();
        for(CuaHang ch : dsCuaHang){
            CuaHangViewModel cuaHangViewModel = new CuaHangViewModel();
            cuaHangViewModel.setId(ch.getId().toUpperCase());
            cuaHangViewModel.setMa(ch.getMa());
            cuaHangViewModel.setTen(ch.getTen());
            cuaHangViewModel.setDiaChi(ch.getDiaChi());
            cuaHangViewModel.setThanhPho(ch.getThanhPho());
            cuaHangViewModel.setQuocGia(ch.getQuocGia());
            dsCuaHangViewModel.add(cuaHangViewModel);
        }
        return dsCuaHangViewModel;
    }
    
    public CuaHang getCuaHangByMa(String Ma){
        return responsitory.getCuaHangByMa(Ma);
    }
    
    public int add(CuaHang ch){
        return responsitory.add(ch);
    }
    
    public int delete(String Ma){
        return responsitory.delete(Ma);
    }
    
    public int update(CuaHang ch){
        return responsitory.update(ch);
    }
}
