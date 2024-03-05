/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory;

import DomainModel.SanPham;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceSanPhamResponsitory {
    ArrayList<SanPham> read();
    SanPham getSanPhamByMa(String Ma);
    int add(SanPham sp);
    int delete(String Ma);
    int update(SanPham sp);
    ArrayList<SanPham> SearchSP(String KeyWord);
}
