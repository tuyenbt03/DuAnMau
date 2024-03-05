/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.MauSac;
import ViewModels.MauSacViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceMauSacService {
    ArrayList<MauSacViewModel> layDanhSachMauSac();
    MauSac getChucVuByMa(String Ma);
    int add(MauSac ms);
    int delete(String Ma);
    int update(MauSac ms);
}
