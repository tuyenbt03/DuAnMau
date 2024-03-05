/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory;

import DomainModel.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceKhachHangResponsitory {
    ArrayList<KhachHang> read();
    KhachHang getKHByMa(String ma);
    ArrayList<KhachHang> findKH(String keyWord);
    int add(KhachHang kh);
    int update(KhachHang kh);
    int delete(String Ma);
}
