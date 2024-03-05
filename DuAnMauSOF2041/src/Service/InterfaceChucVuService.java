/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.ChucVu;
import ViewModels.ChucVuViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceChucVuService {
    ArrayList<ChucVuViewModel> layDanhSachChucVu();
    ChucVu getChucVuByMa(String Ma);
    int add(ChucVu cv);
    int delete(String Ma);
    int update(ChucVu cv);
}
