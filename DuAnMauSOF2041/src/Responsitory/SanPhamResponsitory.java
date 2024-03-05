/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import DomainModel.SanPham;
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
public class SanPhamResponsitory implements InterfaceSanPhamResponsitory{
    public ArrayList<SanPham> read(){
        ArrayList<SanPham> dsSanPham = new ArrayList<>();
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT Id, Ma, Ten FROM SanPham";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String Id = rs.getString("Id");
                String Ma = rs.getString("Ma");
                String Ten = rs.getString("Ten");
                SanPham sanPham = new SanPham(Id, Ma, Ten);
                dsSanPham.add(sanPham);
            }
        } catch (SQLException ex) {
            System.out.println("Loi ket noi !!!");
            Logger.getLogger(ChucVuResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsSanPham;
    }
    
    public SanPham getSanPhamByMa(String Ma){
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT Id, Ma, Ten FROM SanPham WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new SanPham(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten"));
            }
            connection.close();
            rs.close();
            ps.close();
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public int add(SanPham sp){
        String sql = "INSERT INTO SanPham (Ma, Ten) VALUES (?, ?)";
        return JDBCHelpers.executeUpdate(sql, sp.getMa(), sp.getTen());
    }
    
    public int delete(String Ma){
        String sql = "DELETE FROM SanPham WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, Ma);
    }
    
    public int update(SanPham sp){
        String sql = "UPDATE SanPham SET Ten = ? WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, sp.getTen(), sp.getMa());
    }
    
    @Override
    public ArrayList<SanPham> SearchSP(String KeyWord){
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham "
                + "WHERE Ten like CONCAT('%',?,'%') "
                + " ORDER BY Ma";
        ResultSet rs = JDBCHelpers.executeQuery(sql,KeyWord);
        try {
            while (rs.next()) {
                list.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
