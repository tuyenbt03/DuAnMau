/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

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
public class CuaHangResponsitory implements InterfaceCuaHangResponsitory{
    public ArrayList<CuaHang> read(){
        ArrayList<CuaHang> dsCuaHang = new ArrayList<>();
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT Id, Ma, Ten, DiaChi, ThanhPho, QuocGia FROM CuaHang";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String Id = rs.getString("Id");
                String Ma = rs.getString("Ma");
                String Ten = rs.getString("Ten");
                String DiaChi = rs.getString("DiaChi");
                String ThanhPho = rs.getString("ThanhPho");
                String QuocGia = rs.getString("QuocGia");
                CuaHang cuaHang = new CuaHang(Id, Ma, Ten, DiaChi, ThanhPho, QuocGia);
                dsCuaHang.add(cuaHang);
            }
        } catch (SQLException ex) {
            System.out.println("Loi ket noi !!!");
            Logger.getLogger(ChucVuResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsCuaHang;
    }
    
    public CuaHang getCuaHangByMa(String Ma){
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT Id, Ma, Ten, DiaChi, ThanhPho, QuocGia FROM CuaHang WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new CuaHang(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten"), rs.getString("DiaChi"), rs.getString("ThanhPho"), rs.getString("QuocGia"));
            }
            connection.close();
            rs.close();
            ps.close();
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public int add(CuaHang ch){
        String sql = "INSERT INTO CuaHang (Ma, Ten, DiaChi, ThanhPho, QuocGia) VALUES (?, ?, ?, ?, ?)";
        return JDBCHelpers.executeUpdate(sql, ch.getMa(), ch.getTen(), ch.getDiaChi(), ch.getThanhPho(), ch.getQuocGia());
    }
    
    
    public int delete(String Ma){
        String sql = "DELETE FROM CuaHang WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, Ma);
    }
    
    public int update(CuaHang ch){
        String sql = "UPDATE CuaHang SET Ten = ?, DiaChi = ?, ThanhPho = ?,  QuocGia = ? WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, ch.getTen(), ch.getDiaChi(), ch.getThanhPho(), ch.getQuocGia(), ch.getMa());
    }
}
