/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import DomainModel.ChucVu;
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
public class ChucVuResponsitory implements InterfaceChucVuResponsitory{
    public ArrayList<ChucVu> read(){
        ArrayList<ChucVu> dsChucVu = new ArrayList<>();
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT Id, Ma, Ten FROM ChucVu";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String Id = rs.getString("Id");
                String Ma = rs.getString("Ma");
                String Ten = rs.getString("Ten");
                ChucVu chucVu = new ChucVu(Id, Ma, Ten);
                dsChucVu.add(chucVu);
            }
        } catch (SQLException ex) {
            System.out.println("Loi ket noi !!!");
            Logger.getLogger(ChucVuResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsChucVu;
    }
    
    @Override
    public ChucVu getChucVuByMa(String Ma){
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT Id, Ma, Ten FROM ChucVu WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new ChucVu(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten"));
            }
            connection.close();
            rs.close();
            ps.close();
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public int add(ChucVu cv){
        String sql = "INSERT INTO ChucVu (Ma, Ten) VALUES (?, ?)";
        return JDBCHelpers.executeUpdate(sql, cv.getMa(), cv.getTen());
    }
    
    
    public int delete(String Ma){
        String sql = "DELETE FROM ChucVu WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, Ma);
    }
    
    @Override
    public int update(ChucVu cv){
        String sql = "UPDATE ChucVu SET Ten = ? WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, cv.getTen(), cv.getMa());
    }
}
