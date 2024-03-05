/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import DomainModel.NhanVien;
import DomainModel.ChucVu;
import DomainModel.CuaHang;
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
public class NhanVienResponsitory implements InterfaceNhanVienResponsitory{
    
    @Override
    public ArrayList<NhanVien> read(){
        ArrayList<NhanVien> dsNhanVien = new ArrayList<>();
        String sql = """
                     SELECT NhanVien.id,NhanVien.Ma,concat(NhanVien.Ho,' ',NhanVien.TenDem,' ',NhanVien.Ten),NhanVien.GioiTinh,NhanVien.NgaySinh,NhanVien.DiaChi,NhanVien.Sdt,NhanVien.MatKhau,
                     CuaHang.Ma,CuaHang.ten,CuaHang.DiaChi,CuaHang.ThanhPho,CuaHang.QuocGia,
                     ChucVu.Ma,ChucVu.Ten,
                     NhanVien.TrangThai
                     FROM NhanVien
                     Join CuaHang on CuaHang.id = NhanVien.IdCH
                     Join ChucVu on ChucVu.id = NhanVien.IdCV ORDER BY NhanVien.Ma """;
        ResultSet rs = JDBCHelpers.executeQuery(sql);
        try {
            while (rs.next()) {
                CuaHang ch = new CuaHang(rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
                ChucVu cv = new ChucVu(rs.getString(14), rs.getString(15));
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), ch, cv, rs.getInt(16));
                dsNhanVien.add(nv);
            }
            return dsNhanVien;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public NhanVien getNVByMa(String ma){
        NhanVien nv = null;
        String sql = "SELECT NhanVien.id,NhanVien.Ma,concat(NhanVien.Ho,' ',NhanVien.TenDem,' ',NhanVien.Ten),NhanVien.GioiTinh,NhanVien.NgaySinh,NhanVien.DiaChi,NhanVien.Sdt,NhanVien.MatKhau,\n"
                + "CuaHang.Ma,CuaHang.ten,CuaHang.DiaChi,CuaHang.ThanhPho,CuaHang.QuocGia,\n"
                + "ChucVu.Ma,ChucVu.Ten,\n"
                + "NhanVien.TrangThai\n"
                + "FROM NhanVien\n"
                + "Join CuaHang on CuaHang.id = NhanVien.IdCH\n"
                + "Join ChucVu on ChucVu.id = NhanVien.IdCV"
                + " WHERE NhanVien.Ma = ?";
        ResultSet rs = JDBCHelpers.executeQuery(sql, ma);
        try {
            while (rs.next()) {
                CuaHang ch = new CuaHang(rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
                ChucVu cv = new ChucVu(rs.getString(14), rs.getString(15));
                nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), ch, cv, rs.getInt(16));
            }
            return nv;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public ArrayList<NhanVien> findNV(String ketWord){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT NhanVien.id,NhanVien.Ma,concat(NhanVien.Ho,' ',NhanVien.TenDem,' ',NhanVien.Ten),NhanVien.GioiTinh,NhanVien.NgaySinh,NhanVien.DiaChi,NhanVien.Sdt,NhanVien.MatKhau,\n"
                + "CuaHang.Ma,CuaHang.ten,CuaHang.DiaChi,CuaHang.ThanhPho,CuaHang.QuocGia,\n"
                + "ChucVu.Ma,ChucVu.Ten,\n"
                + "NhanVien.TrangThai\n"
                + "FROM NhanVien\n"
                + "Join CuaHang on CuaHang.id = NhanVien.IdCH\n"
                + "Join ChucVu on ChucVu.id = NhanVien.IdCV"
                + " WHERE concat(NhanVien.Ho,' ',NhanVien.TenDem,' ',NhanVien.Ten) like concat('%',?,'%') or NhanVien.Ma like concat('%',?,'%')"
                + " ORDER BY NhanVien.Ma ";
        ResultSet rs = JDBCHelpers.executeQuery(sql, ketWord, ketWord);
        try {
            while (rs.next()) {
                CuaHang ch = new CuaHang(rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
                ChucVu cv = new ChucVu(rs.getString(14), rs.getString(15));
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), ch, cv, rs.getInt(16));
                list.add(nv);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public int add(NhanVien nv){
        String ten[] = nv.getTen().split(" ");
        String sql = "INSERT INTO NhanVien(Ma,Ten,TenDem,Ho,GioiTinh,NgaySinh,DiaChi,Sdt,MatKhau,idCH,idCV,TrangThai) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        String ho = ten[0];
        String tenDem = ten[1];
        String name = "";
        for (int i = 2; i < ten.length; i++) {
            name += ten[i];
        }
        return JDBCHelpers.executeUpdate(sql, nv.getMa(), name, tenDem, ho, nv.getGioiTinh(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSdt(), nv.getMatKhau(), nv.getCuaHang().getId(), nv.getChucVu().getId(), nv.getTrangThai());
    }
    
    @Override
    public int update(NhanVien nv){
        String ten[] = nv.getTen().split(" ");
        String ho = ten[0];
        String tenDem = ten[1];
        String name = "";
        for (int i = 2; i < ten.length; i++) {
            name += ten[i];
        }
        String sql = "UPDATE NhanVien SET Ten =  ?,TenDem = ?,Ho = ?,GioiTinh = ?,NgaySinh = ?,DiaChi = ?,Sdt = ?,MatKhau = ?,idCH = ?,idCV = ?,TrangThai = ? WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, name, tenDem, ho, nv.getGioiTinh(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSdt(), nv.getMatKhau(), nv.getCuaHang().getId(), nv.getChucVu().getId(), nv.getTrangThai(), nv.getMa());
    }
    
    @Override
    public int delete(String Ma){
        String sql = "DELETE FROM NhanVien WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, Ma);
    }
}
