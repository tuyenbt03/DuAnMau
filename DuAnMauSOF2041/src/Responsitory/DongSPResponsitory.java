/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

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
public class DongSPResponsitory implements InterfaceDongSPResponsitory{
    public ArrayList<DongSP> read(){
        ArrayList<DongSP> dsDongSP = new ArrayList<>();
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT Id, Ma, Ten FROM DongSP";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String Id = rs.getString("Id");
                String Ma = rs.getString("Ma");
                String Ten = rs.getString("Ten");
                DongSP dongSP = new DongSP(Id, Ma, Ten);
                dsDongSP.add(dongSP);
            }
        } catch (SQLException ex) {
            System.out.println("Loi ket noi !!!");
            Logger.getLogger(ChucVuResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDongSP;
    }
    
    public DongSP getDongSPByMa(String Ma){
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT Id, Ma, Ten FROM DongSP WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new DongSP(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten"));
            }
            connection.close();
            rs.close();
            ps.close();
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public int add(DongSP dsp){
        String sql = "INSERT INTO DongSP (Ma, Ten) VALUES (?, ?)";
        return JDBCHelpers.executeUpdate(sql, dsp.getMa(), dsp.getTen());
    }
    
    
    public int delete(String Ma){
        String sql = "DELETE FROM DongSP WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, Ma);
    }
    
    
    public int update(DongSP dsp){
        String sql = "UPDATE DongSP SET Ten = ? WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, dsp.getTen(), dsp.getMa());
    }
}
