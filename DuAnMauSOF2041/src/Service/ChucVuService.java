/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.ChucVu;
import Responsitory.ChucVuResponsitory;
import Responsitory.InterfaceChucVuResponsitory;
import ViewModels.ChucVuViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ChucVuService implements InterfaceChucVuService{
    private InterfaceChucVuResponsitory responsitory = new ChucVuResponsitory();
    
    public ArrayList<ChucVuViewModel> layDanhSachChucVu(){
        ArrayList<ChucVuViewModel> dsChucVuViewModel = new ArrayList<>();
        
        ArrayList<ChucVu> dsChucVu = responsitory.read();
        for(ChucVu cv : dsChucVu){
            ChucVuViewModel chucVuViewModel = new ChucVuViewModel();
            chucVuViewModel.setId(cv.getId().toUpperCase());
            chucVuViewModel.setMa(cv.getMa());
            chucVuViewModel.setTen(cv.getTen());
            dsChucVuViewModel.add(chucVuViewModel);
        }
        return dsChucVuViewModel;
    }
    
    @Override
    public ChucVu getChucVuByMa(String Ma){
        return responsitory.getChucVuByMa(Ma);
    }
    
    @Override
    public int add(ChucVu cv){
        return responsitory.add(cv);
    }
    
    @Override
    public int delete(String Ma){
        return responsitory.delete(Ma);
    }
    
    @Override
    public int update(ChucVu cv){
        return responsitory.update(cv);
    }
}
