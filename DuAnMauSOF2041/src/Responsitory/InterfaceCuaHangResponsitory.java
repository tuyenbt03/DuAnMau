/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory;

import DomainModel.CuaHang;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceCuaHangResponsitory {
    ArrayList<CuaHang> read();
    CuaHang getCuaHangByMa(String Ma);
    int add(CuaHang ch);
    int delete(String Ma);
    int update(CuaHang ch);
}
