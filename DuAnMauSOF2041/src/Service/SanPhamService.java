/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.SanPham;
import Responsitory.SanPhamResponsitory;
import Responsitory.InterfaceSanPhamResponsitory;
import ViewModels.SanPhamViewModel;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class SanPhamService implements InterfaceSanPhamService{
    private InterfaceSanPhamResponsitory responsitory = new SanPhamResponsitory();
    
    public ArrayList<SanPhamViewModel> layDanhSachSanPham(){
        ArrayList<SanPhamViewModel> dsSanPhamViewModel = new ArrayList<>();
        
        ArrayList<SanPham> dsSanPham = responsitory.read();
        for(SanPham cv : dsSanPham){
            SanPhamViewModel sanPhamViewModel = new SanPhamViewModel();
            sanPhamViewModel.setId(cv.getId().toUpperCase());
            sanPhamViewModel.setMa(cv.getMa());
            sanPhamViewModel.setTen(cv.getTen());
            dsSanPhamViewModel.add(sanPhamViewModel);
        }
        return dsSanPhamViewModel;
    }
    
    @Override
    public SanPham getSanPhamByMa(String Ma){
        return responsitory.getSanPhamByMa(Ma);
    }
    
    @Override
    public int add(SanPham sp){
        return responsitory.add(sp);
    }
    
    @Override
    public int delete(String Ma){
        return responsitory.delete(Ma);
    }
    
    @Override
    public int update(SanPham sp){
        return responsitory.update(sp);
    }
    
    public ArrayList<SanPhamViewModel> SearchSP(String KeyWord){
        ArrayList<SanPhamViewModel> dsSanPhamViewModel = new ArrayList<>();
        
        ArrayList<SanPham> dsSanPham = responsitory.SearchSP(KeyWord);
        for(SanPham cv : dsSanPham){
            SanPhamViewModel sanPhamViewModel = new SanPhamViewModel();
            sanPhamViewModel.setId(cv.getId().toUpperCase());
            sanPhamViewModel.setMa(cv.getMa());
            sanPhamViewModel.setTen(cv.getTen());
            dsSanPhamViewModel.add(sanPhamViewModel);
        }
        return dsSanPhamViewModel;
    }
}
