/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import java.util.ArrayList;
import java.util.List;
import DomainModel.HoaDon;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilities.JDBCHelpers;
import java.sql.*;

/**
 *
 * @author baphuoc
 */
public   class HoaDonResponsitory implements InterfaceHoaDonResponsitory{

    
    public List<HoaDon> getAllHD() {
        List<HoaDon> list = new ArrayList<>();
        String sql = "SELECT id, Ma, NgayTao,TinhTrang FROM HoaDon order by CAST(substring(Ma,3,4) AS Varchar ) desc ";
        ResultSet rs = JDBCHelpers.executeQuery(sql);
        try {
            while (rs.next()) {
                list.add(new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
   
    public  List<HoaDon> getHDByTT(Integer TinhTrang) {
        List<HoaDon> list = new ArrayList<>();
        String sql = "SELECT id, Ma, NgayTao,TinhTrang FROM HoaDon WHERE TinhTrang = ?"
                + " order by CAST(substring(Ma,3,4) AS Varchar ) desc ";
        ResultSet rs = JDBCHelpers.executeQuery(sql,TinhTrang);
        try {
            while (rs.next()) {
                list.add(new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public  HoaDon getHDByMa(String ma) {
        HoaDon h  = new HoaDon();
        String sql = "SELECT id, Ma, NgayTao,TinhTrang FROM HoaDon WHERE Ma = ?";
        ResultSet rs = JDBCHelpers.executeQuery(sql,ma);
        try {
            while (rs.next()) {
                h =new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4));
            }
            return h;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public  int add(HoaDon h){
        String sql = "INSERT INTO HoaDon(Ma, NgayTao,TinhTrang) VALUES (?,?,?)";
        return JDBCHelpers.executeUpdate(sql, h.getMa(),h.getNgayTao(),0);
    }
    
    public  int ThanhToan(HoaDon h){
        String sql = "UPDATE HoaDon SET TinhTrang = 1 WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, h.getMa());
    }
}
