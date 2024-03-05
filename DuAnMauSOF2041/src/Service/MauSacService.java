/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.MauSac;
import Responsitory.InterfaceMauSacResponsitory;
import Responsitory.MauSacResponsitory;
import ViewModels.MauSacViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class MauSacService implements InterfaceMauSacService{
    private InterfaceMauSacResponsitory responsitory = new MauSacResponsitory();
    
    
    public ArrayList<MauSacViewModel> layDanhSachMauSac(){
        ArrayList<MauSacViewModel> dsMauSacViewModel = new ArrayList<>();
        
        ArrayList<MauSac> dsMauSac = responsitory.read();
        for(MauSac ms : dsMauSac){
            MauSacViewModel mauSacViewModel = new MauSacViewModel();
            mauSacViewModel.setId(ms.getId().toUpperCase());
            mauSacViewModel.setMa(ms.getMa());
            mauSacViewModel.setTen(ms.getTen());
            dsMauSacViewModel.add(mauSacViewModel);
        }
        return dsMauSacViewModel;
    }
    
    @Override
    public MauSac getChucVuByMa(String Ma){
        return responsitory.getChucVuByMa(Ma);
    }
    
    @Override
    public int add(MauSac ms){
        return responsitory.add(ms);
    }
    
    @Override
    public int delete(String Ma){
        return responsitory.delete(Ma);
    }
    
    @Override
    public int update(MauSac ms){
        return responsitory.update(ms);
    }
}
