/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import DomainModel.ChiTietSP;
import DomainModel.SanPham;
import DomainModel.NSX;
import DomainModel.MauSac;
import DomainModel.DongSP;
import Utilities.DBContext;
import Utilities.JDBCHelpers;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Admin
 */
public class SPChiTietResponsitory implements InterfaceChiTietSPResponsitory{
    @Override
    public ArrayList<ChiTietSP> read(){
        ArrayList<ChiTietSP> list = new ArrayList<>();
        String sql = "SELECT ChiTietSP.id ,SanPham.Ma, SanPham.Ten, Nsx.Ma, Nsx.Ten, MauSac.Ma, MauSac.Ten, DongSP.Ma, DongSP.Ten, NamBH,MoTa, SoLuongTon,GiaNhap,GiaBan FROM ChiTietSP \n"
                + "                Join SanPham on ChiTietSP.idSP = SanPham.id\n"
                + "                join Nsx on ChiTietSP.IdNsx = Nsx.Id\n"
                + "                join MauSac on ChiTietSP.IdMauSac = MauSac.Id\n"
                + "                Join DongSP on ChiTietSP.IdDongSP = DongSP.Id\n"
                + "                order by SanPham.Ma";
        ResultSet rs = JDBCHelpers.executeQuery(sql);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                SanPham sp = new SanPham(rs.getString(2), rs.getString(3));
                NSX NSX = new NSX(rs.getString(4), rs.getString(5));
                MauSac ms = new MauSac(rs.getString(6), rs.getString(7));
                DongSP d = new DongSP(rs.getString(8), rs.getString(9));
                int nambh = Integer.parseInt(rs.getString(10));
                String mota = rs.getString(11);
                int SL = Integer.parseInt(rs.getString(12));
                int gianhap = Integer.parseInt(rs.getString(13));
                int giaBan = Integer.parseInt(rs.getString(14));
                list.add(new ChiTietSP(id, sp, NSX, ms, d, nambh, mota, SL, gianhap, giaBan));
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(SPChiTietResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public ArrayList<ChiTietSP> getCTSPByMaSP(String MaSP){
        ArrayList<ChiTietSP> list = new ArrayList<>();
        String sql = "SELECT ChiTietSP.id,SanPham.Ma, SanPham.Ten, Nsx.Ma, Nsx.Ten, MauSac.Ma, MauSac.Ten, DongSP.Ma, DongSP.Ten, NamBH,MoTa, SoLuongTon,GiaNhap,GiaBan FROM ChiTietSP \n"
                + "                Join SanPham on ChiTietSP.idSP = SanPham.id\n"
                + "                join Nsx on ChiTietSP.IdNsx = Nsx.Id\n"
                + "                join MauSac on ChiTietSP.IdMauSac = MauSac.Id\n"
                + "                Join DongSP on ChiTietSP.IdDongSP = DongSP.Id\n"
                + "WHERE SanPham.Ma = ?\n"
                + "                order by SanPham.Ma";
        ResultSet rs = JDBCHelpers.executeQuery(sql, MaSP);
        try {
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(2), rs.getString(3));
                NSX NSX = new NSX(rs.getString(4), rs.getString(5));
                MauSac ms = new MauSac(rs.getString(6), rs.getString(7));
                DongSP d = new DongSP(rs.getString(8), rs.getString(9));
                int nambh = Integer.parseInt(rs.getString(10));
                String mota = rs.getString(11);
                int SL = Integer.parseInt(rs.getString(12));
                int gianhap = Integer.parseInt(rs.getString(13));
                int giaBan = Integer.parseInt(rs.getString(14));
                list.add(new ChiTietSP(rs.getString(1),sp, NSX, ms, d, nambh, mota, SL, gianhap, giaBan));
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(SPChiTietResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public  int add(ChiTietSP sp) {
        String sql = "INSERT INTO ChiTietSP(IdSP, IdNsx, IdMauSac, IdDongSP, NamBH, Mota, SoLuongTon, GiaNhap, GiaBan) VALUES (?,?,?,?,?,?,?,?,?)";
        return JDBCHelpers.executeUpdate(sql, sp.getSanPham().getId(), sp.getNsx().getId(), sp.getMauSac().getId(), sp.getDongSP().getId(), sp.getNamBH(), sp.getMoTa(), sp.getSlTon(), sp.getGiaNhap(), sp.getGiaBan());
    }
    
    @Override
    public  int deleteBySP(String idSP) {
        String sql = "DELETE FROM ChiTietSP WHERE IdSP = ?";
        return JDBCHelpers.executeUpdate(sql, idSP);
    }
    
    @Override
    public  int deleteByColor(String id) {
        String sql = "DELETE FROM ChiTietSP WHERE IdMauSac = ?";
        return JDBCHelpers.executeUpdate(sql, id);
    }
    
    @Override
    public  int deleteByNSX(String id) {
        String sql = "DELETE FROM ChiTietSP WHERE IdNsx = ?";
        return JDBCHelpers.executeUpdate(sql, id);
    }
    
    @Override
    public  int deleteByDongSP(String id) {
        String sql = "DELETE FROM ChiTietSP WHERE IdDongSP = ?";
        return JDBCHelpers.executeUpdate(sql, id);
    }
    
    @Override
    public  int delete(String id) {
        String sql = "DELETE FROM ChiTietSP WHERE Id = ?";
        return JDBCHelpers.executeUpdate(sql, id);
    }
    
    @Override
    public  int update(ChiTietSP sp) {
        String sql = "UPDATE ChiTietSP SET IdNsx = ?, IdMauSac = ?, IdDongSP = ?, NamBH = ?, Mota = ?, SoLuongTon = ?, GiaNhap = ?, GiaBan = ? WHERE Id = ? ";
        return JDBCHelpers.executeUpdate(sql, sp.getNsx().getId(), sp.getMauSac().getId(), sp.getDongSP().getId(), sp.getNamBH(), sp.getMoTa(), sp.getSlTon(), sp.getGiaNhap(), sp.getGiaBan(), sp.getId());
    }
    
    @Override
    public  int update(ChiTietSP sp, int SL) {
        int SLSP = sp.getSlTon() - SL;
        String sql = "UPDATE ChiTietSP SET SoLuongTon = ? WHERE Id = ?  ";
        return JDBCHelpers.executeUpdate(sql, SLSP, sp.getId());
    }
    
    @Override
    public ArrayList<ChiTietSP> search(String keyWord) {
        ArrayList<ChiTietSP> list = new ArrayList<>();
        String sql = """
                     SELECT ChiTietSP.id, SanPham.Ma, SanPham.Ten, Nsx.Ma, Nsx.Ten, MauSac.Ma, MauSac.Ten, DongSP.Ma, DongSP.Ten, NamBH,MoTa, SoLuongTon,GiaNhap,GiaBan FROM ChiTietSP 
                                     Join SanPham on ChiTietSP.idSP = SanPham.id
                                     join Nsx on ChiTietSP.IdNsx = Nsx.Id
                                     join MauSac on ChiTietSP.IdMauSac = MauSac.Id
                                     Join DongSP on ChiTietSP.IdDongSP = DongSP.Id
                                     WHERE SanPham.Ten like CONCAT('%',?,'%') 
                     OR SanPham.Ma like CONCAT('%',?,'%') 
                     order by SanPham.Ma""";
        ResultSet rs = JDBCHelpers.executeQuery(sql, keyWord,keyWord);
        try {
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(2), rs.getString(3));
                NSX NSX = new NSX(rs.getString(4), rs.getString(5));
                MauSac ms = new MauSac(rs.getString(6), rs.getString(7));
                DongSP d = new DongSP(rs.getString(8), rs.getString(9));
                int nambh = Integer.parseInt(rs.getString(10));
                String mota = rs.getString(11);
                int SL = Integer.parseInt(rs.getString(12));
                int gianhap = Integer.parseInt(rs.getString(13));
                int giaBan = Integer.parseInt(rs.getString(14));
                list.add(new ChiTietSP(rs.getString(1),sp, NSX, ms, d, nambh, mota, SL, gianhap, giaBan));
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(SPChiTietResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public ChiTietSP getCTSP(String MaSP,String maMau) {
        ChiTietSP SP = null;
        String sql = "SELECT ChiTietSP.id ,SanPham.Ma, SanPham.Ten, Nsx.Ma, Nsx.Ten, MauSac.Ma, MauSac.Ten, DongSP.Ma, DongSP.Ten, NamBH,MoTa, SoLuongTon,GiaNhap,GiaBan FROM ChiTietSP \n"
                + "                Join SanPham on ChiTietSP.idSP = SanPham.id\n"
                + "                join Nsx on ChiTietSP.IdNsx = Nsx.Id\n"
                + "                join MauSac on ChiTietSP.IdMauSac = MauSac.Id\n"
                + "                Join DongSP on ChiTietSP.IdDongSP = DongSP.Id\n"
                + " WHERE SanPham.Ma = ? AND MauSac.Ma = ? "
                + "                order by SanPham.Ma";
        ResultSet rs = JDBCHelpers.executeQuery(sql,MaSP,maMau);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                SanPham sp = new SanPham(rs.getString(2), rs.getString(3));
                NSX NSX = new NSX(rs.getString(4), rs.getString(5));
                MauSac ms = new MauSac(rs.getString(6), rs.getString(7));
                DongSP d = new DongSP(rs.getString(8), rs.getString(9));
                int nambh = Integer.parseInt(rs.getString(10));
                String mota = rs.getString(11);
                int SL = Integer.parseInt(rs.getString(12));
                int gianhap = Integer.parseInt(rs.getString(13));
                int giaBan = Integer.parseInt(rs.getString(14));
                SP = new ChiTietSP(id, sp, NSX, ms, d, nambh, mota, SL, gianhap, giaBan);
            }
            return SP;

        } catch (SQLException ex) {
            Logger.getLogger(SPChiTietResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public ChiTietSP getCTSPByid(String idctSP) {
        ChiTietSP SP = null;
        String sql = """
                     SELECT ChiTietSP.id ,SanPham.Ma, SanPham.Ten, Nsx.Ma, Nsx.Ten, MauSac.Ma, MauSac.Ten, DongSP.Ma, DongSP.Ten, NamBH,MoTa, SoLuongTon,GiaNhap,GiaBan FROM ChiTietSP 
                                     Join SanPham on ChiTietSP.idSP = SanPham.id
                                     join Nsx on ChiTietSP.IdNsx = Nsx.Id
                                     join MauSac on ChiTietSP.IdMauSac = MauSac.Id
                                     Join DongSP on ChiTietSP.IdDongSP = DongSP.Id
                      WHERE ChiTietSP.id = ?""";
        ResultSet rs = JDBCHelpers.executeQuery(sql,idctSP);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                SanPham sp = new SanPham(rs.getString(2), rs.getString(3));
                NSX NSX = new NSX(rs.getString(4), rs.getString(5));
                MauSac ms = new MauSac(rs.getString(6), rs.getString(7));
                DongSP d = new DongSP(rs.getString(8), rs.getString(9));
                int nambh = Integer.parseInt(rs.getString(10));
                String mota = rs.getString(11);
                int SL = Integer.parseInt(rs.getString(12));
                int gianhap = Integer.parseInt(rs.getString(13));
                int giaBan = Integer.parseInt(rs.getString(14));
                SP = new ChiTietSP(id, sp, NSX, ms, d, nambh, mota, SL, gianhap, giaBan);
            }
            return SP;

        } catch (SQLException ex) {
            Logger.getLogger(SPChiTietResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
}
