/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory;

import DomainModel.NhanVien;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceNhanVienResponsitory {
    ArrayList<NhanVien> read();
    NhanVien getNVByMa(String ma);
    ArrayList<NhanVien> findNV(String ketWord);
    int add(NhanVien nv);
    int update(NhanVien nv);
    int delete(String Ma);
}
