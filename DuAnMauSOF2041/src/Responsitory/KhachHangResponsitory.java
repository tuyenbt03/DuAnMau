/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import DomainModel.KhachHang;
import Utilities.DBContext;
import Utilities.JDBCHelpers;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;


/**
 *
 * @author Admin
 */
public class KhachHangResponsitory implements InterfaceKhachHangResponsitory{
    public ArrayList<KhachHang> read(){
        ArrayList<KhachHang> dsKhachHang = new ArrayList<>();
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT Id, Ma, concat(Ho,' ',TenDem,' ',Ten), NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau FROM KhachHang";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                dsKhachHang.add(kh);
            }
        } catch (SQLException ex) {
            System.out.println("Loi ket noi !!!");
            Logger.getLogger(ChucVuResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsKhachHang;
    }
    
    public KhachHang getKHByMa(String ma) {
        KhachHang kh = null;
        String sql = "SELECT Id,Ma,concat(Ho,' ',TenDem,' ',Ten) ,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau FROM KhachHang"
                + " WHERE Ma = ?";
        ResultSet rs = JDBCHelpers.executeQuery(sql, ma);
        try {
            while (rs.next()) {
                kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
            return kh;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<KhachHang> findKH(String keyWord) {
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "SELECT Id,Ma,concat(Ho,' ',TenDem,' ',Ten) ,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau FROM KhachHang"
                + " WHERE concat(Ho,' ',TenDem,' ',Ten) LIKE concat('%',?,'%')";
        ResultSet rs = JDBCHelpers.executeQuery(sql, keyWord);
        try {
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                list.add(kh);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangResponsitory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public int add(KhachHang kh) {
        String ten[] = kh.getHoTen().split(" ");
        String ho = ten[0];
        String tenDem = ten[1];
        String name = "";
        for (int i = 2; i < ten.length; i++) {
            name += ten[i];
        }
        String sql = "INSERT INTO KhachHang(Ma,Ho,TenDem,Ten,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) VALUES (?,?,?,?,?,?,?,?,?,?)";
        return JDBCHelpers.executeUpdate(sql,kh.getMa(),ho,tenDem,name,kh.getNgaySinh(),kh.getSdt(),kh.getDiaChi(),kh.getThanhPho(),kh.getQuocGia(),kh.getMatKhau());
    }
    
    public int update(KhachHang kh) {
        String ten[] = kh.getHoTen().split(" ");
        String ho = ten[0];
        String tenDem = ten[1];
        String name = "";
        for (int i = 2; i < ten.length; i++) {
            name += ten[i];
        }
        String sql = "UPDATE KhachHang SET Ho= ?,TenDem = ?,Ten = ?,NgaySinh = ?,Sdt = ?,DiaChi = ?,ThanhPho = ?,QuocGia = ?,MatKhau = ? WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql,ho,tenDem,name,kh.getNgaySinh(),kh.getSdt(),kh.getDiaChi(),kh.getThanhPho(),kh.getQuocGia(),kh.getMatKhau(),kh.getMa());
    }
    
    public int delete(String Ma){
        String sql = "DELETE FROM KhachHang WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, Ma);
    }
}
