/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory;

import DomainModel.ChiTietSP;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceChiTietSPResponsitory {
    ArrayList<ChiTietSP> read();
    ArrayList<ChiTietSP> getCTSPByMaSP(String MaSP);
    int add(ChiTietSP sp);
    int deleteBySP(String idSP);
    int deleteByColor(String id);
    int deleteByNSX(String id);
    int deleteByDongSP(String id);
    int delete(String id);
    int update(ChiTietSP sp);
    int update(ChiTietSP sp, int SL);
    ArrayList<ChiTietSP> search(String keyWord);
    ChiTietSP getCTSP(String MaSP,String maMau);
    ChiTietSP getCTSPByid(String idctSP);
}
