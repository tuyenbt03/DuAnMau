/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.DongSP;
import ViewModels.DongSPViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceDongSPService {
    ArrayList<DongSPViewModel> layDanhSachDongSP();
    DongSP getDongSPByMa(String Ma);
    int add(DongSP dsp);
    int delete(String Ma);
    int update(DongSP dsp);
}
