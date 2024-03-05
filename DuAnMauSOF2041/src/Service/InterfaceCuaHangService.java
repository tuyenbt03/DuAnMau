/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.CuaHang;
import ViewModels.CuaHangViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceCuaHangService {
    ArrayList<CuaHangViewModel> layDanhSachCuaHang();
    CuaHang getCuaHangByMa(String Ma);
    int add(CuaHang ch);
    int delete(String Ma);
    int update(CuaHang ch);
}
