/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.DongSP;
import Responsitory.DongSPResponsitory;
import Responsitory.InterfaceDongSPResponsitory;
import ViewModels.DongSPViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DongSPService implements InterfaceDongSPService{
    
    private InterfaceDongSPResponsitory responsitory = new DongSPResponsitory();
    
    public ArrayList<DongSPViewModel> layDanhSachDongSP(){
        ArrayList<DongSPViewModel> dsDongSPViewModel = new ArrayList<>();
        
        ArrayList<DongSP> dsDongSP = responsitory.read();
        for(DongSP dsp : dsDongSP){
            DongSPViewModel dongSPViewModel = new DongSPViewModel();
            dongSPViewModel.setId(dsp.getId().toUpperCase());
            dongSPViewModel.setMa(dsp.getMa());
            dongSPViewModel.setTen(dsp.getTen());
            dsDongSPViewModel.add(dongSPViewModel);
        }
        return dsDongSPViewModel;
    }
    
    @Override
    public DongSP getDongSPByMa(String Ma){
        return responsitory.getDongSPByMa(Ma);
    }
    
    @Override
    public int add(DongSP dsp){
        return responsitory.add(dsp);
    }
    
    
    
    public int delete(String Ma){
        return responsitory.delete(Ma);
    }
    
    @Override
    public int update(DongSP dsp){
        return responsitory.update(dsp);
    }
}
