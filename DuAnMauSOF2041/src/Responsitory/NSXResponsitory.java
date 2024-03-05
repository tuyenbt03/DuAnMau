/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import DomainModel.NSX;
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
public class NSXResponsitory implements InterfaceNSXResponsitory{
    public ArrayList<NSX> read(){
        ArrayList<NSX> dsNSX = new ArrayList<>();
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT Id, Ma, Ten FROM NSX";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String Id = rs.getString("Id");
                String Ma = rs.getString("Ma");
                String Ten = rs.getString("Ten");
                NSX nsx = new NSX(Id, Ma, Ten);
                dsNSX.add(nsx);
            }
        } catch (SQLException ex) {
            System.out.println("Loi ket noi !!!");
            Logger.getLogger(ChucVuResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNSX;
    }
    
    public NSX getNSXByMa(String Ma){
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT Id, Ma, Ten FROM NSX WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new NSX(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten"));
            }
            connection.close();
            rs.close();
            ps.close();
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public int add(NSX nsx){
        String sql = "INSERT INTO NSX (Ma, Ten) VALUES (?, ?)";
        return JDBCHelpers.executeUpdate(sql, nsx.getMa(), nsx.getTen());
    }
    
    public int delete(String Ma){
        String sql = "DELETE FROM NSX WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, Ma);
    }
    
    public int update(NSX nsx){
        String sql = "UPDATE NSX SET Ten = ? WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, nsx.getTen(), nsx.getMa());
    }
    
    
}
