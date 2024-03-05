/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;


import DomainModel.MauSac;
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
public class MauSacResponsitory implements InterfaceMauSacResponsitory{
    public ArrayList<MauSac> read(){
        ArrayList<MauSac> dsMauSac = new ArrayList<>();
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT Id, Ma, Ten FROM MauSac";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String Id = rs.getString("Id");
                String Ma = rs.getString("Ma");
                String Ten = rs.getString("Ten");
                MauSac mauSac = new MauSac(Id, Ma, Ten);
                dsMauSac.add(mauSac);
            }
        } catch (SQLException ex) {
            System.out.println("Loi ket noi !!!");
            Logger.getLogger(ChucVuResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsMauSac;
    }
    
    public MauSac getChucVuByMa(String Ma){
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT Id, Ma, Ten FROM MauSac WHERE Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new MauSac(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten"));
            }
            connection.close();
            rs.close();
            ps.close();
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public int add(MauSac ms){
        String sql = "INSERT INTO MauSac (Ma, Ten) VALUES (?, ?)";
        return JDBCHelpers.executeUpdate(sql, ms.getMa(), ms.getTen());
    }
    
    public int delete(String Ma){
        String sql = "DELETE FROM MauSac WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, Ma);
    }
    
    public int update(MauSac ms){
        String sql = "UPDATE MauSac SET Ten = ? WHERE Ma = ?";
        return JDBCHelpers.executeUpdate(sql, ms.getTen(), ms.getMa());
    }
}
