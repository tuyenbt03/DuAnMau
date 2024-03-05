/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.NSX;
import ViewModels.NSXViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceNSXService {
    ArrayList<NSXViewModel> layDanhSachNSX();
    NSX getNSXByMa(String Ma);
    int add(NSX nsx);
    int delete(String Ma);
    int update(NSX nsx);
}
