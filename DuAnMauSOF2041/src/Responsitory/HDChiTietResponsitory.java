/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import java.util.ArrayList;
import java.util.List;
import DomainModel.HDChiTiet;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import DomainModel.ChiTietSP;
import DomainModel.DongSP;
import DomainModel.HoaDon;
import DomainModel.MauSac;
import DomainModel.NSX;
import DomainModel.SanPham;
import Utilities.JDBCHelpers;

/**
 *
 * @author baphuoc
 */
public  class HDChiTietResponsitory implements InterfaceHDChiTietResponsitory{

    
    public  List<HDChiTiet> getHDCTByMaHD(String ma) {
        List<HDChiTiet> list = new ArrayList<>();
        String sql = """
                     SELECT HoaDon.id, HoaDon.Ma,HoaDon.NgayTao,HoaDon.TinhTrang,
                     ChiTietSP.id,SanPham.Ma, SanPham.Ten, Nsx.Ma, Nsx.Ten, MauSac.Ma, MauSac.Ten, DongSP.Ma, DongSP.Ten, NamBH,MoTa, SoLuongTon,GiaNhap,GiaBan,
                     SoLuong,
                     DonGia
                     FROM HoaDonChiTiet 
                     Join HoaDon ON HoaDon.id = HoaDonChiTiet.idHoaDon
                     join ChiTietSP on ChiTietSP.id = HoaDonChiTiet.idChiTietSP
                     Join SanPham on ChiTietSP.idSP = SanPham.id
                     join Nsx on ChiTietSP.IdNsx = Nsx.Id
                     join MauSac on ChiTietSP.IdMauSac = MauSac.Id
                     Join DongSP on ChiTietSP.IdDongSP = DongSP.Id WHERE HoaDon.Ma = ?""";
        ResultSet rs = JDBCHelpers.executeQuery(sql, ma);
        try {
            while (rs.next()) {
                HoaDon h = new HoaDon(rs.getString(1),rs.getString(2), rs.getDate(3), rs.getInt(4));
                SanPham sp = new SanPham(rs.getString(6), rs.getString(7));
                NSX NSX = new NSX(rs.getString(8), rs.getString(9));
                MauSac ms = new MauSac(rs.getString(10), rs.getString(11));
                DongSP d = new DongSP(rs.getString(12), rs.getString(13));
                int nambh = Integer.parseInt(rs.getString(14));
                String mota = rs.getString(15);
                int SL = Integer.parseInt(rs.getString(16));
                int gianhap = Integer.parseInt(rs.getString(17));
                int giaBan = Integer.parseInt(rs.getString(18));
                ChiTietSP spCT = new ChiTietSP(rs.getString(5),sp, NSX, ms, d, nambh, mota, SL, gianhap, giaBan);
                int soLuong = rs.getInt(19);
                float dongia = rs.getFloat(20);
                list.add(new HDChiTiet(h, spCT, soLuong, dongia));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(HDChiTietResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    public  int addSP(HDChiTiet h){
        String sql = "INSERT INTO HoaDonChiTiet(idHoaDon,idChiTietSP,SoLuong,DonGia) VALUES (?,?,?,?)";
        return JDBCHelpers.executeUpdate(sql,h.getHoaDon().getId(),h.getChiTietSP().getId(),h.getSL(),h.getDonGia());
    }

    
    public int updateSL(HDChiTiet h) {
        String sql = "UPDATE HoaDonChiTiet SET SoLuong = ?, DonGia = ? WHERE idHoaDon= ? and idChiTietSP = ?";
        return JDBCHelpers.executeUpdate(sql,h.getSL(),h.getDonGia(),h.getHoaDon().getId(),h.getChiTietSP().getId());
    }

    
    public int delete(HDChiTiet h) {
        String sql = "DELETE FROM HoaDonChiTiet WHERE idHoaDon= ? and idChiTietSP = ?";
        return JDBCHelpers.executeUpdate(sql,h.getHoaDon().getId(),h.getChiTietSP().getId());
    }
    
}
