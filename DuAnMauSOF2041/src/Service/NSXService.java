/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.NSX;
import Responsitory.NSXResponsitory;
import Responsitory.InterfaceNSXResponsitory;
import ViewModels.NSXViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NSXService implements InterfaceNSXService{
    private InterfaceNSXResponsitory responsitory = new NSXResponsitory();
    
    public ArrayList<NSXViewModel> layDanhSachNSX(){
        ArrayList<NSXViewModel> dsNSXViewModel = new ArrayList<>();
        
        ArrayList<NSX> dsNSX = responsitory.read();
        for(NSX cv : dsNSX){
            NSXViewModel nsxViewModel = new NSXViewModel();
            nsxViewModel.setId(cv.getId().toUpperCase());
            nsxViewModel.setMa(cv.getMa());
            nsxViewModel.setTen(cv.getTen());
            dsNSXViewModel.add(nsxViewModel);
        }
        return dsNSXViewModel;
    }
    
    @Override
    public NSX getNSXByMa(String Ma){
        return responsitory.getNSXByMa(Ma);
    }
    
    @Override
    public int add(NSX nsx){
        return responsitory.add(nsx);
    }
    
    @Override
    public int delete(String Ma){
        return responsitory.delete(Ma);
    }
    
    @Override
    public int update(NSX nsx){
        return responsitory.update(nsx);
    }
    
}
